package br.com.lucas.imdb.util;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import br.com.lucas.imdb.modelo.Movie;

public class HTMLGenerator {

	PrintWriter writer;

	public HTMLGenerator(PrintWriter writerParam) {
		writer = writerParam;
	}

	public void generate(List<Movie> movieList) {

		String head = """
				<head>
					<meta charset=\"utf-8\">
					<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">
					<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\"
						+ "integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">
				</head>
				""";

		String divTemplate = head + """
				<div class=\"card text-white bg-dark mb-3\" style=\"max-width: 18rem;\">
					<h4 class=\"card-header\">%s</h4>
					<div class=\"card-body\">
						<img class=\"card-img\" src=\"%s\" alt=\"%s\">
						<p class=\"card-text mt-2\">Nota: %s - Ano: %s</p>
					</div>
				</div>
				""";

		for (Iterator<Movie> iterator = movieList.iterator(); iterator.hasNext();) {
			Movie movie = iterator.next();
			writer.println(String.format(divTemplate, movie.getTitle(), movie.getImage(), movie.getTitle(),
					movie.getRating(), movie.getYear()));

		}
	}
}
