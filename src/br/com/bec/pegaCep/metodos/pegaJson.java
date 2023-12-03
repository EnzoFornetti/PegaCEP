package br.com.bec.pegaCep.metodos;

import br.com.bec.pegaCep.exceptions.ExcecaoNumeros;
import br.com.bec.pegaCep.modelos.Cep;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class pegaJson {

    private Gson gson;
    private String busca;
    private String endereco;

    public pegaJson() {
        Gson gson = new GsonBuilder().
                setPrettyPrinting().
                create();
    }

    public void setBusca(String busca) {
        if (busca.length() != 8) {
            throw new ExcecaoNumeros("CEP inválido, digite 8 números");
        } else {
            this.busca = busca;
        }
    }

    public Cep fazBusca() {

        URI endereco = URI.create("https://viacep.com.br/ws/" + busca + "/json/");
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(endereco).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Cep cep = new Gson().fromJson(response.body(), Cep.class);
            if (cep.getCep().isEmpty()){
                throw new RuntimeException("Endereço não encontrado");
            }
            return cep;
        } catch (Exception e) {
            throw new RuntimeException("Erro linha 42");
        }
    }
}