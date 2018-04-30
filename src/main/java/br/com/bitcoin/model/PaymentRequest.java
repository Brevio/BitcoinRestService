package br.com.bitcoin.model;

import java.math.BigDecimal;

public class PaymentRequest {

	private String fromAccount;
	private String toAddress;
	private String value;
	private BigDecimal gasPricePriority;
	
	public void setFromAccount(String fromAccount){
		this.fromAccount=fromAccount;
	}
	public String getFromAccount(){
		return fromAccount;
	}
	public void setToAddress(String toWallet){
		this.toAddress=toWallet;
	}
	public String getToAddress(){
		return toAddress;
	}
	public void setValue(String value){
		this.value=value;
	}
	public String getValue(){
		return value;
	}
	public BigDecimal getGasPricePriority() {
		return gasPricePriority;
	}
	public void setGasPricePriority(BigDecimal gasPricePriority) {
		this.gasPricePriority = gasPricePriority;
	}
}

