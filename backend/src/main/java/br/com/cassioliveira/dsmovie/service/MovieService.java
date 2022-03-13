package br.com.cassioliveira.dsmovie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cassioliveira.dsmovie.dto.MovieDTO;
import br.com.cassioliveira.dsmovie.entity.Movie;
import br.com.cassioliveira.dsmovie.repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;
	
	@Transactional(readOnly = true)
	public Page<MovieDTO> findAll(Pageable pageable){
		Page<Movie> result = movieRepository.findAll(pageable);
		Page<MovieDTO> page = result.map(x -> new MovieDTO(x));
		return page;
	}
	
	@Transactional(readOnly = true)
	public MovieDTO findById(Long id){
		Movie result = movieRepository.findById(id).get(); //O .get() pega o objeto movie dentro de Optional, retorno do findById(id)
		MovieDTO movie = new MovieDTO(result);
		return movie;
	}
}
