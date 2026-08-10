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

class ISAManagerRegistrationProductsSpec extends BaseSpec {

  Feature("ISA manager Registration") {

    Scenario("Verify ISA Manager registration products Journey and verifying change links") {
      Given("the user is logged in as an organisation User")
      AuthLoginPage.loginAsAFreshUser("/start")

      Then("the user is navigated to the 'Company Type' page")
      CompanyTypePage.verifyPageTitle(CompanyTypePage.pageTitle, CompanyTypePage.pageUrl) shouldBe true

      Then(
        "the user clicks on the Limited Company radio button and then clicks on save and continue button on 'Registered ISA Manager' page"
      )
      CompanyTypePage.selectLimitedCompanyAndContinue()

      Then("the user is navigated to the 'Task list' page")
      TaskListPage.verifyPageTitle(TaskListPage.pageTitle, TaskListPage.pageUrl) shouldBe true

      Then(
        "the 'ISA products you manage' status is 'Not yet started' the user clicks on the 'ISA products you manage' link"
      )
      TaskListPage.verifyTaskStatus("ISA products you manage", "Not yet started")
      TaskListPage.clickOnByPartialLinkText("ISA products you manage")

      Then("the 'ISA Products' page title & url should be correct")
      ISAProductsPage.verifyPageTitle(ISAProductsPage.pageTitle, ISAProductsPage.pageUrl) shouldBe true

      When("the user selects ISA products and click on 'save and continue' button")
      ISAProductsPage.selectISAProductsThenClickContinue()

      Then("the 'Innovative Financial Products' Page title & url should be correct")
      InnovativeFinancialProductsPage.verifyPageTitle(
        InnovativeFinancialProductsPage.pageTitle,
        InnovativeFinancialProductsPage.pageUrl
      ) shouldBe true

      When(
        "the user selects 'Peer-to-peer loans using a platform with 36H permissions' and click on 'save and continue' button"
      )
      InnovativeFinancialProductsPage.selectInnovativeProductsIncludingPlatformWith36HPermissionsThenClickContinue()

      Then("the 'Peer To Peer Loans' page title & url should be correct")
      PeerToPeerLoansPage.verifyPageTitle(PeerToPeerLoansPage.pageTitle, PeerToPeerLoansPage.pageUrl) shouldBe true

      When("the user enters the platform organization used and click on 'save and continue' button")
      PeerToPeerLoansPage.enterText("value", "PlatformName")
      PeerToPeerLoansPage.clickSaveAndContinue()

      Then("the 'FCA Platform Number' page title & url should be correct")
      FcaPlatformNumberPage.verifyPageTitle(
        FcaPlatformNumberPage.pageTitle,
        FcaPlatformNumberPage.pageUrl
      ) shouldBe true

      When("the user enters the FCA platform number and click on 'save and continue' button")
      FcaPlatformNumberPage.enterFCAPlatformNumberThenClickContinue()

      Then("the 'ISA Products Check your Answers' page title should & url be correct")
      IsaProductsCheckYourAnswersPage.verifyPageTitle(
        IsaProductsCheckYourAnswersPage.pageTitle,
        IsaProductsCheckYourAnswersPage.pageUrl
      ) shouldBe true

      When("the user clicks change link for ISA products on 'ISA Products Check your Answers' page ")
      IsaProductsCheckYourAnswersPage.clickOnLinks("change-isa-products")

      Then("the user is navigated to the 'Change-isa-products' page")
      ChangeISAProductsPage.verifyPageTitle(
        ChangeISAProductsPage.pageTitle,
        ChangeISAProductsPage.pageUrl
      ) shouldBe true

      When("the user selects ISA products and click on 'save and continue' button")
      ISAProductsPage.selectISAProductsThenClickContinue()

      Then("the 'ISA Products Check your Answers' page title should & url be correct")
      IsaProductsCheckYourAnswersPage.verifyPageTitle(
        IsaProductsCheckYourAnswersPage.pageTitle,
        IsaProductsCheckYourAnswersPage.pageUrl
      ) shouldBe true

      Then("the user clicks on Confirm and Save button")
      OrganisationEmailCheckYourAnswersPage.clickConfirmAndSave()

      And(" The status for 'Change ISA products you manage' status is 'Completed'")
      TaskListPage.verifyTaskStatus("Change ISA products you manage", "Completed")

      /* When("the user navigates to the 'Check your answers' page")
      AuthLoginPage.navigateTo(CheckYourAnswersPage.pageUrl)

      Then("the user is navigated to the 'Check your answers' page")
      CheckYourAnswersPage.verifyPageTitle(
        CheckYourAnswersPage.pageTitle,
        CheckYourAnswersPage.pageUrl
      ) shouldBe true

      When("the user clicks  change link for ISA products on 'Check your answers' page ")
      CheckYourAnswersPage.clickOnLinks("change-isa-products")

      Then("the user is navigated to the 'Change-isa-products' page")
      ChangeISAProductsPage.verifyPageTitle(
        ChangeISAProductsPage.pageTitle,
        ChangeISAProductsPage.pageUrl
      ) shouldBe true

      When("the user selects ISA products and click on 'save and continue' button")
      ISAProductsPage.changeISAProductsThenClickContinue()

      Then("the user is navigated to the 'Check your answers' page")
      CheckYourAnswersPage.verifyPageTitle(
        CheckYourAnswersPage.pageTitle,
        CheckYourAnswersPage.pageUrl
      ) shouldBe true

      When("the user clicks  change link for ISA products on 'Check your answers' page ")
      CheckYourAnswersPage.clickOnLinks("change-innovative-financial-products")

      Then("the user is navigated to the 'change-innovative-financial-products' page")
      ChangeISAProductsPage.verifyPageTitle(
        ChangeInnovativeFinancialProductsPage.pageTitle,
        ChangeInnovativeFinancialProductsPage.pageUrl
      ) shouldBe true

      Then("the user clicks on save and continue on 'change-innovative-financial-products' page")
      ChangeInnovativeFinancialProductsPage.clickSaveAndContinue()*/

      /*Then("the user is navigated to the 'Check your answers' page")
      CheckYourAnswersPage.verifyPageTitle(
        CheckYourAnswersPage.pageTitle,
        CheckYourAnswersPage.pageUrl
      ) shouldBe true

      When("the user clicks  change link for platform name on 'Check your answers' page ")
      CheckYourAnswersPage.clickOnLinks("change-peer-to-peer-loans")

      Then("the user is navigated to the 'change-peer-to-peer-loans' page")
      ChangePeerToPeerLoansPage.verifyPageTitle(
        ChangePeerToPeerLoansPage.pageTitle,
        ChangePeerToPeerLoansPage.pageUrl
      ) shouldBe true

      Then(
        "the user changes the platform number and clicks on save and continue on 'change-peer-to-peer-loans' page"
      )
      ChangePeerToPeerLoansPage.enterText("value", "PlatformChanged")
      ChangePeerToPeerLoansPage.clickSaveAndContinue()

      Then("the user is navigated to the 'Check your answers' page")
      CheckYourAnswersPage.verifyPageTitle(
        CheckYourAnswersPage.pageTitle,
        CheckYourAnswersPage.pageUrl
      ) shouldBe true

      When("the user clicks change link for FCA platform number on 'Check your answers' page ")
      CheckYourAnswersPage.clickOnLinks("change-fca-platform-number")

      Then("the user is navigated to the 'change-fca-platform-number' page")
      ChangeFcaPlatformNumberPage.verifyPageTitle(
        ChangeFcaPlatformNumberPage.pageTitle,
        ChangeFcaPlatformNumberPage.pageUrl
      ) shouldBe true

      Then(
        "the user changes the platform number and clicks on save and continue on 'change-peer-to-peer-loans' page"
      )
      ChangeFcaPlatformNumberPage.enterText("value", "3333333")
      ChangeFcaPlatformNumberPage.clickSaveAndContinue()

      Then("the user is navigated to the 'Check your answers' page")
      CheckYourAnswersPage.verifyPageTitle(
        CheckYourAnswersPage.pageTitle,
        CheckYourAnswersPage.pageUrl
      ) shouldBe true*/
    }

    Scenario("Verify ISA Manager registration Journey without peer to peer loans using a platform") {
      Given("the user is logged in as an organisation User")
      AuthLoginPage.loginAsAFreshUser("/start")

      Then("the user is navigated to the 'Company Type' page")
      CompanyTypePage.verifyPageTitle(CompanyTypePage.pageTitle, CompanyTypePage.pageUrl) shouldBe true

      Then(
        "the user clicks on the Limited Company radio button and then clicks on save and continue button on 'Registered ISA Manager' page"
      )
      CompanyTypePage.selectLimitedCompanyAndContinue()

      Then("the user is navigated to the 'Task list' page")
      TaskListPage.verifyPageTitle(TaskListPage.pageTitle, TaskListPage.pageUrl) shouldBe true

      Then(
        "the 'ISA products you manage' status is 'Not yet started' the user clicks on the 'ISA products you manage' link"
      )
      TaskListPage.verifyTaskStatus("ISA products you manage", "Not yet started")
      TaskListPage.clickOnByPartialLinkText("ISA products you manage")

      Then("the 'ISA Products' page title & url should be correct")
      ISAProductsPage.verifyPageTitle(ISAProductsPage.pageTitle, ISAProductsPage.pageUrl) shouldBe true

      When("the user selects ISA products and click on 'save and continue' button")
      ISAProductsPage.selectISAProductsThenClickContinue()

      Then("the 'Innovative Financial Products' page title & url should be correct")
      InnovativeFinancialProductsPage.verifyPageTitle(
        InnovativeFinancialProductsPage.pageTitle,
        InnovativeFinancialProductsPage.pageUrl
      ) shouldBe true

      When(
        "the user selects any option other than 'Peer-to-peer loans using a platform with 36H permissions' and click on 'save and continue' button"
      )
      InnovativeFinancialProductsPage.selectInnovativeProductsWithoutPlatformWith36HPermissionsThenClickContinue()

      Then("the 'ISA Products Check your Answers' page title & url should be correct")
      IsaProductsCheckYourAnswersPage.verifyPageTitle(
        IsaProductsCheckYourAnswersPage.pageTitle,
        IsaProductsCheckYourAnswersPage.pageUrl
      ) shouldBe true
    }
  }
}
