import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        GerenciamentoDaConta gerenciamento = new GerenciamentoDaConta();
        int opcao;

        do {
            System.out.println("\n=== SISTEMA BANCÁRIO ===");
            System.out.println("1 - Criar nova conta");
            System.out.println("2 - Fazer login");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = ler.nextInt();
            ler.nextLine();

            switch (opcao) {
                case 1:
                    gerenciamento.adicionarConta();
                    break;
                case 2:
                    gerenciamento.logarPorCpf();
                    break;
                case 3:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 3);

        ler.close();
    }
}
