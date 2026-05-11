/*
 * Copyright 2024 HM Revenue & Customs
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

object ConnectedThirdPartiesPage extends BasePage {
  val pageUrl: String                         = s"$baseUrl/connected-third-parties"
  val pageTitle: String                       = "Connected organisations - Third-party organisations - Manage ISAs - GOV.UK"
  private val firstThirdPartyOrgCheckBox: By  =
    By.xpath("/html/body/div/main/div/div/form/div/fieldset/div[2]/div[1]/input")
  private val secondThirdPartyOrgCheckBox: By =
    By.xpath("/html/body/div/main/div/div/form/div/fieldset/div[2]/div[2]/input")
  private val thirdThirdPartyOrgCheckBox: By  =
    By.xpath("/html/body/div/main/div/div/form/div/fieldset/div[2]/div[3]/input")

  def selectConnectedOrg(): Unit = {
    selectCheckbox(firstThirdPartyOrgCheckBox)
    selectCheckbox(secondThirdPartyOrgCheckBox)
  }

  def selectThirdOrg(): Unit =
    selectCheckbox(thirdThirdPartyOrgCheckBox)
}
