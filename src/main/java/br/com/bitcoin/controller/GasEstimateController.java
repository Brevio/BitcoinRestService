package br.com.bitcoin.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.bitcoin.model.GasEstimateResponse;
import br.com.bitcoin.services.GasEstimateService;
import br.com.bitcoin.util.Constantes;



@RestController
@RequestMapping("application.wadl/gasEstimate")
public class GasEstimateController {
	@RequestMapping(value = "/estimate", method = RequestMethod.POST)
	public GasEstimateResponse gasEstimate(@RequestParam(defaultValue="0") Integer nBlocks){
		GasEstimateService gas = new GasEstimateService();
		GasEstimateResponse response  = new GasEstimateResponse();
		if(nBlocks<2){
			response.setCode(Constantes.GAS_ESTIMATE_FAILURE);
			response.setStatus("nBlocks < 2");
		}else{
			response = gas.estimate(nBlocks);
		}
		return response;
	}

}
