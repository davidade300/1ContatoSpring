package br.com.Alura.ScreenMatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// essa notacao ignora o que nao for mapeado
@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosSerie(@JsonAlias("Title") String titulo,
						 @JsonAlias("totalSeasons") Integer totalTemporadas,
						 @JsonAlias("imdbRating") String avaliacao) {
	

}
