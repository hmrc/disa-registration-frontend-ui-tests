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

    Scenario("1.Verify user can access Add a signatory and edit the name and title") {

      Given("the user is logged in as an organisation User")
      AuthLoginPage.loginAsAFreshUser("/isa-products")

      Then("the 'ISA products' page title should be correct")
      ISAProductsPage.verifyPageTitle(ISAProductsPage.pageTitle, ISAProductsPage.pageUrl) shouldBe true

      When("the user navigates to the 'Task List' page")
      AuthLoginPage.navigateTo(TaskListPage.pageUrl)

      Then("the user is navigated to the 'Task list' page")
      TaskListPage.verifyPageTitle(TaskListPage.pageTitle, TaskListPage.pageUrl) shouldBe true

      When("User clicks signatories link")
      TaskListPage.clickSignatories()

      Then("the user is navigated to the 'signatory-name' page")
      SignatoryNamePage.verifyPageTitle(SignatoryNamePage.pageTitle, SignatoryNamePage.pageUrl) shouldBe true

      When("the user enters the full name and clicks on Save and continue button")
      SignatoryNamePage.enterText("value", "Signatory One")
      SignatoryNamePage.clickSaveAndContinue()

      Then("the user is navigated to the 'signatory-job-title' page")
      SignatoryJobTitlePage.verifyPageTitle(
        SignatoryJobTitlePage.pageTitle,
        SignatoryJobTitlePage.pageUrl
      ) shouldBe true

      When("the user enters the JobTitle value and clicks on Save and continue button")
      SignatoryJobTitlePage.enterText("value", "QA")
      SignatoryJobTitlePage.clickSaveAndContinue()

      Then("the user is navigated to the 'check-added-signatory' page")
      CheckAddedSignatoryPage.verifyPageTitle(
        CheckAddedSignatoryPage.pageTitle,
        CheckAddedSignatoryPage.pageUrl
      ) shouldBe true

      When("the user clicks on change link for name value ")
      CheckAddedSignatoryPage.clickOnLinks("change-signatory-name")

      Then("the user is navigated to the 'change-signatory-name' page")
      ChangeSignatoryNamePage.verifyPageTitle(
        ChangeSignatoryNamePage.pageTitle,
        ChangeSignatoryNamePage.pageUrl
      ) shouldBe true

      When("the user changes the name and clicks on Save and continue button")
      ChangeSignatoryNamePage.enterText("value", "Changed user")
      ChangeSignatoryNamePage.clickSaveAndContinue()

      Then("the user is navigated to the 'check-added-signatory' page")
      CheckAddedSignatoryPage.verifyPageTitle(
        CheckAddedSignatoryPage.pageTitle,
        CheckAddedSignatoryPage.pageUrl
      ) shouldBe true

      When("the user clicks on change link for Job Title value ")
      CheckAddedSignatoryPage.clickOnLinks("change-signatory-job-title")

      Then("the user is navigated to the 'change-signatory-Job Title' page")
      ChangeSignatoryJobTitlePage.verifyPageTitle(
        ChangeSignatoryJobTitlePage.pageTitle,
        ChangeSignatoryJobTitlePage.pageUrl
      ) shouldBe true

      When("the user changes the Job Title value  and clicks on Save and continue button")
      ChangeSignatoryJobTitlePage.enterText("value", "Sr QA")
      ChangeSignatoryJobTitlePage.clickSaveAndContinue()

      Then("the user is navigated to the 'signatory-check-added-signatory' page")
      CheckAddedSignatoryPage.verifyPageTitle(
        CheckAddedSignatoryPage.pageTitle,
        CheckAddedSignatoryPage.pageUrl
      ) shouldBe true
    }

    Scenario("Verify user can access multiple signatories screen and then remove one") {

      Given("the user is logged in as an organisation User")
      AuthLoginPage.loginAsAFreshUser("/isa-products")

      Then("the 'ISA products' page title should be correct")
      ISAProductsPage.verifyPageTitle(ISAProductsPage.pageTitle, ISAProductsPage.pageUrl) shouldBe true

      When("the user navigates to the 'Task List' page")
      AuthLoginPage.navigateTo(TaskListPage.pageUrl)

      Then("the user is navigated to the 'Task list' page")
      TaskListPage.verifyPageTitle(TaskListPage.pageTitle, TaskListPage.pageUrl) shouldBe true

      When("User clicks signatories link")
      TaskListPage.clickSignatories()

      Then("the user is navigated to the 'signatory-name' page")
      SignatoryNamePage.verifyPageTitle(SignatoryNamePage.pageTitle, SignatoryNamePage.pageUrl) shouldBe true

      Then("the user enters the full name and clicks on Save and continue button")
      SignatoryNamePage.enterText("value", "Signatory One")
      SignatoryNamePage.clickSaveAndContinue()

      Then("the user is navigated to the 'signatory-job-title' page")
      SignatoryJobTitlePage.verifyPageTitle(
        SignatoryJobTitlePage.pageTitle,
        SignatoryJobTitlePage.pageUrl
      ) shouldBe true

      When("the user enters the JobTitle value and clicks on Save and continue button")
      SignatoryJobTitlePage.enterText("value", "QA")
      SignatoryJobTitlePage.clickSaveAndContinue()

      Then("the user is navigated to the 'check-added-signatory' page")
      CheckAddedSignatoryPage.verifyPageTitle(
        CheckAddedSignatoryPage.pageTitle,
        CheckAddedSignatoryPage.pageUrl
      ) shouldBe true

      When("the user clicks on Save and continue button on check-added-signatory' page ")
      CheckAddedSignatoryPage.clickSaveAndContinue()

      Then("the user is navigated to the 'added-signatory' page")
      AddedSignatoriesPage.verifyPageTitle(AddedSignatoriesPage.pageTitle, AddedSignatoriesPage.pageUrl) shouldBe true

      When("the user clicks on yes radio button on 'added-signatory' page ")
      AddedSignatoriesPage.clickRadioButton("Yes")

      When("the user clicks on Save and continue button on 'added-signatory' page ")
      AddedSignatoriesPage.clickSaveAndContinue()

      Then("the user is navigated to the 'signatory-name' page")
      SignatoryNamePage.verifyPageTitle(SignatoryNamePage.pageTitle, SignatoryNamePage.pageUrl) shouldBe true

      When("the user enters the full name and clicks on Save and continue button")
      SignatoryNamePage.enterText("value", "Signatory One")
      SignatoryNamePage.clickSaveAndContinue()

      Then("the user is navigated to the 'signatory-job-title' page")
      SignatoryJobTitlePage.verifyPageTitle(
        SignatoryJobTitlePage.pageTitle,
        SignatoryJobTitlePage.pageUrl
      ) shouldBe true

      When("the user enters the JobTitle value and clicks on Save and continue button")
      SignatoryJobTitlePage.enterText("value", "SR QA")
      SignatoryJobTitlePage.clickSaveAndContinue()

      Then("the user is navigated to the 'check-added-signatory' page")
      CheckAddedSignatoryPage.verifyPageTitle(
        CheckAddedSignatoryPage.pageTitle,
        CheckAddedSignatoryPage.pageUrl
      ) shouldBe true

      Then("the user clicks on Save and continue button on check-added-signatory' page ")
      CheckAddedSignatoryPage.clickSaveAndContinue()

      Then("the user is navigated to the 'added-signatory' page")
      AddedSignatoriesPage.verifyPageTitle(
        AddedSignatoriesPage.pageTitleTwo,
        AddedSignatoriesPage.pageUrl
      ) shouldBe true

      When("the user clicks on remove link for the added user ")
      CheckAddedSignatoryPage.clickOnLinks("remove-signatory")

      Then("the user is navigated to the 'remove-signatory' page")
      RemoveSignatoryPage.verifyPageTitle(RemoveSignatoryPage.pageTitle, RemoveSignatoryPage.pageUrl) shouldBe true

      Then("the user clicks on no radio button on 'remove-signatory' page ")
      RemoveSignatoryPage.clickRadioButton("No")

      When("the user clicks on Save and continue button on 'remove-signatory' page ")
      RemoveSignatoryPage.clickSaveAndContinue()

      Then("the user is navigated to the 'added-signatory' page")
      AddedSignatoriesPage.verifyPageTitle(
        AddedSignatoriesPage.pageTitleTwo,
        AddedSignatoriesPage.pageUrl
      ) shouldBe true

      When("the user clicks on remove link for the added user ")
      CheckAddedSignatoryPage.clickOnLinks("remove-signatory")

      Then("the user is navigated to the 'remove-signatory' page")
      RemoveSignatoryPage.verifyPageTitle(
        RemoveSignatoryPage.pageTitle,
        RemoveSignatoryPage.pageUrl
      ) shouldBe true

      When("the user clicks on Yes radio button on 'remove-signatory' page ")
      RemoveSignatoryPage.clickRadioButton("Yes")

      Then("the user clicks on Save and continue button on 'remove-signatory' page ")
      RemoveSignatoryPage.clickSaveAndContinue()

      Then("the user is navigated to the 'added-signatory' page")
      AddedSignatoriesPage.verifyPageTitle(AddedSignatoriesPage.pageTitle, AddedSignatoriesPage.pageUrl) shouldBe true

    }
  }
}
