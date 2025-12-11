package uk.gov.hmrc.ui.disa.pages

object InnovativeFinancialProductsPage extends BasePage {
  val pageUrl: String   = s"$baseUrl/innovative-financial-products"
  val pageTitle: String =
    "Which types of innovative finance products will your organisation offer? - ISA products - disa-registration-frontend - GOV.UK"

  def verifyPageUrl(): Boolean =
    getCurrentUrl == pageUrl

  def verifyPageTitle(title: String): Boolean =
    getTitle == pageTitle
}
