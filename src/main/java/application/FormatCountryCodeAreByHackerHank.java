package application;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.io.InputStream;
import java.io.FileInputStream;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FormatCountryCodeAreByHackerHank {

    private static final String URL;

    static {
        Properties prop = new Properties();
        // getResourceAsStream looks into the 'resources' folder automatically
        try (InputStream input = FormatCountryCodeAreByHackerHank.class
                .getClassLoader()
                .getResourceAsStream("config.properties")) {

            if (input == null) {
                throw new RuntimeException("Sorry, unable to find config.properties in resources folder");
            }

            prop.load(input);
            URL = prop.getProperty("ApiSettings.CountriesUrl", "");
        } catch (Exception e) {
            throw new RuntimeException("Could not load configuration", e);
        }
    }

    public static String getPhoneNumbers(String country, String phoneNumber) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            String encodedCountry = URLEncoder.encode(country, StandardCharsets.UTF_8);
            String baseUrl = URL + encodedCountry;

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                ObjectMapper mapper = new ObjectMapper();
                JsonNode result = mapper.readTree(response.body());

                JsonNode dataNode = result.get("data");
                if (dataNode != null && dataNode.isArray() && !dataNode.isEmpty()) {
                    // Access data[0].callingCodes[0]
                    JsonNode callingCodes = dataNode.get(0).get("callingCodes");
                    if (callingCodes != null && !callingCodes.isEmpty()) {
                        String countryCode = callingCodes.get(0).asText();
                        return "+" + countryCode + " " + phoneNumber;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "-1";
    }
}
