package com.example.jobportal.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.jobportal.DTO.Login;
import com.example.jobportal.Entities.User;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
public class UserController {
    
    @PostMapping("/Signup")
    public ResponseEntity<User> Registor(@RequestBody User entity) {
        
        return null;
    }

    @PostMapping("/login")
    public ResponseEntity<User> Login(@RequestBody Login entity) {
        
        return null;
    }

    @GetMapping("/getProfile")
    public ResponseEntity<User> Profile() {
        return null;
    }
    
    @PutMapping("/UpdateProfile")
    public ResponseEntity<User> Updateprofile(@RequestBody User entity) {

        
        return null;
    }
    
    @DeleteMapping("/Admin/DeleteUser/{userid}")
    public ResponseEntity<User> DeleteUser(@PathVariable long userid) {
        
        return null;
    }

    @PutMapping("/Admin/ChangeRole/{userid}/{role}")
    public RequestEntity<User> ChangeRole(@PathVariable long userid,@PathVariable String role) {
        
        return null;
    }
}
