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

package uk.gov.hmrc.ui.disa.specs

import uk.gov.hmrc.ui.disa.pages.*
import uk.gov.hmrc.ui.disa.specs.tags.*

class ForYourSecurityWeSignedOutSpec extends BaseSpec {

  Feature("Account Signed Out Page") {

    Scenario("Individual with NINO", RegistrationTests, ZapTests) {

      Given("The user is redirected to the signed out page")
      AuthLoginPage.loginAsNonAutomatchedIndAdmin()
      ForYourSecurityWeSignedYouOutPage.onPage()
      
      Then("The page title should display For your security, we signed you out")
      val titlePageText = ForYourSecurityWeSignedYouOutPage.getTitlePage()
      titlePageText shouldBe "For your security, we signed you out"

      And("The page should display the message We saved your answers")
      val pageMessage = ForYourSecurityWeSignedYouOutPage.getWeSavedYourAnswersText()
      pageMessage shouldBe "We saved your answers."
      
      And("A Sign in button should be visible")
      ForYourSecurityWeSignedYouOutPage.isSignInButtonPresent() shouldBe true

      And("The Sign in button should redirect the user to the login page")

      And("The user should be able to switch the language between English and Cymraeg")
      ForYourSecurityWeSignedYouOutPage.isEnglishLinkPresentAndClickable() shouldBe true
      ForYourSecurityWeSignedYouOutPage.isCymraegLinkPresentAndClickable() shouldBe true
    }

  }
}
