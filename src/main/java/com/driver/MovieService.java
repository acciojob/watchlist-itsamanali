package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    public String addMovie(Movie movie) {
        return movieRepository.addmovie(movie);
    }

    public String addDirector(Director director) {
        return movieRepository.addDirector(director);
    }

    public Movie findMovie(String name) {
        return movieRepository.findByName(name);
    }

    public String addMovieDirectorPair(String movieName, String directorName) {
        return movieRepository.addMovieDirectorPair(movieName , directorName);
    }

    public Director findDirector(String name) {
        return movieRepository.findByDirectorName(name);
    }


    public List<String> findMoviesFromDirector(String director) {
        return movieRepository.findMoviesFromDirector(director);
    }

    public List<String> findAllMovies() {
        return movieRepository.findAllMovies();
    }

    public void deleteDirectorByName(String name) {
        movieRepository.deleteDirectorByName(name);
    }

    public void deleteAllDirectors() {
        movieRepository.deleteAllDirectors();
    }
}
