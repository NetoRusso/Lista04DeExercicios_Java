package ExerciciosLista4;

import java.util.Scanner;

/*
Caso de Uso 5: Operações Matemáticas

Desenvolva um método que realiza operações matemáticas básicas (adição, subtração, multiplicação e divisão) com base em dois números fornecidos pelo usuário e uma operação especificada. Se a operação não for reconhecida, deve ser lançada uma exceção personalizada `InvalidOperationException`. Se uma divisão por zero for tentada, deve ser lançada uma exceção `ArithmeticException`.
*/

class InvalidOperationException extends Exception {
    public InvalidOperationException(String message) {
        super(message);
    }
}

public class Exercicio05 {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        double num1 = userInput.nextDouble();

        System.out.print("Digite o segundo número: ");
        double num2 = userInput.nextDouble();

        System.out.print("Digite a operação (+, -, *, /): ");
        char operacao = userInput.next().charAt(0);

        try {
            double resultado = calcular(num1, num2, operacao);
            System.out.println("Resultado: " + resultado);
        } catch (InvalidOperationException | ArithmeticException e) {
            System.err.println(e.getMessage());
        }
        userInput.close();
    }

    public static double calcular(double num1, double num2, char operacao) throws InvalidOperationException, ArithmeticException {
        switch (operacao) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 == 0) {
                    throw new ArithmeticException("Divisão por zero não permitida.");
                }
                return num1 / num2;
            default:
                throw new InvalidOperationException("Operação inválida: " + operacao);
        }
    }


}