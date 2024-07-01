package ExerciciosLista4;
/*
Caso de Uso 1: Leitura de Arquivo e Processamento de Dados
Você precisa ler um arquivo de texto que contém uma lista de números, um em cada linha, e calcular a soma desses números. Se o arquivo não existir, deve ser criada uma exceção personalizada `FileNotFoundException`. Se uma linha não puder ser convertida para um número, deve ser lançada uma exceção personalizada `InvalidNumberFormatException`.
*/

import java.io.File;  // Importação do pacote File
import java.io.FileNotFoundException;  // Importação do pacote FileNotFoundException
import java.util.Scanner;

public class Exercicio01 {
    public static void main(String[] args) {

        String arquivo = "C:\\Users\\user\\Desktop\\lista.txt";
       //String arquivo = "C:/Users/TIBUFF/Desktop/Lista.txt"; //arquivo de teste

        int soma = 0;

        try {

            Scanner scanner = new Scanner(new File(arquivo));

            // Lê cada linha do arquivo e adiciona à soma
            while (scanner.hasNextLine()) {
                try {
                    // Tenta converter a linha para um inteiro
                    int numero = Integer.parseInt(scanner.nextLine());
                    soma += numero;
                } catch (NumberFormatException e) {
                    System.err.println("Formato de número inválido: " + e.getMessage());
                }
            }

            scanner.close();

            System.out.println("Soma dos números: " + soma);

        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: " + e.getMessage());
        }
    }
}

