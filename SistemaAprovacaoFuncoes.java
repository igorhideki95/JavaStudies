public class SistemaAprovacaoFuncoes {

    // CONSTANTES DO SISTEMA
    public static final double NOTA_APROVACAO = 7.0;
    public static final double NOTA_RECUPERACAO = 5.0;
    public static final double FREQUENCIA_MINIMA = 75.0;

    // FUNÇÃO PRINCIPAL DO SISTEMA (PROCESSA A TURMA)

    public static void processarTurma(String[] nomes, double[] medias, double[] frequencias) {

        System.out.println("=== SISTEMA DE APROVAÇÃO - TURMA 2026 ===\n");

        int totalAprovados = 0;
        int totalRecuperacao = 0;
        int totalReprovados = 0;
        int totalMencoes = 0;

        for (int i = 0; i < nomes.length; i++) {

            String situacao = verificarSituacao(medias[i], frequencias[i]);
            String desempenho = classificarDesempenho(medias[i]);
            String mencao = obterMencaoHonrosa(medias[i], frequencias[i]);

            if (situacao.equals("Aprovado")) totalAprovados++;
            else if (situacao.equals("Recuperação")) totalRecuperacao++;
            else if (situacao.startsWith("Reprovado")) totalReprovados++;

            if (mencao.equals("Sim")) totalMencoes++;

            System.out.println("Aluno " + (i + 1) + ": " + nomes[i]);
            System.out.println("  Média: " + medias[i]);
            System.out.println("  Frequência: " + frequencias[i] + "%");
            System.out.println("  Desempenho: " + desempenho);
            System.out.println("  Situação: " + situacao);
            System.out.println("  Menção Honrosa: " + mencao + "\n");
        }

        System.out.println("=== RESUMO DA TURMA ===");
        System.out.println("Total de alunos: " + nomes.length);
        System.out.println("Aprovados: " + totalAprovados);
        System.out.println("Recuperação: " + totalRecuperacao);
        System.out.println("Reprovados: " + totalReprovados);
        System.out.println("Menções Honrosas: " + totalMencoes);
    }

    // FUNÇÃO 1: Verifica a situação final do aluno

    public static String verificarSituacao(double media, double frequencia) {

        if (media < 0 || media > 10) return "Média inválida";
        if (frequencia < 0 || frequencia > 100) return "Frequência inválida";

        if (media >= NOTA_APROVACAO && frequencia >= FREQUENCIA_MINIMA) {
            return "Aprovado";
        } else if (media >= NOTA_RECUPERACAO && media < NOTA_APROVACAO && frequencia >= FREQUENCIA_MINIMA) {
            return "Recuperação";
        } else if (media < NOTA_RECUPERACAO || frequencia < FREQUENCIA_MINIMA) {
            return (frequencia < FREQUENCIA_MINIMA) ? "Reprovado por frequência" : "Reprovado por nota";
        }

        return "Situação indefinida";
    }

    // FUNÇÃO 2: Classifica o desempenho do aluno

    public static String classificarDesempenho(double media) {
        return (media >= 9.0) ? "Excelente" :
               (media >= 7.0) ? "Bom" :
               (media >= 5.0) ? "Regular" : "Insuficiente";
    }

    // FUNÇÃO 3: Verifica menção honrosa

    public static String obterMencaoHonrosa(double media, double frequencia) {
        return (media >= 9.0 && frequencia == 100.0) ? "Sim" : "Não";
    }
}

    // MAIN
public class Main {
    public static void main(String[] args) {

        String[] nomes = {"João Silva", "Maria Santos", "Pedro Costa", "Ana Paula", "Carlos Mendes"};
        double[] medias = {8.5, 6.0, 4.5, 9.5, 8.0};
        double[] frequencias = {90, 80, 85, 100, 70};

        SistemaAprovacaoFuncoes.processarTurma(nomes, medias, frequencias);
    }
}

