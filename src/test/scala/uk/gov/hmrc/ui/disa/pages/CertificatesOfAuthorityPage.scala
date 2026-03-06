/*
 * Copyright 2026 HM Revenue & Customs
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
import uk.gov.hmrc.ui.disa.pages.DeclarationForIsaManagersPage.baseUrl
import uk.gov.hmrc.ui.disa.pages.FcaPlatformNumberPage.clickSaveAndContinue

object CertificatesOfAuthorityPage extends BasePage {
  val pageUrl: String         = s"$baseUrl/certificates-of-authority"
  val pageTitle: String       =
    "Certificates of authority which apply to your organisation - Certificates of authority - disa-registration-frontend - GOV.UK"
  private val yesCheckBox: By = By.id("value_0")
  private val noCheckBox: By  = By.id("value_1")

  def selectYesAndContinue(): Unit = {
    selectCheckbox(yesCheckBox)
    clickSaveAndContinue()
  }

  def selectNoAndContinue(): Unit = {
    selectCheckbox(noCheckBox)
    clickSaveAndContinue()
  }
}
