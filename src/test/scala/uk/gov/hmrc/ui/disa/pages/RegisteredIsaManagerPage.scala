package uk.gov.hmrc.ui.disa.pages

object RegisteredIsaManagerPage extends BasePage {
  val pageUrl: String   = s"$baseUrl/registered-isa-manager"
  val pageTitle: String =
    "Is your organisation registered to manage ISAs with HMRC? - Organisation details - disa-registration-frontend - GOV.UK"

  def verifyPageUrl(): Boolean =
    getCurrentUrl == pageUrl

  def verifyPageTitle(title: String): Boolean =
    getTitle == pageTitle
}
