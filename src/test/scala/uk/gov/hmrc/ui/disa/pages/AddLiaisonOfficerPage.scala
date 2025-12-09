package uk.gov.hmrc.ui.disa.pages

object AddLiaisonOfficerPage extends BasePage {
  val pageUrl: String   = s"$baseUrl/add-liaison-officer"
  val pageTitle: String = "Add liaison officer - Liaison officers - disa-registration-frontend - GOV.UK"

  def verifyPageUrl(): Boolean =
    getCurrentUrl == pageUrl

  def verifyPageTitle(title: String): Boolean =
    getTitle == pageTitle
}
