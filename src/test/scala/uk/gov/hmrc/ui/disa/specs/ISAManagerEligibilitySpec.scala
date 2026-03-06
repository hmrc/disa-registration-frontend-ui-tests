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

    Scenario("Verify ISA Manager eligibility Journey when they have certificate of authority") {
      Given("Given the ISA manager is logged in as an organisation User")
      AuthLoginPage.loginAsAFreshUser("/eligibility-to-manage-isas")

      Then("the Eligibility To Manage Isas Page title should be correct")
      EligibilityToManageIsasPage.verifyPageTitle(
        EligibilityToManageIsasPage.pageTitle,
        EligibilityToManageIsasPage.pageUrl
      ) shouldBe true

      When("the user click on 'Continue' button")
      EligibilityToManageIsasPage.clickContinue()

      Then("the certificates of authority Page title should be correct")
      CertificatesOfAuthorityPage.verifyPageTitle(
        CertificatesOfAuthorityPage.pageTitle,
        CertificatesOfAuthorityPage.pageUrl
      ) shouldBe true

      When(
        "the user selects 'yes' and click on 'save and continue' button"
      )
      CertificatesOfAuthorityPage.selectYesAndContinue()

      Then("the fca articles Page title should be correct")
      FcaArticlesPage.verifyPageTitle(FcaArticlesPage.pageTitle, FcaArticlesPage.pageUrl) shouldBe true

      When("the user selects FCA articles and click on 'save and continue' button")
      FcaArticlesPage.selectFACArticlesSaveAndContinue()

      Then("the Certificates Of Authority Check Your Answers Page title should be correct")
      CertificatesOfAuthorityCheckYourAnswersPage.verifyPageTitle(
        CertificatesOfAuthorityCheckYourAnswersPage.pageTitle,
        CertificatesOfAuthorityCheckYourAnswersPage.pageUrl
      ) shouldBe true
    }

    Scenario("Verify ISA Manager eligibility Journey when they don't have certificate of authority") {
      Given("Given the ISA manager is logged in as an organisation User")
      AuthLoginPage.loginAsAFreshUser("/eligibility-to-manage-isas")

      Then("the Eligibility To Manage Isas Page title should be correct")
      EligibilityToManageIsasPage.verifyPageTitle(
        EligibilityToManageIsasPage.pageTitle,
        EligibilityToManageIsasPage.pageUrl
      ) shouldBe true

      When("the user click on 'Continue' button")
      EligibilityToManageIsasPage.clickContinue()

      Then("the certificates of authority Page title should be correct")
      CertificatesOfAuthorityPage.verifyPageTitle(
        CertificatesOfAuthorityPage.pageTitle,
        CertificatesOfAuthorityPage.pageUrl
      ) shouldBe true

      When(
        "the user selects 'No' and click on 'save and continue' button"
      )
      CertificatesOfAuthorityPage.selectNoAndContinue()

      Then("the financial organisation Page title should be correct")
      FinancialOrganisationPage.verifyPageTitle(
        FinancialOrganisationPage.pageTitle,
        FinancialOrganisationPage.pageUrl
      ) shouldBe true

      When("the user selects financial organizations and click on 'save and continue' button")
      FinancialOrganisationPage.selectFinancialOrganizationSaveAndContinue()

      Then("the Certificates Of Authority Check Your Answers Page title should be correct")
      CertificatesOfAuthorityCheckYourAnswersPage.verifyPageTitle(
        CertificatesOfAuthorityCheckYourAnswersPage.pageTitle,
        CertificatesOfAuthorityCheckYourAnswersPage.pageUrl
      ) shouldBe true
    }
  }
}
