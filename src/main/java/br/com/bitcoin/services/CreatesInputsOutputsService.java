package br.com.bitcoin.services;

import java.util.ArrayList;

import br.com.bitcoin.model.PayByAddressRequest;
import br.com.bitcoin.model.PayByListRequest;
import br.com.bitcoin.model.PaymentResponse;
import br.com.bitcoin.model.TxInputModel;
import br.com.bitcoin.model.TxOutputModel;

public class CreatesInputsOutputsService {
	private TxInputModel input = new TxInputModel();
	private TxOutputModel output;
	private String rawTransactionHex;
	private CreateMultRawTransactionService raw;
	private SendRawTransactionService send = new SendRawTransactionService();
	
	
	public PaymentResponse creates(PayByAddressRequest request){
		input.setScriptPubKey(request.getScriptPubKey());
		input.setTxId(request.getTxId());
		input.setVout(request.getVout());
		output = new TxOutputModel(request.getAddress(), request.getAmount());
		raw = new CreateMultRawTransactionService(input, output);
		rawTransactionHex = raw.createRawFromAddress();
		return send.sendRaw(rawTransactionHex);
	}
	public PaymentResponse createsMult(PayByListRequest request){
		ArrayList<TxInputModel> listInputs = new ArrayList<TxInputModel>();
		ArrayList<TxOutputModel> listOutputs = new ArrayList<TxOutputModel>();
		ArrayList<PayByAddressRequest> payByListRequest = request.getPayByListRequest();
		for (PayByAddressRequest payByAddressRequest : payByListRequest) {
			if(!payByAddressRequest.getTxId().equals(""))
			{
				input.setScriptPubKey(payByAddressRequest.getScriptPubKey());
				input.setTxId(payByAddressRequest.getTxId());
				input.setVout(payByAddressRequest.getVout());
				listInputs.add(input);
			}
			if(!payByAddressRequest.getAddress().equals("")){
				output = new TxOutputModel(payByAddressRequest.getAddress(), payByAddressRequest.getAmount());
				listOutputs.add(output);
			}
		}
		raw = new CreateMultRawTransactionService(listInputs, listOutputs);
		rawTransactionHex = raw.createRawFromMultAddress();
		return send.sendRaw(rawTransactionHex);
	}

}
