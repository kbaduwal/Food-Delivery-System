package com.baduwal.ecommerce.controller;

import com.baduwal.ecommerce.data.entity.User;
import com.baduwal.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Objects;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        boolean isRegistered = userService.registerUser(user);
        if (isRegistered) {
            return ResponseEntity.status(HttpStatus.OK).body(user);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);

    }

    @PostMapping("/verify")
    public ResponseEntity<Map<String, Object>> verifyOtp(@RequestBody Map<String,String> request) {
        String email = request.get("email");
        String otp = request.get("otp");

        boolean verified = userService.verifyOtp(email,otp);

        if (verified) {
            return ResponseEntity.ok(Map.of(
                    "success",true,
                    "message","OTP verified successfully."));
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
                    "success", false,
                    "message", "Invalid OTP or OTP expired"
            ));
        }
    }

    @PostMapping("/set-new-password")
    public ResponseEntity<User> setNewPassword(@RequestBody User user) {
        if (userService.setNewPassword(user.getEmail(),user.getOtp(),user.getPassword())){
            return ResponseEntity.status(HttpStatus.OK).body(user);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);
    }

    @PostMapping("/change-password")
    public ResponseEntity<User> changePassword(@RequestBody Map<String,String> requestBody) {
        String email = requestBody.get("email");
        String oldPassword = requestBody.get("oldPassword");
        String newPassword = requestBody.get("newPassword");

        User user = new User();
        user.setEmail(email);

        String result = userService.changePassword(oldPassword,newPassword,user);

        if ("Password changed successfully".equals(result)) {
            return ResponseEntity.status(HttpStatus.OK).body(user);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);
        }
    }

}
