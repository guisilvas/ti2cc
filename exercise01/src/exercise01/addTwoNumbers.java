/*
Autor: Guilherme Soares Silva
Matrícula: 863485
Disciplina: Trabalho Interdisciplinar II: Back-End
Atividade: Exercício 1: Integração Eclipse e GitHub
 */

package exercise01;

import java.util.*;

class addTwoNumbers {
        public static Scanner sc = new Scanner(System.in);

        public static void main(String[] args) {
                //Declaração de variáveis (inteiro)
                int num1, num2, sum;

                //Leitura das variáveis
                System.out.print("Digite um número: ");
                num1 = sc.nextInt();
                System.out.print("Digite outro número: ");
                num2 = sc.nextInt();

                //Soma dos números
                sum = num1 + num2;

                //Printando a soma das variáveis num1 e num2
                System.out.println("Soma: " + num1 + " + " + num2 + " = " + sum);
        }
}