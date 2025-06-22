# Pruebas E2E en Vaadin con Playwright y JUnit 5

Este proyecto es un ejemplo y punto de partida para configurar pruebas End-to-End (E2E) en una aplicación Vaadin,
utilizando Playwright como motor de automatización y JUnit 5 como framework de pruebas.

El objetivo es demostrar cómo
integrar pruebas de UI automatizadas en un flujo de desarrollo y de Integración Continua (CI) a través de GitHub
Actions.

## Flujo de Trabajo del Proyecto

El flujo principal de este repositorio se centra en tres áreas clave:

1. **La Aplicación Vaadin:** Una aplicación web simple
   que sirve como sujeto de prueba.
2. **Las Pruebas E2E:** Scripts de prueba que simulan la interacción de un usuario con la
   aplicación.
3. **La Integración Continua (CI):** Un pipeline automatizado que ejecuta las pruebas en cada cambio para
   garantizar la calidad del código.

## Ejecución de las Pruebas

### 1. Ejecución en Local

Para ejecutar las pruebas en tu máquina, el proyecto utiliza Maven. El siguiente comando compilará la aplicación, la
iniciará, ejecutará las pruebas de Playwright contra ella y finalmente la detendrá.

```shell
./mvnw verify
```

Si tienes Maven instalado globalmente, puedes usar `mvn verify`. Las pruebas se encuentran en el directorio
`src/test/java`.

### 2. Integración Continua con GitHub Actions

El repositorio incluye un flujo de trabajo preconfigurado en `.github/workflows/playwright-java.yml`. Este workflow se
activa
automáticamente con cada `push` o `pull request` al repositorio y realiza los siguientes pasos:

* Configura el entorno de Java.
* Construye el proyecto.
* Ejecuta el comando `./mvnw verify` para lanzar las pruebas E2E.

Esto asegura que ninguna nueva contribución rompa la funcionalidad existente de la interfaz de usuario.

### 3. Probar GitHub Actions Localmente con `act`

Para validar los cambios en el workflow de GitHub Actions sin necesidad de hacer un `push` al repositorio, puedes usar
`act`. Esta herramienta te permite ejecutar tus workflows de GitHub Actions localmente.

**Pasos para usar act:**

1. **Instala `act`**: Sigue las instrucciones de instalación oficiales.
2. **Ejecuta el workflow**: Desde la raíz del proyecto, simplemente ejecuta el comando:

```shell
    act
```

`act` leerá el archivo `.github/workflows/playwright-java.yml` y ejecutará los jobs definidos, dándote feedback
inmediato sobre el
funcionamiento de tu pipeline de CI.

## Estructura del Proyecto

* `src/main/java`: Contiene el código fuente de la aplicación Vaadin que se va a probar.
* `src/test/java`: Contiene las clases de prueba escritas con JUnit 5 y Playwright.
* `.github/workflows/playwright-java.yml`: Define el pipeline de Integración Continua.
* `pom.xml`: Gestiona las dependencias del proyecto, incluyendo Vaadin, Playwright, JUnit y los plugins de Maven
  necesarios.
