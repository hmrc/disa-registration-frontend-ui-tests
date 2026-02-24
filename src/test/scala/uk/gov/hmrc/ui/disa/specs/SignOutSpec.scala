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
import uk.gov.hmrc.ui.disa.pages.AuthLoginPage.generateRandomZReference

class SignOutSpec extends BaseSpec {

  Feature("Display correct service timeout sign out page") {

    Scenario(
      "Verify 'saved answers sign out page' displayed correctly for the users who already saved answers and logs out"
    ) {
      val zReference: String = generateRandomZReference()
      Given("Given the ISA manager is logged in as an organisation User")
      AuthLoginPage.loginAsOrgUser(zReference)

      Then("The ISA products page title should be correct")
      ISAProductsPage.verifyPageTitle(ISAProductsPage.pageTitle, ISAProductsPage.pageUrl) shouldBe true

      When("The user selects ISA products and click on 'save and continue' button")
      ISAProductsPage.selectISAProductsAndContinue()

      Then("The Innovative Financial Products Page title should be correct")
      InnovativeFinancialProductsPage.verifyPageTitle(
        InnovativeFinancialProductsPage.pageTitle,
        InnovativeFinancialProductsPage.pageUrl
      ) shouldBe true

      When("The user clicks on sign out link")
      InnovativeFinancialProductsPage.signOut()

      /** Below step needed to add manually as the landing page port is incorrect when navigating from the previous page
        */
      When("The user navigates to correct sign out page manually")
      SavedAnswersSignOutPage.navigateTo(SavedAnswersSignOutPage.pageUrl)

      Then("The user directed to the sign out page which state the user answers were saved")
      SavedAnswersSignOutPage.verifyPageHeader(
        SavedAnswersSignOutPage.pageHeaderText,
        SavedAnswersSignOutPage.pageUrl
      ) shouldBe true
    }

    Scenario(
      "Verify 'sign out page' displayed correctly for the users who logs out without saving any answer"
    ) {
      val zReference: String = generateRandomZReference()
      Given("Given the ISA manager is logged in as an organisation User")
      AuthLoginPage.loginAsOrgUser(zReference)

      Then("The ISA products page title should be correct")
      ISAProductsPage.verifyPageTitle(ISAProductsPage.pageTitle, ISAProductsPage.pageUrl) shouldBe true

      When("The user clicks on sign out link")
      ISAProductsPage.signOut()

      /** Below step needed to added manually as the landing page port is incorrect when navigating from the previous
        * page
        */
      When("The user navigates to correct sign out page manually")
      SignOutPage.navigateTo(SignOutPage.pageUrl)

      Then("The user directed to the sign out page which state the user answers were saved")
      SignOutPage.verifyPageHeader(
        SignOutPage.pageHeaderText,
        SignOutPage.pageUrl
      ) shouldBe true
    }
  }
}
