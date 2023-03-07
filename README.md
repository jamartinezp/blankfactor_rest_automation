#BlankFactor - Automation API REST


# Pre-requisitos📋
1.   Java v1.8 update 151 o superior y JDK (variables de entorno configuradas)
2.   IntelliJ IDEA (2021) o Eclipse IDE (Oxigen o Neon)
3.   Gradle v7.6 o superior
4.   Cucumber

# Instalación 🔧
- Importar el proyecto desde Eclipse o Intellij IDE bajo la estructura de un proyecto Gradle existente.
- Configurar JRE System Library con JavaSE-1.8
- Configurar la codificación a UTF-8 al proyecto una vez sea importado.


# Compilar el proyecto y generar Wrapper 🔨
- Para compilar el proyecto se debe ejecutar el comando: gradle clean build -x test
- Para generar los archivos wrapper del proyecto se debe ejecutar el comando: gradle wrapper --gradle-distribution-url=https://services.gradle.org/distributions/gradle-7.6-all.zip


# Para Ejecutar Las Pruebas ⚙️


## Comandos de ejecucion 💻
- ejecutar todos los features: `gradle clean test aggregate --info`
- ejecutar feature especifico: `gradle clean test clean test --tests "runners.nombreDelRunner" aggregate --info`


#Detalles Generales De La Implementación 💻

###🚧 La estructura completa del proyecto es la siguiente:

**src/main/java**
+ exceptions

  Clases que capturan excepciones personalizadas cuando falla la automatización.

+ models

  Clases con las que se construyen los modelos de datos, usando un builder cuando es necesario.

+ questions

  Clases con las que se realizan las validaciones de las pruebas, se hace en forma de pregunta para conocer el resultado o estado en que se encuentra luego de haber ejecutado las tareas.

+ tasks

  Clases que realizan las acciones de alto nivel (proceso de negocio), se componen de llamados a interacciones u otras tareas.

+ util

  Clases que contienen funcionalidades comunes.


**src/test/java**
+ runners:

  Clases para ejecutar la automatización con los escenarios indicados en el feature.

+ stepdefinitions:

  Clases donde se acopla el lenguaje Gherkin con que se escriben los escenarios y el código java que va a ser ejecutado para la automatización.


**src/test/resources**
+ data:

  Datos de prueba utilizados por la automatización.

+ serenity.conf:

  archivos de propiedades corresponden a una clase de archivos de texto, que permiten realizar la precarga de información a un aplicativo.
  para este caso se usa para almacenar la API Rest

+ features:

  Se encuentran los features del proyecto que es donde se escriben los escenarios o historias que lleva a cabo el usuario a nivel de negocio.


# Construido Con 🛠️
La automatización fue desarrollada con:
- BDD - Estrategia de desarrollo
- Screenplay (Patrón de diseño enfocado a desarrollo de pruebas automatizadas)
- Gradle
- Serenity API Rest
- Cucumber
- Serenity BDD - Biblioteca de código abierto para la generación de reportes-
- Gherkin - Lenguaje Business Readable DSL (Lenguaje especifico de dominio legible por el negocio)

