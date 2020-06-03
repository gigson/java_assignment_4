package ge.btu.giorgi.kusikashvili.work.controller;

import ge.btu.giorgi.kusikashvili.work.dto.MovieDTO;
import ge.btu.giorgi.kusikashvili.work.dto.MovieInput;
import ge.btu.giorgi.kusikashvili.work.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("getMovies")
    public List<MovieDTO> getMovies() {
        return movieService.getMovies();
    }

    @GetMapping("getMovie")
    public MovieDTO getMovie(@RequestParam Long id) {
        return movieService.getMovie(id);
    }

    @DeleteMapping("deleteMovie")
    public void deleteMovie(@RequestParam Long id) {
        movieService.deleteMovie(id);
    }

    @PostMapping("addMovie")
    public void addMovie(@RequestBody MovieInput movieInput) {
        movieService.addMovie(movieInput);
    }
}
