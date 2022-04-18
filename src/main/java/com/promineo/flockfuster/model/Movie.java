package com.promineo.flockfuster.model;






import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.relational.core.mapping.Column;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH}) //this is just cool and not totally necessary
			@JoinTable(name = "cast_members", joinColumns = 
			@JoinColumn(name = "movies_id"),inverseJoinColumns = 
			@JoinColumn(name = "actors_id"))
	@JsonIgnore
	private Set<Actors> castMembers = new HashSet<Actors>(); 

	//@ManyToOne
	//@JoinColumn(name = "director_id")
	//@JsonIgnore
	//private Directors director;
	

}

//set up an entity for each table. I will want one to one and many to many. I can populate the table. Look at the options orders tables
