package br.com.bitcoin.services;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import br.com.bitcoin.model.MultPayRequest;
import br.com.bitcoin.model.PaymentResponse;
import br.com.bitcoin.model.TxOutputModel;
import br.com.bitcoin.util.Constantes;
import wf.bitcoin.javabitcoindrpcclient.BitcoinJSONRPCClient;
import wf.bitcoin.javabitcoindrpcclient.BitcoindRpcClient.TxInput;
import wf.bitcoin.javabitcoindrpcclient.BitcoindRpcClient.TxOutput;
import wf.bitcoin.javabitcoindrpcclient.BitcoindRpcClient.Unspent;

public class MultPayTransactionService {
	private BitcoinJSONRPCClient bitcoin = new BitcoinJSONRPCClient();
	private List<TxInput> listTxInputs;
	private List<TxOutput> listTxOutputs;
	private String transactionHex;
	private String signRawTransactionHex;
	private List<TxOutputModel> listTxOutputModel;
	public PaymentResponse sendMany(MultPayRequest request){
		PaymentResponse response = new PaymentResponse();
		try {
			listTxOutputModel = new ArrayList<TxOutputModel>();
			for(int i = 0; i<request.getListFromAddress().size();i++){
				listTxOutputModel.add(new TxOutputModel(request.getListToAddress().get(i), request.getListAmount().get(i)));
			}
			listTxInputs = toListTxInput(request.getListFromAddress());
			listTxOutputs = toListTxOutput(listTxOutputModel);
			transactionHex = createRawTransaction(listTxInputs,listTxOutputs);
			signRawTransactionHex = bitcoin.signRawTransaction(transactionHex);
			response.setTxId(bitcoin.sendRawTransaction(signRawTransactionHex));
			response.setCode(Constantes.CODE_SUCCESS);
			response.setStatus(Constantes.SUCCESS_STATUS);
			
			
		}catch (Exception e) {
			response.setCode(Constantes.TRANSACTION_FAILURE);
			response.setStatus(e.getMessage());
		}
		return response;
	}
	public String createRawTransaction(List<TxInput> inputs, List<TxOutput> outputs) {
	    List<Map> pInputs = new ArrayList<>();

	    for (final TxInput txInput : inputs) {
	      pInputs.add(new LinkedHashMap() {
	        {
	          put("txid", txInput.txid());
	          put("vout", txInput.vout());
	        }
	      });
	    }

	    Map<String, Double> pOutputs = new LinkedHashMap();

	    Double oldValue;
	    for (TxOutput txOutput : outputs) {
	    	oldValue = txOutput.amount();
	        pOutputs.put(txOutput.address(),oldValue);
	    }

	    return (String) bitcoin.query("createrawtransaction", pInputs, pOutputs);
	  }

	private List<TxInput> toListTxInput(List<String> listFromAddress){
		List<TxInput> listTxInputs = new ArrayList<TxInput>();
		for (String address : listFromAddress) {
			List<Unspent> listUnspent = bitcoin.listUnspent(0, 999999999, address);
				TxInput input = new TxInput() {
					@Override
					public int vout() {
						return listUnspent.get(0).vout();
					}
					@Override
					public String txid() {
						return listUnspent.get(0).txid();
					}
					@Override
					public String scriptPubKey() {
						return listUnspent.get(0).scriptPubKey();
					}
				};
				listTxInputs.add(input);				
		}
		return listTxInputs;
	}
	private List<TxOutput> toListTxOutput(List<TxOutputModel> listToAddressAndAmount ){
		
		List<TxOutput> listTxOutput = new ArrayList<TxOutput>();
		
		for (TxOutputModel toAddress : listToAddressAndAmount) {
				TxOutput txOutput = new TxOutput() {
					
					@Override
					public double amount() {
						return toAddress.getAmount();
					}
					
					@Override
					public String address() {
						return toAddress.getAddress();
					}
				};
				listTxOutput.add(txOutput);
			}
		return listTxOutput;
	}
}
