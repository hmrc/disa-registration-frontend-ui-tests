resolvers += Resolver.bintrayRepo("hmrc", "releases")

addSbtPlugin("uk.gov.hmrc" % "sbt-auto-build" % "3.24.0")
addSbtPlugin("uk.gov.hmrc" % "sbt-test-report" % "1.10.0")
ThisBuild / scalaVersion := "2.12.20"