package th.mfu.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    // Method to publish movie events to Kafka
    public void publishMovieEvent(String movie) {
        kafkaTemplate.send("movies", movie);
        System.out.println("Published movie event: " + movie);
    }

    // Kafka Listener for movie events
    @KafkaListener(topics = "movies", groupId = "movie-group")
    public void listenToMovies(String message) {
        System.out.println("Received Message in MovieService: " + message);
        // Logic to handle the message
    }
}
