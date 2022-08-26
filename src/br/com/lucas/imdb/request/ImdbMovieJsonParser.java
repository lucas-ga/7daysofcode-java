package br.com.lucas.imdb.request;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import br.com.lucas.imdb.interfaces.JsonParser;
import br.com.lucas.imdb.modelo.Movie;

public class ImdbMovieJsonParser implements JsonParser {
	
	JSONObject requestBody;
	List<Movie> movieList = new ArrayList<>();

	public ImdbMovieJsonParser(String json) {
		requestBody = new JSONObject(json); 
	}

	public List<Movie> parse() {
		JSONArray items = new JSONArray(requestBody.getJSONArray("items"));

		for (int i = 0; i < items.length(); i++) {

			Movie movie = new Movie();
			movie.createMovie(items.getJSONObject(i).getString("title"), items.getJSONObject(i).getString("image"),
					items.getJSONObject(i).getString("imDbRating"), items.getJSONObject(i).getString("year"));
			movieList.add(movie);
		}
		
		return movieList;
	}
	
}
