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

class CreateLtdCompanySpec extends BaseSpec {

  Feature(" Create Limited Company journey ") {

    Scenario("Verify that upon successful cred id submission task list page is displayed") {
      Given("the ISA manager is logged in as an organisation User")
      AuthLoginPage.launchAuthPage("/start")
      AuthLoginPage.enterCredId("grs-create-journey-success")
      AuthLoginPage.clickSubmit()

      Then("the user is navigated to the 'Task list' page")
      TaskListPage.verifyPageTitle(TaskListPage.pageTitle, TaskListPage.pageUrl) shouldBe true

    }

    Scenario("Verify that when user enters cred id with Business verification failure lock out page is displayed") {
      Given("the ISA manager is logged in as an organisation User")
      AuthLoginPage.launchAuthPage("/start")
      AuthLoginPage.enterCredId("grs-retrieval-bv-fail")
      AuthLoginPage.clickSubmit()

      Then("the user is navigated to the 'BV Lock out' page")
      BVLockOutPage.verifyPageTitle(BVLockOutPage.pageTitle, BVLockOutPage.pageUrl) shouldBe true

    }
  }
}
