package com.promineo.flockfuster.model;

import java.util.List;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import org.springframework.data.relational.core.mapping.Column;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="directors")
public class Directors {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(value="first_name")
	private String first_name;
	
	@Column(value="last_name")
	private String last_name;
	
	@OneToMany(mappedBy = "director")
	@JsonIgnore
	private Set<Movie> movies;
	

}
