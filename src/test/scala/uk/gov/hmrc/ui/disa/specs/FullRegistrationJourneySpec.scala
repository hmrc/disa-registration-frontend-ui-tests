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

class FullRegistrationJourneySpec extends BaseSpec {

  Feature("Manage Isas") {

    Scenario("Verify user can complete all the journeys in manage ISAs tasklist page then submit and declare", WIP) {

      Given("the user is logged in as an organisation User")
      AuthLoginPage.loginAsAFreshUser("/company-type")

      Then("the user is navigated to the 'Company Type' page")
      CompanyTypePage.verifyPageTitle(CompanyTypePage.pageTitle, CompanyTypePage.pageUrl) shouldBe true

      Then(
        "the user clicks on the Limited Company radio button and then clicks on save and continue button on 'Company Type' page"
      )
      CompanyTypePage.selectLimitedCompanyAndContinue()

      Then("the user is navigated to the 'Task list' page")
      TaskListPage.verifyPageTitle(TaskListPage.pageTitle, TaskListPage.pageUrl) shouldBe true

      Then(
        "the 'Add organisation details' status is 'Not yet started' the user clicks on the 'Add organisation information' link"
      )
      TaskListPage.verifyTaskStatus("Add organisation details", "Not yet started")
      TaskListPage.clickOnByPartialLinkText("Add organisation details")

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

      Then(
        "the user enters the 'Organisation trading name' page and clicks on save and continue on 'Organisation Z reference number' page"
      )
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
        "the user clicks on the No radio button and then clicks on confirm and continue button on 'registered-address-correspondence' page"
      )
      RegisteredAddressCorrespondencePage.clickRadioButton("No")
      RegisteredAddressCorrespondencePage.clickConfirmAndContinue()

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

      Then("the user clicks on Save and continue button")
      EnterYourOrganisationAddressPage.clickSaveAndContinue()

      Then("the user is navigated to the 'confirm-correspondence-address' page")
      ConfirmCorrespondenceAddressPage.verifyPageTitle(
        ConfirmCorrespondenceAddressPage.pageTitle,
        ConfirmCorrespondenceAddressPage.pageUrl
      )

      Then("the user clicks on Save and continue button")
      ConfirmCorrespondenceAddressPage.clickConfirmAndContinue()

      Then("the user is navigated to the 'Organisation telephone number' page")
      OrganisationTelephoneNumberPage.verifyPageTitle(
        OrganisationTelephoneNumberPage.pageTitle,
        OrganisationTelephoneNumberPage.pageUrl
      ) shouldBe true

      Then(
        "the user enters the telephone number and clicks on save and continue on 'Organisation telephone number' page"
      )
      OrganisationTelephoneNumberPage.enterText("value", "07777 777 777")
      OrganisationTelephoneNumberPage.clickSaveAndContinue()

      Then("the user is navigated to the 'Check your organisation details' page")
      OrganisationDetailsCheckYourAnswersPage.verifyPageTitle(
        OrganisationDetailsCheckYourAnswersPage.pageTitle,
        OrganisationDetailsCheckYourAnswersPage.pageUrl
      ) shouldBe true

      Then("the user clicks on Save and Continue on the Check your organisation details page")
      OrganisationDetailsCheckYourAnswersPage.clickConfirmAndSaveForCheckOrgDetails()

      Then("the user is navigated to the 'Task list' page")
      TaskListPage.verifyPageTitle(TaskListPage.pageTitle, TaskListPage.pageUrl) shouldBe true

      And("The status for organisation  status is 'Completed'")
      TaskListPage.verifyTaskStatus("Change organisation details", "Completed")

      When(
        "the 'Add organisation email' status is 'Not yet started' the user navigates to the 'Organisation email address' page"
      )
      TaskListPage.verifyTaskStatus("Add organisation email", "Not yet started")
      TaskListPage.clickOnByPartialLinkText("Add organisation email")

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

      Then("the user clicks on Confirm and Continue button")
      OrganisationEmailCheckYourAnswersPage.clickConfirmAndContinue()

      Then("the user is navigated to the 'Task list' page")
      TaskListPage.verifyPageTitle(TaskListPage.pageTitle, TaskListPage.pageUrl) shouldBe true

      And(" The status for 'Organisation email' status is 'Verified'")
      TaskListPage.verifyTaskStatus("Change organisation email", "Verified")

      When(
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

      Then("the user clicks on Confirm and Continue button")
      OrganisationEmailCheckYourAnswersPage.clickConfirmAndContinue()

      And(" The status for 'Change ISA products you manage' status is 'Completed'")
      TaskListPage.verifyTaskStatus("Change ISA products you manage", "Completed")

      When(
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

      When("the user selects 'yes' and click on 'save and continue' button")
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

      Then("the user clicks on Confirm and Continue button")
      CertificatesOfAuthorityCheckYourAnswersPage.clickConfirmAndContinue()

      And(" The status for 'Change which certificates of authority apply to your organisation' status is 'Completed'")
      TaskListPage.verifyTaskStatus("Change which certificates of authority apply to your organisation", "Completed")

      Then(
        "the 'Add liaison officers' status is 'Not yet started' the user clicks on the 'Add liaison officers' link"
      )
      TaskListPage.verifyTaskStatus("Add liaison officers", "Not yet started")
      TaskListPage.clickOnByPartialLinkText("Add liaison officers")

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
      CheckAddedLiaisonOfficerPage.clickConfirmAndContinueLink()

      Then("the user clicks on no radio button on 'added-liaison-officer' page ")
      AddedLiaisonOfficersPage.clickRadioButton("No")

      Then("the user clicks on Save and continue button on 'added-liaison-officer' page ")
      AddedLiaisonOfficersPage.clickSaveAndContinue()

      Then("the user is navigated to the 'Task list' page")
      TaskListPage.verifyPageTitle(TaskListPage.pageTitle, TaskListPage.pageUrl) shouldBe true

      And("The status for 'Change liaison officers' is '1 liaison officer'")
      TaskListPage.verifyTaskStatus("Change liaison officers", "1 liaison officer")

      Then("the 'Add signatories' status is 'Not yet started' the user clicks on the 'Add signatories' link")
      TaskListPage.verifyTaskStatus("Add signatories", "Not yet started")
      TaskListPage.clickOnByPartialLinkText("Add signatories")

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

      Then("the user clicks on Confirm and continue button on 'added-signatory' page ")
      AddedSignatoriesPage.clickConfirmAndContinueLink()

      Then("the user clicks on No radio button on 'added-signatory' page ")
      AddedSignatoriesPage.clickRadioButton("No")

      When("the user clicks on Save and continue button on 'added-signatory' page ")
      AddedSignatoriesPage.clickSaveAndContinue()

      Then("the user is navigated to the 'Task-list' page")
      TaskListPage.verifyPageTitle(TaskListPage.pageTitle, TaskListPage.pageUrl) shouldBe true

      And("The status for 'Change signatories' is '1 signatory'")
      TaskListPage.verifyTaskStatus("Change signatories", "1 signatory")

      Then(
        "the 'Add organisations you outsource to' status is 'Not yet started' the user clicks on the 'Add organisations you outsource to' link"
      )
      TaskListPage.verifyTaskStatus("Add organisations you outsource to", "Not yet started")
      TaskListPage.clickOnByPartialLinkText("Add organisations you outsource to")

      Then("the user is navigated to the 'ISA products managed by third party' page")
      ThirdPartyProductManagePage.verifyPageTitle(
        ThirdPartyProductManagePage.pageTitle,
        ThirdPartyProductManagePage.pageUrl
      ) shouldBe true

      Then(
        "the user clicks on yes radio button and then click save and continue on 'ISA products managed by third party' page "
      )
      ThirdPartyProductManagePage.clickRadioButton("Yes")
      ThirdPartyProductManagePage.clickSaveAndContinue()

      Then("the user is navigated to the 'Third party organisations details' page")
      ThirdPartyDetailsPage.verifyPageTitle(
        ThirdPartyDetailsPage.pageTitle,
        ThirdPartyDetailsPage.pageUrl
      ) shouldBe true

      When("the user enters the Third party org name and FRN and clicks on Save and continue button")
      ThirdPartyDetailsPage.enterText("thirdPartyName", "ThirdParty")
      ThirdPartyDetailsPage.enterText("frn", "777333")
      ThirdPartyDetailsPage.clickSaveAndContinue()

      Then("the user is navigated to the 'ISA returns and reporting managed by third party' page")
      ThirdPartyManageISAsPage.verifyPageTitle(
        ThirdPartyManageISAsPage.pageTitle,
        ThirdPartyManageISAsPage.pageUrl
      ) shouldBe true

      Then(
        "the user clicks on yes radio button and then click on save and continue button  on 'ISA returns and reporting managed by third party' page "
      )
      ThirdPartyManageISAsPage.clickRadioButton("Yes")
      ThirdPartyManageISAsPage.clickSaveAndContinue()

      Then("the user is navigated to the 'Investor funds used for ISA products managed by third party' page")
      ThirdPartyManageISAsPage.verifyPageTitle(
        ThirdPartyInvestorFundsPage.pageTitle,
        ThirdPartyInvestorFundsPage.pageUrl
      ) shouldBe true

      Then(
        "the user clicks on yes radio button and then click on save and continue button  on 'Investor funds used for ISA products managed by third party' page "
      )
      ThirdPartyInvestorFundsPage.clickRadioButton("Yes")
      ThirdPartyInvestorFundsPage.clickSaveAndContinue()

      Then(
        "the user is navigated to the 'What percentage of Investor funds used for ISA products managed by third party' page"
      )
      ThirdPartyManageISAsPage.verifyPageTitle(
        ThirdPartyPercentageOfInvestorFundsPage.pageTitle,
        ThirdPartyPercentageOfInvestorFundsPage.pageUrl
      ) shouldBe true

      When("the user enters the percentage value and clicks on Save and continue button")
      ThirdPartyPercentageOfInvestorFundsPage.enterText("value", "20")
      ThirdPartyPercentageOfInvestorFundsPage.clickSaveAndContinue()

      Then("the user is navigated to the 'Check added third party org' page")
      CheckAddedThirdPartyPage.verifyPageTitle(
        CheckAddedThirdPartyPage.pageTitle,
        CheckAddedThirdPartyPage.pageUrl
      ) shouldBe true

      Then("the user clicks on Confirm and continue button on 'check added third party' page ")
      CheckAddedThirdPartyPage.clickConfirmAndContinueLink()

      Then("the user clicks on no radio button and then save and continue on 'added third party organisation' page ")
      AddedThirdPartiesPage.clickRadioButton("No")
      AddedThirdPartiesPage.clickSaveAndContinue()

      Then("the user is navigated to the 'Task list' page")
      TaskListPage.verifyPageTitle(TaskListPage.pageTitle, TaskListPage.pageUrl) shouldBe true

      And("The status for 'Change organisations you outsource to' is '1 third party'")
      TaskListPage.verifyTaskStatus("Change organisations you outsource to", "1 third-party")

      When(
        "the 'Check answers and submit' status is 'Not yet started' the user clicks on the 'Check answers and submit' link"
      )
      TaskListPage.verifyTaskStatus("Check answers and submit", "Not yet started")
      TaskListPage.clickOnByPartialLinkText("Check answers and submit")

      Then("the user is navigated to the 'check all your answers before you submit' page")
      CheckYourAnswersPage.verifyPageTitle(CheckYourAnswersPage.pageTitle1, CheckYourAnswersPage.pageUrl) shouldBe true

      When("the user clicks on Confirm and continue button on 'check all your answers before you submit' page ")
      CheckYourAnswersPage.clickConfirmAndContinue()

      And("the user should see ISA manager declaration screen")
      DeclarationForIsaManagersPage.verifyPageTitle(
        DeclarationForIsaManagersPage.pageTitle,
        DeclarationForIsaManagersPage.pageUrl
      ) shouldBe true

      When("the user clicks on Confirm and continue button on 'ISA manager declaration screen' page ")
      DeclarationForIsaManagersPage.clickConfirmAndSubmit()

      And("the user should see enrolment completed screen")
      EnrolmentCompletePage.verifyPageTitle(
        EnrolmentCompletePage.pageTitle,
        EnrolmentCompletePage.pageUrl
      ) shouldBe true
    }

  }

}
