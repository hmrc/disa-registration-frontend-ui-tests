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

package uk.gov.hmrc.ui.disa.cucumber.stepdefs

import io.cucumber.datatable.DataTable
import io.cucumber.scala.{EN, ScalaDsl}
import org.junit.Assert
import org.openqa.selenium.{By, WebElement}
import org.scalatest.concurrent.Eventually
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.selenium.WebBrowser
import uk.gov.hmrc.ui.disa.conf.TestConfiguration
import uk.gov.hmrc.ui.disa.driver.BrowserDriver
import uk.gov.hmrc.ui.disa.pages.BasePage
import uk.gov.hmrc.ui.disa.pages.generic.PageObjectFinder
import uk.gov.hmrc.ui.disa.pages.generic.PageObjectFinder.DataTableConverters

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import scala.jdk.CollectionConverters.*

trait BaseStepDef
    extends ScalaDsl
    with EN
    with BrowserDriver
    with Eventually
    with Matchers
    with WebBrowser
    with BasePage {

  // The Check Your Returns page has the previous 4 months under Outstanding returns
  // and the 3 months before that under Completed returns
  // So the month with quarterly spirits under Completed returns is as follows:
  // Current Month = Feb/Mar/Apr -> the previous September
  // Current Month = May/Jun/Jul -> the previous December
  // Current Month = Aug/Sep/Oct -> the previous March
  // Current Month = Nov/Dec/Jan -> the previous June
  // Which means the year of the spirits return we want to access is
  // that of 7 months in the past
  val currentYear: Int  = LocalDate.now().minusMonths(7).getYear
  val shortYear: String = currentYear.toString.substring(2)

  Then("""I navigate to the {string}""") { page: String =>
    go to PageObjectFinder.page(page)
  }

  When("""I click submit button on {string}""") { (page: String) =>
    PageObjectFinder.page(page).waitForPageHeader
    PageObjectFinder.page(page).clickSubmitButton()
  }

  Then("""I am presented with the {string}""") { (page: String) =>
    //waitForPageHeaderRemoved in necessary places
    PageObjectFinder.page(page).checkURL
    PageObjectFinder.page(page).checkPageHeader()
    PageObjectFinder.page(page).checkPageTitle()
  }

  Then("""I am presented with the External {string}""") { (page: String) =>
    PageObjectFinder.page(page).waitForPageHeader
    PageObjectFinder.page(page).checkPageHeader()
    PageObjectFinder.page(page).checkPageTitle()
  }

  Then("""I am presented with the dynamic header page {string} {string}""") { (page: String, text: String) =>
    PageObjectFinder.page(page).checkURL
    PageObjectFinder.page(page).checkPageHeader()
    PageObjectFinder.page(page).checkPageTitle()
    checkDynamicPageHeader(text)
  }

  Then("""I am presented with the {string} with new url""") { page: String =>
    PageObjectFinder.page(page).checkNewURL
    PageObjectFinder.page(page).checkPageHeader()
    PageObjectFinder.page(page).checkPageTitle()
  }

  Then("""I am presented with the {string} with new url containing prefix as {string} and suffix as {string}""") {
    (page: String, urlPrefix: String, urlSuffix: String) =>
      PageObjectFinder.page(page).checkNewURLWithTwoDynamicValues(urlPrefix, urlSuffix)
      PageObjectFinder.page(page).checkPageHeader()
      PageObjectFinder.page(page).checkPageTitle()
  }

  Then("""I am presented with the {string} with url suffix as {string}""") { (page: String, urlSuffix: String) =>
    PageObjectFinder.page(page).checkNewDynamicURL(urlSuffix)
    PageObjectFinder.page(page).checkPageHeader()
    PageObjectFinder.page(page).checkPageTitle()
  }
  Then("""I am presented with the {string} with existing url suffix as {string}""") {
    (page: String, urlSuffix: String) =>
      PageObjectFinder.page(page).checkExistingDynamicURL(urlSuffix)
      PageObjectFinder.page(page).checkPageHeader()
      PageObjectFinder.page(page).checkPageTitle()
  }

  When("""I select radio button {string} on {string}""") { (choice: String, page: String) =>
    PageObjectFinder.page(page).waitForPageHeader
    PageObjectFinder.page(page).clickRadioButton(choice)
  }
  

  When("""I {string} checkbox {string} on {string}""") { (checkBoxAction: String, choice: String, page: String) =>
    checkBoxAction match {
      case "select" | "unselect" =>
        PageObjectFinder.page(page).waitForPageHeader
        PageObjectFinder.page(page).selectCheckBoxes(choice.split(","))
    }
  }

  When("""I click save and continue button on {string}""") { (page: String) =>
    PageObjectFinder.page(page).waitForPageHeader
    PageObjectFinder.page(page).clickSaveAndContinueButton()
  }
  
  When("""I click confirm and continue button on {string}""") { (page: String) =>
    PageObjectFinder.page(page).waitForPageHeader
    PageObjectFinder.page(page).clickConfirmAndContinueButton()
  }

  When("""I click continue button on {string}""") { (page: String) =>
    PageObjectFinder.page(page).waitForPageHeader
    PageObjectFinder.page(page).clickContinueButton()
  }

  When("""I click back button on {string}""") { (page: String) =>
    PageObjectFinder.page(page).waitForPageHeader
    PageObjectFinder.page(page).clickBackButton()
  }

  When("""I click confirm button on {string}""") { (page: String) =>
    PageObjectFinder.page(page).waitForPageHeader
    PageObjectFinder.page(page).clickBackButton()
  }

  Then("""I am presented with the {string} error page""") { page: String =>
    PageObjectFinder.page(page).checkURL
    PageObjectFinder.page(page).checkPageErrorTitle()
  }

  Then("""The error summary title is {string} and the error message is {string}""") {
    (errorSummaryTitle: String, errorMessage: String) =>
      PageObjectFinder.checkPageErrorSummaryTitle(errorSummaryTitle)
      val finalErrorMessage = errorMessage.replace("^", "’")
      PageObjectFinder.checkPageErrorMessage(finalErrorMessage)
  }

  When("""I enter {string} on {string}""") { (data: String, page: String) =>
    PageObjectFinder.page(page).waitForPageHeader
    PageObjectFinder.page(page).enterDetails(data)
  }

  When("""I enter {string} for {string} on {string}""") { (textToEnter: String, text: String, page: String) =>
    PageObjectFinder.page(page).waitForPageHeader
    PageObjectFinder.page(page).enterMultipleDetails(textToEnter, text)
  }

  When("""I enter {string} for {string} on {string} at {string} input box""") {
    (textToEnter: String, text: String, page: String, index: String) =>
      PageObjectFinder.page(page).waitForPageHeader
      PageObjectFinder.page(page).enterMultipleDetailsWithIndex(textToEnter, text, index)
  }

  When("""I enter month {string} and year {string} on {string}""") { (month: String, year: String, page: String) =>
    PageObjectFinder.page(page).waitForPageHeader
    PageObjectFinder.page(page).enterDate(month, year)
  }

  When("""I enter redirect url for {string}""") { (page: String) =>
    page match {
      case "Task List Page" =>
        driver.get(TestConfiguration.url("alcohol-duty-returns-frontend") + "/complete-return/task-list")
      case "Return Summary Page" =>
        driver.get(TestConfiguration.url("alcohol-duty-returns-frontend") + "/complete-return/check-return")
      case "Alcohol Duty Service" =>
        driver.get(
          TestConfiguration.url("alcohol-duty-returns-frontend") + "/before-you-start-your-return/" + periodKey
        )
      case "Previous Month Period Key" =>
        val url =
          s"http://localhost:9949/auth-login-stub/gg-sign-in?continue=http%3A%2F%2Flocalhost%3A16000%2Fmanage-alcohol-duty%2Fbefore-you-start-your-return%2F$previousPeriodKey"
        driver.get(url)

      //        driver.get(
//          TestConfiguration.url(
//            "alcohol-duty-returns-frontend"
//          ) + "/before-you-start-your-return/" + previousPeriodKey

      case "Previous Spirits Period Key" =>
        val url =
          s"http://localhost:9949/auth-login-stub/gg-sign-in?continue=http%3A%2F%2Flocalhost%3A16000%2Fmanage-alcohol-duty%2Fbefore-you-start-your-return%2F$periodKey"
        driver.get(url)
    }
  }

  And("""^I should see the following details""") { data: DataTable =>
    val expectedData = data.asMaps().asScala.toList.flatMap(_.asScala.toMap).toMap
    val actualData   = PageObjectFinder.pageData
    actualData should be(expectedData)
  }

  And("""I should verify the outstanding returns details on {string}""") { (page: String) =>
    PageObjectFinder.page(page).waitForPageHeader
    val expected = PageObjectFinder.expectedOutstandingReturns
    val actual   = outstandingReturnsList
    actual should be(expected)
  }

  And("""I should verify the completed returns details on {string}""") { (page: String) =>
    PageObjectFinder.page(page).waitForPageHeader
    val expected = PageObjectFinder.expectedCompletedReturns
    val actual   = completedReturnsList
    actual should be(expected)
  }

  And("""I verify the content {string} on {string}""") { (expectedText: String, page: String) =>
    PageObjectFinder.page(page).waitForPageHeader
    val actualText = driver.findElement(By.className("govuk-heading-l")).getText
    actualText should be(expectedText)
  }

  And("""I verify {string} on {string}""") { (expectedText: String, page: String) =>
    PageObjectFinder.page(page).waitForPageHeader
    val actualText = driver.findElement(By.xpath("//h2[normalize-space()='Your total net volume of beer is 999.99 litres']")).getText
    actualText should be(expectedText)
  }

  And("""I verify {string} of pure alcohol on {string}""") { (expectedText: String, page: String) =>
    PageObjectFinder.page(page).waitForPageHeader
    val actualText = driver.findElement(By.xpath("//h2[contains(text(),'Your total net volume of pure alcohol is 88.1234 l')]")).getText
    actualText should be(expectedText)
  }

  And("""I should verify the details of the table {int} on {string}""") { (num: Int, page: String, data: DataTable) =>
    PageObjectFinder.page(page).waitForPageHeader
    val expected                                   = data.asScalaListOfLists
    def getResultList(num: Int): Seq[List[String]] =
      driver
        .findElement(By.xpath("//div/table[" + num + "]"))
        .findElements(By.tagName("tr"))
        .asScala
        .map(
          _.findElements(By.xpath("td | th")).asScala
            .map(_.getText.trim)
            .toList
        )
        .toList

    val actual = getResultList(num)
    actual should be(expected)
  }

  And("""I should see the below details at {string} section on {string} with {string}""") {
    (paymentType: String, page: String, dateFormat: String, data: DataTable) =>
      PageObjectFinder.page(page).waitForPageHeader
      val expectedResults = data.rows(0).asLists().asScala.map(_.asScala.toList).toList
      val updatedTable    = replacePlaceholdersInScenario(expectedResults, dateFormat)
      val actual          = paymentDetails(paymentType)
      actual.toSet should be(updatedTable.toSet)
  }

  And("""I should see the following details at {string} section on {string} with {string}""") {
    (paymentType: String, page: String, dateFormat: String, data: DataTable)=>
      PageObjectFinder.page(page).waitForPageHeader

      // Convert DataTable to Scala list of lists and remove the header row
      val tableWithoutHeader = data.asLists(classOf[String])
        .asScala
        .map(_.asScala.toList)
        .toList
        .drop(1) // <--- drop header row

      // Get current month/year dynamically
      val now = LocalDate.now()
      val currentMonthYear = now.format(DateTimeFormatter.ofPattern("MMMM yyyy"))

//      // Replace only the first row's first column with dynamic month/year
//      val updatedTable = tableWithoutHeader.zipWithIndex.map {
//        case (row, 0) => row.updated(0, currentMonthYear)
//        case (row, _) => row
//      }

      // Replace placeholder "currentMonth" with actual month/year
      val updatedTable = tableWithoutHeader.map { row =>
        row.map { cell =>
          if (cell.trim.equalsIgnoreCase("currentMonth")) currentMonthYear else cell
        }
      }

      // Replace any other placeholders if needed
      val finalTable = replacePlaceholdersInScenario(updatedTable, dateFormat)

      // Get actual data from UI
      val actual = currentMonthPaymentDetails(paymentType)

      // Compare as lists (if only 1 row expected) or sets (if multiple rows, order ignored)
      actual should be(finalTable)
  }


  And("""I should see the following details on {string}""") {(page: String, data: DataTable)=>
    PageObjectFinder.page(page).waitForPageHeader

    // Collect only data rows (skip header rows with <th>)
    val actualDataRows: List[List[String]] =
      driver
        .findElement(By.xpath("//div//tbody"))
        .findElements(By.tagName("tr")).asScala
        .flatMap { row =>
          val tdCells = row.findElements(By.tagName("td")).asScala
          if (tdCells.isEmpty) None // skip header row
          else {
            val cleaned = tdCells.map(_.getText
              .trim
              .replaceAll("""\(ref:.*""", "") // remove "(ref: ...)"
              .replaceAll("\n", "")           // remove newlines
              .replace("\u00A0", " ")         // replace non-breaking space
            ).toList
            Some(cleaned)
          }
        }
        .toList

    // Convert feature file DataTable into Scala List[List[String]] and drop header
    val expectedDataRows: List[List[String]] =
      data.asLists(classOf[String]).asScala.map(_.asScala.toList).toList.drop(1)

    // Compare only data rows
    actualDataRows should be(expectedDataRows)
  }

  And("""^I should see the following product details""") { data: DataTable =>
    val expected = data.asScalaListOfLists
    val actual   = productsList
    actual should be(expected)
  }

  And("""I click on View Return link for one of the completed returns on {string}""") { (page: String) =>
    PageObjectFinder.page(page).waitForPageHeader
    driver.findElement(By.xpath("//div/table[2]/tbody/tr[1]/td[3]/ul/li/a")).click()
  }
  When("""I redirect to a URL with Spirits section on {string}""") { (page: String) =>
    PageObjectFinder.page(page).waitForPageHeader
    val expectedPeriod = driver.findElement(By.xpath("(//tbody[@class='govuk-table__body'])[2]")).getText
    val periodToUrl    = Map(
      s"December $currentYear" -> s"${shortYear}AL",
      s"March $currentYear"   -> s"${shortYear}AC",
      s"June $currentYear"    -> s"${shortYear}AF",
      s"September $currentYear" -> s"${shortYear}AI"
    )

    periodToUrl.find { case (period, _) => expectedPeriod.contains(period) } match {
      case Some((_, suffix)) =>
        driver.get(TestConfiguration.url("alcohol-duty-returns-frontend") + s"/view-your-return/$suffix")
      case None              =>
        logger.warn("No month returned to fit within the quarterly spirits requirement. Please check")
        Assert.fail()
    }

  }

  Then("""The page header is {string}""") { (pageHeader: String) =>
    val actualPageHeader = driver.findElement(By.tagName("h1")).getText
    val currentURL       = driver.getCurrentUrl

    val urlToPeriod = Map(
      s"${shortYear}AL" -> s"December $currentYear",
      s"${shortYear}AC" -> s"March $currentYear",
      s"${shortYear}AF" -> s"June $currentYear",
      s"${shortYear}AI" -> s"September $currentYear"
    )

    urlToPeriod.find { case (suffix, _) =>
      currentURL.contains(suffix)
    } match {
      case Some((_, period)) =>
        val finalPageHeader = pageHeader.replace("SpiritsPeriod", period)
        actualPageHeader should be(finalPageHeader)
      case None              =>
        logger.warn("No month to return")
        Assert.fail()
    }
  }

  When("""I click {string} on {string}""") { (button: String, page: String) =>
    PageObjectFinder.page(page).clickButton(button)
  }

  When("""I verify the ABV value displayed as {string} on {string}""") { (expectedText: String, page: String) =>
    PageObjectFinder.page(page).waitForPageHeader
    val actualText = driver.findElement(By.cssSelector("ul[class='govuk-list govuk-list--bullet'] li")).getText
    actualText should be(expectedText)
  }

  Then("""I verify the due amount displayed as {string} on {string}""") { (expectedText: String, page: String) =>
    PageObjectFinder.page(page).waitForPageHeader
    val actualText = driver.findElement(By.xpath("//main/div/div/p[1]")).getText.trim.replaceAll("\n", " ")
    actualText should be(expectedText)
  }

  Then("""I verify the return due date for {string} on {string}""") { (content: String, page: String) =>
    PageObjectFinder.page(page).waitForPageHeader
    val actualText = driver.findElement(By.xpath("//div/div/form/p[1]")).getText

    content match {
      // This is the most recent month with quarterly spirits
      case "Latest Month Selected" =>
        actualText should be(
          "Use this service to submit your Alcohol Duty return for " + getDateRange + "."
        )

      case "Previous Month Selected"         =>
        actualText should be(
          "Use this service to submit your Alcohol Duty return for " + firstDayOfPreviousMonth + " to " + lastDayOfPreviousMonth + "."
        )
    }
  }

  And("""I should verify the table header displayed""") { (data: DataTable) =>
    val expectedText = data.asScalaListOfStrings
    tableHeaderText should be(expectedText)
  }

  Then("""I can see below tax type codes on the {string}""") { (page: String, data: DataTable) =>
    PageObjectFinder.page(page).waitForPageHeader
    val expectedText = data.asScalaListOfStrings
    allTaxTypeCodeText() should be(expectedText)
  }

  Then("""I can see below text on the {string}""") { (page: String, data: DataTable) =>
    PageObjectFinder.page(page).waitForPageHeader
    val expectedText = data.asScalaListOfStrings
    getBulletPointsTextPureAlcohol should be(expectedText)
  }

  Then("""I can see below text on the {string} for pure alcohol""") { (data: DataTable) =>
    val expectedText = data.asScalaListOfStrings
    getBulletPointsTextPureAlcohol should be(expectedText)
  }

  Then("""I can see below text for {string}""") { (entryType: String, data: DataTable) =>
    val expectedText = data.asScalaListOfStrings
    entryType match {
      case "pure alcohol" => getBulletPointsTextPureAlcohol should be(expectedText)
      case "duty due"     => getBulletPointsTextDutyDue     should be(expectedText)
    }
  }

  Then("""I am presented with the {string} {string}""") { (page: String, specificPage: String) =>
    PageObjectFinder.page(page).checkURL
    PageObjectFinder.page(page).checkPageTitle(specificPage)
  }

  When("""I click on {string} hyperlink on {string}""") { (hyperlink: String, page: String) =>
    PageObjectFinder.page(page).waitForPageHeader
    driver.findElement(By.xpath("//a[normalize-space()='" + hyperlink + "']")).click()
  }

  And("""^I should see the following status of the submission journey""") { data: DataTable =>
    val expectedData = data.asMaps().asScala.toList.flatMap(_.asScala.toMap).toMap
    val actualData   = PageObjectFinder.taskListPageContentView
    actualData should be(expectedData)
  }

  And("""I should see the following subsections""") { data: DataTable =>
    val expected = data.asScalaListOfStrings
    subSectionsHeaderText should be(expected)
  }

  Given("""I cleared the data for the service""") {
    driver.get(TestConfiguration.url("alcohol-duty-returns-frontend") + "/test-only/clear-all")
  }

  And("""I clear the data to view Past Payments""") {
    driver.get(TestConfiguration.url("alcohol-duty-returns-frontend") + "/test-only/clear-user-historic-payments")
  }

  Given("""I go to the Before You Start auth page""") {
    driver.get(TestConfiguration.url("alcohol-duty-returns-frontend") + "/test-only/clear-all")
  }

  And("""I should see following details at the {string}""") { (page: String, data: DataTable) =>
    val expectedData = data.asMaps().asScala.toList.flatMap(_.asScala.toMap).toMap
    PageObjectFinder.page(page).waitForPageHeader
    val actualData   = PageObjectFinder.dataAtCheckYourAnswersPage
    actualData should be(expectedData)
  }

  And("""I should see the {string} and below error messages""") { (errorSummaryTitle: String, data: DataTable) =>
    val expectedErrorMessages = data.asScalaListOfStrings
    PageObjectFinder.checkPageErrorSummaryTitle(errorSummaryTitle)
    PageObjectFinder.checkListOfErrorMessages(expectedErrorMessages)
//    PageObjectFinder.listOfErrorMessages() should be(expectedErrorMessages)
  }
  And("""I check the page source for the following key-value pairs:""") { (data: DataTable) =>
    val pageSource: String = driver.getPageSource.trim
    val keyValuePairs      = data.asMaps(classOf[String], classOf[String]).asScala

    // Function to count occurrences of a substring in a string
    def countOccurrences(source: String, target: String): Int =
      source.sliding(target.length).count(window => window == target)
    // Verify each key-value pair
    keyValuePairs.foreach { pair =>
      val key   = pair.get("key")
      val value = pair.get("value")
      if (key != null && value != null) {
        val keyCount   = countOccurrences(pageSource, key)
        if (keyCount == 0) {
          fail(s"The key '$key' does not exist, please check")
        }
        val valueCount = countOccurrences(pageSource, value)
        if (valueCount == 0) {
          fail(s"The value '$value' does not exist, please check")
        }
      }
    }
  }

  And("""I should see the following text on the page""") { data: DataTable =>
    val expected = data.asScalaListOfStrings
    alcoholToDeclareSectionText should be(expected)
  }

  And("""I should see the following text on CYA page""") { data: DataTable =>
    val expected = data.asScalaListOfStrings
    alcoholDeclaredSectionTextCYA should be(expected)
  }

  And("""I click on change link {int} on {string} for alcohol type {string}""") {
    (changeLinkIndex: Int, page: String, alcoholType: String) =>
      PageObjectFinder.page(page).waitForPageHeader
      driver
        .findElement(
          By.xpath(
            "(//a[@href='/manage-alcohol-duty/complete-return/alcoholic-products/" + alcoholType + "/declare/check-your-answers'])[" + changeLinkIndex + "]"
          )
        )
        .click()
  }

  And("""I verify {int} change links present on {string}""") { (expectedCount: Int, page: String) =>
    PageObjectFinder.page(page).waitForPageHeader
    val changeHrefs: List[WebElement] = driver.findElements(By.xpath("//a[text()='Change']")).asScala.toList
    changeHrefs.size shouldBe expectedCount
  }

  And("""I should see the following details of the table {int} at the returns summary page""") {
    (num: Int, data: DataTable) =>
      val expected = data.asScalaListOfLists

      def declaredProductListAtReturnsSummary(num: Int): Seq[List[String]] = driver
        .findElements(By.xpath("//table[" + num + "]/tbody/tr[@class='govuk-table__row']"))
        .asScala
        .map { declaredProductDetails =>
          declaredProductDetails
            .findElements(By.tagName("td"))
            .asScala
            .map(getVisibleTextFromElement)
            .toList
        }
        .map(_.map {
          case text if text.startsWith("Change") => "Change" // Replace text with "Change" if it starts with "Change"
          case other                             => other // Keep all other values as they are
        })
        .toList

      val actual = declaredProductListAtReturnsSummary(num)
      actual should be(expected)
  }

  And("""the status of the Send return is marked as {string}""") { (sendReturnStatus: String) =>
    val expected = driver.findElement(By.xpath("//div[@id='checkAndSubmit-1-status']")).getText ////strong[@class='govuk-tag govuk-tag--grey
    sendReturnStatus should be(expected)
  }

  When("""I click on Agree and send return button {string}""") { (page: String) =>
    PageObjectFinder.page(page).waitForPageHeader
    PageObjectFinder.page(page).clickAgreeAndSendReturnButton()
  }

  When("""the page source contains {string}""") { (paymentAmountText: String) =>
    val actualText = driver.findElement(By.xpath("//p[normalize-space()='" + paymentAmountText + "']")).getText
    actualText should be(paymentAmountText)
  }

  When("""the view returns page contains duty {string}""") { (paymentAmountText: String) =>
    val actualText = driver.findElement(By.xpath("//dd[normalize-space()='" + paymentAmountText + "']")).getText
    actualText should be(paymentAmountText)
  }

  When("""the view returns page contains summary list text {string} {string} {string}""") {
    (alcoholType: String, status: String, link: String) =>
      val actualText = driver.findElement(By.xpath("(//dl[@class='govuk-summary-list'])[2]")).getText
      actualText should be(alcoholType)
  }

  And("""I should see the following alcohol types""") { data: DataTable =>
    val expected = data.asScalaListOfStrings
    alcoholTypes should be(expected)
  }
}
