# sonar-java-extracted

Sonar-java java-frontend part extracted, so it does rely only on external API and not internal implementations.
This allows plugin creators to use external tools such as Visitors bridge or custom visitors that are defined in the sonar-java-plugin
api but are not loaded by the SonarQube classloader when loading the plugin during analysis.

Main purpose of this is to use the sonar-java-plugin in `provided` scope as it is supposed to be used, but also use classes that are available during the compile time. 
Extracting those classes in a separate class allows you to have those classes at runtime and avoid class clashes due to different classloaders at runtime.
