package br.com.bitcoin.services;

import java.util.List;

import org.bitcoinj.core.ECKey;
import org.bitcoinj.core.Utils;

import br.com.bitcoin.model.AccountsResponse;
import br.com.bitcoin.model.AddressResponse;
import br.com.bitcoin.model.BalanceResponse;
import br.com.bitcoin.model.NewAccountResponse;
import br.com.bitcoin.util.Constantes;
import wf.bitcoin.javabitcoindrpcclient.BitcoinJSONRPCClient;
import wf.bitcoin.javabitcoindrpcclient.BitcoindRpcClient.Unspent;

public class AdminTransactionService {
	
	private BitcoinJSONRPCClient admin = new BitcoinJSONRPCClient();
	
	
	public BalanceResponse getBalanceAccount(String account) {
		BalanceResponse response = new BalanceResponse();
		Double balance;
		try{
			balance = admin.getBalance(account);
			response.setCode(Constantes.CODE_SUCCESS);
			response.setStatus(Constantes.SUCCESS_STATUS);
			response.setBalance(balance);
		}catch (Exception e) {
			response.setCode(Constantes.ADMIN_FAILURE);
			response.setStatus(e.toString());
		}

		return response;
	}
	public BalanceResponse getBalanceAddress(String address) {
		BalanceResponse response = new BalanceResponse();
		Double balance = 0.0;
		try{
			List<Unspent> listUnspent = admin.listUnspent(1, 9999999, address);
			if(!listUnspent.isEmpty()){
				for (Unspent unspent : listUnspent) {
					balance = balance+unspent.amount();
				}
				response.setCode(Constantes.CODE_SUCCESS);
				response.setStatus(Constantes.SUCCESS_STATUS);
				response.setBalance(balance);
			}else {
				response.setCode(Constantes.CODE_SUCCESS);
				response.setStatus(Constantes.SUCCESS_STATUS);
				response.setBalance(0.0);
			}
			
		}catch (Exception e) {
			response.setCode(Constantes.ADMIN_FAILURE);
			response.setStatus(e.toString());
		}

		return response;
	}
	public AccountsResponse getListAccounts(){
	
		AccountsResponse response = new AccountsResponse();
		try{
			response.setListAccounts(admin.listAccounts());
			response.setCode(Constantes.CODE_SUCCESS);
			response.setStatus(Constantes.SUCCESS_STATUS);
		}catch (Exception e) {
			response.setCode(Constantes.ADMIN_FAILURE);
			response.setStatus(e.toString());
		}
		
		return response;
	}
	public AddressResponse getAddressAccount(String account){
		
		AddressResponse response = new AddressResponse();
		try{
			response.setAddress(admin.getAddressesByAccount(account));
			response.setCode(Constantes.CODE_SUCCESS);
			response.setStatus(Constantes.SUCCESS_STATUS);
		}catch (Exception e) {
			response.setCode(Constantes.ADMIN_FAILURE);
			response.setStatus(e.toString());
		}
		
		return response;
	}
	public NewAccountResponse createAccount() {
		
		NewAccountResponse response = new NewAccountResponse();
		
		ECKey key = new ECKey();
		String privateKeyAsHex = Utils.HEX.encode(key.getPrivKeyBytes());
		response.setPrivateKeyAsHex(privateKeyAsHex);
		
		try{
			response.setNewAddress(admin.getNewAddress(privateKeyAsHex));
			response.setCode(Constantes.CODE_SUCCESS);
			response.setStatus(Constantes.SUCCESS_STATUS);
		}catch (Exception e) {
			e.printStackTrace();
			response.setCode(Constantes.ADMIN_FAILURE);
			response.setStatus(e.toString());
		}
		return response;
	}
	public NewAccountResponse createAddressByAccount(String account) {
		
		NewAccountResponse response = new NewAccountResponse();
		response.setPrivateKeyAsHex(account);
		
		try{
			response.setNewAddress(admin.getNewAddress(account));
			response.setCode(Constantes.CODE_SUCCESS);
			response.setStatus(Constantes.SUCCESS_STATUS);
		}catch (Exception e) {
			e.printStackTrace();
			response.setCode(Constantes.ADMIN_FAILURE);
			response.setStatus(e.toString());
		}
		return response;
	}

}
