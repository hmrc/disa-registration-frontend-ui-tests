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

class AddThirdPartySpec extends BaseSpec {

  Feature("Add third party details") {

    Scenario("1.Verify user can add third party organisations") {
      Given("the user is logged in as an organisation User")
      AuthLoginPage.loginAsAFreshUser("/isa-products")

      Then("the 'ISA products' page title should be correct")
      ISAProductsPage.verifyPageTitle(ISAProductsPage.pageTitle, ISAProductsPage.pageUrl) shouldBe true

      When("the user navigates to the 'manage third party' page")
      AuthLoginPage.navigateTo(ThirdPartyProductManagePage.pageUrl)

      Then("the user is navigated to the 'manage third party' page")
      ThirdPartyProductManagePage.verifyPageTitle(
        ThirdPartyProductManagePage.pageTitle,
        ThirdPartyProductManagePage.pageUrl
      ) shouldBe true

      Then("the user clicks on yes radio button on 'Manage third party' page ")
      ThirdPartyProductManagePage.clickRadioButton("Yes")

      Then("the user clicks on save and continue button on 'Manage third party' page ")
      ThirdPartyProductManagePage.clickSaveAndContinue()

      Then("the user is navigated to the 'third party details' page")
      ThirdPartyDetailsPage.verifyPageTitle(
        ThirdPartyDetailsPage.pageTitle,
        ThirdPartyDetailsPage.pageUrl
      ) shouldBe true

      When("the user enters the Third party org name and FRN and clicks on Save and continue button")
      ThirdPartyDetailsPage.enterText("thirdPartyName", "ThirdParty")
      ThirdPartyDetailsPage.enterText("frn", "777333")
      ThirdPartyDetailsPage.clickSaveAndContinue()

      Then("the user is navigated to the 'third party manage' page")
      ThirdPartyManageISAsPage.verifyPageTitle(
        ThirdPartyManageISAsPage.pageTitle,
        ThirdPartyManageISAsPage.pageUrl
      ) shouldBe true

    }

  }
}
