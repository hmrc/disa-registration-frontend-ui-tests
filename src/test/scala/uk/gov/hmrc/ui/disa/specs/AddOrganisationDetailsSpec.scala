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

class AddOrganisationDetailsSpec extends BaseSpec {

  Feature("Add an organisation") {

    Scenario(
      "1.Verify user can add organisation details as registered to manage ISAs with HMRC and then edits details"
    ) {

      Given("the user is logged in as an organisation User")
      AuthLoginPage.loginAsAFreshUser("/start")

      Then("the user is navigated to the 'Manage ISAs' page")
      TaskListPage.verifyPageTitle(TaskListPage.pageTitle, TaskListPage.pageUrl) shouldBe true

      When("the user navigates to the 'Registered ISA Manager' page")
      AuthLoginPage.navigateTo(RegisteredIsaManagerPage.pageUrl)

      Then("the user is navigated to the 'Registered ISA Manager' page")
      RegisteredIsaManagerPage.verifyPageTitle(
        RegisteredIsaManagerPage.pageTitle,
        RegisteredIsaManagerPage.pageUrl
      ) shouldBe true

      Then(
        "the user clicks on the Yes radio button and then clicks on save and continue button on 'Registered ISA Manager' page"
      )
      RegisteredIsaManagerPage.clickRadioButton("Yes")
      RegisteredIsaManagerPage.clickSaveAndContinue()

      Then("the user is navigated to the 'Organisation Z reference number' page")
      OrganisationZReferenceNumberPage.verifyPageTitle(
        OrganisationZReferenceNumberPage.pageTitle,
        OrganisationZReferenceNumberPage.pageUrl
      ) shouldBe true

      Then(
        "the user enters the Z reference value and clicks on save and continue on 'Organisation Z reference number' page"
      )
      OrganisationZReferenceNumberPage.enterText("value", "Z1234")
      OrganisationZReferenceNumberPage.clickSaveAndContinue()

      Then("the user is navigated to the 'Trading using different name' page")
      TradingUsingDifferentNamePage.verifyPageTitle(
        TradingUsingDifferentNamePage.pageTitle,
        TradingUsingDifferentNamePage.pageUrl
      ) shouldBe true

      Then(
        "the user clicks on the Yes radio button and then clicks on save and continue button on 'Trading using different name' page"
      )
      TradingUsingDifferentNamePage.clickRadioButton("Yes")
      TradingUsingDifferentNamePage.clickSaveAndContinue()

      Then("the user is navigated to the 'Organisation trading name' page")
      OrganisationTradingNamePage.verifyPageTitle(
        OrganisationTradingNamePage.pageTitle,
        OrganisationTradingNamePage.pageUrl
      ) shouldBe true

      Then("the user enters the trading name and clicks on save and continue on 'Organisation Z reference number' page")
      OrganisationTradingNamePage.enterText("value", "Trading org")
      OrganisationTradingNamePage.clickSaveAndContinue()

      Then("the user is navigated to the 'Firm reference number' page")
      FirmReferenceNumberPage.verifyPageTitle(
        FirmReferenceNumberPage.pageTitle,
        FirmReferenceNumberPage.pageUrl
      ) shouldBe true

      When("the user enters the Firm reference number and clicks on save and continue on 'Firm reference number' page")
      FirmReferenceNumberPage.enterText("value", "7777777")
      FirmReferenceNumberPage.clickSaveAndContinue()

      Then("the user is navigated to the 'Registered address correspondence' page")
      RegisteredAddressCorrespondencePage.verifyPageTitle(
        RegisteredAddressCorrespondencePage.pageTitle,
        RegisteredAddressCorrespondencePage.pageUrl
      ) shouldBe true

      Then(
        "the user clicks on the No radio button and then clicks on save and continue button on 'registered-address-correspondence' page"
      )
      RegisteredAddressCorrespondencePage.clickRadioButton("No")
      RegisteredAddressCorrespondencePage.clickSaveAndContinue()

      Then("the user is navigated to the 'add-another-address' page")
      AddAnotherAddressForYourOrganisationPage.verifyPageTitle(
        AddAnotherAddressForYourOrganisationPage.pageTitle,
        AddAnotherAddressForYourOrganisationPage.pageUrl
      ) shouldBe true

      Then("the user enters the postcode value and clicks on save and continue on 'add-another-address' page")
      AddAnotherAddressForYourOrganisationPage.enterText("postcode", "ZZ22 2ZZ")
      AddAnotherAddressForYourOrganisationPage.enterText("filter", "10")
      AddAnotherAddressForYourOrganisationPage.clickSaveAndContinue()

      Then("the user is navigated to the 'confirm-correspondence-address' page")
      ConfirmCorrespondenceAddressPage.verifyPageTitle(
        ConfirmCorrespondenceAddressPage.pageTitle,
        ConfirmCorrespondenceAddressPage.pageUrl
      )

      When("the user clicks on the Edit address link on 'confirm-correspondence-address' page")
      ConfirmCorrespondenceAddressPage.clickOnLinks("enter-your-organisation-address")

      Then("the user is navigated to the 'enter-your-organisation-address' page")
      EnterYourOrganisationAddressPage.verifyPageTitle(
        EnterYourOrganisationAddressPage.pageTitle,
        EnterYourOrganisationAddressPage.pageUrl
      )

      Then("the user changes the address  and clicks on Save and continue button")
      EnterYourOrganisationAddressPage.clickSaveAndContinue()

      Then("the user is navigated to the 'confirm-correspondence-address' page")
      ConfirmCorrespondenceAddressPage.verifyPageTitle(
        ConfirmCorrespondenceAddressPage.pageTitle,
        ConfirmCorrespondenceAddressPage.pageUrl
      )

      Then("the user clicks on Save and continue button")
      ConfirmCorrespondenceAddressPage.clickSaveAndContinue()

      Then("the user is navigated to the 'Organisation telephone number' page")
      OrganisationTelephoneNumberPage.verifyPageTitle(
        OrganisationTelephoneNumberPage.pageTitle,
        OrganisationTelephoneNumberPage.pageUrl
      ) shouldBe true

      Then("the user enters the telephone number and clicks on save and continue on 'add-another-address' page")
      OrganisationTelephoneNumberPage.enterText("value", "07777 777 777")
      OrganisationTelephoneNumberPage.clickSaveAndContinue()

      Then("the user is navigated to the 'Check your organisation details' page")
      OrganisationDetailsCheckYourAnswersPage.verifyPageTitle(
        OrganisationDetailsCheckYourAnswersPage.pageTitle,
        OrganisationDetailsCheckYourAnswersPage.pageUrl
      ) shouldBe true

      When("the user clicks on change link for Change Trading name")
      OrganisationDetailsCheckYourAnswersPage.clickOnLinks("change-trading-name")

      Then("the user is navigated to the 'change-trading-name' page")
      ChangeOrganisationTradingNamePage.verifyPageTitle(
        ChangeOrganisationTradingNamePage.pageTitle,
        ChangeOrganisationTradingNamePage.pageUrl
      ) shouldBe true

      Then("the user changes the trading name")
      ChangeOrganisationTradingNamePage.enterText("value", "Changed Trading org")
      ChangeOrganisationTradingNamePage.clickSaveAndContinue()

      Then("the user is navigated to the 'Check your organisation details' page")
      OrganisationDetailsCheckYourAnswersPage.verifyPageTitle(
        OrganisationDetailsCheckYourAnswersPage.pageTitle,
        OrganisationDetailsCheckYourAnswersPage.pageUrl
      ) shouldBe true

      When("the user clicks on change link for Change FCA number")
      OrganisationDetailsCheckYourAnswersPage.clickOnLinks("change-firm-reference-number")

      Then("the user is navigated to the 'change-firm-reference-number' page")
      ChangeFirmReferenceNumberPage.verifyPageTitle(
        ChangeFirmReferenceNumberPage.pageTitle,
        ChangeFirmReferenceNumberPage.pageUrl
      ) shouldBe true

      Then("the user changes the FRN")
      ChangeOrganisationTradingNamePage.enterText("value", "9992299")
      ChangeOrganisationTradingNamePage.clickSaveAndContinue()

      Then("the user is navigated to the 'Check your organisation details' page")
      OrganisationDetailsCheckYourAnswersPage.verifyPageTitle(
        OrganisationDetailsCheckYourAnswersPage.pageTitle,
        OrganisationDetailsCheckYourAnswersPage.pageUrl
      ) shouldBe true

      When("the user clicks on change link for Change organisation Telephone number")
      OrganisationDetailsCheckYourAnswersPage.clickOnLinks("change-organisation-telephone-number")

      Then("the user is navigated to the 'change-organisation-telephone-number' page")
      ChangeOrganisationTelephoneNumberPage.verifyPageTitle(
        ChangeOrganisationTelephoneNumberPage.pageTitle,
        ChangeOrganisationTelephoneNumberPage.pageUrl
      ) shouldBe true

      Then("the user changes the organisation telephone number")
      ChangeOrganisationTelephoneNumberPage.enterText("value", "07777777777")
      ChangeOrganisationTelephoneNumberPage.clickSaveAndContinue()

      Then("the user is navigated to the 'Check your organisation details' page")
      OrganisationDetailsCheckYourAnswersPage.verifyPageTitle(
        OrganisationDetailsCheckYourAnswersPage.pageTitle,
        OrganisationDetailsCheckYourAnswersPage.pageUrl
      ) shouldBe true

//      When("the user navigates to the 'Check your answers' page")
//      AuthLoginPage.navigateTo(CheckYourAnswersPage.pageUrl)
//
//      Then("the user is navigated to the 'Check your answers' page")
//      CheckYourAnswersPage.verifyPageTitle(
//        CheckYourAnswersPage.pageTitle,
//        CheckYourAnswersPage.pageUrl
//      ) shouldBe true

      When("the user clicks on change link for Change Trading name")
      CheckYourAnswersPage.clickOnLinks("change-trading-name")

      Then("the user is navigated to the 'change-trading-name' page")
      ChangeOrganisationTradingNamePage.verifyPageTitle(
        ChangeOrganisationTradingNamePage.pageTitle,
        ChangeOrganisationTradingNamePage.pageUrl
      ) shouldBe true

      Then("the user changes the trading name")
      ChangeOrganisationTradingNamePage.enterText("value", "Trading org")
      ChangeOrganisationTradingNamePage.clickSaveAndContinue()

      Then("the user is navigated to the 'Check your organisation details' page")
      OrganisationDetailsCheckYourAnswersPage.verifyPageTitle(
        OrganisationDetailsCheckYourAnswersPage.pageTitle,
        OrganisationDetailsCheckYourAnswersPage.pageUrl
      ) shouldBe true

      When("the user clicks on change link for Change FCA number")
      CheckYourAnswersPage.clickOnLinks("change-firm-reference-number")

      Then("the user is navigated to the 'change-firm-reference-number' page")
      ChangeFirmReferenceNumberPage.verifyPageTitle(
        ChangeFirmReferenceNumberPage.pageTitle,
        ChangeFirmReferenceNumberPage.pageUrl
      ) shouldBe true

      Then("the user changes the FRN")
      ChangeOrganisationTradingNamePage.enterText("value", "9992299")
      ChangeOrganisationTradingNamePage.clickSaveAndContinue()

//      Then("the user is navigated to the 'Check your answers' page")
//      CheckYourAnswersPage.verifyPageTitle(
//        CheckYourAnswersPage.pageTitle,
//        CheckYourAnswersPage.pageUrl
//      ) shouldBe true

      When("the user clicks on change link for Change organisation Telephone number")
      CheckYourAnswersPage.clickOnLinks("change-organisation-telephone-number")

      Then("the user is navigated to the 'change-organisation-telephone-number' page")
      ChangeOrganisationTelephoneNumberPage.verifyPageTitle(
        ChangeOrganisationTelephoneNumberPage.pageTitle,
        ChangeOrganisationTelephoneNumberPage.pageUrl
      ) shouldBe true

      Then("the user changes the organisation telephone number")
      ChangeOrganisationTelephoneNumberPage.enterText("value", "07777777777")
      ChangeOrganisationTelephoneNumberPage.clickSaveAndContinue()

//      Then("the user is navigated to the 'Check your answers' page")
//      CheckYourAnswersPage.verifyPageTitle(
//        CheckYourAnswersPage.pageTitle,
//        CheckYourAnswersPage.pageUrl
//      ) shouldBe true

      Then("the user clicks on Save and Continue on the Check your organisation details page")
      OrganisationDetailsCheckYourAnswersPage.clickConfirmAndSaveForCheckOrgDetails()

      Then("the user clicks on is navigated to the 'Manage ISAs' page")
      TaskListPage.verifyPageTitle(TaskListPage.pageTitle, TaskListPage.pageUrl) shouldBe true

    }

    Scenario(
      "2.Verify user can add organisation details as not registered to manage ISAs with HMRC and edit details from CYA page"
    ) {

      Given("the user is logged in as an organisation User")
      AuthLoginPage.loginAsAFreshUser("/start")

      Then("the user is navigated to the 'Task list' page")
      TaskListPage.verifyPageTitle(TaskListPage.pageTitle, TaskListPage.pageUrl) shouldBe true

      When("the user navigates to the 'Registered ISA Manager' page")
      AuthLoginPage.navigateTo(RegisteredIsaManagerPage.pageUrl)

      Then("the user is navigated to the 'Registered ISA Manager' page")
      RegisteredIsaManagerPage.verifyPageTitle(
        RegisteredIsaManagerPage.pageTitle,
        RegisteredIsaManagerPage.pageUrl
      ) shouldBe true

      Then(
        "the user clicks on the No radio button and then clicks on save and continue button on 'Registered ISA Manager' page"
      )
      RegisteredIsaManagerPage.clickRadioButton("No")
      RegisteredIsaManagerPage.clickSaveAndContinue()

      Then("the user is navigated to the 'Trading using different name' page")
      TradingUsingDifferentNamePage.verifyPageTitle(
        TradingUsingDifferentNamePage.pageTitle,
        TradingUsingDifferentNamePage.pageUrl
      ) shouldBe true

      Then(
        "the user clicks on the No radio button and then clicks on save and continue button on 'Trading using different name' page"
      )
      TradingUsingDifferentNamePage.clickRadioButton("No")
      TradingUsingDifferentNamePage.clickSaveAndContinue()

      Then("the user is navigated to the 'Firm reference number' page")
      FirmReferenceNumberPage.verifyPageTitle(
        FirmReferenceNumberPage.pageTitle,
        FirmReferenceNumberPage.pageUrl
      ) shouldBe true

      When("the user enters the Firm reference number and clicks on save and continue on 'Firm reference number' page")
      FirmReferenceNumberPage.enterText("value", "7777777")
      FirmReferenceNumberPage.clickSaveAndContinue()

      Then("the user is navigated to the 'Registered address correspondence' page")
      RegisteredAddressCorrespondencePage.verifyPageTitle(
        RegisteredAddressCorrespondencePage.pageTitle,
        RegisteredAddressCorrespondencePage.pageUrl
      ) shouldBe true

      Then(
        "the user clicks on the No radio button and then clicks on save and continue button on 'registered-address-correspondence' page"
      )
      RegisteredAddressCorrespondencePage.clickRadioButton("No")
      RegisteredAddressCorrespondencePage.clickSaveAndContinue()

      Then("the user is navigated to the 'add-another-address' page")
      AddAnotherAddressForYourOrganisationPage.verifyPageTitle(
        AddAnotherAddressForYourOrganisationPage.pageTitle,
        AddAnotherAddressForYourOrganisationPage.pageUrl
      ) shouldBe true

      Then(
        "the user enters the postcode value which results in multiple results and clicks on save and continue  'add-another-address' page"
      )
      AddAnotherAddressForYourOrganisationPage.enterText("postcode", "ZZ22 2ZZ")
      AddAnotherAddressForYourOrganisationPage.clickSaveAndContinue()

      Then("the user is navigated to the 'choose-address' page")
      ChooseAnotherAddressForYourOrganisationPage.verifyPageTitle(
        ChooseAnotherAddressForYourOrganisationPage.pageTitle,
        ChooseAnotherAddressForYourOrganisationPage.pageUrl
      ) shouldBe true

      Then(
        "the user clicks on 1st address radio button and then click on save and continue button on 'Choose address' page "
      )
      ChooseAnotherAddressForYourOrganisationPage.clickRadioButton("10 Test Street, Test town, ZZ22 2ZZ")
      ChooseAnotherAddressForYourOrganisationPage.clickSaveAndContinue()

      Then("the user is navigated to the 'confirm-correspondence-address' page")
      ConfirmCorrespondenceAddressPage.verifyPageTitle(
        ConfirmCorrespondenceAddressPage.pageTitle,
        ConfirmCorrespondenceAddressPage.pageUrl
      )

      When("the user clicks on the Edit address link they are taken to the 'enter-your-organisation-address' page")
      ConfirmCorrespondenceAddressPage.clickOnLinks("enter-your-organisation-address")

      Then("the user is navigated to the 'enter-your-organisation-address' page")
      EnterYourOrganisationAddressPage.verifyPageTitle(
        EnterYourOrganisationAddressPage.pageTitle,
        EnterYourOrganisationAddressPage.pageUrl
      )

      Then("the user changes the address  and clicks on Save and continue button")
      EnterYourOrganisationAddressPage.clickSaveAndContinue()

      Then("the user is navigated to the 'confirm-correspondence-address' page and clicks on Save and continue button")
      ConfirmCorrespondenceAddressPage.verifyPageTitle(
        ConfirmCorrespondenceAddressPage.pageTitle,
        ConfirmCorrespondenceAddressPage.pageUrl
      )

      Then("the user  clicks on Save and continue button")
      ConfirmCorrespondenceAddressPage.clickSaveAndContinue()

      Then("the user is navigated to the 'Organisation telephone number' page")
      OrganisationTelephoneNumberPage.verifyPageTitle(
        OrganisationTelephoneNumberPage.pageTitle,
        OrganisationTelephoneNumberPage.pageUrl
      ) shouldBe true

      Then("the user enters the telephone number and clicks on save and continue on 'add-another-address' page")
      OrganisationTelephoneNumberPage.enterText("value", "07777 777 777")
      OrganisationTelephoneNumberPage.clickSaveAndContinue()

      Then("the user is navigated to the 'Check your organisation details' page")
      OrganisationDetailsCheckYourAnswersPage.verifyPageTitle(
        OrganisationDetailsCheckYourAnswersPage.pageTitle,
        OrganisationDetailsCheckYourAnswersPage.pageUrl
      ) shouldBe true

      When("the user clicks on change link for Registered to manage ISAs")
      OrganisationDetailsCheckYourAnswersPage.clickOnLinks("change-registered-isa-manager")

      Then("the user is navigated to the 'Change Registered to manage ISAsl' page")
      ChangeRegisteredIsaManagerPage.verifyPageTitle(
        ChangeRegisteredIsaManagerPage.pageTitle,
        ChangeRegisteredIsaManagerPage.pageUrl
      ) shouldBe true

      Then("the user changes the Registered ISA manager to Yes and clicks on Save and continue button")
      ChangeRegisteredIsaManagerPage.clickRadioButton("Yes")
      ChangeRegisteredIsaManagerPage.clickSaveAndContinue()

      Then("the user is navigated to the 'Organisation Z reference number' page")
      OrganisationZReferenceNumberPage.verifyPageTitle(
        OrganisationZReferenceNumberPage.pageTitle,
        OrganisationZReferenceNumberPage.pageUrl
      ) shouldBe true

      Then(
        "the user enters the Z reference value and clicks on save and continue on 'Organisation Z reference number' page"
      )
      OrganisationZReferenceNumberPage.enterText("value", "Z1234")
      OrganisationZReferenceNumberPage.clickSaveAndContinue()

      Then("the user is navigated to the 'Check your organisation details' page")
      OrganisationDetailsCheckYourAnswersPage.verifyPageTitle(
        OrganisationDetailsCheckYourAnswersPage.pageTitle,
        OrganisationDetailsCheckYourAnswersPage.pageUrl
      ) shouldBe true

      When("the user clicks on change link for Different trading name")
      OrganisationDetailsCheckYourAnswersPage.clickOnLinks("change-trading-using-different-name")

      Then("the user is navigated to the 'Change Trading using different name' page")
      ChangeTradingUsingDifferentNamePage.verifyPageTitle(
        ChangeTradingUsingDifferentNamePage.pageTitle,
        ChangeTradingUsingDifferentNamePage.pageUrl
      ) shouldBe true

      Then("the user changes Trading using different name to Yes and clicks on Save and continue button")
      ChangeTradingUsingDifferentNamePage.clickRadioButton("Yes")
      ChangeTradingUsingDifferentNamePage.clickSaveAndContinue()

      Then("the user is navigated to the 'Organisation trading name' page")
      OrganisationTradingNamePage.verifyPageTitle(
        OrganisationTradingNamePage.pageTitle,
        OrganisationTradingNamePage.pageUrl
      ) shouldBe true

      Then("the user enters the trading name and clicks on save and continue on 'Organisation trading name' page")
      OrganisationTradingNamePage.enterText("value", "Trading name")
      OrganisationTradingNamePage.clickSaveAndContinue()

      Then("the user is navigated to the 'Check your organisation details' page")
      OrganisationDetailsCheckYourAnswersPage.verifyPageTitle(
        OrganisationDetailsCheckYourAnswersPage.pageTitle,
        OrganisationDetailsCheckYourAnswersPage.pageUrl
      ) shouldBe true

      When("the user clicks on change link for Registered address for correspondence")
      OrganisationDetailsCheckYourAnswersPage.clickOnLinks("change-registered-address-correspondence")

      Then("the user is navigated to the 'change-registered-address-correspondence' page")
      ChangeRegisteredAddressCorrespondencePage.verifyPageTitle(
        ChangeRegisteredAddressCorrespondencePage.pageTitle,
        ChangeRegisteredAddressCorrespondencePage.pageUrl
      ) shouldBe true

      Then("the user changes the Registered Address Correspondence to Yes and clicks on Save and continue button")
      ChangeRegisteredAddressCorrespondencePage.clickRadioButton("Yes")
      ChangeRegisteredAddressCorrespondencePage.clickSaveAndContinue()

      Then("the user is navigated to the 'Check your organisation details' page")
      OrganisationDetailsCheckYourAnswersPage.verifyPageTitle(
        OrganisationDetailsCheckYourAnswersPage.pageTitle,
        OrganisationDetailsCheckYourAnswersPage.pageUrl
      ) shouldBe true

      Then("the user clicks on Save and Continue on the Check your organisation details page")
      OrganisationDetailsCheckYourAnswersPage.clickConfirmAndSaveForCheckOrgDetails()

      Then("the user clicks on is navigated to the 'Manage ISAs' page")
      TaskListPage.verifyPageTitle(TaskListPage.pageTitle, TaskListPage.pageUrl) shouldBe true
    }

  }

}
