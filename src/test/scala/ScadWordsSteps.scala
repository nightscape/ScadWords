import cuke4duke._

import java.io.{FileInputStream, File}
import scala.collection.JavaConversions._
import com.google.api.adwords.lib.{AdWordsService,AdWordsUser}
import org.yaml.snakeyaml.Yaml
import com.google.api.adwords.v201008.mcm.Account

class ScadWordsSteps extends ScalaDsl with EN {
  import AdWordsDsl._
  val userHome = System getProperty "user.home"
  val configParser = new Yaml()
  val config:Map[String,Any] = configParser.load(new FileInputStream(new File(userHome+"/.sem4r/sem4r.yml"))).asInstanceOf[java.util.Map[String,Object]].toMap
  val adwordsConfig = config("google_adwords").asInstanceOf[java.util.Map[String,Object]].toMap
  val sandBoxConfig = adwordsConfig("sandbox").asInstanceOf[java.util.Map[String,String]].toMap
  var user:AdWordsUser = null
  var account:Account = null 
  
  Given("""I am logged into my AdWords API account""") {
    user = new AdWordsUser(sandBoxConfig("email"),sandBoxConfig("password"),null,"some user agent",sandBoxConfig("developer_token"),true)
  }
  Given("all client accounts are empty") {}
  Given("I select one client account") {
    account = user.accounts().first
  }
  When("I create the following campaigns") { table: Table =>
	for(hash <- table.hashes) {
      println(account.createCampaign(hash.get("name")))
	}
  }
}