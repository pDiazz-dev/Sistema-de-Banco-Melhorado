import java.util.ArrayList;
import java.util.Scanner;

public class GerenciamentoDaConta{
    Scanner ler = new Scanner(System.in);
    ArrayList<Conta> contas = new ArrayList<Conta>();


    public void adicionarConta(){
        Conta conta = new Conta();
        conta.cadastrarCliente();
        contas.add(conta);
    }

    public void logarPorCpf(){
        System.out.println("Digite o cpf");
        String cpfProcurar = ler.next();
        for (Conta cpfEncontrado : contas){
            if (cpfProcurar.equals(cpfEncontrado.getCpf())){
                System.out.println("Seja bem-vindo " + cpfEncontrado.getNome());
                verificacaoDaConta(cpfEncontrado);
                return;
            }
        }
        System.err.println("Cpf não encontrado");

    }

    public void verificacaoDaConta(Conta conta){
        for ( int tentativas = 2;tentativas >= 0;tentativas--){
            System.out.println("Digite a senha da sua conta");
            int tentativaSenha = ler.nextInt();
            if (tentativaSenha == conta.getSenha()){
                System.out.println("Seja bem vindo! " + conta.getNome());
                tarefasDaConta(conta);
                break;
            }else {
                System.err.println("Senha invalida mais " + tentativas + " tentativas");

            }
        }

    }




    public void tarefasDaConta(Conta conta){
        Transacoes transacoes = new Transacoes(conta);
        int opcao;
        do {
            System.out.println("Qual tarefa gostaria de fazer " + conta.getNome() +"?"+ " \n 1-Deposito\n 2-saque\n 3-saldo\n 4-Extrato\n 5-Tranferencia\n 6-Sair");
            opcao = ler.nextInt();
            switch (opcao){
                case 1:
                    conta.extrato.add(transacoes.depositar());
                    break;
                case 2:
                    conta.extrato.add(transacoes.sacar());
                    break;
                case 3:
                    System.out.println("O saldo da sua conta é " + conta.getSaldo());
                    break;
                case 4:
                    for (String mostrar: conta.extrato){
                        System.out.println(mostrar);
                    }
                    break;
                case 5:
                    conta.extrato.add(transacoes.tranferencia(contas));
            }
        }while (opcao!=6);

    }




}
