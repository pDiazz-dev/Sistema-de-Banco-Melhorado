
import java.util.ArrayList;
import java.util.Scanner;

public class Conta{
    private String nome;
    private int senha;
    private String cpf;
    private double saldo;
    ArrayList<String> extrato = new ArrayList<String>();
    Scanner ler = new Scanner(System.in);



    public void cadastrarCliente(){
        System.out.println("Digite seu nome para cadastrar");
        nome = ler.nextLine();
        System.out.println("Digite o seu CPF");
        cpf = ler.nextLine();

        System.out.println("Digite a senha");
        senha = ler.nextInt();
    }









    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public void fechamento(){
        ler.close();
    }


}
