package br.com.Alura.ScreenMatch.service;

public interface IConverteDados {
	<T> T getData(String json, Class<T> classe);
}
