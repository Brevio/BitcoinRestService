package br.com.bitcoin.services;

import br.com.bitcoin.model.SearchResponse;
import br.com.bitcoin.util.Constantes;
import wf.bitcoin.javabitcoindrpcclient.BitcoinJSONRPCClient;
import wf.bitcoin.javabitcoindrpcclient.GenericRpcException;

public class SearchTransactionsService {

	private BitcoinJSONRPCClient bitcoinClient = new BitcoinJSONRPCClient();
	
	public SearchResponse search(String transactionHash) {
		
	
		SearchResponse response = new SearchResponse();
		try{
			response.setStatusTransaction(getTransaction(transactionHash));
			response.setCode(Constantes.CODE_SUCCESS);
			response.setStatus(Constantes.SUCCESS_STATUS);
			
		}catch (Exception e) {
			response.setCode(Constantes.SEARCH_FAILURE);
			response.setStatus(e.getMessage());
		}
		
		return response;
	}
	  private Object getTransaction(String txId) throws GenericRpcException {
		    return  bitcoinClient.query("gettransaction", txId);
		  }

}
