package br.com.bitcoin.model;

import java.math.BigDecimal;

public class GasEstimateResponse extends BaseResponse{
	private BigDecimal estimate;

	public String getEstimate() {
		return estimate.toString();
	}

	public void setEstimate(BigDecimal estimate) {
		this.estimate = estimate;
	}
}
