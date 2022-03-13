package br.com.cassioliveira.dsmovie.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_score")
public class Score  implements Serializable{

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ScorePK id = new ScorePK();
	
	private Double value;
	
	public Score() {

	}
	
	/**
	 * Este método vai permitir associar o Score com o filme.
	 * @param movie
	 */
	public void setMovie(Movie movie) {
		id.setMovie(movie);
	}
	
	/**
	 * Este método vai permitir associar o Usuario com o filme.
	 * @param user
	 */
	public void setUser(User user) {
		id.setUser(user);
	}

	public ScorePK getId() {
		return id;
	}

	public void setId(ScorePK id) {
		this.id = id;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
	
	
	
}
