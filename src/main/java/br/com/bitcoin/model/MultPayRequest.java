package br.com.bitcoin.model;

import java.util.ArrayList;
import java.util.List;


public class MultPayRequest {
	private String listFromAddress;
	private String listToAddress;
	private String listAmount;
	public List<String> getListFromAddress() {
		String[] split = listFromAddress.split(",");
		List<String> list = new ArrayList<String>();
		for (String address : split) {
			list.add(address);
		}
		return list;
	}
	public void setListFromAddress(String listFromAddress) {
		this.listFromAddress = listFromAddress;
	}
	public List<String> getListToAddress() {
		String[] split = listToAddress.split(",");
		List<String> list = new ArrayList<String>();
		for (String address : split) {
			list.add(address);
		}
		return list;
	}
	public void setListToAddress(String listToAddress) {
		this.listToAddress = listToAddress;
	}
	public List<Double> getListAmount() {
		String[] split = listAmount.split(",");
		List<Double> list = new ArrayList<Double>();
		for (String address : split) {
			list.add(Double.parseDouble(address));
		}
		return list;
	}
	public void setListAmount(String listAmount) {
		this.listAmount = listAmount;
	}
}
