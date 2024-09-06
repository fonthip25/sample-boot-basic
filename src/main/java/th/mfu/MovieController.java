package th.mfu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import th.mfu.Service.MovieService;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/publish")
    public ResponseEntity<String> publishMovie(@RequestBody String movie) {
        movieService.publishMovieEvent(movie);
        return ResponseEntity.ok("Movie published to Kafka successfully");
    }

    // Other endpoints...
}
