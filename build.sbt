lazy val commonSettings = Seq(
  organization := "org.plgrnds",
  version := "1.0",
  scalaVersion := "2.12.3",
  scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")
)

lazy val HttpApi = (project in file("modules/HttpApi"))
  .settings(
    commonSettings,
    Seq(
      libraryDependencies ++= {
        val akkaV = "2.5.3"
        val akkaHttpV = "10.0.9"
        val scalaTestV = "3.0.1"
        Seq(
          "com.typesafe.akka" %% "akka-actor" % akkaV,
          "com.typesafe.akka" %% "akka-stream" % akkaV,
          "com.typesafe.akka" %% "akka-testkit" % akkaV,
          "com.typesafe.akka" %% "akka-http" % akkaHttpV,
          "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpV,
          "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpV,
          "org.scalatest" %% "scalatest" % scalaTestV % "test"
        )
      }
    )
  )

lazy val EventEmitter = (project in file("modules/EventEmitter"))
  .settings(commonSettings)

lazy val root = (project in file("."))
  .settings(commonSettings)
  .aggregate(HttpApi, EventEmitter)
  .dependsOn(HttpApi, EventEmitter)