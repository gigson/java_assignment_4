package ge.btu.giorgi.kusikashvili.work.service;

import ge.btu.giorgi.kusikashvili.work.dto.MovieDTO;
import ge.btu.giorgi.kusikashvili.work.dto.MovieInput;
import ge.btu.giorgi.kusikashvili.work.model.Movie;
import ge.btu.giorgi.kusikashvili.work.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<MovieDTO> getMovies() {
        List<MovieDTO> movies = new ArrayList<>();
        for (Movie movie : movieRepository.findAll()) {
            MovieDTO movieDTO = new MovieDTO();

            movieDTO.setId(movie.getId());
            movieDTO.setCountry(movie.getCountry());
            movieDTO.setTitle(movie.getTitle());

            movies.add(movieDTO);
        }
        return movies;
    }

    public MovieDTO getMovie(Long id) {
        Movie movie = movieRepository.getOne(id);

        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setId(movie.getId());
        movieDTO.setCountry(movie.getCountry());
        movieDTO.setTitle(movie.getTitle());

        return movieDTO;
    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

    public void addMovie(MovieInput movieInput) {
        Movie movie = new Movie();

        movie.setTitle(movieInput.getTitle());
        movie.setCountry(movieInput.getCountry());

        movieRepository.save(movie);
    }
}
