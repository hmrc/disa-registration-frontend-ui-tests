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

class AddSignatoryScreenSpec extends BaseSpec {

  Feature("Add a Signatory Screen") {

    Scenario("Verify user can access Add a signatory screen and proceed") {
      Given("Given the user is logged in and on the \"/add-a-signatory\" URL")
      AuthLoginPage.loginAsNonAutomatchedOrgAdmin()

      When("the user navigates to the Add a Signatory page")
      AuthLoginPage.navigateTo(AddSignatoryPage.pageUrl)

      Then("the page URL should be correct")
      AddSignatoryPage.verifyPageUrl() shouldBe true

      And("the page title should be correct")
      AddSignatoryPage.verifyPageTitle() shouldBe true
    }
  }
}
