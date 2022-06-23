package com.prueba_lider.spring.datajpa.model;

import javax.persistence.*;

@Entity
@Table(name = "inversiones")
public class Inversiones {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
    @JoinColumn(name = "user_id")
    private Usuarios usuario;
	
	@ManyToOne
    @JoinColumn(name = "proyect_id")
    private Proyecto proyeto;
	
	@Column(name = "amount")
	private Double amount;

	public Inversiones() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	public Proyecto getProyeto() {
		return proyeto;
	}

	public void setProyeto(Proyecto proyeto) {
		this.proyeto = proyeto;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Inversiones(Usuarios usuario, Proyecto proyeto, Double amount) {
		super();
		this.usuario = usuario;
		this.proyeto = proyeto;
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Inversiones [id=" + id + ", usuario=" + usuario + ", proyeto=" + proyeto + ", amount=" + amount + "]";
	}
	
	
}
