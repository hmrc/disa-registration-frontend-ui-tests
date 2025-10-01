/*
 * Copyright 2024 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.ui.pages

import org.openqa.selenium.By

object ForYourSecurityWeSignedYouOutPage extends BasePage {
  override val pageUrl: String   = baseUrl + "/account/signed-out"
  val weSavedYourAnswersText: By = By.xpath("//p[@class='govuk-body'][position()=1]")
  val h1PageTitleText: By        = By.className("govuk-heading-xl")
  private val englishLink: By    = By.xpath("//span[text()='English']")
  private val cymraegLink: By    = By.linkText("//span[text()='Cymraeg']")

  def getTitlePage(): String = {
    onPage()
    getText(h1PageTitleText)
  }

  def getWeSavedYourAnswersText(): String = {
    onPage()
    getText(weSavedYourAnswersText)
  }

  def isSignInButtonPresent(): Boolean =
    isElementPresent(signInButtonClassName)

  def isEnglishLinkPresentAndClickable(): Boolean =
    isLanguageLinkPresentAndClickable(englishLink)

  def isCymraegLinkPresentAndClickable(): Boolean =
    isLanguageLinkPresentAndClickable(cymraegLink)
}
