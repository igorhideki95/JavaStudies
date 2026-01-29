import java.util.Scanner;

/*
 * Atividade 01 - Sistema de Controle de Estoque
 * Desenvolvido por: Igor Hideki
 *
 * Objetivo:
 * Gerenciar o estoque de 5 produtos utilizando vetores paralelos,
 * realizando cálculos e análises conforme solicitado no enunciado.
 */

public class ControleEstoque {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Declaração dos vetores (vetores paralelos)
        String[] nomes = new String[5];
        int[] quantidades = new int[5];
        double[] precos = new double[5];

        // ===============================
        // Preenchimento dos vetores
        // ===============================
        for (int i = 0; i < 5; i++) {
            System.out.println("Produto " + (i + 1));

            System.out.print("Nome: ");
            nomes[i] = sc.nextLine();

            System.out.print("Quantidade em estoque: ");
            quantidades[i] = Integer.parseInt(sc.nextLine());

            System.out.print("Preço unitário: ");
            precos[i] = Double.parseDouble(sc.nextLine());

            System.out.println();
        }

        // ===============================
        // Cálculo do valor total do estoque
        // ===============================
        double valorTotalEstoque = 0;

        for (int i = 0; i < 5; i++) {
            valorTotalEstoque += quantidades[i] * precos[i];
        }

        System.out.println("Valor total do estoque: R$ " + valorTotalEstoque);

        // ===============================
        // Produtos com estoque baixo
        // ===============================
        System.out.println("\nProdutos com estoque baixo (menos de 10 unidades):");

        for (int i = 0; i < 5; i++) {
            if (quantidades[i] < 10) {
                System.out.println("- " + nomes[i]);
            }
        }

        // ===============================
        // Produto mais caro e mais barato
        // ===============================
        double maiorPreco = precos[0];
        double menorPreco = precos[0];
        int indiceMaior = 0;
        int indiceMenor = 0;

        for (int i = 1; i < 5; i++) {
            if (precos[i] > maiorPreco) {
                maiorPreco = precos[i];
                indiceMaior = i;
            }

            if (precos[i] < menorPreco) {
                menorPreco = precos[i];
                indiceMenor = i;
            }
        }

        System.out.println("\nProduto mais caro: " + nomes[indiceMaior] + " (R$ " + maiorPreco + ")");
        System.out.println("Produto mais barato: " + nomes[indiceMenor] + " (R$ " + menorPreco + ")");

        // ===============================
        // Cálculo do valor médio dos produtos
        // ===============================
        double somaPrecos = 0;

        for (int i = 0; i < 5; i++) {
            somaPrecos += precos[i];
        }

        double mediaPrecos = somaPrecos / 5;

        System.out.println("\nValor médio dos produtos: R$ " + mediaPrecos);

        sc.close();
    }
}
