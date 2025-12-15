package uk.gov.hmrc.ui.disa.pages

object TradingUsingDifferentNamePage extends BasePage {
  val pageUrl: String   = s"$baseUrl/trading-using-different-name"
  val pageTitle: String =
    "Does your organisation trade using a different name? - Organisation details - disa-registration-frontend - GOV.UK"

  def verifyPageUrl(): Boolean =
    getCurrentUrl == pageUrl

  def verifyPageTitle(title: String): Boolean =
    getTitle == pageTitle
}
