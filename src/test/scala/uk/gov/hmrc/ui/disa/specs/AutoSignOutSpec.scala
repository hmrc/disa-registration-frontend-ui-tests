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

class AutoSignOutSpec extends BaseSpec {

  Feature("Auto Sign-Out") {

      Scenario("User is automatically signed out after inactivity", RegistrationTests, ZapTests) {

        Given("The user is redirected to the signed out page")
        AuthLoginPage.loginAsNonAutomatchedOrgAdmin()
        AutoSignOutPage.loadPage()

//        Then("The page title should display For your security, we signed you out")
//        val titlePageText = AutoSignOutPage.getTitlePage()
//        titlePageText shouldBe "For your security, we signed you out"

//        And("The page should display the message We saved your answers")
//        val pageMessage = AutoSignOutPage.getWeSavedYourAnswersText()
//        pageMessage shouldBe "We saved your answers."

        And("A Sign in button should be visible")
        AutoSignOutPage.isSignInButtonPresent() shouldBe true

//        And("The user should be able to switch the language between English and Cymraeg")
//        AutoSignOutPage.isEnglishLinkPresentAndClickable() shouldBe true
//        AutoSignOutPage.isCymraegLinkPresentAndClickable() shouldBe true
      }
  }
}
