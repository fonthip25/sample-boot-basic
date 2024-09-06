package th.mfu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import th.mfu.Service.GenreService;
import th.mfu.domain.Genre;
import th.mfu.repository.GenreRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class GenreServiceTest {

    @InjectMocks
    private GenreService genreService;

    @Mock
    private GenreRepository genreRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetGenreById() {
        Genre genre = new Genre("Action");
        when(genreRepository.findById(1L)).thenReturn(Optional.of(genre));

        Genre foundGenre = genreService.getGenreById(1L);

        assertNotNull(foundGenre);
        assertEquals("Action", foundGenre.getName());
    }

    @Test
    void testCreateGenre() {
        Genre genre = new Genre("Action");
        when(genreRepository.save(genre)).thenReturn(genre);

        Genre createdGenre = genreService.createGenre(genre);

        assertNotNull(createdGenre);
        assertEquals("Action", createdGenre.getName());
    }

    @Test
    void testUpdateGenre() {
        Genre genre = new Genre("Action");
        when(genreRepository.findById(1L)).thenReturn(Optional.of(genre));
        when(genreRepository.save(genre)).thenReturn(genre);

        Genre updatedGenre = genreService.updateGenre(1L, genre);

        assertNotNull(updatedGenre);
        assertEquals("Action", updatedGenre.getName());
    }

    @Test
    void testDeleteGenre() {
        doNothing().when(genreRepository).deleteById(1L);

        genreService.deleteGenre(1L);

        verify(genreRepository, times(1)).deleteById(1L);
    }
}
