package org.suitesquad.likehome.rest;

import org.springframework.web.bind.annotation.*;
import org.suitesquad.likehome.rest.RestTypes.Room;

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
