package org.suitesquad.likehome.rest;

import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import org.suitesquad.likehome.rest.ResponseTypes.Reservation;
import org.suitesquad.likehome.rest.ResponseTypes.SignUpInfo;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

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
     * Get the reservations for this user.
     */
    @GetMapping(path = "/reservations")
    public List<Reservation> getReservations(JwtAuthenticationToken token) {
        return List.of(Reservation.sample);
    }

    /**
     * Get a specific reservation for this user by ID.
     */
    @GetMapping(path = "/reservations/{reservationId}")
    public Reservation getReservationById(JwtAuthenticationToken token, @PathVariable String reservationId) {
        return Stream.of(Reservation.sample).filter(r -> r.id().equals(reservationId)).findAny().orElseThrow();
    }

    /**
     * Create a reservation for this user.
     * The reservation.id field and reservation.userID fields are ignored.
     * Instead, the id is generated and assigned, and the user ID is retrieved from the token.
     */
    @PostMapping(path = "/reservations")
    public void createReservation(JwtAuthenticationToken token, @RequestBody Reservation reservation) {

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
