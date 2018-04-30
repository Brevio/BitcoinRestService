package br.com.bitcoin.model;

public class NewAccountResponse extends BaseResponse{
	
	private String newAddress;
	private String privateKeyAsHex;
	
	

	public String getPrivateKeyAsHex() {
		return privateKeyAsHex;
	}

	public void setPrivateKeyAsHex(String privateKeyAsHex) {
		this.privateKeyAsHex = privateKeyAsHex;
	}

	public String getNewAddress() {
		return newAddress;
	}

	public void setNewAddress(String newAddress) {
		this.newAddress = newAddress;
	}
}
