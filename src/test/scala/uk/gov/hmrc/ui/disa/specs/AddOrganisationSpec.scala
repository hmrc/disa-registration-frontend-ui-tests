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
import uk.gov.hmrc.ui.disa.specs.tags.WIP

class AddOrganisationSpec extends BaseSpec {

  Feature("Add an organisation") {

    Scenario("1.Verify user can add a organisation") {

      Given("the user is logged in as an organisation User")
      AuthLoginPage.loginAsAFreshUser("/start")

      Then("the user is navigated to the 'Task list' page")
      TaskListPage.verifyPageTitle(TaskListPage.pageTitle, TaskListPage.pageUrl) shouldBe true

      /* we need to put steps to add org details when navigation is available. */

      When("the user navigates to the 'Organisation email address' page")
      AuthLoginPage.navigateTo(OrganisationEmailAddressPage.pageUrl)

      Then("the user is navigated to the 'Organisation email address' page")
      OrganisationEmailAddressPage.verifyPageTitle(
        OrganisationEmailAddressPage.pageTitle,
        OrganisationEmailAddressPage.pageUrl
      ) shouldBe true

      Then("the user enters the email value and clicks on Save and continue button")
      OrganisationEmailAddressPage.enterText("value", "codesent@sendcode.com")
      OrganisationEmailAddressPage.clickSaveAndContinue()

      Then("the user is navigated to the 'Email code verification' page")
      OrganisationEmailVerificationCodePage.verifyPageTitle(
        OrganisationEmailVerificationCodePage.pageTitle,
        OrganisationEmailVerificationCodePage.pageUrl
      ) shouldBe true

      Then("the user enters the code and clicks on Save and continue button")
      OrganisationEmailVerificationCodePage.enterText("value", "ABCDEF")
      OrganisationEmailVerificationCodePage.clickSaveAndContinue()

      Then("the user is navigated to the 'Task list' page")
      TaskListPage.verifyPageTitle(TaskListPage.pageTitle, TaskListPage.pageUrl) shouldBe true


    }

  }
}
