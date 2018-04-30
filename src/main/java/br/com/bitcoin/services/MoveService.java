package br.com.bitcoin.services;

import br.com.bitcoin.model.MoveRequest;
import br.com.bitcoin.model.MoveResponse;
import br.com.bitcoin.util.Constantes;
import br.com.bitcoin.util.validateBalance;
import wf.bitcoin.javabitcoindrpcclient.BitcoinJSONRPCClient;
import wf.bitcoin.javabitcoindrpcclient.GenericRpcException;

public class MoveService {
	private BitcoinJSONRPCClient bitcoin = new BitcoinJSONRPCClient();
	public MoveResponse move(MoveRequest request){
		MoveResponse response = new MoveResponse();
		try{
			if(validateBalance.isBalanceValidMove(request.getFromAccount(), request.getAmount())){
				if(move(request.getFromAccount(), request.getToAccount(), request.getAmount())){
					response.setSucess("true");
					response.setCode(Constantes.CODE_SUCCESS);
					response.setStatus(Constantes.SUCCESS_STATUS);
				}else{
					response.setCode(Constantes.TRANSACTION_FAILURE);
					response.setStatus("Saldo insuficiente.");
				}
			}
		}catch (Exception e) {
			response.setSucess("false");
			response.setCode(Constantes.BITCOIND_FAILURE);
			response.setStatus(e.getMessage());
		}
		return response;
	}
	
	  public boolean move(String fromAccount, String toBitcoinAddress, double amount) throws GenericRpcException {
		    return (boolean) bitcoin.query("move", fromAccount, toBitcoinAddress, amount);
		  }

}
