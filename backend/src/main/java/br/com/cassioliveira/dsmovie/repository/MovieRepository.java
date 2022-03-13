package br.com.cassioliveira.dsmovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cassioliveira.dsmovie.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
