package br.com.bitcoin.model;

public class TxOutputModel {
	private String address;
	private Double amount;
	
	public TxOutputModel(String address, Double amount) {
		super();
		this.address = address;
		this.amount = amount;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	

}
