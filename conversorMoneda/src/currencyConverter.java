import java.io.IOException;
//Metodo de llamada de la API para simplificar el codigo en currencyConverterApp
public class currencyConverter {
    private final currencyConverterAPI api;

    public currencyConverter(currencyConverterAPI api) {
        this.api = api;
    }
    //Metodo para convertir las monedas
    public String convert(String baseCurrency, String targetCurrency, double amount) throws IOException, InterruptedException {
        double rate = api.getExchangeRate(baseCurrency, targetCurrency);
        double convertedAmount = amount * rate;
        return amount + " " + baseCurrency + " es igual a " + convertedAmount + " " + targetCurrency;
    }
}


