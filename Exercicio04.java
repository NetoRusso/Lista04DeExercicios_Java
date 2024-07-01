package ExerciciosLista4;

/*
Caso de Uso 4: Manipulação de Coleções

Implemente um método que remove um elemento de uma lista de strings com base em um índice fornecido pelo usuário. Se o índice estiver fora dos limites da lista, deve ser lançada uma exceção personalizada `IndexOutOfBoundsException`. O programa deve pedir ao usuário para tentar novamente com um índice válido.
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class IndexOutOfBoundsException extends Exception {
    public IndexOutOfBoundsException(String message) {
        super(message);
    }
}

public class Exercicio04 {

    public static void removerElemento(List<String> lista, int indice) throws IndexOutOfBoundsException {
        if (indice < 0 || indice >= lista.size()) {
            throw new IndexOutOfBoundsException("Índice inválido: " + indice);
        }
        lista.remove(indice);
    }

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        List<String> listaStrings = new ArrayList<>();
        listaStrings.add("Maçã");
        listaStrings.add("Banana");
        listaStrings.add("Laranja");

        System.out.println("Lista de strings: " + listaStrings);

        while (true) {
            try {
                System.out.print("Digite o índice do elemento a ser removido: ");
                int indice = entrada.nextInt();
                removerElemento(listaStrings, indice);
                System.out.println("Lista atualizada: " + listaStrings);
                break;
            } catch (IndexOutOfBoundsException e) {
                System.err.println(e.getMessage());
                System.err.println("Tente novamente com um índice válido.");
                entrada.nextLine();
            }
        }

        entrada.close();
    }
}