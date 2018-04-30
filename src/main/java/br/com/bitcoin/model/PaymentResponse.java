package br.com.bitcoin.model;



public class PaymentResponse extends BaseResponse{
	private String txId;

	public String getTxId() {
		return txId;
	}

	public void setTxId(String txId) {
		this.txId = txId;
	}

}
