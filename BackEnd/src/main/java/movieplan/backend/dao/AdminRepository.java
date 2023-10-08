package movieplan.backend.dao;

import org.springframework.data.repository.CrudRepository;

import movieplan.backend.entity.Movie;

public interface AdminRepository extends CrudRepository<Movie, Integer> {

}
