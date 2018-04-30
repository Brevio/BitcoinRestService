package br.com.bitcoin.services;

import br.com.bitcoin.model.PaymentResponse;
import br.com.bitcoin.util.Constantes;
import wf.bitcoin.javabitcoindrpcclient.BitcoinJSONRPCClient;

public class SendRawTransactionService {
	public PaymentResponse sendRaw(String rawTransaction){
		PaymentResponse response = new PaymentResponse();
		BitcoinJSONRPCClient client = new BitcoinJSONRPCClient();
		try{
			String hex = client.signRawTransaction(rawTransaction);
			response.setTxId(client.sendRawTransaction(hex));
			response.setCode(Constantes.CODE_SUCCESS);
			response.setStatus(Constantes.SUCCESS_STATUS);
		}catch(Exception e){
			response.setCode(Constantes.TRANSACTION_FAILURE);
			response.setStatus(e.getMessage());
		}
		return response;
	}
}
