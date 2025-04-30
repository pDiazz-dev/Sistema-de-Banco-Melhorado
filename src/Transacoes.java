import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Transacoes{
    private double deposito;
    private double saque;
    private double tranferencia;
    private Conta conta;
    private String horarioTransacoes;
    Scanner ler = new Scanner(System.in);
    private GerenciamentoDaConta gerenciamentoDaConta;
    public Transacoes(Conta conta) {
        this.conta = conta;
    }


    public String depositar(){
        System.out.println("Digite o valor do seu deposito");
        deposito = ler.nextDouble();
        conta.setSaldo(deposito + conta.getSaldo());
        System.out.println("Deposito feito com sucesso");
        DateTimeFormatter formatadorDeData = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime horarioAgora = LocalDateTime.now();
        horarioTransacoes = formatadorDeData.format(horarioAgora);
        return String.format("Deposito feito de %.2f\t as %s", deposito, horarioTransacoes);
    }

    public String sacar(){
        System.out.println("Digite o valor do seu saque");
        saque = ler.nextDouble();
        if (conta.getSaldo() >= saque){
            conta.setSaldo(conta.getSaldo() - saque);
            DateTimeFormatter formatadorDeData = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            LocalDateTime horarioAgora = LocalDateTime.now();
            horarioTransacoes = formatadorDeData.format(horarioAgora);
            return String.format("Saque feito de %.2f\t as %s", saque, horarioTransacoes);
        } else {
            System.err.println("Saldo Insuficiente para Saque");
        }
        return String.format("Saque feito de %.2f RECUSADA \t as %s", saque,horarioTransacoes);
    }
    public String tranferencia(ArrayList<Conta> contas){
        System.out.println("Valor da tranferencia: ");
        tranferencia = ler.nextDouble();
        if (conta.getSaldo() >= tranferencia){
            System.out.println("Digite o CPF do destino");
            String cpfProcurar = ler.next();
            DateTimeFormatter formatadorDeData = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            LocalDateTime horarioAgora = LocalDateTime.now();
            horarioTransacoes = formatadorDeData.format(horarioAgora);
            for (Conta cpfEncontrado : contas){
                if (cpfProcurar.equals(cpfEncontrado.getCpf())){
                    conta.setSaldo(conta.getSaldo() - tranferencia);
                    cpfEncontrado.setSaldo(cpfEncontrado.getSaldo() + tranferencia);
                    System.out.println("Tranferencia bem sucedida! para " + cpfEncontrado.getNome());
                    cpfEncontrado.extrato.add(receberTranferencia(conta));
                    return String.format("tranferencia feito de %.2f\t para %s\tas %s", tranferencia,cpfEncontrado.getNome(), horarioTransacoes);
                }
            }
        } else {
            System.err.println("Saldo Insuficiente para a transação");
        }
        System.err.println("CPF não encontrado!");
        return String.format("tranferencia feito de %.2f RECUSADA \t as %s", tranferencia,horarioTransacoes);
    }

    public String receberTranferencia(Conta conta){
        return String.format("tranferencia recebida de %.2f\t do(a) %s\tas %s", tranferencia,conta.getNome(), horarioTransacoes);
    }


    public double getDeposito() {
        return deposito;
    }

    public void setDeposito(double deposito) {
        this.deposito = deposito;
    }

    public double getSaque() {
        return saque;
    }

    public void setSaque(double saque) {
        this.saque = saque;
    }
    public void fechamento(){
        ler.close();
    }

    public double getTranferencia() {
        return tranferencia;
    }

    public void setTranferencia(double tranferencia) {
        this.tranferencia = tranferencia;
    }
}
