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

      When("the user navigates to the 'ISA products managed by third party' page")
      AuthLoginPage.navigateTo(ThirdPartyProductManagePage.pageUrl)

      Then("the user is navigated to the 'ISA products managed by third party' page")
      ThirdPartyProductManagePage.verifyPageTitle(
        ThirdPartyProductManagePage.pageTitle,
        ThirdPartyProductManagePage.pageUrl
      ) shouldBe true

      Then(
        "the user clicks on yes radio button and then click save and continue on 'ISA products managed by third party' page "
      )
      ThirdPartyProductManagePage.clickRadioButton("Yes")
      ThirdPartyProductManagePage.clickSaveAndContinue()

      Then("the user is navigated to the 'Third party organisations details' page")
      ThirdPartyDetailsPage.verifyPageTitle(
        ThirdPartyDetailsPage.pageTitle,
        ThirdPartyDetailsPage.pageUrl
      ) shouldBe true

      When("the user enters the Third party org name and FRN and clicks on Save and continue button")
      ThirdPartyDetailsPage.enterText("thirdPartyName", "ThirdParty")
      ThirdPartyDetailsPage.enterText("frn", "777333")
      ThirdPartyDetailsPage.clickSaveAndContinue()

      Then("the user is navigated to the 'ISA returns and reporting managed by third party' page")
      ThirdPartyManageISAsPage.verifyPageTitle(
        ThirdPartyManageISAsPage.pageTitle,
        ThirdPartyManageISAsPage.pageUrl
      ) shouldBe true

      Then(
        "the user clicks on yes radio button and then click on save and continue buttonn  on 'ISA returns and reporting managed by third party' page "
      )
      ThirdPartyManageISAsPage.clickRadioButton("Yes")
      ThirdPartyManageISAsPage.clickSaveAndContinue()

      Then("the user is navigated to the 'Investor funds used for ISA products managed by third party' page")
      ThirdPartyManageISAsPage.verifyPageTitle(
        ThirdPartyInvestorFundsPage.pageTitle,
        ThirdPartyInvestorFundsPage.pageUrl
      ) shouldBe true

      Then(
        "the user clicks on yes radio button and then click on save and continue button  on 'Investor funds used for ISA products managed by third party' page "
      )
      ThirdPartyInvestorFundsPage.clickRadioButton("Yes")
      ThirdPartyInvestorFundsPage.clickSaveAndContinue()

      Then(
        "the user is navigated to the 'What percentage of Investor funds used for ISA products managed by third party' page"
      )
      ThirdPartyManageISAsPage.verifyPageTitle(
        ThirdPartyPercentageOfInvestorFundsPage.pageTitle,
        ThirdPartyPercentageOfInvestorFundsPage.pageUrl
      ) shouldBe true

    }

  }
}
