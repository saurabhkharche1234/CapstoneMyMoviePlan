package movieplan.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import movieplan.backend.dao.AdminRepository;
import movieplan.backend.entity.Movie;

@Service
public class AdminService {
	
	@Autowired
	AdminRepository adminRepository;  //using repository object 
	
	//to get all movie details
	public List<Movie> getAllMovies(){
		List<Movie> movieList = new ArrayList<>();
		adminRepository.findAll().forEach(movie ->movieList.add(movie));
		return movieList;
	}
	
	//to get single movie detail
	public Movie getMovieById(int movieId) {
		return adminRepository.findById(movieId).get();
	}
	
	//to save a new movie 
	public void saveMovie(Movie movie) {
		adminRepository.save(movie);
	}

	//update already stored movie details
	public Movie updateMovie(Movie movie) {
		Integer movieId = movie.getMovieId();
		Movie mv = adminRepository.findById(movieId).get();
		mv.setMovieName(movie.getMovieName());
		mv.setMovieDescription(movie.getMovieDescription());
		mv.setPrice(movie.getPrice());
		return adminRepository.save(mv);
	}
	
	//delete the movie by id
	public void deleteMovie(int movieId) {
		adminRepository.deleteById(movieId);
	}

}
