package br.com.bitcoin.model;

import java.util.LinkedHashMap;
import java.util.List;

import wf.bitcoin.javabitcoindrpcclient.BitcoindRpcClient.Unspent;

public class UnspentResponse extends BaseResponse{
	
	private List<LinkedHashMap> unspent;

	public List<LinkedHashMap> getUnspent() {
		return unspent;
	}

	public void setUnspent(List<LinkedHashMap> list) {
		this.unspent = list;
	}
	

}
