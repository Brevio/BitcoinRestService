package br.com.bitcoin.services;

import java.util.ArrayList;
import java.util.List;

import br.com.bitcoin.model.TxInputModel;
import br.com.bitcoin.model.TxOutputModel;
import wf.bitcoin.javabitcoindrpcclient.BitcoinJSONRPCClient;
import wf.bitcoin.javabitcoindrpcclient.BitcoindRpcClient.TxInput;
import wf.bitcoin.javabitcoindrpcclient.BitcoindRpcClient.TxOutput;

public class CreateMultRawTransactionService {
	private TxInputModel txInput;
	private TxOutputModel txOutput;
	private ArrayList<TxInputModel> listTxInput;
	private ArrayList<TxOutputModel> listTxOutput;
	private BitcoinJSONRPCClient client = new BitcoinJSONRPCClient();

	public CreateMultRawTransactionService(TxInputModel txInput,TxOutputModel txOutput) {
		super();
		this.txInput = txInput;
		this.txOutput = txOutput;
	}
	public CreateMultRawTransactionService(ArrayList<TxInputModel> listTxInput,ArrayList<TxOutputModel> listTxOutput) {
		super();
		this.listTxInput = listTxInput;
		this.listTxOutput = listTxOutput;
	}
	public String createRawFromAddress(){
		ArrayList<TxInput> listInputs = new ArrayList<TxInput>();
		ArrayList<TxOutput> listOutputs= new ArrayList<TxOutput>();
		TxInput input = new TxInput() {
			
			@Override
			public int vout() {
				return txInput.getVout();
			}
			
			@Override
			public String txid() {
				return txInput.getTxId();
			}
			
			@Override
			public String scriptPubKey() {
				return null;
			}
		};
		listInputs.add(input);
		TxOutput output = new TxOutput() {
			
			@Override
			public double amount() {
				return txOutput.getAmount();
			}
			
			@Override
			public String address() {
				return txOutput.getAddress();
			}
		};
		listOutputs.add(output);
		
		return client.createRawTransaction(listInputs, listOutputs);
	}
	
	public String createRawFromMultAddress(){
		ArrayList<TxInput> listInputs = toListTxInput(listTxInput);
		ArrayList<TxOutput> listOutputs = toListTxOutput(listTxOutput);
		return client.createRawTransaction(listInputs, listOutputs);
		
		
	}
	private ArrayList <TxOutput> toListTxOutput(List<TxOutputModel> listToAddressAndAmount){
		
		ArrayList<TxOutput> listTxOutput = new ArrayList<TxOutput>();
		
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
	private ArrayList<TxInput> toListTxInput(ArrayList<TxInputModel> listFromAddress){
		ArrayList<TxInput> listTxInputs = new ArrayList<TxInput>();
		for (TxInputModel inputs : listFromAddress) {
			
				TxInput input = new TxInput() {
					@Override
					public int vout() {
						return inputs.getVout();
					}
					@Override
					public String txid() {
						return inputs.getTxId();
					}
					@Override
					public String scriptPubKey() {
						return inputs.getScriptPubKey();
					}
				};
				listTxInputs.add(input);				
		}
		return listTxInputs;
	}
	
}
