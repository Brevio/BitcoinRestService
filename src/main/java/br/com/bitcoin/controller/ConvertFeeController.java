package br.com.bitcoin.controller;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.bitcoin.model.ConvertResponse;
import br.com.bitcoin.util.Constantes;

@RestController
@RequestMapping("application.wadl/convertFee")
public class ConvertFeeController {
	
	@RequestMapping(value = "/convert", method = RequestMethod.POST)
	public ConvertResponse convert(@RequestParam Double fee){
		ConvertResponse response = new ConvertResponse();
		String result;
		result = BigDecimal.valueOf(fee).toString();
		response.setCode(Constantes.CODE_SUCCESS);
		response.setStatus(Constantes.SUCCESS_STATUS);
		response.setFee(result);
		return response;
		
		
		
	}

}
