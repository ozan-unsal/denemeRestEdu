package com.ozan.restEdu.ui.controller;

import com.ozan.restEdu.ui.model.response.UserRest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @GetMapping
    public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
                           @RequestParam(value = "limit", defaultValue = "50") int limit) {
        return "get user was called page ="+page +" limit= "+limit;
    }

    @GetMapping(path = "/{userId}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
        UserRest ret = new UserRest();
        ret.setFirstName("Ozan");
        ret.setLastName("LLL");
        ret.setEmail("test@test");
        ret.setUserId("111");

        return new ResponseEntity<UserRest>(ret,HttpStatus.OK);
    }

    @PostMapping(consumes  = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
    ,produces  = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> createUser(@RequestBody UserRest user) {
        user.setLastName("Ozan2");
        return new ResponseEntity<UserRest>(user,HttpStatus.OK);
    }

    @PutMapping
    public String updateUser() {
        return "update user was called";
    }

    @DeleteMapping
    public String deleteUser() {
        return "delete user was called";
    }
}
