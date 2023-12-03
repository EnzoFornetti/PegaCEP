package br.com.bec.pegaCep.modelos;

public record Cep (String cep, String logradouro, String complemento, String bairro,
                  String localidade, String uf, String ibge, String gia, String ddd,
                  String siafi) {

    public String getCep() {
        return cep;
    }
}
