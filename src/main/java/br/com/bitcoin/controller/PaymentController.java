package br.com.bitcoin.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.bitcoin.model.MoveRequest;
import br.com.bitcoin.model.MoveResponse;
import br.com.bitcoin.model.PayByAddressRequest;
import br.com.bitcoin.model.PayByListRequest;
import br.com.bitcoin.model.PaymentRequest;
import br.com.bitcoin.model.PaymentResponse;
import br.com.bitcoin.services.CreatesInputsOutputsService;
import br.com.bitcoin.services.MoveService;
import br.com.bitcoin.services.TransactionService;
import br.com.bitcoin.util.Constantes;


@RestController
@RequestMapping("application.wadl/payment")
public class PaymentController {
	@RequestMapping(value = "/pay", method = RequestMethod.POST)
	public PaymentResponse pay(@RequestBody PaymentRequest request) {
		TransactionService transaction = new TransactionService();
		PaymentResponse response = new PaymentResponse();
		if(request.getFromAccount().equalsIgnoreCase(request.getToAddress())){
			response.setStatus("Operação não permitida! Carteira de origem não pode ser a mesma de destino.");
			response.setCode(Constantes.TRANSACTION_FAILURE);
		}else{

			return transaction.send(request);
		}
		return response;
 }
	@RequestMapping(value = "/payByAddress", method = RequestMethod.POST)
	public PaymentResponse payByAddress(@RequestBody PayByAddressRequest request){
		CreatesInputsOutputsService inputsOutputsService = new CreatesInputsOutputsService();
		return inputsOutputsService.creates(request);
	}
	
	@RequestMapping(value = "/payMult", method = RequestMethod.POST)
	public PaymentResponse multPay(@RequestBody PayByListRequest request){
		CreatesInputsOutputsService inputsOutputsService = new CreatesInputsOutputsService();
		return inputsOutputsService.createsMult(request);
	}
	
	@RequestMapping(value = "/move", method = RequestMethod.POST)
	public MoveResponse move(@RequestBody MoveRequest request){
		MoveService moveService = new MoveService();
		return moveService.move(request);
	}
}