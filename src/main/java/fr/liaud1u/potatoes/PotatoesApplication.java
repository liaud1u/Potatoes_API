package fr.liaud1u.potatoes;

import fr.liaud1u.potatoes.dao.PotatoDAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PotatoesApplication {

    public static void main(String[] args) {
        SpringApplication.run(PotatoesApplication.class, args);
        new PotatoDAO();
    }

}
