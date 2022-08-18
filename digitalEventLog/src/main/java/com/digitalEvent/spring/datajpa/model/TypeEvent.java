package com.digitalEvent.spring.datajpa.model;

import javax.persistence.*;

/**
 * Clase entidad de tipo eventos (Contiene constructor)
 *
 * @version 	17/08/2022
 * @author 	Daniel Contreras
 */
@Entity
@Table(name = "typeEvents")
public class TypeEvent {

	@Id
	@Column(name = "idevent")
	private String idevent;

	@Column(name = "description")
	private String description;
	
	@Column(name = "value")
	private Double value;

	public TypeEvent(String idevent, String description, Double value) {
		super();
		this.idevent = idevent;
		this.description = description;
		this.value = value;
	}

	public TypeEvent() {
	}

	public String getIdevent() {
		return idevent;
	}

	public void setIdevent(String idevent) {
		this.idevent = idevent;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

}
