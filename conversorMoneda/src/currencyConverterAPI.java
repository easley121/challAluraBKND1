import java.io.IOException;
//Interfaz de funcionamiento de la API
public interface currencyConverterAPI {
    double getExchangeRate(String baseCurrency, String targetCurrency)
            throws IOException, InterruptedException;
}
