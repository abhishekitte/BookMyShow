package dev.abhishek.BookMyShow.Controller;

import dev.abhishek.BookMyShow.DTO.UserLoginRequestDTO;
import dev.abhishek.BookMyShow.DTO.UserSignUpRequestDTO;
import dev.abhishek.BookMyShow.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity signUp(@RequestBody UserSignUpRequestDTO requestDto) throws Exception{
        return ResponseEntity.ok(
                userService.signUp(requestDto.getName(),requestDto.getEmail(),requestDto.getPassword())
        );
    }
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserLoginRequestDTO requestDto) throws Exception{
        return ResponseEntity.ok(
                userService.login(requestDto.getEmail(),requestDto.getPassword())
        );
    }
}
