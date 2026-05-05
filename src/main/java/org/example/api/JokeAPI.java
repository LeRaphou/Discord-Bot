package org.example.api;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JokeAPI {
    private static final String API_URL = "https://official-joke-api.appspot.com/random_joke";
    private static final HttpClient httpClient = HttpClient.newHttpClient();

    public static Joke getRandomJoke() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL))
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                return null;
            }

            JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();

            String setup = json.get("setup").getAsString();
            String punchline = json.get("punchline").getAsString();
            String type = json.get("type").getAsString();

            return new Joke(setup, punchline, type);

        } catch (IOException | InterruptedException e) {
            System.err.println("Erreur lors de la récupération de la blague : " + e.getMessage());
            return null;
        }
    }

    public static class Joke {
        public final String setup;
        public final String punchline;
        public final String type;

        public Joke(String setup, String punchline, String type) {
            this.setup = setup;
            this.punchline = punchline;
            this.type = type;
        }

        @Override
        public String toString() {
            return setup + "\n>>> " + punchline;
        }
    }
}

