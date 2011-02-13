

import sbt._

class LiftProject(info: ProjectInfo) extends DefaultWebProject(info) {
  val scalatoolsRelease = "Scala Tools Snapshot" at "http://scala-tools.org/repo-releases/"
  //val neo4j = "Neo4J Maven2 repository" at "http://m2.neo4j.org"
  // for 'netty'
  //val jBossRepository = "JBoss Repository Old" at "http://repository.jboss.org/maven2"
  val jBossRepositoryNexus = "JBoss Repository New" at "http://repository.jboss.org/nexus/content/groups/public"

  val liftVersion = "2.2"

  // for jrebel
  override def scanDirectories = Nil

  override def libraryDependencies = Set(
    "net.liftweb" %% "lift-webkit" % liftVersion % "compile->default",
    "net.liftweb" %% "lift-testkit" % liftVersion % "compile->default",
    "net.liftweb" %% "lift-mapper" % liftVersion % "compile->default",
    "org.neo4j" % "neo4j" % "1.3.M01" % "compile->default",
    "org.mortbay.jetty" % "jetty" % "6.1.22" % "test->default",
    "ch.qos.logback" % "logback-classic" % "0.9.26",
    "junit" % "junit" % "4.5" % "test->default",
    "org.scala-tools.testing" %% "specs" % "1.6.6" % "test->default",
    "net.liftweb" %% "lift-mapper" % liftVersion % "compile->default",
    "com.h2database" % "h2" % "1.2.138",
    "mysql" % "mysql-connector-java" % "5.1.13" % "compile->default"
  ) ++ super.libraryDependencies
}
