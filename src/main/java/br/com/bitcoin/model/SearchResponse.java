package br.com.bitcoin.model;

public class SearchResponse extends BaseResponse{
	private Object statusTransaction;
	

	public Object getStatusTransaction() {
		return statusTransaction;
	}

	public void setStatusTransaction(Object rawTransaction) {
		this.statusTransaction = rawTransaction;
	}


}
