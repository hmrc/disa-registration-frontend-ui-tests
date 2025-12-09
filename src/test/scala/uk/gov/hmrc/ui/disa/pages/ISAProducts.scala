package uk.gov.hmrc.ui.disa.pages

object ISAProducts extends BasePage {
  val pageUrl: String   = s"$baseUrl/isa-products"
  val pageTitle: String =
    "Which ISA products does your organisation offer? - ISA products - disa-registration-frontend - GOV.UK"

  def verifyPageUrl(): Boolean =
    getCurrentUrl == pageUrl

  def verifyPageTitle(title: String): Boolean =
    getTitle == pageTitle
}
