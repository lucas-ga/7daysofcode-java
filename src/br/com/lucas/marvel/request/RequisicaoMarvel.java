package br.com.lucas.marvel.request;

import java.io.PrintWriter;
import java.util.List;

import br.com.lucas.imdb.modelo.Movie;
import br.com.lucas.imdb.util.HTMLGenerator;
import br.com.lucas.marvel.util.MarvelJsonParser;

public class RequisicaoMarvel {
	
	public static void main(String[] args) throws Exception {
		
		String json = new MarvelClient().getBody();

		List<Movie> movieList = new MarvelJsonParser(json).parse();

		PrintWriter writer = new PrintWriter("cards2.html");
		
		new HTMLGenerator(writer).generate(movieList);
		
		writer.close();
		
	}
	
}
