package com.digitalEvent.spring.datajpa.model;

import javax.persistence.*;
/**
 * Clase entidad tipo plataformas (Contiene constructor)
 *
 * @version 	17/08/2022
 * @author 	Daniel Contreras
 */
@Entity
@Table(name = "platforms")
public class Platform {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;

	public Platform(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public Platform() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
