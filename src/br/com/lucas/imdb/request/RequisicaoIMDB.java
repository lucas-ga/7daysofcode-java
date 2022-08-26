package br.com.lucas.imdb.request;

import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.lucas.imdb.modelo.Movie;
import br.com.lucas.imdb.util.HTMLGenerator;
import br.com.lucas.imdb.util.ImdbApiClient;

public class RequisicaoIMDB {

	public static void main(String[] args) throws Exception {
		
		String json = new ImdbApiClient().buscaFilme();

		List<Movie> movieList = new ImdbMovieJsonParser(json).parse();

		PrintWriter writer = new PrintWriter("cards.html");
		
		Collections.sort(movieList,Comparator.reverseOrder());
		
		new HTMLGenerator(writer).generate(movieList);
		
		writer.close();
	}
}
