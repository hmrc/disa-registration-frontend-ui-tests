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

class ISAManagerRegistrationProductsSpec extends BaseSpec {

  Feature("ISA manager Registration") {

    Scenario("Verify ISA Manager registration Journey") {
      val zReference: String = generateRandomZReference()
      Given("Given the ISA manager is logged in as an organisation User")
      AuthLoginPage.loginAsAnExistingUser(zReference)

      Then("the ISA products page title should be correct")
      ISAProductsPage.verifyPageTitle(ISAProductsPage.pageTitle, ISAProductsPage.pageUrl) shouldBe true

      When("the user selects ISA products and click on 'save and continue' button")
      ISAProductsPage.selectISAProductsAndContinue()

      Then("the Innovative Financial Products Page title should be correct")
      InnovativeFinancialProductsPage.verifyPageTitle(
        InnovativeFinancialProductsPage.pageTitle,
        InnovativeFinancialProductsPage.pageUrl
      ) shouldBe true

      When(
        "the user selects 'Peer-to-peer loans using a platform with 36H permissions' and click on 'save and continue' button"
      )
      InnovativeFinancialProductsPage.selectInnovativeProductsIncludingPlatformWith36HPermissionsAndContinue()

      Then("the Peer To Peer Loans Page title should be correct")
      PeerToPeerLoansPage.verifyPageTitle(PeerToPeerLoansPage.pageTitle, PeerToPeerLoansPage.pageUrl) shouldBe true

      When("the user enters the platform organization used and click on 'save and continue' button")
      PeerToPeerLoansPage.enterPlatformNameAndContinue()

      Then("the FCA Platform Number Page title should be correct")
      FcaPlatformNumberPage.verifyPageTitle(
        FcaPlatformNumberPage.pageTitle,
        FcaPlatformNumberPage.pageUrl
      ) shouldBe true

      When("the user enters the FCA platform number and click on 'save and continue' button")
      FcaPlatformNumberPage.enterFCAPlatformNumberAndContinue()

      Then("the ISA Products Check your Answers Page title should be correct")
      IsaProductsCheckYourAnswersPage.verifyPageTitle(
        IsaProductsCheckYourAnswersPage.pageTitle,
        IsaProductsCheckYourAnswersPage.pageUrl
      ) shouldBe true

    }

    Scenario("Verify ISA Manager registration Journey without peer to peer loans using a platform") {
      val zReference: String = generateRandomZReference()
      Given("Given the ISA manager is logged in as an organisation User")
      AuthLoginPage.loginAsAnExistingUser(zReference)

      Then("the ISA products page title should be correct")
      ISAProductsPage.verifyPageTitle(ISAProductsPage.pageTitle, ISAProductsPage.pageUrl) shouldBe true

      When("the user selects ISA products and click on 'save and continue' button")
      ISAProductsPage.selectISAProductsAndContinue()

      Then("the Innovative Financial Products Page title should be correct")
      InnovativeFinancialProductsPage.verifyPageTitle(
        InnovativeFinancialProductsPage.pageTitle,
        InnovativeFinancialProductsPage.pageUrl
      ) shouldBe true

      When(
        "the user selects any option other than 'Peer-to-peer loans using a platform with 36H permissions' and click on 'save and continue' button"
      )
      InnovativeFinancialProductsPage.selectInnovativeProductsWithoutPlatformWith36HPermissionsAndContinue()

      Then("the ISA Products Check your Answers Page title should be correct")
      IsaProductsCheckYourAnswersPage.verifyPageTitle(
        IsaProductsCheckYourAnswersPage.pageTitle,
        IsaProductsCheckYourAnswersPage.pageUrl
      ) shouldBe true
    }
  }
}
