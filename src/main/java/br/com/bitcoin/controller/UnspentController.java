package br.com.bitcoin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.bitcoin.model.UnspentResponse;
import br.com.bitcoin.services.UnspentListService;

@RestController
@RequestMapping("application.wadl/unspent")
public class UnspentController {
	@RequestMapping(value = "/listUnspentByAddress", method = RequestMethod.POST)
	public UnspentResponse listUnspent(@RequestParam (defaultValue = "")String address){
		UnspentListService unspent = new UnspentListService();
		return unspent.listUnspentByAddres(address);
		
	}
	@RequestMapping(value = "/listUnspent", method = RequestMethod.GET)
	public UnspentResponse listUnspent(){
		UnspentListService unspent = new UnspentListService();
		return unspent.listUnspents();
		
	}

}
