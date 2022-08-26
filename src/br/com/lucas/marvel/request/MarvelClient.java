package br.com.lucas.marvel.request;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import br.com.lucas.marvel.interfaces.APIClient;

public class MarvelClient implements APIClient {

	@Override
	public String getBody() throws Exception {

		//Scanner scan = new Scanner(new File("C:\\7daysofcode\\APIKeyMarvel.txt"));
		//String apiKey = scan.next();
		String urlApi = "https://gateway.marvel.com/v1/public/characters/1009351/series?apikey=e2239595ab9c2d16d515dac7e045740f&hash=522af825e4dd64640731c5eccacf643b&ts=1";

		HttpClient client = HttpClient.newBuilder().version(Version.HTTP_2).build();
		HttpRequest request = HttpRequest.newBuilder().uri(new URI(urlApi)).GET().build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		
		return response.body();
	}

	@Override
	public String type() {
		// TODO
		return null;
	}

//GET /v1/public/characters/{characterId}/series	
}
