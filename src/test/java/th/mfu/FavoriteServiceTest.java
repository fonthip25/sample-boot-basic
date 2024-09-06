package th.mfu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import th.mfu.Service.FavoriteService;

import th.mfu.Service.FavoriteService;
import th.mfu.domain.Favorite;
import th.mfu.dto.FavoriteDTO;
import th.mfu.dto.mapper.FavoriteMapper;
import th.mfu.repository.FavoriteRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FavoriteServiceTest {

    @Mock
    private FavoriteRepository favoriteRepository;

    @Mock
    private FavoriteMapper favoriteMapper;

    @InjectMocks
    private FavoriteService favoriteService;

    private Favorite favorite;
    private FavoriteDTO favoriteDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        favorite = new Favorite("user1", 123L);
        favoriteDTO = new FavoriteDTO();
        favoriteDTO.setUserId("user1");
        favoriteDTO.setMovieId(123L);
    }

    @Test
    void testGetAllFavorites() {
        when(favoriteRepository.findAll()).thenReturn(Arrays.asList(favorite));
        when(favoriteMapper.toDto(any(Favorite.class))).thenReturn(favoriteDTO);

        List<Favorite> favorites = favoriteService.getAllFavorites();
        assertNotNull(favorites);
        assertEquals(1, favorites.size());
        assertEquals("user1", favorites.get(0).getUserId());
    }

    @Test
    void testGetFavoriteById() {
        when(favoriteRepository.findById(anyLong())).thenReturn(Optional.of(favorite));
        when(favoriteMapper.toDto(any(Favorite.class))).thenReturn(favoriteDTO);

        Favorite foundFavorite = favoriteService.getFavoriteById(1L);
        assertNotNull(foundFavorite);
        assertEquals("user1", foundFavorite.getUserId());
    }

    @Test
    void testCreateFavorite() {
        when(favoriteMapper.toEntity(any(FavoriteDTO.class))).thenReturn(favorite);
        when(favoriteRepository.save(any(Favorite.class))).thenReturn(favorite);
        when(favoriteMapper.toDto(any(Favorite.class))).thenReturn(favoriteDTO);

        Favorite createdFavorite = favoriteService.createFavorite(favoriteDTO);
        assertNotNull(createdFavorite);
        assertEquals("user1", createdFavorite.getUserId());
    }

    @Test
    void testUpdateFavorite() {
        when(favoriteRepository.findById(anyLong())).thenReturn(Optional.of(favorite));
        doNothing().when(favoriteMapper).updateFavoriteFromDto(any(FavoriteDTO.class), any(Favorite.class));
        when(favoriteRepository.save(any(Favorite.class))).thenReturn(favorite);
        when(favoriteMapper.toDto(any(Favorite.class))).thenReturn(favoriteDTO);

        Favorite updatedFavorite = favoriteService.updateFavorite(1L, favoriteDTO);
        assertNotNull(updatedFavorite);
        assertEquals("user1", updatedFavorite.getUserId());
    }

    @Test
    void testDeleteFavorite() {
        when(favoriteRepository.findById(anyLong())).thenReturn(Optional.of(favorite));
        doNothing().when(favoriteRepository).delete(any(Favorite.class));

        favoriteService.deleteFavorite(1L);
        verify(favoriteRepository, times(1)).delete(any(Favorite.class));
    }
}
