package br.com.bitcoin.model;

import java.util.List;

public class AddressResponse extends BaseResponse{
	private List<String> address;

	public List<String> getAddress() {
		return address;
	}

	public void setAddress(List<String> address) {
		this.address = address;
	}
}
