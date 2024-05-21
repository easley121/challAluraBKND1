import java.io.IOException;

public interface currencyConverterAPI {
    double getExchangeRate(String baseCurrency, String targetCurrency)
            throws IOException, InterruptedException;
}
