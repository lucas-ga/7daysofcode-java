package br.com.lucas.imdb.modelo;

import br.com.lucas.imdb.interfaces.Content;

public class Movie implements Content {

	private String title;
	private String urlImage;
	private String rating;
	private String year;

	public void createMovie(String title, String urlImage, String rating, String year) {
		this.title = title;
		this.urlImage = urlImage;
		this.rating = rating;
		this.year = year;
	}

	@Override
	public String title() {
		// TODO
		return title;
	}

	@Override
	public String urlImage() {
		// TODO
		return urlImage;
	}

	@Override
	public String rating() {
		// TODO
		return rating;
	}

	@Override
	public String year() {
		// TODO
		return year;
	}
}
