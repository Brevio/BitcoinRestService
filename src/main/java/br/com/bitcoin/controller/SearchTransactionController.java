package br.com.bitcoin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.bitcoin.model.SearchResponse;
import br.com.bitcoin.services.SearchTransactionsService;



@RestController
@RequestMapping("application.wadl/searchTransaction")
public class SearchTransactionController {
	private SearchTransactionsService search = new SearchTransactionsService();
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public SearchResponse getTransaction(@RequestParam(defaultValue="") String transactionHash){
			return search.search(transactionHash);
	}

}
