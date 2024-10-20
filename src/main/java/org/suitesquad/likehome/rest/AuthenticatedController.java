package org.suitesquad.likehome.rest;

import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import org.suitesquad.likehome.rest.ResponseTypes.SignUpInfo;

import java.util.Map;

/**
 * This class handles all authenticated requests.
 * Authenticated means the user has a valid JWT token.
 * Any user that is authenticated can access these endpoints.
 */
@RestController
@RequestMapping("/auth")
public class AuthenticatedController {

    /**
     * Creates a user in the database with the email and name from the SignUpInfo object
     * and the user ID retrieved from the token.
     */
    @PostMapping(path = "/signup")
    public void signUp(@RequestBody SignUpInfo info, JwtAuthenticationToken token) {

    }

    /**
     * Called when a user has signed in.
     * Checks database for user data consistency.
     */
    @PostMapping(path = "/signin")
    public void signedIn(JwtAuthenticationToken token) {

    }

    /**
     * @return the user id and the token passed in
     */
    @GetMapping(path = "/test")
    public Map<String, String> test(JwtAuthenticationToken token) {
        return Map.of("user id", getUserID(token), "token", token.getToken().getTokenValue());
    }

    /**
     * Converts the JWT Auth Token to a user id.
     *
     * @param token JWT Token
     * @return User ID
     */
    private static String getUserID(JwtAuthenticationToken token) {
        return token.getName();
    }
}
