package uk.gov.hmrc.ui.disa.pages

object AgentServicesKickOutPage extends BasePage {
  val pageUrl: String   = s"$baseUrl/unsupported-affinity-group?affinityGroup=Agent"
  val pageTitle: String = "Sorry, you’re unable to use this service - disa-registration-frontend - GOV.UK"

  def verifyPageUrl(): Boolean =
    getCurrentUrl == pageUrl

  def verifyPageTitle(title: String): Boolean =
    getTitle == pageTitle
}
