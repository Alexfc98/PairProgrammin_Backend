package com.AppBackend.Users.Controller;


import com.AppBackend.Users.Exceptions.RecordNotFoundException;
import com.AppBackend.Users.Model.User;
import com.AppBackend.Users.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService service;


    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> list = service.getAllUsers();

        return new ResponseEntity<List<User>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") String id)
            throws RecordNotFoundException {
        User entity = service.getUserById(id);

        return new ResponseEntity<User>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User myItem){
        User created = service.createUser(myItem);
        return new ResponseEntity<User>(created, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<User> UpdateUser(@Valid @RequestBody User myItem)
            throws RecordNotFoundException {
        User updated = service.UpdateUser(myItem);
        return new ResponseEntity<User>(updated, new HttpHeaders(), HttpStatus.OK);
    }
}
