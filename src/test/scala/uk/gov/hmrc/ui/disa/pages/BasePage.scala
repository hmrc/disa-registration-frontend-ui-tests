/*
 * Copyright 2023 HM Revenue & Customs
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

package uk.gov.hmrc.ui.disa.pages

import org.openqa.selenium.{By, WebDriver}
import org.openqa.selenium.support.ui.{ExpectedConditions, FluentWait, Wait}
import org.scalatest.matchers.should.Matchers
import uk.gov.hmrc.selenium.component.PageObject
import uk.gov.hmrc.selenium.webdriver.Driver
import uk.gov.hmrc.ui.disa.conf.TestConfiguration

import java.time.Duration

trait BasePage extends Matchers with PageObject {

  val pageUrl: String
  val baseUrl: String     = TestConfiguration.url("disa-registration-frontend") + "" //   /register
  val submitButtonId: By  = By.id("submit")
  val yesRadioId: By      = By.id("value")
  val noRadioId: By       = By.id("value-no")
  val countryDropdown: By = By.id("country")
  val countryOption: By   = By.id("country__option--0")
  val backLinkText: By    = By.id("Back")

  val signInButtonClassName: By    = By.className("govuk-button")

  private def fluentWait: Wait[WebDriver] = new FluentWait[WebDriver](Driver.instance)
    .withTimeout(Duration.ofSeconds(2))
    .pollingEvery(Duration.ofMillis(200))

  def onPage(url: String = this.pageUrl): Unit = fluentWait.until(ExpectedConditions.urlToBe(url))

  def countryAutoSelect(countryName: String): Unit = {
    click(countryDropdown)
    sendKeys(countryDropdown, countryName)
    click(countryOption)
  }

  def onPageSubmitById(): Unit = {
    onPage()
    click(submitButtonId)
  }

  def clickOnBackLink(): Unit = {
    onPage()
    click(backLinkText)
  }

  def clickOnByPartialLinkText(partialLinkText: By): Unit = {
    onPage()
    click(partialLinkText)
  }


  def clickOnSignInButton(): Unit = {
    onPage()
    click(signInButtonClassName)
  }

  def isElementPresent(locator: By): Boolean = {
    Driver.instance.findElements(locator).size() > 0
  }

  def isLanguageLinkPresentAndClickable(locator: By): Boolean = {
    val element = Driver.instance.findElement(locator)
    element.isDisplayed && element.isEnabled
  }
}
