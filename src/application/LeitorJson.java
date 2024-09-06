package application;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;

public class LeitorJson {

	public static void main(String[] args) {
		try (Reader reader = new FileReader("dados.json")) {

			Gson gson = new Gson();
			Type tipoLista = new TypeToken<List<Dados>>() {
			}.getType();
			List<Dados> dados = gson.fromJson(reader, tipoLista);

			filtrarValoresZero(dados);
			double maior = calcularMaior(dados);
			double media = calcularMedia(dados);
			double menor = calcularMenor(dados);
			
			menorValor(dados, menor);
			maiorValor(dados, maior);
			imprimirValoresAcimaDaMedia(dados, media);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void filtrarValoresZero(List<Dados> dados) {
		for (Iterator<Dados> it = dados.iterator(); it.hasNext();) {
			Dados dado = it.next();
			if (dado.getValor() == 0) {
				it.remove();
			}
		}
	}
	public static double calcularMenor(List<Dados> dados) {
		return dados.stream().mapToDouble(Dados::getValor).min().orElse(0.0);
	}
	public static double calcularMaior(List<Dados> dados) {
		return dados.stream().mapToDouble(Dados::getValor).max().orElse(0.0);
	}
	public static double calcularMedia(List<Dados> dados) {
		return dados.stream().mapToDouble(Dados::getValor).average().orElse(0.0);
	}

	public static void imprimirValoresAcimaDaMedia(List<Dados> dados, double media) {
		for (Dados dado : dados) {
			if (dado.getValor() > media) {
				System.out.println("Dias acima da média: " + dado.getDia() + ", Valor: " + dado.getValor());
			}
		}
	}

	public static void maiorValor(List<Dados> dados, double maior) {
		for (Dados dado : dados) {
			if (dado.getValor() > maior) {
				maior = dado.getValor();
			}
		}
		System.out.println("Maior valor:"+ maior);
	}
	public static void menorValor(List<Dados> dados, double menor) {
		for (Dados dado : dados) {
			if (dado.getValor() < menor) {
				menor = dado.getValor();
			}
		}
		System.out.println("Menor valor:"+ menor);
	}
}