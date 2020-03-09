
name := "microService"

version := "0.0.1"

val CatsVersion = "2.0.0"
val ZioVersion = "1.0.0-RC17"
val ZioCatsVersion = "2.0.0.0-RC9"

val Http4sVersion = "0.21.0-M5"
val LogbackVersion = "1.2.3"
val CirceVersion = "0.12.3"
val strykerVersion = "0.6.1"
val scalatestVersion = "3.0.8"
val sttpClientVersion = "2.0.0-RC3"
val sttpVersion = "1.7.2"
val sttpTapirVersion = "0.12.4"

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs@_*) => MergeStrategy.discard
  case x => MergeStrategy.first
}
test in assembly := {}

lazy val root = (project in file("."))
  .settings(
    organization := "jemstep",
    name := "jemstep",
    version := "0.0.1",
    scalaVersion := "2.13.0",
    libraryDependencies ++= Seq(
      "org.typelevel" %% "cats-effect" % CatsVersion,
      "dev.zio" %% "zio" % ZioVersion,
      "dev.zio" %% "zio-interop-cats" % ZioCatsVersion,
      "org.http4s" %% "http4s-blaze-server" % Http4sVersion,
      "org.http4s" %% "http4s-circe" % Http4sVersion,
      "org.http4s" %% "http4s-dsl" % Http4sVersion,
      "io.circe" %% "circe-core" % CirceVersion,
      "io.circe" %% "circe-literal" % CirceVersion,
      "com.softwaremill.sttp.client" %% "core" % sttpClientVersion,
      "dev.zio" %% "zio-test" % ZioVersion,
      "dev.zio" %% "zio-test-sbt" % ZioVersion,
      "org.http4s" %% "http4s-dsl" % Http4sVersion,
      "org.http4s" %% "http4s-client" % Http4sVersion,
      "org.http4s" %% "http4s-blaze-server" % Http4sVersion,
      "org.http4s" %% "http4s-blaze-client" % Http4sVersion,
      "ch.qos.logback" % "logback-classic" % LogbackVersion,
      "io.circe" %% "circe-generic" % CirceVersion,
      "com.softwaremill.sttp" %% "core" % sttpVersion,
    ),
    testFrameworks ++= Seq(new TestFramework("zio.test.sbt.ZTestFramework")),
    scalacOptions ++= Seq(
      "-deprecation", // Emit warning and location for usages of deprecated APIs.
      "-encoding", "UTF-8", // Specify character encoding used by source files.
      "-language:higherKinds", // Allow higher-kinded types
      "-language:postfixOps", // Allows operator syntax in postfix position (deprecated since Scala 2.10)
      "-feature", // Emit warning and location for usages of features that should be imported explicitly.
      "-Xfatal-warnings" // Fail the compilation if there are any warnings
    )
  )
