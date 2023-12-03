package br.com.bec.pegaCep.principal;

import br.com.bec.pegaCep.exceptions.ExcecaoNumeros;
import br.com.bec.pegaCep.metodos.pegaJson;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner leitura = new Scanner(System.in);
        pegaJson pegaJson = new pegaJson();
        boolean sair = false;

        while(!sair) {
            try {
                System.out.println("\nDigite o CEP: ");
                pegaJson.setBusca(leitura.nextLine());
                leitura.close();
                System.out.println(pegaJson.fazBusca());
                sair = true;
            } catch (ExcecaoNumeros e) {
                System.out.println("Erro, verifique se o CEP digitado está correto");
            }
        }
    }
}
