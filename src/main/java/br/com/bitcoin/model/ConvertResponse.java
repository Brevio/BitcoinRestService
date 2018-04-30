package br.com.bitcoin.model;

public class ConvertResponse extends BaseResponse{
	private String fee;

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

}
