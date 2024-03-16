package br.com.Alura.ScreenMatch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.Alura.ScreenMatch.model.DadosEpisodio;
import br.com.Alura.ScreenMatch.model.DadosSerie;
import br.com.Alura.ScreenMatch.service.ConsumeApi;
import br.com.Alura.ScreenMatch.service.ConvertData;

@SpringBootApplication
public class ScreenMatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenMatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ConsumeApi consumeApi = new ConsumeApi();
		var json = consumeApi.
				getData("https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c");
		//System.out.println(json);
		//json = consumeApi.getData("https://coffee.alexflipnote.dev/random.json");
		//System.out.println(json);
		ConvertData converter = new ConvertData();
		DadosSerie dados = converter.getData(json, DadosSerie.class);
		System.out.println(dados);
		json = consumeApi.getData("https://omdbapi.com/?t=gilmore+girls&season=1&episode=2&apikey=6585022c");
		DadosEpisodio dadosEpisodio = converter.getData(json, DadosEpisodio.class);
		System.out.println(dadosEpisodio);
	}

}
