/*
 * Copyright 2025 HM Revenue & Customs
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

package uk.gov.hmrc.ui.disa.pages

import org.openqa.selenium.By
import uk.gov.hmrc.ui.disa.pages.InnovativeFinancialProductsPage.clickSaveAndContinue

object PeerToPeerLoansPage extends BasePage {
  val pageUrl: String           = s"$baseUrl/peer-to-peer-loans"
  val pageTitle: String         =
    "Which platform does your organisation use to offer peer-to-peer loans? - ISA products - disa-registration-frontend - GOV.UK"
  val platformNameTextField: By = By.id("value")

  def enterPlatformNameAndContinue(): Unit = {
    sendKeys(platformNameTextField, "PlatformName")
    clickSaveAndContinue()
  }
}
