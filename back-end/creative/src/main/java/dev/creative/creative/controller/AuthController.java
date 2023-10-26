package dev.creative.creative.controller;


import dev.creative.creative.dto.TokenDTO;
import dev.creative.creative.dto.UserDTO;
import dev.creative.creative.service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
    private final AuthService authService;

    public AuthController(
            @Autowired AuthService authService
    ){
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<UserDTO> signUp(
            @RequestBody UserDTO userDTO
    ){
        return this.authService.signUp(userDTO);
    }

    @PostMapping("/signin")
    public ResponseEntity<TokenDTO> signIn(
            @RequestBody UserDTO userDTO
    ){
        return this.authService.signIn(userDTO);
    }


}
