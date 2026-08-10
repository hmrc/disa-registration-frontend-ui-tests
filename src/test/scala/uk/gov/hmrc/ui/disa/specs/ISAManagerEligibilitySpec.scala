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

class ISAManagerEligibilitySpec extends BaseSpec {

  Feature("ISA manager eligibility check") {

    Scenario(
      "Verify ISA Manager eligibility Journey when they have certificate of authority and checking change links features"
    ) {
      Given("the user is logged in as an organisation User")
      AuthLoginPage.loginAsAFreshUser("/company-type")

      Then("the user is navigated to the 'Company Type' page")
      CompanyTypePage.verifyPageTitle(CompanyTypePage.pageTitle, CompanyTypePage.pageUrl) shouldBe true

      Then(
        "the user clicks on the Limited Company radio button and then clicks on save and continue button on 'Registered ISA Manager' page"
      )
      CompanyTypePage.selectLimitedCompanyAndContinue()

      Then("the user is navigated to the 'Task list' page")
      TaskListPage.verifyPageTitle(TaskListPage.pageTitle, TaskListPage.pageUrl) shouldBe true

      Then(
        "the 'Which certificates of authority apply to your organisation' status is 'Not yet started' the user clicks on the 'Which certificates of authority apply to your organisation' link"
      )
      TaskListPage.verifyTaskStatus("Which certificates of authority apply to your organisation", "Not yet started")
      TaskListPage.clickOnByPartialLinkText("Which certificates of authority apply to your organisation")

      Then("the 'Eligibility To Manage ISAs' Page title & url should be correct")
      EligibilityToManageIsasPage.verifyPageTitle(
        EligibilityToManageIsasPage.pageTitle,
        EligibilityToManageIsasPage.pageUrl
      ) shouldBe true

      When("the user click on 'Continue' button")
      EligibilityToManageIsasPage.clickContinue()

      Then("the 'Certificates Of Authority' Page title & url should be correct")
      CertificatesOfAuthorityPage.verifyPageTitle(
        CertificatesOfAuthorityPage.pageTitle,
        CertificatesOfAuthorityPage.pageUrl
      ) shouldBe true

      When(
        "the user selects 'yes' and click on 'save and continue' button"
      )
      CertificatesOfAuthorityPage.selectYesAndContinue()

      Then("the 'FCA Articles' Page title & url should be correct")
      FcaArticlesPage.verifyPageTitle(FcaArticlesPage.pageTitle, FcaArticlesPage.pageUrl) shouldBe true

      When("the user selects FCA articles and click on 'save and continue' button")
      FcaArticlesPage.selectFACArticlesThenClickSaveAndContinue()

      Then("the 'Certificates Of Authority Check Your Answers' Page title should be correct")
      CertificatesOfAuthorityCheckYourAnswersPage.verifyPageTitle(
        CertificatesOfAuthorityCheckYourAnswersPage.pageTitle,
        CertificatesOfAuthorityCheckYourAnswersPage.pageUrl
      ) shouldBe true

      When(
        "the user clicks  change link for certificate of authority on 'Certificates Of Authority Check Your Answers' page "
      )
      CertificatesOfAuthorityCheckYourAnswersPage.clickOnLinks("change-certificates-of-authority")

      Then("the user is navigated to the 'Change-Certificates' page")
      ChangeCertificatesOfAuthorityPage.verifyPageTitle(
        ChangeCertificatesOfAuthorityPage.pageTitle,
        ChangeCertificatesOfAuthorityPage.pageUrl
      ) shouldBe true

      When(
        "the user selects 'No' and click on 'save and continue' button"
      )
      ChangeCertificatesOfAuthorityPage.selectNoAndContinue()

      Then("the 'Financial Organisation' Page title & url should be correct")
      FinancialOrganisationPage.verifyPageTitle(
        FinancialOrganisationPage.pageTitle,
        FinancialOrganisationPage.pageUrl
      ) shouldBe true

      When("the user selects financial organisations and click on 'save and continue' button")
      FinancialOrganisationPage.selectFinancialOrganizationThenClickSaveAndContinue()

      Then("the 'Certificates Of Authority Check Your Answers' Page title should be correct")
      CertificatesOfAuthorityCheckYourAnswersPage.verifyPageTitle(
        CertificatesOfAuthorityCheckYourAnswersPage.pageTitle,
        CertificatesOfAuthorityCheckYourAnswersPage.pageUrl
      ) shouldBe true

      Then("the user clicks on Confirm and Save button")
      OrganisationEmailCheckYourAnswersPage.clickConfirmAndSave()

      And(" The status for 'Change which certificates of authority apply to your organisation' status is 'Completed'")
      TaskListPage.verifyTaskStatus("Change which certificates of authority apply to your organisation", "Completed")

      /*When("the user navigates to the 'Check your answers' page")
      AuthLoginPage.navigateTo(CheckYourAnswersPage.pageUrl)

      Then("the user is navigated to the 'Check your answers' page")
      CheckYourAnswersPage.verifyPageTitle(
        CheckYourAnswersPage.pageTitle,
        CheckYourAnswersPage.pageUrl
      ) shouldBe true

      When("the user clicks  change link for certificate of authority on 'Check your answers' page ")
      CheckYourAnswersPage.clickOnLinks("change-certificates-of-authority")

      Then("the user is navigated to the 'Change-Certificates' page")
      ChangeCertificatesOfAuthorityPage.verifyPageTitle(
        ChangeCertificatesOfAuthorityPage.pageTitle,
        ChangeCertificatesOfAuthorityPage.pageUrl
      ) shouldBe true

      When(
        "the user selects 'yes' and click on 'save and continue' button"
      )
      ChangeCertificatesOfAuthorityPage.selectYesAndContinue()

      Then("the 'FCA Articles' Page title & url should be correct")
      FcaArticlesPage.verifyPageTitle(FcaArticlesPage.pageTitle, FcaArticlesPage.pageUrl) shouldBe true

      When("the user selects FCA articles and click on 'save and continue' button")
      FcaArticlesPage.selectFACArticlesThenClickSaveAndContinue()

      Then("the user is navigated to the 'Check your answers' page")
      CheckYourAnswersPage.verifyPageTitle(
        CheckYourAnswersPage.pageTitle,
        CheckYourAnswersPage.pageUrl
      ) shouldBe true*/

    }

    Scenario("Verify ISA Manager eligibility Journey when they don't have certificate of authority") {
      Given("the user is logged in as an organisation User")
      AuthLoginPage.loginAsAFreshUser("/company-type")

      Then("the user is navigated to the 'Company Type' page")
      CompanyTypePage.verifyPageTitle(CompanyTypePage.pageTitle, CompanyTypePage.pageUrl) shouldBe true

      Then(
        "the user clicks on the Limited Company radio button and then clicks on save and continue button on 'Registered ISA Manager' page"
      )
      CompanyTypePage.selectLimitedCompanyAndContinue()

      Then("the user is navigated to the 'Task list' page")
      TaskListPage.verifyPageTitle(TaskListPage.pageTitle, TaskListPage.pageUrl) shouldBe true

      Then(
        "the 'Which certificates of authority apply to your organisation' status is 'Not yet started' the user clicks on the 'Which certificates of authority apply to your organisation' link"
      )
      TaskListPage.verifyTaskStatus("Which certificates of authority apply to your organisation", "Not yet started")
      TaskListPage.clickOnByPartialLinkText("Which certificates of authority apply to your organisation")

      Then("the 'Eligibility To Manage ISAs' Page title & url should be correct")
      EligibilityToManageIsasPage.verifyPageTitle(
        EligibilityToManageIsasPage.pageTitle,
        EligibilityToManageIsasPage.pageUrl
      ) shouldBe true

      When("the user click on 'Continue' button")
      EligibilityToManageIsasPage.clickContinue()

      Then("the 'Certificates Of Authority' Page title & url should be correct")
      CertificatesOfAuthorityPage.verifyPageTitle(
        CertificatesOfAuthorityPage.pageTitle,
        CertificatesOfAuthorityPage.pageUrl
      ) shouldBe true

      When(
        "the user selects 'No' and click on 'save and continue' button"
      )
      CertificatesOfAuthorityPage.selectNoAndContinue()

      Then("the 'Financial Organisation' Page title & url should be correct")
      FinancialOrganisationPage.verifyPageTitle(
        FinancialOrganisationPage.pageTitle,
        FinancialOrganisationPage.pageUrl
      ) shouldBe true

      When("the user selects financial organisations and click on 'save and continue' button")
      FinancialOrganisationPage.selectFinancialOrganizationThenClickSaveAndContinue()

      Then("the 'Certificates Of Authority Check Your Answers' Page title & url should be correct")
      CertificatesOfAuthorityCheckYourAnswersPage.verifyPageTitle(
        CertificatesOfAuthorityCheckYourAnswersPage.pageTitle,
        CertificatesOfAuthorityCheckYourAnswersPage.pageUrl
      ) shouldBe true

      Then("the user clicks on Confirm and Save button")
      OrganisationEmailCheckYourAnswersPage.clickConfirmAndSave()

      And(" The status for 'Change which certificates of authority apply to your organisation' status is 'Completed'")
      TaskListPage.verifyTaskStatus("Change which certificates of authority apply to your organisation", "Completed")

    }
  }
}
