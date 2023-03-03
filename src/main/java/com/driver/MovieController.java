package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/movies/add-movie")
    public ResponseEntity addMovie(@RequestBody Movie movie) {
        return new ResponseEntity(movieService.addMovie(movie), HttpStatus.CREATED);
    }

    @PostMapping("/movies/add-director")
    public ResponseEntity addDirector(@RequestBody Director director) {
        return new ResponseEntity(movieService.addDirector(director), HttpStatus.CREATED);
    }

    @GetMapping("/movies/get-movie-by-name")
    public ResponseEntity<Movie> getMovieByName(@RequestParam("name") String name) {
        Movie movie = movieService.findMovie(name);

        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }

    @PutMapping("/movies/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam("movie") String movieName, @RequestParam("director") String directorName) {
        return new ResponseEntity(movieService.addMovieDirectorPair(movieName, directorName), HttpStatus.OK);
    }

    @GetMapping("/movies/get-director-by-name")
    public ResponseEntity<Director> getDirectorByName(@RequestParam("name") String name) {
        Director director = movieService.findDirector(name);
        return new ResponseEntity<>(director, HttpStatus.CREATED);
    }
    @GetMapping("/movies/get-movies-by-director-name")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@RequestParam("director") String director){
        List<String> movies = movieService.findMoviesFromDirector(director);
        return new ResponseEntity<>(movies, HttpStatus.CREATED);
    }

    @GetMapping("/movies/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        return new ResponseEntity(movieService.findAllMovies() , HttpStatus.OK);
    }

    @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam("name") String name){
        movieService.deleteDirectorByName(name);
        return new ResponseEntity<>("Success" , HttpStatus.OK);
    }
    @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity deleteAllDirectors(){
        movieService.deleteAllDirectors();
        return new ResponseEntity<>("Success" , HttpStatus.OK);
    }



}
