import com.google.api.adwords.lib.{AdWordsService,AdWordsUser}
import com.google.api.adwords.v201008.mcm.{ServicedAccountSelector,ServicedAccountServiceInterface, Account}


class RichAdwordsUser(val user:AdWordsUser) {
  def keywords() = {
//    val service = user.getService(AdWordsService.V201008.ADGROUP_CRITERION_SERVICE);
//    final AdGroupCriterionServiceDataSource dataSource = new AdGroupCriterionServiceDataSource(service, campaign.getCampaign().getId());
	  List()
  }
  def accounts() : List[Account] = {
	  	  // Get the ServicedAccountService.
      val servicedAccountService:ServicedAccountServiceInterface =
          user.getService(AdWordsService.V201008.SERVICED_ACCOUNT_SERVICE)
      // Create selector.
      val selector = new ServicedAccountSelector();
      // To get the links paging must be disabled.
      selector.setEnablePaging(false);

      // Get serviced account graph.
      val graph = servicedAccountService.get(selector)

      // Display serviced account graph.
      if (graph != null) {
        // Create map from customerId to account node.
        // Create account tree nodes for each account.
        return graph.getAccounts().elements.toList

    } else {
    	return List()
    }
      
  }
}