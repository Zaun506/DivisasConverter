package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import org.example.models.Divisa;

public class RealizarConversion {
    public RealizarConversion() {
    }

    public static void realizarConversion(Scanner sc) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Divisa divisa = new Divisa();

        try {
            System.out.println("Ingresa las iniciales de la moneda que deseas convertir: ");
            System.out.println("|-----------------------------------__-------|");
            System.out.println("|--------         Opciones      -------------|");
            System.out.println("|--------------------------------------------|");
            System.out.println("|--------   USD: Dolar EstadoUidense   ----------|");
            System.out.println("|--------   ARS: Peso Argentino    ----------|");
            System.out.println("|--------   COP: Peso Colombiano   ----------|");
            System.out.println("|--------   CLP: Peso Chileno      ----------|");
            System.out.println("|--------   BRL: Real Brasileño    ----------|");
            System.out.println("|--------   MXN: Peso Mexcicao       ----------|");
            System.out.println("|--------   EUR: Euro      ----------|");
            System.out.println("|--------   GBP: Libra Esterlina  ----------|");
            System.out.println("|                                            |");
            System.out.println("|--------//////////////////////////----------|");
            System.out.println("Divisa: ");
            divisa.setDivisaOriginal(scanner.nextLine());
            sc.nextLine();
            System.out.println("Ingresa la Moneda a la cual vas convertir: ");
            divisa.setDivisaConvertir(scanner.nextLine());
            System.out.println("Ingrese el valor a convertir:");
            divisa.setValorConversion(scanner.nextDouble());
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://v6.exchangerate-api.com/v6/213e1901327afb0c0f826607/latest/" + divisa.getDivisaOriginal())).build();
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            String json = (String)response.body();
            Gson gson = new Gson();
            JsonObject jsonObject = (JsonObject)gson.fromJson(json, JsonObject.class);
            String result = jsonObject.get("result").getAsString();
            String base = jsonObject.get("base_code").getAsString();
            System.out.println("|--------**************************-------------------|");
            System.out.println("|                                                     |");
            System.out.println("|   Estado de la operacion: " + result + "                |");
            System.out.println("|   Base de conversión: " + base + " $" + divisa.getValorConversion() + "|");
            System.out.println("|                                                     |");
            System.out.println("|--------***********************************----------|");
            JsonObject conversionRatesObject = jsonObject.getAsJsonObject("conversion_rates");
            Iterator var12 = conversionRatesObject.entrySet().iterator();

            while(var12.hasNext()) {
                Map.Entry<String, JsonElement> entry = (Map.Entry)var12.next();
                String currency = (String)entry.getKey();
                double rate = ((JsonElement)entry.getValue()).getAsDouble();
                if (((String)entry.getKey()).equals(divisa.getDivisaConvertir())) {
                    double valorFinal = rate * divisa.getValorConversion();
                    System.out.println("|--------**************************************************************************----------|");
                    System.out.println("|   resultado conversion: " + currency + ": " + valorFinal + "                                   ");
                    PrintStream var10000 = System.out;
                    Double var10001 = divisa.getValorConversion();
                    var10000.println("|   $ " + var10001 + " " + divisa.getDivisaOriginal() + " equivale a $" + valorFinal + " " + divisa.getDivisaConvertir() + "  ");
                    System.out.println("|--------**************************************************************************----------|");
                }
            }
        } catch (NullPointerException var19) {
            System.out.println("ERROR: La opción es incorrecta. Por favor, ingrese una opcion valida.");
            sc.nextLine();
        }

    }
}
