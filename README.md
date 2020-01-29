# sonar-java-extracted

Sonar-java java-frontend part extracted, so it does rely only on external API and not internal implementations.
This allows plugin creators to use external tools such as Visitors bridge or custom visitors that are defined in the sonar-java-plugin
api but are not loaded by the SonarQube classloader when loading the plugin during analysis.
