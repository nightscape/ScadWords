import com.google.api.adwords.lib.AdWordsUser
import com.google.api.adwords.v201008.mcm.Account
object AdWordsDsl {
  implicit def enrichUser(user:AdWordsUser) = new RichAdwordsUser(user)
  implicit def enrichAccount(account:Account) = new RichAccount(account)
}