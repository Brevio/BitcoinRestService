package br.com.bitcoin.services;

import java.util.LinkedHashMap;
import java.util.List;

import br.com.bitcoin.model.UnspentResponse;
import br.com.bitcoin.util.Constantes;
import wf.bitcoin.javabitcoindrpcclient.BitcoinJSONRPCClient;
import wf.bitcoin.javabitcoindrpcclient.GenericRpcException;


public class UnspentListService {
	private BitcoinJSONRPCClient bitcoin = new BitcoinJSONRPCClient();
	public UnspentResponse listUnspentByAddres(String address){
		UnspentResponse response = new UnspentResponse();
		try{
			response.setUnspent(listUnspentAdress(1, 9999999, address));
			response.setCode(Constantes.CODE_SUCCESS);
			response.setStatus(Constantes.SUCCESS_STATUS);
		}catch (Exception e) {
			response.setCode(Constantes.UNSPENT_FAILURE);
			response.setStatus(e.getMessage());
		}
		return response;
	}
	public UnspentResponse listUnspents(){
		UnspentResponse response = new UnspentResponse();
		try{
			response.setUnspent(listUnspent());
			response.setCode(Constantes.CODE_SUCCESS);
			response.setStatus(Constantes.SUCCESS_STATUS);
		}catch (Exception e) {
			response.setCode(Constantes.UNSPENT_FAILURE);
			response.setStatus(e.getMessage());
		}
		return response;
	}

	private List<LinkedHashMap> listUnspentAdress(int minConf, int maxConf, String... addresses) throws GenericRpcException {
	    return  (List<LinkedHashMap>) bitcoin.query("listunspent");
	  }
	private List<LinkedHashMap> listUnspent() throws GenericRpcException {
	    return  (List<LinkedHashMap>) bitcoin.query("listunspent");
	  }
}
