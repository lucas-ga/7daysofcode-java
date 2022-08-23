package br.com.lucas.imdb.request;

import java.io.File;
import java.io.PrintWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import br.com.lucas.imdb.modelo.Movie;
import br.com.lucas.imdb.util.HTMLGenerator;

public class RequisicaoIMDB {

	public static void main(String[] args) throws Exception {

		Scanner scan = new Scanner(new File("C:\\7daysofcode\\APIKeyIMDB.txt"));
		String apiKey = scan.next();
		String urlApi = "https://imdb-api.com/en/API/Top250Movies/" + apiKey;

		HttpClient client = HttpClient.newBuilder().version(Version.HTTP_2).build();
		HttpRequest request = HttpRequest.newBuilder().uri(new URI(urlApi)).GET().build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

		JSONObject responseBody = new JSONObject(response.body());
		JSONArray items = new JSONArray(responseBody.getJSONArray("items"));

		List<Movie> movieList = new ArrayList<>();

		for (int i = 0; i < items.length(); i++) {

			Movie movie = new Movie();
			movie.createMovie(items.getJSONObject(i).getString("title"), items.getJSONObject(i).getString("image"),
					items.getJSONObject(i).getString("imDbRating"), items.getJSONObject(i).getString("year"));
			movieList.add(movie);
		}

		/*
		 * int i = 0;
		 * 
		 * for (Iterator<Movie> iterator = movieList.iterator(); iterator.hasNext();) {
		 * Movie movie = iterator.next(); i++; System.out.println(i + " => " + movie); }
		 */

		PrintWriter writer = new PrintWriter(new File("cards.html"));
		
		HTMLGenerator generator = new HTMLGenerator(writer);
		generator.generate(movieList);
		
		writer.close();
	}
}
