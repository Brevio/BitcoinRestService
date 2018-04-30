package br.com.bitcoin.model;
import java.util.Map;

public class AccountsResponse extends BaseResponse {
	Map<String, Number> listAccounts;

	public Map<String, Number> getListAccounts() {
		return listAccounts;
	}

	public void setListAccounts(Map<String, Number> listAccounts) {
		this.listAccounts = listAccounts;
	}
	

}
