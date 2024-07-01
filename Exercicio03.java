package ExerciciosLista4;


/*
Caso de Uso 3: Conversão de Tipos

Desenvolva um método que recebe uma lista de strings e tenta convertê-las para inteiros. Se a conversão de uma string para inteiro falhar, deve ser lançada uma exceção personalizada `InvalidTypeConversionException` e o programa deve continuar tentando converter as outras strings da lista.
*/
import java.util.ArrayList;
import java.util.List;

public class Exercicio03 {
    public static List<Integer> converterParaInteiros(List<String> listaStrings) {
        List<Integer> listaInteiros = new ArrayList<>();
        for (String str : listaStrings) {
            try {
                int inteiro = Integer.parseInt(str);
                listaInteiros.add(inteiro);
            } catch (NumberFormatException e) {
                System.err.println("Não foi possível converter a string '" + str + "' para um inteiro: " + e.getMessage());
            }
        }
        return listaInteiros;
    }

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("10");
        strings.add("27");
        strings.add("Neto");
        strings.add("35");
        strings.add("16");
        strings.add("Foi");
        strings.add("15");

        List<Integer> inteiros = converterParaInteiros(strings);
        System.out.println("Lista de inteiros: " + inteiros);
    }
}