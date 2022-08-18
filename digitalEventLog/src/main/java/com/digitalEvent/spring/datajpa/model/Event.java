package com.digitalEvent.spring.datajpa.model;

import java.util.Date;

import javax.persistence.*;
/**
 * Clase entidad tipo evento (Contiene métodos de encapsulamiento)
 *
 * @version 	17/08/2022
 * @author 	Daniel Contreras
 */
@Entity
@Table(name = "events")
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
    @JoinColumn(name = "event")
    private TypeEvent event;
	
	@ManyToOne
    @JoinColumn(name = "platform")
    private Platform platform;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "amount")
	private Double amount;
	
	@Column(name = "date")
	private Date date;

	public Event() {
	}

	

	public Event(TypeEvent event, Platform platform, int quantity, Double amount, Date date) {
		super();
		this.event = event;
		this.platform = platform;
		this.quantity = quantity;
		this.amount = amount;
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TypeEvent getEvent() {
		return event;
	}

	public void setEvent(TypeEvent event) {
		this.event = event;
	}

	public Platform getPlatform() {
		return platform;
	}

	public void setPlatform(Platform platform) {
		this.platform = platform;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
}
