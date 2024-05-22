import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class currencyConverterApp {
    //Default para las monedas a usar
    private static String baseCurrency = "MXN";
    private static String targetCurrency = "USD";
    //Metodo principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        currencyConverterAPI api = new exchangeRateAPI();
        currencyConverter converter = new currencyConverter(api);
        //Uso de boleano para darle un fin al While
        boolean continuar = true;
        while (continuar) {
            //While de implementacion del menu para el usuario
            System.out.println("Menú: (Recuerda que la conversion base es de MXN a USD");
            System.out.println("1. Convertir");
            System.out.println("2. Cambiar la moneda a convertir");
            System.out.println("3. Finalizar el programa");
            System.out.print("Seleccione una opción: ");

            int opcion = obtenerOpcion(scanner);

            switch (opcion) {
                case 1:
                    convertirMoneda(scanner, converter);
                    break;
                case 2:
                    cambiarMoneda(scanner);
                    break;
                case 3:
                    continuar = false;
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }

        scanner.close();
    }
    //Metodo para dar la primer conversion de moneda, pide la cantidad y muestra una exepcion si hay error en la conversion
    private static void convertirMoneda(Scanner scanner, currencyConverter converter) {
        boolean continuar = true;

        while (continuar) {
            System.out.println("Ingrese la cantidad a convertir: ");
            double amount = obtenerCantidad(scanner);

            try {
                String resultado = converter.convert(baseCurrency, targetCurrency, amount);
                System.out.println(resultado);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
                System.out.println("Error en la conversión: " + e.getMessage());
            }


            System.out.println("¿Qué desea hacer a continuación?");
            System.out.println("1. Convertir otra cantidad");
            System.out.println("2. Cambiar la moneda a convertir");
            System.out.println("3. Regresar al menú principal");
            System.out.print("Seleccione una opción: ");

            int opcion = obtenerOpcion(scanner);

            switch (opcion) {
                case 1:
                  //Cuando da un resultado pide otra opcion para convertir, cambiar moneda o regresar al menu principal
                    System.out.println("Ingrese la cantidad a convertir: ");
                    amount = obtenerCantidad(scanner);
                    try {
                        String resultado = converter.convert(baseCurrency, targetCurrency, amount);
                        System.out.println(resultado);
                    } catch (IOException | InterruptedException e) {
                        e.printStackTrace();
                        System.out.println("Error en la conversión: " + e.getMessage());
                    }
                    break;
                case 2:
                    cambiarMoneda(scanner);
                    break;
                case 3:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida. Regresando al menú principal.");
                    continuar = false;
                    break;
            }
        }
    }

    //Metodo para cambiar la moneda, usa el mismo catalogo de 3 opciones que seleccionarMoneda
    private static void cambiarMoneda(Scanner scanner) {
        System.out.println("Seleccione la nueva moneda base:");
        baseCurrency = seleccionarMoneda(scanner, "base");
        System.out.println("Seleccione la nueva moneda destino:");
        targetCurrency = seleccionarMoneda(scanner, "destino");
        System.out.println("Monedas actualizadas: " + baseCurrency + " a " + targetCurrency);
    }
        //Metodo seleccionarMoneda, brinda un catalogo de las monedas a convertir
    private static String seleccionarMoneda(Scanner scanner, String tipoMoneda) {
        String[] monedasSoportadas = {"MXN", "USD", "BRL"};
        int opcion = -1;
        boolean valido = false;

        while (!valido) {
            System.out.println("Seleccione la moneda " + tipoMoneda + ":");
            for (int i = 0; i < monedasSoportadas.length; i++) {
                System.out.println((i + 1) + ". " + monedasSoportadas[i]);
            }
            System.out.print("Seleccione una opción (1, 2, 3): ");

            opcion = obtenerOpcion(scanner);

            if (opcion >= 1 && opcion <= monedasSoportadas.length) {
                valido = true;
            } else {
                System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }

        return monedasSoportadas[opcion - 1];
    }
    //Metodos para acegurarce que sea un numero la cantidad a convertir
    private static int obtenerOpcion(Scanner scanner) {
        int opcion = -1;
        boolean valido = false;

        while (!valido) {
            try {
                opcion = scanner.nextInt();
                scanner.nextLine();
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Error! Por favor ingresa un número.");
                scanner.nextLine();
            }
        }

        return opcion;
    }

    private static double obtenerCantidad(Scanner scanner) {
        double amount = -1;
        boolean valido = false;

        while (!valido) {
            try {
                amount = scanner.nextDouble();
                scanner.nextLine();
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Error! Por favor ingresa un número.");
                scanner.nextLine();
            }
        }

        return amount;
    }
}


