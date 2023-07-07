package com.shashank.spring.token.auth.user;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shashank.spring.token.auth.security.AuthenticationResponse;
import com.shashank.spring.token.auth.security.JwtProvider;
import com.shashank.spring.token.auth.security.UserDetails;
import com.shashank.spring.token.auth.user.model.User;
import com.shashank.spring.token.auth.user.service.UserService;

@RestController
public class AuthenticationController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody User user) {
        userService.registerUser(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User loginUser) {
        try {
            UserDetails userDetails = userService.authenticate(loginUser.getUsername(), loginUser.getPassword());
            System.out.println(userDetails.getUsername());
            String token = jwtProvider.generateToken(userDetails);
            AuthenticationResponse response = new AuthenticationResponse(token);
            return ResponseEntity.ok(response.getToken());
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("unauthorised");
        }
    }

    @GetMapping("/secret") // you can see this page if you have valid authorisation token
    public ResponseEntity<String> secret(Principal principal) {
        return ResponseEntity.ok("Hii!! "+principal.getName()+" This is secret page");
    }
}
