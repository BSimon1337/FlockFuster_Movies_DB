package com.promineo.flockfuster.model;






import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import org.springframework.data.relational.core.mapping.Column;


import lombok.Data;

@Data
@Entity
@Table(name="movies")
public class Movie {
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(value="director_id")
	private int director_id;
	
	@Column(value="actors_id")
	private int actors_id;
	
	@Column(value="genre_id")
	private int genre_id;
	
	@Column(value="title")
	private String title;
	
	@Column(value="studio")
	private String studio;
	
	@Column(value="year_released")
	private int year_released;
	

}
