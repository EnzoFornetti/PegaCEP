package br.com.bec.pegaCep.exceptions;

public class ExcecaoNumeros extends RuntimeException {

    private String mensagem;

    public ExcecaoNumeros(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
