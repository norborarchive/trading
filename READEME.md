###RUN
sbt "run-main main.Main"

###TEST
sbt test

###SCALA STYLE
sbt scalastyleGenerateConfig
sbt scalastyle