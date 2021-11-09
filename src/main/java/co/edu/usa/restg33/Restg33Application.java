package co.edu.usa.restg33;

import co.edu.usa.restg33.model.Category;
import co.edu.usa.restg33.model.Client;
import co.edu.usa.restg33.model.Message;
import co.edu.usa.restg33.model.Quadbike;
import co.edu.usa.restg33.model.Reservation;
import co.edu.usa.restg33.repository.CategoryRepository;
import co.edu.usa.restg33.repository.ClientRepository;
import co.edu.usa.restg33.repository.MessageRepository;
import co.edu.usa.restg33.repository.QuadbikeRepository;
import co.edu.usa.restg33.repository.ReservationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@EntityScan(basePackages = {"co.edu.usa.restg33.model"})
@SpringBootApplication
public class Restg33Application {

    @Autowired
    private CategoryRepository repoCategory;
    @Autowired
    private ClientRepository repoClient;
    @Autowired
    private MessageRepository repoMessage;
    @Autowired
    private QuadbikeRepository repoQuadbike;
    @Autowired
    private ReservationRepository repoReservation;
    
    public static void main(String[] args) {
        SpringApplication.run(Restg33Application.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner() {
        return args -> {
            List<Category> pca = repoCategory.getAll();
            System.out.println("Category: "+pca.size());
            
            List<Client> pc = repoClient.getAll();
            System.out.println("Client: "+pc.size());
            
            List<Message> pm = repoMessage.getAll();
            System.out.println("Message: "+pm.size());
            
            List<Quadbike> pq = repoQuadbike.getAll();
            System.out.println("Quadbike: "+pq.size());
            
            List<Reservation> pr = repoReservation.getAll();
            System.out.println("Reservation: "+pr.size());
        };
    }
}
