package br.com.bec.pegaCep.principal;

import br.com.bec.pegaCep.exceptions.ExcecaoNumeros;
import br.com.bec.pegaCep.metodos.GeradorDeArquivo;
import br.com.bec.pegaCep.metodos.pegaJson;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner leitura = new Scanner(System.in);
        pegaJson pegaJson = new pegaJson();
        GeradorDeArquivo geraArquivo = new GeradorDeArquivo();
        boolean sair = false;

        while(!sair) {
            try {
                System.out.println("\nDigite o CEP: ");
                pegaJson.setBusca(leitura.nextLine());
                System.out.println(pegaJson.fazBusca());
                geraArquivo.salvaArquivo(pegaJson.fazBusca());
                sair = true;
            } catch (ExcecaoNumeros e) {
                System.out.println("Erro, verifique se o CEP digitado está correto 4");
            } catch (IOException t) {
                System.out.println("Erro IO, finalizando aplicação");
                sair = true;
            } catch (RuntimeException l) {
                System.out.println(l.getMessage());
            }
        }
        leitura.close();
    }
}
