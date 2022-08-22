package br.com.lucas.imdb.modelo;

public class Movie {

	private String title;
	private String image;
	private String rating;
	private String year;
	
	public void createMovie (String title, String image, String rating, String year) {
		this.title = title;
		this.image = image;
		this.rating = rating;
		this.year = year;
	}
	
	@Override
	public String toString() {
		return "Título: "+ this.title + " | Ano: " + this.year + " | Nota: " + this.rating + " | URL Imagem: " + this.image;
	}
}
