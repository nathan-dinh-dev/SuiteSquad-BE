package org.suitesquad.likehome.rest;

import org.springframework.web.bind.annotation.*;
import org.suitesquad.likehome.model.Hotel;
import org.suitesquad.likehome.model.Reservation;
import org.suitesquad.likehome.model.User;
import org.suitesquad.likehome.rest.RestTypes.Room;
import org.suitesquad.likehome.service.HotelService;
import org.suitesquad.likehome.service.ReservationService;
import org.suitesquad.likehome.service.UserService;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * This class handles all requests not requiring authentication.
 */
@RestController
@RequestMapping
public class PublicController {

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    private final UserService userService;
    private final HotelService hotelService;
    private final ReservationService reservationService;

    // Constructor injector
    public PublicController(UserService userService, HotelService hotelService, ReservationService reservationService) {
        this.userService = userService;
        this.hotelService = hotelService;
        this.reservationService = reservationService;
    }

    @GetMapping("/userdb")
    public List<User> userDb() {
        return userService.fetchAllUserData();
    }

    @GetMapping("/hoteldb")
    public List<Hotel> hotelDb() {
        return hotelService.fetchAllHotelData();
    }

    @GetMapping("/reservedb")
    public List<Reservation> reservationDb() {
        return reservationService.fetchAllReservationData();
    }

    /**
     * Retrieve a list of all rooms with optional filters.
     * @param filters a set of filters to apply to the room search (for example, type=apartment)
     */
    @GetMapping("/rooms")
    public List<Room> getAllRooms(@RequestParam(required = false) Map<String, String> filters) {
        return List.of(Room.sample);
    }

    @GetMapping("/rooms/{roomId}")
    public Room getRoomById(@PathVariable String roomId) {
        return Stream.of(Room.sample).filter(r -> r.id().equals(roomId)).findAny().orElseThrow();
    }

}
