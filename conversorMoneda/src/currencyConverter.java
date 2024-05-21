import java.io.IOException;

public class currencyConverter {
    private final currencyConverterAPI api;

    public currencyConverter(currencyConverterAPI api) {
        this.api = api;
    }

    public String convert(String baseCurrency, String targetCurrency, double amount) throws IOException, InterruptedException {
        double rate = api.getExchangeRate(baseCurrency, targetCurrency);
        double convertedAmount = amount * rate;
        return amount + " " + baseCurrency + " es igual a " + convertedAmount + " " + targetCurrency;
    }
}


