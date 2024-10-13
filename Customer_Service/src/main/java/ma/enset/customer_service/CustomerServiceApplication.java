package ma.enset.customer_service;

import ma.enset.customer_service.entities.Customer;
import ma.enset.customer_service.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(CustomerRepository customerRepository){
        return args -> {
            customerRepository.save(new Customer(null,"Hasna EL BACHA","elbachahasna1@gmail.com"));
            customerRepository.save(new Customer(null,"asma EL BACHA","elbachaasma@gmail.com"));
            customerRepository.save(new Customer(null,"ilyas EL BACHA","elbachailyas@gmail.com"));
            customerRepository.findAll().forEach(c->{
                System.out.println(c.toString());
            });
        };
    }

}
