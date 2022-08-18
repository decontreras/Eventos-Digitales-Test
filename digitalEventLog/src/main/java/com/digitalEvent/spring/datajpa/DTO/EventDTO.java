package com.digitalEvent.spring.datajpa.DTO;

import java.util.Date;

/**
 * Clase para el mapeo de objetos tipo evento (Contiene métodos de encapsulamiento)
 *
 * @version 	17/08/2022
 * @author 	Daniel Contreras
 */
public class EventDTO {
	
    private String event_id;
	
    private Long platform_id;
	
	private double amount;
	
	private int quantity;
	
	private Date date;

	public EventDTO(String event_id, Long platform_id, double amount, int quantity, Date date) {
		super();
		this.event_id = event_id;
		this.platform_id = platform_id;
		this.amount = amount;
		this.quantity = quantity;
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getEvent_id() {
		return event_id;
	}

	public void setEvent_id(String event_id) {
		this.event_id = event_id;
	}

	public Long getPlatform_id() {
		return platform_id;
	}

	public void setPlatform_id(Long platform_id) {
		this.platform_id = platform_id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
