package br.com.cassioliveira.dsmovie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cassioliveira.dsmovie.dto.MovieDTO;
import br.com.cassioliveira.dsmovie.dto.ScoreDTO;
import br.com.cassioliveira.dsmovie.entity.Movie;
import br.com.cassioliveira.dsmovie.entity.Score;
import br.com.cassioliveira.dsmovie.entity.User;
import br.com.cassioliveira.dsmovie.repository.MovieRepository;
import br.com.cassioliveira.dsmovie.repository.ScoreRepository;
import br.com.cassioliveira.dsmovie.repository.UserRepository;

@Service
public class ScoreService {

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ScoreRepository scoreRepository;

	@Transactional
	public MovieDTO saveScore(ScoreDTO scoreDTO) {
		User user = userRepository.findByEmail(scoreDTO.getEmail());

		if (user == null) {
			user = new User();
			user.setEmail(scoreDTO.getEmail());
			user = userRepository.saveAndFlush(user);// saveAndFlush garante o objeto atualizado??
		}

		Movie movie = movieRepository.findById(scoreDTO.getId()).get();

		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(scoreDTO.getScore());

		score = scoreRepository.saveAndFlush(score);

		double sum = 0.0;
		for (Score s : movie.getScores()) {
			sum = sum + s.getValue();
		}

		double average = sum / movie.getScores().size();
		movie.setScore(average);
		movie.setCount(movie.getScores().size());

		movie = movieRepository.save(movie);

		return new MovieDTO(movie);
	}
}
