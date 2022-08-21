package br.com.lucas.imdb.request;

import java.io.File;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.json.*;

public class RequisicaoIMDB {
	
	public static void main(String[] args) throws Exception {

		Scanner scan = new Scanner(new File("C:\\7daysofcode\\APIKeyIMDB.txt"));
		String apiKey = scan.next();
		String urlApi = "https://imdb-api.com/en/API/Top250Movies/"+apiKey;
		
		HttpClient client = HttpClient.newBuilder().version(Version.HTTP_2).build();
		HttpRequest request = HttpRequest.newBuilder().uri(new URI(urlApi)).GET().build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		
		JSONObject responseBody = new JSONObject(response.body());
		JSONArray items = new JSONArray(responseBody.getJSONArray("items"));

		List<String> titles = new ArrayList<>();
		List<String> urlImages = new ArrayList<>();
		List<String> year = new ArrayList<>();
		List<String> ImdbRating = new ArrayList<>();
		
		for (int i = 0; i < items.length(); i++) {
			titles.add(items.getJSONObject(i).getString("title"));
			urlImages.add(items.getJSONObject(i).getString("image"));
			year.add(items.getJSONObject(i).getString("year"));
			ImdbRating.add(items.getJSONObject(i).getString("imDbRating"));
		}
		
//		System.out.println(titles.toString());
//		System.out.println(urlImages.toString());
//		System.out.println(year.toString());
//		System.out.println(ImdbRating.toString());
		
		
//		if (response.statusCode() == 200 ) {
//			System.out.println(response.body());
//		} else {
//			System.out.println("error "+response.statusCode());
//			System.out.println("");
//			System.out.println(response.body());
//		}
	}
}
