package jpa_data.jpa_data.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jpa_data.jpa_data.model.User;
import jpa_data.jpa_data.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

  @Autowired
  UserService userservice;

  @CrossOrigin
  @GetMapping()
  public ResponseEntity<List<User>> getUsers() {
    List<User> users = userservice.getAllUsers();
    return ResponseEntity.status(HttpStatus.OK).body(users);
  }

  @CrossOrigin
  @GetMapping("/{id}")
  public ResponseEntity<Object> getUserById(@PathVariable("id") Integer id) {
    User user = userservice.getUserById(id);
    if(user != null) {
      return ResponseEntity.ok(user);
    } else {
      Map<String, String> responseBody = new HashMap<>();
      responseBody.put("message", "Usuário não encontrado");
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseBody);
    }
  }

  @CrossOrigin
  @PostMapping()
  public ResponseEntity<Object> createUser(@RequestBody User user){
    userservice.createUser(user);
    Map<String, String> responseentity = new HashMap<>();
    responseentity.put("message", "Created user with success.");
    return ResponseEntity.status(HttpStatus.CREATED).body(responseentity);
  }

  @CrossOrigin
  @GetMapping("/user/{username}")
  public ResponseEntity<List<User>> getUsersByName(@PathVariable("username") String name){
    return ResponseEntity.status(HttpStatus.OK).body(userservice.getUsersByName(name));
  }

  @CrossOrigin
  @DeleteMapping("/{id}")
  public ResponseEntity<Object> deleteUserById(@PathVariable("id") Integer id){
    Map<String, String> responseentity = new HashMap<>();
    responseentity.put("message", userservice.deleteUser(id));
    return ResponseEntity.status(HttpStatus.OK).body(responseentity);
  }

  @CrossOrigin
  @PutMapping("/{id}")
  public ResponseEntity<Object> updateUser(@RequestBody User user, @PathVariable("id") Integer id){
    userservice.updateUser(user, id);
    Map<String, String> responseentity = new HashMap<>();
    responseentity.put("message", "Updated with success.");
    return ResponseEntity.status(HttpStatus.OK).body(responseentity);
  }
}
