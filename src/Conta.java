import java.util.Arrays;
public class Conta {

    private int numero;

    private int totalOp = 0;

    private int numOp = 10;

    private Cliente dono;

    private double saldo;

    private double limite;

    private Operacao[] operacoes;

    private int proximaOperacao;

    private static int totalContas = 0;

    public Conta(int numero, Cliente dono, double saldo, double limite) {
        this.numero = numero;
        this.dono = dono;
        this.saldo = saldo;
        this.limite = limite;

        this.operacoes = new Operacao[10];
        this.proximaOperacao = 0;

        Conta.totalContas++;
    }



    public boolean sacar(double valor) {
        if (valor >= 0 && valor <= this.limite) {
            this.saldo -= valor;

            this.operacoes[proximaOperacao] = new OperacaoSaque(valor);
            this.proximaOperacao++;
            this.totalOp++;
            this.dobraOperacoes();
            return true;
        }

        return false;
    }

    public void depositar(double valor) {
        this.saldo += valor;

        this.operacoes[proximaOperacao] = new OperacaoDeposito(valor);
        this.proximaOperacao++;
        this.totalOp++;
        this.dobraOperacoes();
    }

    public boolean transferir(Conta destino, double valor) {
        boolean valorSacado = this.sacar(valor);
        if (valorSacado) {
            destino.depositar(valor);
            this.totalOp++;
            this.dobraOperacoes();
            return true;
        }
        return false;
    }

    public String toString(){
        String ContaStr = "===== Conta " + this.numero + " ===== \n"
                + "Dono: " + this.dono.getNome() + "\n"
                + "Saldo: " + this.saldo + "\n"
                + "Limite: " + this.limite + "\n"
                + "====================";

        return ContaStr;
    }

    public void imprimirExtrato() {
        System.out.println("======= Extrato Conta " + this.numero + "======");
        for(Operacao atual : this.operacoes) {
            if (atual != null) {
                System.out.println(atual);
            }
        }
        System.out.println("====================");
    }

    public int getNumero() {
        return numero;
    }

    public Cliente getDono() {
        return dono;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimite() {
        return limite;
    }

    public static int getTotalContas() {
        return Conta.totalContas;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setDono(Cliente dono) {
        this.dono = dono;
    }

    public void setLimite(double limite) {
        if (limite < 0)
            limite = 0;

        this.limite = limite;
    }

    private void dobraOperacoes(){
        if(totalOp >= numOp){
            this.numOp = this.numOp * 2;
            this.operacoes = Arrays.copyOf(operacoes, numOp);
        }
    }

    public boolean equals(Conta object){
        if(this.numero == object.numero) return true;
        return false;
    }
}
