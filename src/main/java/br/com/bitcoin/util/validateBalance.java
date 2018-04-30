package br.com.bitcoin.util;

import wf.bitcoin.javabitcoindrpcclient.BitcoinJSONRPCClient;
import wf.bitcoin.javabitcoindrpcclient.BitcoindRpcClient.SmartFeeResult;

public class validateBalance {
	private static boolean valid;
	private static BitcoinJSONRPCClient bitcoin = new BitcoinJSONRPCClient();
	public static boolean isBalanceValid(String account, Double amountToSend){
		double balance = bitcoin.getBalance(account);
		SmartFeeResult estimateSmartFee = bitcoin.getEstimateSmartFee(2);
		double finalValue = amountToSend+estimateSmartFee.feeRate();
		if(finalValue<balance){
			valid = true;
		}else{
			valid = false;
		}
		return valid;
	}
	public static boolean isBalanceValidMove(String fromAccount, Double amount) {
		double balance = bitcoin.getBalance(fromAccount);

		if(amount<balance){
			valid = true;
		}else{
			valid = false;
		}
		return valid;
	}
}
