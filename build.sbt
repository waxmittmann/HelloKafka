name := "HelloKafka"

version := "0.1"

scalaVersion := "2.12.4"

val argonautVersion = "6.2"
val catsVersion = "1.0.0-RC1"
val catsEffectVersion = "0.5"
val circeVersion = "0.8.0"
val doobieVersion = "0.4.4"
val http4sVersion = "0.17.5"
val monocleVersionScalaz = "1.4.0"
val monocleVersionCats = "1.5.0-cats-M1"
val scalazVersion = "7.2.16"
val scalacheckVersion = "1.13.4"
val specsVersion = "4.0.0"

resolvers += Resolver.bintrayRepo("cakesolutions", "maven")

libraryDependencies ++= Seq(
  // Cats
  "org.typelevel" %% "cats-core" % catsVersion,
  //"org.typelevel" %% "cats-effect" % catsEffectVersion,
  //"org.typelevel" %% "cats-mtl" % catsVersion,
  "org.typelevel" %% "dogs-core" % "0.6.9",

  // Monocle
  "com.github.julien-truffaut" %%  "monocle-core"  % monocleVersionCats,
  "com.github.julien-truffaut" %%  "monocle-macro" % monocleVersionCats,
  "com.github.julien-truffaut" %%  "monocle-law"   % monocleVersionCats % "test",

  // Circe
  "io.circe" %% "circe-core" % circeVersion,
  "io.circe" %% "circe-generic" % circeVersion,
  "io.circe" %% "circe-parser" % circeVersion,

  // Doobie cats
  "org.tpolecat" %% "doobie-core-cats" % doobieVersion, // cats
  "org.tpolecat" %% "doobie-h2-cats" % doobieVersion, // scalaz
  "org.tpolecat" %% "doobie-hikari-cats" % doobieVersion, // scalaz
  "org.tpolecat" %% "doobie-postgres-cats" % doobieVersion, // scalaz
  "org.tpolecat" %% "doobie-specs2-cats" % doobieVersion, // scalaz

  "net.cakesolutions" %% "scala-kafka-client" % "0.11.0.0",

  // Test
  "org.specs2" %% "specs2-core" % specsVersion % "test",
  "org.scalacheck" %% "scalacheck" % scalacheckVersion % "test"
)

// For macro annotations
addCompilerPlugin("org.scalamacros" %% "paradise" % "2.1.0" cross CrossVersion.full)