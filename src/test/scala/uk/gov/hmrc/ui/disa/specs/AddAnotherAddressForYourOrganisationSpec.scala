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

import uk.gov.hmrc.ui.disa.pages.{AddAnotherAddressForYourOrganisationPage, AuthLoginPage, RegisteredAddressCorrespondencePage, TaskListPage}

class AddAnotherAddressForYourOrganisationSpec extends BaseSpec {

  Feature("Add an organisation") {

    Scenario("1.Verify user can add a organisation") {

      Given("the user is logged in as an organisation User")
      AuthLoginPage.loginAsAFreshUser("/start")

      Then("the user is navigated to the 'Task list' page")
      TaskListPage.verifyPageTitle(TaskListPage.pageTitle, TaskListPage.pageUrl) shouldBe true

      /* we need to put steps to add org details when navigation is available. */

      When("the user navigates to the 'Registered address correspondence' page")
      AuthLoginPage.navigateTo(RegisteredAddressCorrespondencePage.pageUrl)

      Then("the user clicks on the No radio button on 'registered-address-correspondence' page")
      RegisteredAddressCorrespondencePage.clickRadioButton("No")

      When("the user clicks on Save and continue button on 'registered-address-correspondence' page ")
      RegisteredAddressCorrespondencePage.clickSaveAndContinue()

      Then("the user is navigated to the 'add-another-address' page")
      AddAnotherAddressForYourOrganisationPage.verifyPageTitle(
        AddAnotherAddressForYourOrganisationPage.pageTitle,
        AddAnotherAddressForYourOrganisationPage.pageUrl
      ) shouldBe true

      Then("the user enters the postcode value and property name or number value")
      AddAnotherAddressForYourOrganisationPage.enterText("value", "ZZ11 1ZZ")
//      AddAnotherAddressForYourOrganisationPage.enterText("value", "")

      Then("clicks on Save and continue button")
      AddAnotherAddressForYourOrganisationPage.clickSaveAndContinue()

      Then("the user is navigated to the 'Task list' page")
      TaskListPage.verifyPageTitle(TaskListPage.pageTitle, TaskListPage.pageUrl) shouldBe true

    }

  }

}
