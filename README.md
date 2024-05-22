# Currency Converter Application

Esta es una aplicación simple de conversión de monedas en Java que utiliza la API de ExchangeRate-API para obtener los tipos de cambio actuales. 
La aplicación permite al usuario convertir una cantidad de una moneda base a una moneda destino seleccionadas, cambiar las monedas base y destino, y finalizar el programa.
Se intentara agregar las funcionalidades extra si el tiempo lo permite.

## Características

- Convertir una cantidad de una moneda base a una moneda destino.
- Cambiar las monedas base y destino.
- Interfaz de usuario en la consola.

## Requisitos

- Java 11 o superior
- Biblioteca GSON de Google para manejo de JSON

## Instalación

1. Clona este repositorio:

    ```sh
    git clone https://github.com/tu-usuario/currency-converter-app.git
    cd currency-converter-app
    ```

2. Descarga la biblioteca GSON y agrégala a tu proyecto. ( Puedes descargar el JAR de GSON desde [aquí](https://github.com/google/gson). )

3. Asegúrate de que el archivo GSON JAR esté incluido en el classpath de tu proyecto.

## Configuración

1. Obtén una clave API de [ExchangeRate-API](https://www.exchangerate-api.com/).

2. Reemplaza `"YOUR_API_KEY"` en la URL de la API en la clase `ExchangeRateAPI` con tu clave API:

    ```java
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/YOUR_API_KEY/latest/";
    ```

## Uso

1. Compila el proyecto:

2. Ejecuta la aplicación:

3. Sigue las instrucciones en la consola para convertir monedas, cambiar las monedas base y destino, o finalizar el programa.

## Estructura del Proyecto

- `CurrencyConverterApp`: Clase principal que maneja el menú y la interacción con el usuario.
- `CurrencyConverter`: Clase que realiza la conversión utilizando la API.
- `CurrencyConverterAPI`: Interfaz para obtener el tipo de cambio.
- `ExchangeRateAPI`: Implementación de `CurrencyConverterAPI` que obtiene los tipos de cambio desde ExchangeRate-API.


