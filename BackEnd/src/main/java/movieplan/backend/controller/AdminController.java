package movieplan.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import movieplan.backend.entity.Movie;
import movieplan.backend.service.AdminService;

@RestController
@CrossOrigin(allowedHeaders = "*",origins = "*")
public class AdminController {

	@Autowired
	AdminService adminService;
	//crud operations
	//list of all movies-getmapping
	
	@GetMapping("/allmovies")
	private List<Movie> getAllMovies(){
		return adminService.getAllMovies();
	}
	
	//list of single movie-getmapping
	@GetMapping("/allmovies/{movieId}")
	private Movie getMovies(@PathVariable("movieId") int movieId) {
		return adminService.getMovieById(movieId);
	}
	
	//add a movie-post mapping
	@PostMapping("/addmovie")
	private int addMovie(@RequestBody Movie movie) {
		adminService.saveMovie(movie);
		return movie.getMovieId();
	}
	
	//update a movie - put mapping
	@PutMapping("/updatemovie")
	private Movie updateMovie(@RequestBody Movie movie) {
		return adminService.updateMovie(movie);
	}
	//delete a movie - delete mapping
	@DeleteMapping("/allmovies/{movieId}")
	private void deleteMovie(@PathVariable("movieId") int movieId) {
		adminService.deleteMovie(movieId);
	}
}
