package br.com.bitcoin.services;

import java.math.BigDecimal;

import br.com.bitcoin.model.GasEstimateResponse;
import br.com.bitcoin.util.Constantes;
import wf.bitcoin.javabitcoindrpcclient.BitcoinJSONRPCClient;
import wf.bitcoin.javabitcoindrpcclient.BitcoindRpcClient.SmartFeeResult;

public class GasEstimateService {
	
	private BitcoinJSONRPCClient bitcoinClient = new BitcoinJSONRPCClient();
	public GasEstimateResponse estimate(int nBlocks) {
		GasEstimateResponse response = new GasEstimateResponse();
		try{
			SmartFeeResult estimateSmartFee = bitcoinClient.getEstimateSmartFee(nBlocks);
			BigDecimal fee = BigDecimal.valueOf(estimateSmartFee.feeRate());
			response.setEstimate(fee);
			response.setCode(Constantes.CODE_SUCCESS);
			response.setStatus(Constantes.SUCCESS_STATUS);
		}catch (Exception e) {
			response.setCode(Constantes.GAS_ESTIMATE_FAILURE);
			response.setStatus(e.getMessage());
		}
		return response;
	}
}
