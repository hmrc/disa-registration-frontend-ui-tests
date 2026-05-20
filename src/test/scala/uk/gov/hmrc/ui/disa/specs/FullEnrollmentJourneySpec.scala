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

class FullEnrollmentJourneySpec extends BaseSpec {

  Feature("Add an organisation") {

    Scenario("1.Verify user can complete enrollment as registered to manage ISAs with HMRC",WIP) {

      Given("the user is logged in as an organisation User")
      AuthLoginPage.loginAsAFreshUser("/start")

      Then("the user is navigated to the 'Task list' page")
      TaskListPage.verifyPageTitle(TaskListPage.pageTitle, TaskListPage.pageUrl) shouldBe true

      // Adding organisation details

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

      Then("the user is navigated to the 'Organisation details check your answers' page")
      OrganisationDetailsCheckYourAnswersPage.verifyPageTitle(
        OrganisationDetailsCheckYourAnswersPage.pageTitle,
        OrganisationDetailsCheckYourAnswersPage.pageUrl
      ) shouldBe true

      Then("the user clicks on save and continue on 'Organisation details check your answers' page")
      OrganisationDetailsCheckYourAnswersPage.clickSaveAndContinue()

      Then("the user is navigated to the 'Task list' page")
      TaskListPage.verifyPageTitle(TaskListPage.pageTitle, TaskListPage.pageUrl) shouldBe true

      // Adding organisation email

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

      Then("the user is navigated to the 'Organisation Email CYA' page")
      OrganisationEmailCheckYourAnswersPage.verifyPageTitle(
        OrganisationEmailCheckYourAnswersPage.pageTitle,
        OrganisationEmailCheckYourAnswersPage.pageUrl
      ) shouldBe true

      When("the user clicks on change link for change organisation email address")
      OrganisationEmailCheckYourAnswersPage.clickOnLinks("change-organisation-email-address")

      Then("the user is navigated to the 'Change Organisation Email address' page")
      OrganisationEmailCheckYourAnswersPage.verifyPageTitle(
        ChangeOrganisationEmailAddressPage.pageTitle,
        ChangeOrganisationEmailAddressPage.pageUrl
      ) shouldBe true

      Then("the user clicks on Save and continue button")
      ChangeOrganisationEmailAddressPage.clickSaveAndContinue()

      Then("the user is navigated to the 'Organisation Email CYA' page")
      OrganisationEmailCheckYourAnswersPage.verifyPageTitle(
        OrganisationEmailCheckYourAnswersPage.pageTitle,
        OrganisationEmailCheckYourAnswersPage.pageUrl
      ) shouldBe true

      Then("the user clicks on Confirm and Save button")
      OrganisationEmailCheckYourAnswersPage.clickConfirmAndSave()

      Then("the user is navigated to the 'Task list' page")
      TaskListPage.verifyPageTitle(TaskListPage.pageTitle, TaskListPage.pageUrl) shouldBe true

      // Adding product details

      When("the user navigates to the 'ISA-products' page")
      AuthLoginPage.navigateTo(ISAProductsPage.pageUrl)

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
      PeerToPeerLoansPage.enterPlatformNameThenClickContinue()

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

      Then("the user clicks on Confirm and Save button")
      IsaProductsCheckYourAnswersPage.clickConfirmAndSave()

      Then("the user is navigated to the 'Task list' page")
      TaskListPage.verifyPageTitle(TaskListPage.pageTitle, TaskListPage.pageUrl) shouldBe true

      // Adding Certificates and authority details

      Given("the user navigates 'Eligibility to manage ISAs' page")
      AuthLoginPage.loginAsAFreshUser("/eligibility-to-manage-isas")

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
      CertificatesOfAuthorityCheckYourAnswersPage.clickConfirmAndSave()

   //  Adding Liaison Officers

      When("the user navigates to the 'liaison officer name' page")
      LiaisonOfficerNamePage.navigateTo(LiaisonOfficerNamePage.pageUrl)

      Then("the user is navigated to the 'liaison-officer-name' page")
      LiaisonOfficerNamePage.verifyPageTitle(
        LiaisonOfficerNamePage.pageTitle,
        LiaisonOfficerNamePage.pageUrl
      ) shouldBe true

      Then("the user enters the full name and clicks on Save and continue button")
      LiaisonOfficerNamePage.enterText("value", "Liaison One")
      LiaisonOfficerNamePage.clickSaveAndContinue()

      Then("the user is navigated to the 'liaison-officer-email' page")
      LiaisonOfficerEmailPage.verifyPageTitle(
        LiaisonOfficerEmailPage.pageTitle,
        LiaisonOfficerEmailPage.pageUrl
      ) shouldBe true

      Then("the user enters the email value and clicks on Save and continue button")
      LiaisonOfficerEmailPage.enterText("value", "loone@email.com")
      LiaisonOfficerEmailPage.clickSaveAndContinue()

      Then("the user is navigated to the 'liaison-officer-phone-number' page")
      LiaisonOfficerPhoneNumberPage.verifyPageTitle(
        LiaisonOfficerPhoneNumberPage.pageTitle,
        LiaisonOfficerPhoneNumberPage.pageUrl
      ) shouldBe true

      Then("the user enters the phone number and clicks on Save and continue button")
      LiaisonOfficerPhoneNumberPage.enterText("value", "07733773373")
      LiaisonOfficerPhoneNumberPage.clickSaveAndContinue()

      Then("the user is navigated to the 'liaison-officer-communication' page")
      LiaisonOfficerCommunicationPage.verifyPageTitle(
        LiaisonOfficerCommunicationPage.pageTitle,
        LiaisonOfficerCommunicationPage.pageUrl
      ) shouldBe true

      Then("the user selects all communication modes and clicks on Save and continue button")
      LiaisonOfficerCommunicationPage.selectCommunicationModes()
      LiaisonOfficerCommunicationPage.clickSaveAndContinue()

      Then("the user is navigated to the 'liaison-officer-check-added-liaison-officer' page")
      CheckAddedLiaisonOfficerPage.verifyPageTitle(
        CheckAddedLiaisonOfficerPage.pageTitle,
        CheckAddedLiaisonOfficerPage.pageUrl
      ) shouldBe true

      Then("the user clicks on Save and continue button on check-added-liaison-officer' page ")
      CheckAddedLiaisonOfficerPage.clickOnLinks("added-liaison-officers")

      Then("the user is navigated to the 'added-liaison-officer' page")
      AddedLiaisonOfficersPage.verifyPageTitle(
        AddedLiaisonOfficersPage.pageTitle,
        AddedLiaisonOfficersPage.pageUrl
      ) shouldBe true

      Then("the user clicks on no radio button on 'added-liaison-officer' page ")
      AddedLiaisonOfficersPage.clickRadioButton("No")

      Then("the user clicks on Save and continue button on 'added-liaison-officer' page ")
      AddedLiaisonOfficersPage.clickSaveAndContinue()

      // launching check your answer page

      When("the user navigates to the 'Check your answers' page")
      AuthLoginPage.navigateTo(CheckYourAnswersPage.pageUrl)

      Then("the user is navigated to the 'Check your answers' page")
      CheckYourAnswersPage.verifyPageTitle(
        CheckYourAnswersPage.pageTitle,
        CheckYourAnswersPage.pageUrl
      ) shouldBe true

      When("the user clicks  change link for ISA products on 'Check your answers' page ")
      CheckYourAnswersPage.clickOnLinks("change-certificates-of-authority")

      Then("the user is navigated to the 'Change-Certificates' page")
      ChangeCertificatesOfAuthorityPage.verifyPageTitle(
        ChangeCertificatesOfAuthorityPage.pageTitle,
        ChangeCertificatesOfAuthorityPage.pageUrl
      ) shouldBe true


      Then("the user clicks on Save and continue button on 'change-certificates' page ")
      ChangeCertificatesOfAuthorityPage.clickSaveAndContinue()

      Then("the user is navigated to the 'Check your answers' page")
      CheckYourAnswersPage.verifyPageTitle(
        CheckYourAnswersPage.pageTitle,
        CheckYourAnswersPage.pageUrl
      ) shouldBe true

      When("the user clicks on Liaison officer change link on 'Check your answers' page ")
      CheckYourAnswersPage.clickOnLinks("change-liaison-officer-name")

      Then("the user is navigated to the 'liaison-officer-name' page")
      ChangeLiaisonOfficerNamePage.verifyPageTitle(
        ChangeLiaisonOfficerNamePage.pageTitle,
        ChangeLiaisonOfficerNamePage.pageUrl
      ) shouldBe true


      Then("the user clicks on Save and continue button on 'change-liaison-name' page ")
      ChangeLiaisonOfficerNamePage.clickSaveAndContinue()
      
    }

    Scenario("2.Verify user can add organisation details as not registered to manage ISAs with HMRC and edit details from CYA page") {

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

      Then("the user is navigated to the 'Organisation details check your answers' page")
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

      Then("the user is navigated to the 'Organisation details check your answers' page")
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

      Then("the user is navigated to the 'Organisation details check your answers' page")
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

      Then("the user is navigated to the 'Organisation details check your answers' page")
      OrganisationDetailsCheckYourAnswersPage.verifyPageTitle(
        OrganisationDetailsCheckYourAnswersPage.pageTitle,
        OrganisationDetailsCheckYourAnswersPage.pageUrl
      ) shouldBe true

    }

  }

}
