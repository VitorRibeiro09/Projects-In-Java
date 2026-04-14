public class Conta {
    protected String titular;
    protected double saldo;

    public Conta(String titular) {
        this.titular= titular;
        this.saldo= 0.0;
    }
    public void depositar(double valor){
        this.saldo += valor;
    }
    public void sacar(double valor){
        this.saldo -= valor;   }

    public String  getTitular() {return this.titular;}
    public double getSaldo() {return this.saldo;}



}
