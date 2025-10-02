import sbt.*

object Dependencies {

  val test: Seq[ModuleID] = Seq(
    "ch.qos.logback"       % "logback-classic" % "1.5.18" % Test,
    //  "uk.gov.hmrc" %% "ui-test-runner" % "0.45.0" % Test,
    "org.scalatest"       %% "scalatest"       % "3.2.19" % Test,
//  "io.cucumber"         %% "cucumber-scala"         % "8.25.1"   % Test,
//  "io.cucumber"          % "cucumber-junit"         % "7.20.1"   % Test,
//  "io.cucumber"          % "cucumber-picocontainer" % "7.20.1"   % Test,
    // "junit"                % "junit"                  % "4.13.2"   % Test,
    // "com.novocode"         % "junit-interface"        % "0.11"     % Test,
    "uk.gov.hmrc"         %% "ui-test-runner"  % "0.49.0" % Test,
    "uk.gov.hmrc"         %% "domain-test-play-30"  % "13.0.0" % Test
    // "org.scalatestplus"   %% "selenium-4-12"          % "3.2.17.0" % Test,
    // "com.typesafe.play"   %% "play-json-joda"         % "2.10.6"   % Test,
    // "com.typesafe"         % "config"                 % "1.4.3"    % Test,
    "com.vladsch.flexmark" % "flexmark-all"    % "0.64.8" % Test
  )

}
