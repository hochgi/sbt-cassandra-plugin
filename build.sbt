sbtPlugin := true

organization := "com.github.hochgi"

name := "sbt-cassandra-plugin"

description := "SBT plugin to allow launching Cassandra during tests, and test your application against it"

version := "0.9.0"

scalaVersion := "2.12.4"

libraryDependencies ++= Seq("org.apache.thrift" % "libthrift" % "0.9.2" exclude("commons-logging","commons-logging"),
                            "org.slf4j" % "slf4j-api" % "1.7.12",
                            "org.slf4j" % "jcl-over-slf4j" % "1.7.12",
                            "org.yaml" % "snakeyaml" % "1.15",
                            "net.leibman" %% "semverfi" % "0.2.0")

scalacOptions ++= Seq("-deprecation", "-feature", "-unchecked", "-language:postfixOps")

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value) Some("snapshots" at nexus + "content/repositories/snapshots")
  else                  Some("releases" at nexus + "service/local/staging/deploy/maven2")
}

publishMavenStyle := true

publishArtifact in Test := false

publishArtifact in (Compile, packageSrc) :=  true

pomIncludeRepository := { x => false }

homepage := Some(url("http://github.com/hochgi/sbt-cassandra-plugin"))

licenses := Seq("The MIT License (MIT)" -> url("http://opensource.org/licenses/MIT"))

pomExtra := (
  <scm>
    <url>https://github.com/hochgi/sbt-cassandra.git</url>
    <connection>scm:git@github.com:hochgi/sbt-cassandra.git</connection>
  </scm>
  <developers>
    <developer>
      <id>hochgi</id>
      <name>Gilad Hoch</name>
      <url>http://blog.hochgi.com</url>
    </developer>
  </developers>
)
