package jpa_data.jpa_data.service;

import java.util.List;

import jpa_data.jpa_data.handler.NotFound;
import jpa_data.jpa_data.handler.ResponseAddUserError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jpa_data.jpa_data.model.User;
import jpa_data.jpa_data.repository.UserRepository;
import org.springframework.util.StringUtils;


@Service
@Transactional
public class UserService {

  @Autowired
  private UserRepository repository;

  public List<User> getAllUsers() {
    return repository.findAll();
  }

  public User getUserById(Integer id){
    User user = repository.findUserById(id);
    if(user == null){
      throw new NotFound();
    }
    return repository.findUserById(id);
  }

  public void createUser(User user) {
    String email = user.getEmail();
    String name = user.getName();
    String password = user.getPassword();

    if (StringUtils.isEmpty(email) || StringUtils.isEmpty(name) || StringUtils.isEmpty(password)) {
      throw new ResponseAddUserError();
    }
    repository.save(user);
  }

  public List<User> getUsersByName(String name){
    return repository.findByNameContaining(name);
  }

  public String deleteUser(Integer id){
    User user = repository.findUserById(id);
    if(user != null){
      repository.deleteById(id);
      return "User deleted with success!";
    }
    throw new NotFound();
  }

  public void updateUser(User user, Integer id) {
    User existingUser = repository.findById(id).orElse(null);
    if (existingUser != null) {
      String newName = user.getName();
      String newEmail = user.getEmail();
      String newPassword = user.getPassword();

      if (!StringUtils.isEmpty(newName) && !StringUtils.isEmpty(newEmail) && !StringUtils.isEmpty(newPassword)) {
        existingUser.setName(newName);
        existingUser.setEmail(newEmail);
        existingUser.setPassword(newPassword);
        repository.save(existingUser);
      } else {
        throw new ResponseAddUserError();
      }
    } else {
      throw new NotFound();
    }
  }


}
