package br.com.bitcoin.model;

import java.util.ArrayList;

public class PayByListRequest {
	private ArrayList<PayByAddressRequest> payByListRequest;

	public ArrayList<PayByAddressRequest> getPayByListRequest() {
		return payByListRequest;
	}

	public void setPayByListRequest(ArrayList<PayByAddressRequest> payByListRequest) {
		this.payByListRequest = payByListRequest;
	}

}
