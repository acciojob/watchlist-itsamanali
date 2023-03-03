package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {


    HashMap<String , Movie> moviedb;
    HashMap<String , Director> directordb;
    HashMap<String , List<String>> directorMoviedb;

    public MovieRepository() {
        moviedb = new HashMap<>();
        directordb = new HashMap<>();
        directorMoviedb = new HashMap<>();
    }

    public String addmovie(Movie movie) {

        moviedb.put(movie.getName() , movie);
        return "success";
    }

    public String addDirector(Director director) {
        directordb.put(director.getName() , director);
        return "success";
    }

    public Movie findByName(String name) {

     return moviedb.get(name);

    }

    public String addMovieDirectorPair(String movieName, String directorName) {
         if(moviedb.containsKey(movieName) && directordb.containsKey(directorName)){
             List<String> currentDirectorMovieList = new ArrayList<>();
             if(directorMoviedb.containsKey(directorName)){
                 currentDirectorMovieList = directorMoviedb.get(directorName);
             }
                currentDirectorMovieList.add(movieName);
                 directorMoviedb.put(directorName , currentDirectorMovieList);

             return "success pair added";
         }
         return "Not Found";
    }

    public Director findByDirectorName(String name) {

        return directordb.get(name);
    }
    public List<String> findMoviesFromDirector(String director){
        List<String> moviesList = new ArrayList<String>();
        if(directorMoviedb.containsKey(director)) moviesList = directorMoviedb.get(director);
        return moviesList;
    }

    public List<String> findAllMovies() {
        List<String> AllMovies = new ArrayList<>(moviedb.keySet());
//        List<String> ans = new ArrayList<>();
//        for(Movie m : AllMovies) ans.add(m.getName());
        return AllMovies;
    }

    public void deleteDirectorByName(String name) {
        if(directordb.containsKey(name)){
            directordb.remove(name);
        }
        if(directorMoviedb.containsKey(name)){
            List<String> delMovies = directorMoviedb.get(name);
            for(String S : delMovies){
                if(moviedb.containsKey(S)){
                    moviedb.remove(S);
                }
            }
            directorMoviedb.remove(name);
        }
    }

    public void deleteAllDirectors() {
        List<String> mappedMovies = new ArrayList<>();
        for(List<String> movieList : directorMoviedb.values()){
            for(String movie : movieList){
                if(!mappedMovies.contains(movie)){
                    mappedMovies.add(movie);
                }
            }
        }
        directordb.clear();
        for(String movie : mappedMovies){
            if(moviedb.containsKey(movie)){
                moviedb.remove(movie);
            }
        }
    }
}
