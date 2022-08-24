package br.com.lucas.imdb.request;

import java.io.PrintWriter;
import java.util.List;

import br.com.lucas.imdb.modelo.Movie;
import br.com.lucas.imdb.util.HTMLGenerator;
import br.com.lucas.imdb.util.ImdbApiClient;

public class RequisicaoIMDB {

	public static void main(String[] args) throws Exception {
		
		String json = new ImdbApiClient().buscaFilme();

		List<Movie> movieList = new ImdbMovieJsonParser(json).parse();

		/*
		 * int i = 0;
		 * 
		 * for (Iterator<Movie> iterator = movieList.iterator(); iterator.hasNext();) {
		 * Movie movie = iterator.next(); i++; System.out.println(i + " => " + movie); }
		 */

		PrintWriter writer = new PrintWriter("cards.html");
		
		new HTMLGenerator(writer).generate(movieList);
		
		writer.close();
	}
}
