
import br.com.bitcoin.services.GasEstimateService;
import br.com.bitcoin.services.SearchTransactionsService;
import br.com.bitcoin.services.UnspentListService;

public class Tests {


	
	public static void main(String[] args)  {
	
	//	AdminTransactionService admin = new AdminTransactionService();
		
//		SearchTransactionsService s = new SearchTransactionsService();
//		UnspentListService u = new UnspentListService();
		
		GasEstimateService gas = new GasEstimateService();
		gas.estimate(2);
		
//		System.out.println(s.search("b6b1264414c603fe135c0a642235b6d53dea17cd40f4957c83a371ebd50a2933").getStatusTransaction());
//		System.out.println(admin.getListAccounts().getListAccounts().toString());
		
		
}
}