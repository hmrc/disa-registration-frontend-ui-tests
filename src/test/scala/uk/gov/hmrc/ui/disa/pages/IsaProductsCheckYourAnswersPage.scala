package uk.gov.hmrc.ui.disa.pages

object IsaProductsCheckYourAnswersPage extends BasePage {
  val pageUrl: String   = s"$baseUrl/isa-products-check-your-answers"
  val pageTitle: String = "Check your answers - ISA products - disa-registration-frontend - GOV.UK"

  def verifyPageUrl(): Boolean =
    getCurrentUrl == pageUrl

  def verifyPageTitle(title: String): Boolean =
    getTitle == pageTitle
}
