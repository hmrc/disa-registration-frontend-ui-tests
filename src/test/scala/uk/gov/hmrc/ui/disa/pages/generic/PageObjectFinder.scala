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

package uk.gov.hmrc.ui.disa.pages.generic

import io.cucumber.datatable.DataTable
import org.apache.commons.io.FileUtils
import org.scalatest.exceptions.TestFailedException
import uk.gov.hmrc.ui.disa.pages.BasePage

import java.io.{File, FileNotFoundException}
import java.time.LocalDate
import scala.jdk.CollectionConverters.CollectionHasAsScala

object PageObjectFinder extends BasePage {

  override val title: String = ""
  override val url: String = ""

  private val files = {
    val directories = Seq(
      file("src/test/scala/uk/gov/hmrc/alcoholDuty/pages/")
    )

    val fileList: File => List[File] = f => FileUtils
      .listFiles(f, Array("scala"), true)
      .asScala.toList

    directories.flatMap(fileList)
  }

  def page(pageIn: String): BasePage = {
    val page = pageIn.replaceAll(" ", "")
    files.find(_.getName == s"$page.scala")
      .map(_.getAbsolutePath.replaceAll(".*/(uk/.*).scala", "$1").replaceAll("/", "."))
      .map(str => Class.forName(str + "$").getField("MODULE$").get(classOf[BasePage]).asInstanceOf[BasePage])
      .getOrElse(throw new TestFailedException(s"$page does not exist in tests, or it does not conform to Web page format", new FileNotFoundException(), 12))
  }

  def file(path: String): File = {
    new File(path)
  }

  implicit class DataTableConverters(dataTable: DataTable) {
    def asScalaListOfStrings: List[String] = {
      dataTable.cells()
        .asScala
        .flatMap(_.asScala)
        .map(cell => cell.replace("[currentYear]", LocalDate.now().getYear.toString)) //replacing place holder text with current year
        .toList
    }

    def asScalaListOfLists: List[List[String]] = dataTable.rows(0).asLists().asScala.map(_.asScala.toList).toList

    def updatedTable(formatType: String): Seq[List[String]] =
      replacePlaceholdersInScenario(asScalaListOfLists, formatType)

    def replaceTextInScalaListOfLists(dataTable: List[List[String]], formatType: String): List[List[String]] = {
      // Retrieve the month details for replacements
      val monthDetails = getMonthDetails(formatType)

      // Replace placeholders like plus9Months in the data table with corresponding values
      dataTable.map { row =>
        row.map { cell =>
          monthDetails.foldLeft(cell) { (updatedCell, replacement) =>
            val (key, value) = replacement
            if (updatedCell.contains(key)) updatedCell.replace(key, value) else updatedCell
          }
        }
      }
    }
  }
}