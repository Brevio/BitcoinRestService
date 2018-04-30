package br.com.bitcoin.model;

public class PayByAddressRequest {
	
	private String txId;
	private Integer vout;
	private String scriptPubKey;
	private String address;
	private Double amount;
	
	public String getTxId() {
		return txId;
	}
	public void setTxId(String txId) {
		this.txId = txId;
	}
	public Integer getVout() {
		return vout;
	}
	public void setVout(Integer vout) {
		this.vout = vout;
	}
	public String getScriptPubKey() {
		return scriptPubKey;
	}
	public void setScriptPubKey(String scriptPubKey) {
		this.scriptPubKey = scriptPubKey;
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
