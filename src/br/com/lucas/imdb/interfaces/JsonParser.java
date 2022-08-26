package br.com.lucas.imdb.interfaces;

import java.util.List;

public interface JsonParser {

	public List<? extends Content> parse();
}
