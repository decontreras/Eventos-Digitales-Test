package com.prueba_lider.spring.datajpa.DTO;

public class inversionDTO {
	
    private Long user_id;
	
    private Long proyect_id;
	
	private double amount;

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public Long getProyect_id() {
		return proyect_id;
	}

	public void setProyect_id(Long proyect_id) {
		this.proyect_id = proyect_id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}


}
