package br.com.bitcoin.services;

import br.com.bitcoin.model.PaymentRequest;
import br.com.bitcoin.model.PaymentResponse;
import br.com.bitcoin.util.Constantes;
import br.com.bitcoin.util.validateBalance;
import wf.bitcoin.javabitcoindrpcclient.BitcoinJSONRPCClient;

public class TransactionService {

	private BitcoinJSONRPCClient bitcoin = new BitcoinJSONRPCClient();
	public PaymentResponse send(PaymentRequest request) {
		PaymentResponse response = new PaymentResponse();
		try{
			if (request.getGasPricePriority()!=null){
				bitcoin.setTxFee(request.getGasPricePriority());
			}
			if(validateBalance.isBalanceValid(request.getFromAccount(), new Double(request.getValue()))){
				String txId = bitcoin.sendFrom(request.getFromAccount(), request.getToAddress(), Double.parseDouble(request.getValue()));
				response.setTxId(txId);
				response.setCode(Constantes.CODE_SUCCESS);
				response.setStatus(Constantes.SUCCESS_STATUS);
			}else{
				response.setCode(Constantes.TRANSACTION_FAILURE);
				response.setStatus("Saldo insuficiente. amount+feerate");
			}
		}catch (Exception e) {
			response.setCode(Constantes.TRANSACTION_FAILURE);
			response.setStatus(e.getMessage());
		}
		return response;
	}
}