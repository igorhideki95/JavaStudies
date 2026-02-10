import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CadastroAlunos {

    // Lista que guarda todos os alunos
    // Cada aluno é representado por um Map (sem classe Aluno)
    static ArrayList<Map<String, Object>> alunos = new ArrayList<>();

    // Map para indexar a matrícula e apontar para a posição no ArrayList
    static Map<String, Integer> indiceMatricula = new HashMap<>();

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Buscar por matrícula");
            System.out.println("3 - Listar todos");
            System.out.println("4 - Remover por matrícula");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            // Tratamento básico de entrada inválida
            while (!scanner.hasNextInt()) {
                System.out.print("Digite um número válido: ");
                scanner.next();
            }

            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    cadastrarAluno();
                    break;
                case 2:
                    buscarAluno();
                    break;
                case 3:
                    listarAlunos();
                    break;
                case 4:
                    removerAluno();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    // Método para cadastrar aluno
    static void cadastrarAluno() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Idade: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Idade inválida! Digite novamente: ");
            scanner.next();
        }
        int idade = scanner.nextInt();
        scanner.nextLine();

        if (idade < 0) {
            System.out.println("Idade não pode ser negativa!");
            return;
        }

        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();

        // Verifica se a matrícula já existe
        if (indiceMatricula.containsKey(matricula)) {
            System.out.println("Matrícula já cadastrada!");
            return;
        }

        // Criando o aluno como um Map
        Map<String, Object> aluno = new HashMap<>();
        aluno.put("nome", nome);
        aluno.put("idade", idade);
        aluno.put("matricula", matricula);

        // Adiciona na lista
        alunos.add(aluno);

        // Atualiza o índice da matrícula
        indiceMatricula.put(matricula, alunos.size() - 1);

        System.out.println("Aluno cadastrado com sucesso!");
    }

    // Método para buscar aluno pela matrícula
    static void buscarAluno() {
        System.out.print("Digite a matrícula: ");
        String matricula = scanner.nextLine();

        if (!indiceMatricula.containsKey(matricula)) {
            System.out.println("Aluno não encontrado!");
            return;
        }

        int indice = indiceMatricula.get(matricula);
        Map<String, Object> aluno = alunos.get(indice);

        System.out.println("Nome: " + aluno.get("nome"));
        System.out.println("Idade: " + aluno.get("idade"));
        System.out.println("Matrícula: " + aluno.get("matricula"));
    }

    // Método para listar todos os alunos
    static void listarAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado!");
            return;
        }

        System.out.println("\n=== LISTA DE ALUNOS ===");

        for (Map<String, Object> aluno : alunos) {
            System.out.println("----------------------");
            System.out.println("Nome: " + aluno.get("nome"));
            System.out.println("Idade: " + aluno.get("idade"));
            System.out.println("Matrícula: " + aluno.get("matricula"));
        }
    }

    // Método para remover aluno pela matrícula
    static void removerAluno() {
        System.out.print("Digite a matrícula para remover: ");
        String matricula = scanner.nextLine();

        if (!indiceMatricula.containsKey(matricula)) {
            System.out.println("Matrícula não encontrada!");
            return;
        }

        int indiceRemover = indiceMatricula.get(matricula);

        // Remove da lista
        alunos.remove(indiceRemover);

        // Remove do Map de índice
        indiceMatricula.remove(matricula);

        // Atualiza os índices das matrículas restantes
        for (int i = indiceRemover; i < alunos.size(); i++) {
            String mat = (String) alunos.get(i).get("matricula");
            indiceMatricula.put(mat, i);
        }

        System.out.println("Aluno removido com sucesso!");
    }
}
