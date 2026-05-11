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

import uk.gov.hmrc.ui.disa.pages.SignOutPage.baseUrl

object ChangeAddedThirdPartiesPage extends BasePage {
  val pageUrl: String      = s"$baseUrl/change-added-third-parties"
  val pageTitle: String    = "You have added a third-party organisation - Third-party organisations - Manage ISAs - GOV.UK"
  val pageTitleTwo: String =
    "You have added 2 third-party organisations - Third-party organisations - Manage ISAs - GOV.UK"

}
