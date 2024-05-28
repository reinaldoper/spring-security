package jpa_data.jpa_data;

import jpa_data.jpa_data.model.User;
import jpa_data.jpa_data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class StartApp implements CommandLineRunner {
    @Autowired
    private UserRepository repository;
    @Override
    public void run(String... args) throws Exception {
        for(User u: repository.findAll()){
            System.out.println(u);
        }
        System.out.println("-----Por Id------");

        User result = repository.findUserById(52);
        System.out.println(result);

        List<User> users = repository.findByNameContaining("Reinaldo");
        System.out.println("------Filtro------");
        for(User u: users){
            System.out.println(u);
        }

        System.out.println("----------Com like---------");
        List<User> user = repository.findByUsername("Reinaldo");
        for(User u: user){
            System.out.println(u);
        }
    }
}
