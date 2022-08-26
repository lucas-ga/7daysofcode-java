package br.com.lucas.marvel.util;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import br.com.lucas.imdb.interfaces.JsonParser;
import br.com.lucas.imdb.modelo.Movie;

public class MarvelJsonParser implements JsonParser {

	JSONObject requestBody;
	List<Movie> movieList = new ArrayList<>();

	public MarvelJsonParser(String json) {
		requestBody = new JSONObject(json);
	}

	public List<Movie> parse() {
		JSONArray results = new JSONArray(requestBody.getJSONObject("data").getJSONArray("results"));

		for (int i = 0; i < results.length(); i++) {

			String title = results.getJSONObject(i).getString("title");
			String image = results.getJSONObject(i).getJSONObject("thumbnail").getString("path");
			image += "." + results.getJSONObject(i).getJSONObject("thumbnail").getString("extension");			
			String rating = results.getJSONObject(i).getString("rating");
			String year = String.valueOf(results.getJSONObject(i).getInt("startYear"));

			Movie movie = new Movie();
			movie.createMovie(title,image,rating,year);
			movieList.add(movie);
		}

		return movieList;
	}

}
