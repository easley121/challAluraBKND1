import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
//Metodo para hacer los HTTP Request y obtener el Json usango la libreria de Gson
public class exchangeRateAPI implements currencyConverterAPI {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/737c3400e04069e37046df6d/latest/";

    @Override
    public double getExchangeRate(String baseCurrency, String targetCurrency) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        String url = API_URL + baseCurrency;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            Gson gson = new Gson();
            JsonObject jsonResponse = gson.fromJson(response.body(), JsonObject.class);

            if (jsonResponse.has("conversion_rates")) {
                JsonObject rates = jsonResponse.getAsJsonObject("conversion_rates");
                if (rates.has(targetCurrency)) {
                    return rates.get(targetCurrency).getAsDouble();
                } else {
                    //Implementacion de exepciones
                    throw new IOException("Moneda destino no encontrada: " + targetCurrency);
                }
            } else {
                throw new IOException("Respuesta de API inválida: 'conversion_rates' no encontrada");
            }
        } else {
            throw new IOException("Error en la solicitud: " + response.statusCode());
        }
    }
}
