#BlankFactor - Automation API REST


# Pre-requisites📋
1.   Java v1.8 update 151 or higher and JDK (Configured environment variables)
2.   IntelliJ IDEA (2021) or Eclipse IDE (Oxygen or Neon)
3.   Gradle v7.6 or higher
4.   Cucumber

# Installation 🔧
- Import the project from Eclipse or Intellij IDE under the structure of an existing Gradle project.
- Configure JRE System Library with JavaSE-1.8
- Set the encoding to UTF-8 to the project once it is imported.


# Compile the project and generate the Wrapper file 🔨
- To compile the project, you have to execute the command: gradle clean build -x test
- To generate the project wrapper files, execute the command: gradle wrapper --gradle-distribution-url=https://services.gradle.org/distributions/gradle-6.7-all.zip


# Run the tests ⚙️


## Execution commands 💻
- Run all features: `gradle clean test aggregate --info`
- Run a specific feature: `gradle clean test clean test --tests "runners.RunnerName" aggregate --info`


# General implementation details 💻

### 🚧 The complete structure of the project is as follows:

**src/main/java**
+ exceptions

  Classes that catch custom exceptions when the automation fails.

+ models

  Classes with which data models are built, using a builder when necessary.

+ questions

  Classes with which the validations of the tests are carried out, it is done in the form of a question to know the result or state in which it is found after having executed the tasks.

+ tasks

  Classes that perform high-level actions (business process), are composed of calls to interactions or other tasks.

+ utils

  Classes that contain commons functionalities.


**src/test/java**
+ runners:

  Classes to execute the automation with the scenarios indicated in the feature.

+ stepdefinitions:

  Classes where the Gherkin language is coupled with which the scenarios and the java code to be executed for the automation are written.

**src/test/resources**
+ data:

  Test data used by the automation.

+ serenity.conf:

  property files correspond to a class of text files, which allow the preloading of information to an application.
  for this case it is used to store the Rest API

+ features:

  The features of the project are found, which is where the scenarios or stories carried out by the user at the business level are written.

# Built with 🛠️
The automation was developed with:
- BDD - Development strategy
- Screenplay (Design pattern focused on development of automated tests)
- Gradle
- Serenity API Rest
- Cucumber
- Serenity BDD - Open source library for generating reports
- Gherkin - Business Readable DSL Language (Domain Specific Language readable by the business)

