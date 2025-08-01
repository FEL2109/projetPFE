package com.example.gestionconge.services.serviceImpl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.gestionconge.configuration.KeycloakConfig;
import com.example.gestionconge.dtos.LoginDto;
import com.example.gestionconge.dtos.RefreshTokenDto;
import com.example.gestionconge.dtos.TokenDto;
import com.example.gestionconge.feign.KeycloakClient;
import com.example.gestionconge.services.serviceinterface.AuthInterface;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.AccessTokenResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders; // Correct

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static com.example.gestionconge.constants.Constants.*;


@Service
@Slf4j
public class AuthServiceImpl implements AuthInterface {

    private final KeycloakClient keycloakClient;
    private final KeycloakConfig keycloakConfig;
    private Keycloak keycloak;
    private final RestTemplate restTemplate;


    public AuthServiceImpl(KeycloakClient keycloakClient,
                           KeycloakConfig keycloakConfig,
                           Keycloak keycloak,
                           RestTemplate restTemplate){
        this.keycloakClient=keycloakClient;
        this.keycloakConfig=keycloakConfig;
        this.keycloak=keycloak;
        this.restTemplate=restTemplate;
    }

    @Value("${authorization.realm}")
    public String realm;
    @Value("${authorization.client.id}")
    public String clientId;
    @Value("${authorization.client.secret}")
    public String clientSecret;
    @Value("${authorization.server-url}")
    public String serverUrl;


    private HttpHeaders createFormUrlEncodedHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        return headers;
    }

    @Override
    public TokenDto login(LoginDto loginDto) {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add(GRANT_TYPE, PASSWORD);
        map.add(USERNAME, loginDto.username());
        map.add(PASSWORD, loginDto.password());
        map.add(CLIENT_ID, clientId);
        map.add(CLIENT_SECRET, clientSecret);
        ResponseEntity<AccessTokenResponse> accessToken = keycloakClient.login(map);
        if (Objects.isNull(accessToken)) {
            throw new RuntimeException();
        } else {
            accessToken.getBody();
        }

        return TokenDto.builder()
                .accessToken(Objects.requireNonNull(accessToken.getBody()).getToken())
                .expIn(accessToken.getBody().getExpiresIn())
                .refExpIn(accessToken.getBody().getRefreshExpiresIn())
                .refreshToken(accessToken.getBody().getRefreshToken())
                .refreshExpiresIn(accessToken.getBody().getRefreshExpiresIn())
                .tokenType(accessToken.getBody().getTokenType())
                .build();
    }

    @Override
    public void logout(RefreshTokenDto refreshToken) {
        MultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
        requestParams.add(GRANT_TYPE, REFRESH_TOKEN);
        requestParams.add(CLIENT_ID, clientId);
        requestParams.add(CLIENT_SECRET, clientSecret);
        requestParams.add(REFRESH_TOKEN, refreshToken.getRefreshToken());

        keycloakClient.logout(realm, requestParams);
    }

    @Override
    public Map refreshAccessToken(RefreshTokenDto refreshToken) {
        String url = String.format("%s/realms/%s/protocol/openid-connect/token", serverUrl, realm);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add(GRANT_TYPE, REFRESH_TOKEN);
        params.add(CLIENT_ID, clientId);
        params.add(CLIENT_SECRET, clientSecret);
        params.add(REFRESH_TOKEN, refreshToken.getRefreshToken());

        HttpHeaders headers = createFormUrlEncodedHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);

        ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.POST, request, Map.class);

        return response.getBody();
    }

    public String getAdminToken() {

        String keycloakUrl = serverUrl + REALMS + realm + PROTOCOL_OPEN_ID_CONNECT_TOKEN;

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add(GRANT_TYPE, CLIENT_CREDENTIALS);
        body.add(CLIENT_ID, clientId);
        body.add(CLIENT_SECRET, clientSecret);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(body, headers);

        ResponseEntity<Map> response = restTemplate.exchange(
                keycloakUrl,
                HttpMethod.POST,
                request,
                Map.class
        );

        return response.getBody().get(ACCESS_TOKEN).toString();
    }


    public List<String> getUserRoles(String accessToken) {
        try {

            DecodedJWT jwt = JWT.decode(accessToken);
            Map<String, Object> realmAccess = jwt.getClaim("realm_access").asMap();

            if (realmAccess != null && realmAccess.containsKey("roles")) {
                List<String> roles = (List<String>) realmAccess.get("roles");
                return roles;
            }

            return Collections.emptyList();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
