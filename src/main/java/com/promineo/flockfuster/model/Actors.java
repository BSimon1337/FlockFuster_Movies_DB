package com.promineo.flockfuster.model;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


import org.springframework.data.relational.core.mapping.Column;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="actors")
public class Actors {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(value="first_name")
	private String first_name;
	
	@Column(value="last_name")
	private String last_name;

	@ManyToMany(mappedBy = "castMembers")
	@JsonIgnore
	private List<Movie> movies = new ArrayList<Movie>();
	
}


