package org.suitesquad.likehome.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
