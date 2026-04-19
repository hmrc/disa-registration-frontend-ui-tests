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
import uk.gov.hmrc.ui.disa.specs.tags.{AllTests, WIP}

class AddLiaisonOfficerSpec extends BaseSpec {

  Feature("Add a Liaison Officer") {

    Scenario("1.Verify user can add a Liaison Officer and then able to edit the added liaison officer ",
    ) {
      Given("the user is logged in as an organisation User")
      AuthLoginPage.loginAsAFreshUser("/isa-products")

      Then("the 'ISA products' page title should be correct")
      ISAProductsPage.verifyPageTitle(ISAProductsPage.pageTitle, ISAProductsPage.pageUrl) shouldBe true

      When("the user navigates to the 'Add a liaison officer' page")
      AuthLoginPage.navigateTo(AddLiaisonOfficerPage.pageUrl)

      Then("the page title should be correct")
      AddLiaisonOfficerPage.verifyPageTitle(AddLiaisonOfficerPage.pageTitle, AddLiaisonOfficerPage.pageUrl) shouldBe true

      When("User clicks on Add a Liaison officer button")
      AddLiaisonOfficerPage.clickAddLiaisonOfficer()

      Then("the user is navigated to the 'liaison-officer-name' page")
      LiaisonOfficerNamePage.verifyPageTitle(LiaisonOfficerNamePage.pageTitle, LiaisonOfficerNamePage.pageUrl) shouldBe true

      Then("the user enters the full name and clicks on Save and continue button")
      LiaisonOfficerNamePage.enterText("value", "Liaison One")
      LiaisonOfficerNamePage.clickSaveAndContinue()

      Then("the user is navigated to the 'liaison-officer-email' page")
      LiaisonOfficerEmailPage.verifyPageTitle(LiaisonOfficerEmailPage.pageTitle, LiaisonOfficerEmailPage.pageUrl) shouldBe true

      Then("the user enters the email value and clicks on Save and continue button")
      LiaisonOfficerEmailPage.enterText("value", "loone@email.com")
      LiaisonOfficerEmailPage.clickSaveAndContinue()

      Then("the user is navigated to the 'liaison-officer-phone-number' page")
      LiaisonOfficerPhoneNumberPage.verifyPageTitle(LiaisonOfficerPhoneNumberPage.pageTitle, LiaisonOfficerPhoneNumberPage.pageUrl) shouldBe true

      Then("the user enters the phone number and clicks on Save and continue button")
      LiaisonOfficerPhoneNumberPage.enterText("value", "07733773373")
      LiaisonOfficerPhoneNumberPage.clickSaveAndContinue()

      Then("the user is navigated to the 'liaison-officer-communication' page")
      LiaisonOfficerCommunicationPage.verifyPageTitle(LiaisonOfficerCommunicationPage.pageTitle, LiaisonOfficerCommunicationPage.pageUrl) shouldBe true

      Then("the user selects all communication modes and clicks on Save and continue button")
      LiaisonOfficerCommunicationPage.selectCommunicationModes()
      LiaisonOfficerCommunicationPage.clickSaveAndContinue()

      Then("the user is navigated to the 'liaison-officer-check-added-liaison-officer' page")
      CheckAddedLiaisonOfficerPage.verifyPageTitle(CheckAddedLiaisonOfficerPage.pageTitle, CheckAddedLiaisonOfficerPage.pageUrl) shouldBe true

      When("the user clicks on change link for name value ")
      CheckAddedLiaisonOfficerPage.clickOnChangeOrRemoveLinks("change-liaison-officer-name")

      Then("the user is navigated to the 'change-liaison-officer-name' page")
      ChangeLiaisonOfficerNamePage.verifyPageTitle(ChangeLiaisonOfficerNamePage.pageTitle, ChangeLiaisonOfficerNamePage.pageUrl) shouldBe true

      Then("the user changes the name and clicks on Save and continue button")
      ChangeLiaisonOfficerNamePage.enterText("value", "Changed user")
      ChangeLiaisonOfficerNamePage.clickSaveAndContinue()

      Then("the user is navigated to the 'liaison-officer-check-added-liaison-officer' page")
      CheckAddedLiaisonOfficerPage.verifyPageTitle(CheckAddedLiaisonOfficerPage.pageTitle, CheckAddedLiaisonOfficerPage.pageUrl) shouldBe true

      When("the user clicks on change link for email value ")
      CheckAddedLiaisonOfficerPage.clickOnChangeOrRemoveLinks("change-liaison-officer-email")

      Then("the user is navigated to the 'liaison-officer-email' page")
      ChangeLiaisonOfficerEmailPage.verifyPageTitle(ChangeLiaisonOfficerEmailPage.pageTitle, ChangeLiaisonOfficerEmailPage.pageUrl) shouldBe true

      Then("the user changes the email value  and clicks on Save and continue button")
      ChangeLiaisonOfficerEmailPage.enterText("value", "changed@email.com")
      ChangeLiaisonOfficerEmailPage.clickSaveAndContinue()

      Then("the user is navigated to the 'liaison-officer-check-added-liaison-officer' page")
      CheckAddedLiaisonOfficerPage.verifyPageTitle(CheckAddedLiaisonOfficerPage.pageTitle, CheckAddedLiaisonOfficerPage.pageUrl) shouldBe true

    }

    Scenario("2.Verify user can add more than one Liaison Officers and then remove one",
    ) {
      Given("the user is logged in as an organisation User")
      AuthLoginPage.loginAsAFreshUser("/isa-products")

      Then("the 'ISA products' page title should be correct")
      ISAProductsPage.verifyPageTitle(ISAProductsPage.pageTitle, ISAProductsPage.pageUrl) shouldBe true

      When("the user navigates to the 'Add a liaison officer' page")
      AuthLoginPage.navigateTo(AddLiaisonOfficerPage.pageUrl)

      Then("the page title should be correct")
      AddLiaisonOfficerPage.verifyPageTitle(AddLiaisonOfficerPage.pageTitle, AddLiaisonOfficerPage.pageUrl) shouldBe true

      When("User clicks on Add a Liaison officer button")
      AddLiaisonOfficerPage.clickAddLiaisonOfficer()

      Then("the user is navigated to the 'liaison-officer-name' page")
      LiaisonOfficerNamePage.verifyPageTitle(LiaisonOfficerNamePage.pageTitle, LiaisonOfficerNamePage.pageUrl) shouldBe true

      Then("the user enters the full name and clicks on Save and continue button")
      LiaisonOfficerNamePage.enterText("value", "Liaison One")
      LiaisonOfficerNamePage.clickSaveAndContinue()

      Then("the user is navigated to the 'liaison-officer-email' page")
      LiaisonOfficerEmailPage.verifyPageTitle(LiaisonOfficerEmailPage.pageTitle, LiaisonOfficerEmailPage.pageUrl) shouldBe true

      Then("the user enters the email value and clicks on Save and continue button")
      LiaisonOfficerEmailPage.enterText("value", "loone@email.com")
      LiaisonOfficerEmailPage.clickSaveAndContinue()

      Then("the user is navigated to the 'liaison-officer-phone-number' page")
      LiaisonOfficerPhoneNumberPage.verifyPageTitle(LiaisonOfficerPhoneNumberPage.pageTitle, LiaisonOfficerPhoneNumberPage.pageUrl) shouldBe true

      Then("the user enters the phone number and clicks on Save and continue button")
      LiaisonOfficerPhoneNumberPage.enterText("value", "07733773373")
      LiaisonOfficerPhoneNumberPage.clickSaveAndContinue()

      Then("the user is navigated to the 'liaison-officer-communication' page")
      LiaisonOfficerCommunicationPage.verifyPageTitle(LiaisonOfficerCommunicationPage.pageTitle, LiaisonOfficerCommunicationPage.pageUrl) shouldBe true

      Then("the user selects all communication modes and clicks on Save and continue button")
      LiaisonOfficerCommunicationPage.selectCommunicationModes()
      LiaisonOfficerCommunicationPage.clickSaveAndContinue()

      Then("the user is navigated to the 'liaison-officer-check-added-liaison-officer' page")
      CheckAddedLiaisonOfficerPage.verifyPageTitle(CheckAddedLiaisonOfficerPage.pageTitle, CheckAddedLiaisonOfficerPage.pageUrl) shouldBe true

      Then("the user clicks on Save and continue button on check-added-liaison-officer' page ")
      CheckAddedLiaisonOfficerPage.clickSaveAndContinue()

      Then("the user is navigated to the 'added-liaison-officer' page")
      AddedLiaisonOfficersPage.verifyPageTitle(AddedLiaisonOfficersPage.pageTitle, AddedLiaisonOfficersPage.pageUrl) shouldBe true

      Then("the user clicks on yes radio button on 'added-liaison-officer' page ")
      AddedLiaisonOfficersPage.clickRadioButton("Yes")

      Then("the user clicks on Save and continue button on 'added-liaison-officer' page ")
      AddedLiaisonOfficersPage.clickSaveAndContinue()

      Then("the user is navigated to the 'liaison-officer-name' page")
      LiaisonOfficerNamePage.verifyPageTitle(LiaisonOfficerNamePage.pageTitle, LiaisonOfficerNamePage.pageUrl) shouldBe true

      Then("the user enters the full name and clicks on Save and continue button")
      LiaisonOfficerNamePage.enterText("value", "Liaison One")
      LiaisonOfficerNamePage.clickSaveAndContinue()

      Then("the user is navigated to the 'liaison-officer-email' page")
      LiaisonOfficerEmailPage.verifyPageTitle(LiaisonOfficerEmailPage.pageTitle, LiaisonOfficerEmailPage.pageUrl) shouldBe true

      Then("the user enters the email value and clicks on Save and continue button")
      LiaisonOfficerEmailPage.enterText("value", "lotwo@email.com")
      LiaisonOfficerEmailPage.clickSaveAndContinue()

      Then("the user is navigated to the 'liaison-officer-phone-number' page")
      LiaisonOfficerPhoneNumberPage.verifyPageTitle(LiaisonOfficerPhoneNumberPage.pageTitle, LiaisonOfficerPhoneNumberPage.pageUrl) shouldBe true

      Then("the user enters the phone number and clicks on Save and continue button")
      LiaisonOfficerPhoneNumberPage.enterText("value", "07733773372")
      LiaisonOfficerPhoneNumberPage.clickSaveAndContinue()

      Then("the user is navigated to the 'liaison-officer-communication' page")
      LiaisonOfficerCommunicationPage.verifyPageTitle(LiaisonOfficerCommunicationPage.pageTitle, LiaisonOfficerCommunicationPage.pageUrl) shouldBe true

      Then("the user selects all communication modes and clicks on Save and continue button")
      LiaisonOfficerCommunicationPage.selectCommunicationModes()
      LiaisonOfficerCommunicationPage.clickSaveAndContinue()

      Then("the user is navigated to the 'liaison-officer-check-added-liaison-officer' page")
      CheckAddedLiaisonOfficerPage.verifyPageTitle(CheckAddedLiaisonOfficerPage.pageTitle, CheckAddedLiaisonOfficerPage.pageUrl) shouldBe true

      Then("the user clicks on Save and continue button on check-added-liaison-officer' page ")
      CheckAddedLiaisonOfficerPage.clickSaveAndContinue()

      Then("the user is navigated to the 'added-liaison-officer' page")
      AddedLiaisonOfficersPage.verifyPageTitle(AddedLiaisonOfficersPage.pageTitleTwo, AddedLiaisonOfficersPage.pageUrl) shouldBe true

      When("the user clicks on remove link for the added user ")
      CheckAddedLiaisonOfficerPage.clickOnChangeOrRemoveLinks("remove-liaison-officer")

      Then("the user is navigated to the 'remove-liaison-officer' page")
      RemoveLiaisonOfficerPage.verifyPageTitle(RemoveLiaisonOfficerPage.pageTitle, RemoveLiaisonOfficerPage.pageUrl) shouldBe true

      Then("the user clicks on no radio button on 'remove-liaison-officer' page ")
      RemoveLiaisonOfficerPage.clickRadioButton("No")

      Then("the user clicks on Save and continue button on 'remove-liaison-officer' page ")
      RemoveLiaisonOfficerPage.clickSaveAndContinue()

      Then("the user is navigated to the 'added-liaison-officer' page")
      AddedLiaisonOfficersPage.verifyPageTitle(AddedLiaisonOfficersPage.pageTitleTwo, AddedLiaisonOfficersPage.pageUrl) shouldBe true

      When("the user clicks on remove link for the added user ")
      CheckAddedLiaisonOfficerPage.clickOnChangeOrRemoveLinks("remove-liaison-officer")

      Then("the user is navigated to the 'remove-liaison-officer' page")
      RemoveLiaisonOfficerPage.verifyPageTitle(RemoveLiaisonOfficerPage.pageTitle, RemoveLiaisonOfficerPage.pageUrl) shouldBe true

      Then("the user clicks on Yes radio button on 'remove-liaison-officer' page ")
      RemoveLiaisonOfficerPage.clickRadioButton("Yes")

      Then("the user clicks on Save and continue button on 'remove-liaison-officer' page ")
      RemoveLiaisonOfficerPage.clickSaveAndContinue()

      Then("the user is navigated to the 'added-liaison-officer' page")
      AddedLiaisonOfficersPage.verifyPageTitle(AddedLiaisonOfficersPage.pageTitle, AddedLiaisonOfficersPage.pageUrl) shouldBe true

    }

  }
}
