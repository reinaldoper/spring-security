package jpa_data.jpa_data.repository;

import jpa_data.jpa_data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByNameContaining(String name);

    @Query("SELECT u FROM User u WHERE u.name LIKE %:name%")
    List<User> findByUsername(@Param("name") String name);
    User findUserById(Integer id);
}
