package th.mfu.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.mfu.domain.Favorite;
import th.mfu.dto.FavoriteDTO;
import th.mfu.dto.mapper.FavoriteMapper;
import th.mfu.repository.FavoriteRepository;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

@Service
public class FavoriteService {

    private final FavoriteRepository favoriteRepository;
    private final FavoriteMapper favoriteMapper; // เพิ่ม FavoriteMapper

    @Autowired
    public FavoriteService(FavoriteRepository favoriteRepository, FavoriteMapper favoriteMapper) {
        this.favoriteRepository = favoriteRepository;
        this.favoriteMapper = favoriteMapper; // ฉีด FavoriteMapper
    }

    public List<Favorite> getAllFavorites() {
        return favoriteRepository.findAll();
    }

    public Favorite getFavoriteById(Long id) {
        return favoriteRepository.findById(id).orElse(null);
    }

    public Favorite createFavorite(@Valid FavoriteDTO favoriteDTO) {
        Favorite favorite = favoriteMapper.toEntity(favoriteDTO); // แปลง DTO เป็น Entity
        return favoriteRepository.save(favorite);
    }

    public Favorite updateFavorite(Long id, @Valid FavoriteDTO favoriteDetails) {
        return favoriteRepository.findById(id).map(favorite -> {
            favoriteMapper.updateFavoriteFromDto(favoriteDetails, favorite); // ใช้ mapper ในการอัปเดต
            return favoriteRepository.save(favorite);
        }).orElse(null);
    }

    public void deleteFavorite(Long id) {
        if (favoriteRepository.existsById(id)) {
            favoriteRepository.deleteById(id);
        }
    }
}
