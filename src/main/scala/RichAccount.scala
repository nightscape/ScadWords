import com.google.api.adwords.v201008.mcm.Account
import com.google.api.adwords.v201008.cm.Campaign
class RichAccount(val account:Account) {
  def createCampaign(name:String) = {
    val campaign = new Campaign()
    campaign.setName(name)
  }
}