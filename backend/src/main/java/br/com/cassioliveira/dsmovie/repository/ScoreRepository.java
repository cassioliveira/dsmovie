package br.com.cassioliveira.dsmovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cassioliveira.dsmovie.entity.Score;
import br.com.cassioliveira.dsmovie.entity.ScorePK;

public interface ScoreRepository extends JpaRepository<Score, ScorePK> {

}
