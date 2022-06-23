package com.prueba_lider.spring.datajpa.model;

import javax.persistence.*;

@Entity
@Table(name = "proyectos")
public class Proyecto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "request")
	private Double request;
	
	@Column(name = "state")
	private Boolean state;

	public Proyecto() {

	}

	public Proyecto(String name, Double request, Boolean state) {
		this.name = name;
		this.request = request;
		this.state = state;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getRequest() {
		return request;
	}

	public void setRequest(Double request) {
		this.request = request;
	}
	
	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Usuarios [id=" + id + ", name=" + name + ", request=" + request + "]";
	}

}
