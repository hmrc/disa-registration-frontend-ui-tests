package uk.gov.hmrc.ui.disa.pages

object PeerToPeerLoans extends BasePage {
  val pageUrl: String   = s"$baseUrl/peer-to-peer-loans"
  val pageTitle: String =
    "Which platform does your organisation use to offer peer-to-peer loans? - ISA products - disa-registration-frontend - GOV.UK"

  def verifyPageUrl(): Boolean =
    getCurrentUrl == pageUrl

  def verifyPageTitle(title: String): Boolean =
    getTitle == pageTitle
}
