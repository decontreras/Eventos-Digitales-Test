package com.prueba_lider.spring.datajpa.model;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuarios {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "lastName")
	private String lastName;

	@Column(name = "complete")
	private boolean complete;
	
	@Column(name = "monthlyIncome")
	private Double monthlyIncome;

	public Usuarios() {

	}

	

	public Usuarios(String name, String lastName, boolean complete, Double monthlyIncome) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.complete = complete;
		this.monthlyIncome = monthlyIncome;
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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean isComplete) {
		this.complete = isComplete;
	}
	
	

	public Double getMonthlyIncome() {
		return monthlyIncome;
	}

	public void setMonthlyIncome(Double monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}

	@Override
	public String toString() {
		return "Usuarios [id=" + id + ", name=" + name + ", request=" + lastName + ", complete=" + complete + "]";
	}

}
