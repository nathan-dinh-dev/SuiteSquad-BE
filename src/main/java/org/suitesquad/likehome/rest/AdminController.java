package org.suitesquad.likehome.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class handles all administrator requests.
 * This is accessible by any user with the ADMIN role.
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
}
