package uk.gov.hmrc.ui.disa.pages

object OrganisationZReferenceNumberPage extends BasePage {
  val pageUrl: String   = s"$baseUrl/z-reference-number"
  val pageTitle: String =
    " What is your organisation’s Z-reference number? - Organisation details - disa-registration-frontend - GOV.UK"

  def verifyPageUrl(): Boolean =
    getCurrentUrl == pageUrl

  def verifyPageTitle(): Boolean =
    getTitle == pageTitle
}
