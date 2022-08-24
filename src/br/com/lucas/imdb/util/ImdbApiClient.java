package br.com.lucas.imdb.util;

import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;

public class ImdbApiClient {
	
	public String buscaFilme() throws Exception {


		Scanner scan = new Scanner(new File("C:\\7daysofcode\\APIKeyIMDB.txt"));
		String apiKey = scan.next();
		String urlApi = "https://imdb-api.com/en/API/Top250Movies/" + apiKey;

		HttpClient client = HttpClient.newBuilder().version(Version.HTTP_2).build();
		HttpRequest request = HttpRequest.newBuilder().uri(new URI(urlApi)).GET().build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		
		return response.body();
	}

}
