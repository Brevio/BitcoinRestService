package br.com.bitcoin.controller;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.bitcoin.model.AccountsResponse;
import br.com.bitcoin.model.AddressResponse;
import br.com.bitcoin.model.BalanceResponse;
import br.com.bitcoin.model.NewAccountResponse;
import br.com.bitcoin.services.AdminTransactionService;


@RestController
@RequestMapping("application.wadl/admin")
public class AdminTrasactionController {
	
	private AdminTransactionService admin = new AdminTransactionService();
	
	@RequestMapping(value = "/balance", method = RequestMethod.POST)
	public BalanceResponse getBalance(@RequestParam(defaultValue="") String account){
			return admin.getBalanceAccount(account);
	}
	@RequestMapping(value = "/balanceAddress", method = RequestMethod.POST)
	public BalanceResponse getBalanceAddress(@RequestParam(defaultValue="") String address){
			return admin.getBalanceAddress(address);
	}
	@RequestMapping(value = "/accounts", method = RequestMethod.GET)
	public AccountsResponse listAccounts(){
		return admin.getListAccounts();
	}
	@RequestMapping(value = "/address", method = RequestMethod.POST)
	public AddressResponse address(@RequestParam (defaultValue="") String account) {
		return admin.getAddressAccount(account);
	}
	@RequestMapping(value = "/newAccount", method = RequestMethod.GET)
	public NewAccountResponse createAccount() {
		return admin.createAccount();
	}
	@RequestMapping(value = "/newAddressByAccount", method = RequestMethod.GET)
	public NewAccountResponse createAddressByAccount(@RequestParam (defaultValue="") String account) {
		return admin.createAddressByAccount(account);
	}

}

