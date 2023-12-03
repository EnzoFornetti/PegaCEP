package br.com.bec.pegaCep.metodos;

public record Cep (String cep, String logradouro, String complemento, String bairro,
                  String localidade, String uf, String ibge, String gia, String ddd,
                  String siafi) {
}
