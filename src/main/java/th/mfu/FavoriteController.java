package th.mfu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import th.mfu.Service.FavoriteService;
import th.mfu.domain.Favorite;
import th.mfu.dto.FavoriteDTO;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/favorites")
public class FavoriteController {

    private final FavoriteService favoriteService;

    @Autowired
    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @GetMapping
    public ResponseEntity<List<Favorite>> getAllFavorites() {
        List<Favorite> favorites = favoriteService.getAllFavorites();
        return ResponseEntity.ok(favorites);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Favorite> getFavoriteById(@PathVariable Long id) {
        Favorite favorite = favoriteService.getFavoriteById(id);
        if (favorite != null) {
            return ResponseEntity.ok(favorite);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Favorite> createFavorite(@Valid @RequestBody FavoriteDTO favorite) {
        Favorite createdFavorite = favoriteService.createFavorite(favorite);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFavorite); // ใช้ 201 Created
    }

    @PutMapping("/{id}")
    public ResponseEntity<Favorite> updateFavorite(@PathVariable Long id, @Valid @RequestBody FavoriteDTO favoriteDetails) {
        Favorite updatedFavorite = favoriteService.updateFavorite(id, favoriteDetails);
        if (updatedFavorite != null) {
            return ResponseEntity.ok(updatedFavorite);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFavorite(@PathVariable Long id) {
        favoriteService.deleteFavorite(id);
        return ResponseEntity.noContent().build(); // ใช้ 204 No Content
    }
}
