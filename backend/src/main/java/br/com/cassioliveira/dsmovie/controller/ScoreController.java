package br.com.cassioliveira.dsmovie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cassioliveira.dsmovie.dto.MovieDTO;
import br.com.cassioliveira.dsmovie.dto.ScoreDTO;
import br.com.cassioliveira.dsmovie.service.ScoreService;

@RestController
@RequestMapping(value = "/scores")
public class ScoreController {
	
	@Autowired
	private ScoreService scoreService;

	@PutMapping
	public MovieDTO saveScore(@RequestBody ScoreDTO scoreDTO) {
		return scoreService.saveScore(scoreDTO);
	}
}
