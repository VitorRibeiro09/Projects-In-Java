public class ContaPoupanca extends Conta {


    public ContaPoupanca(String titular) {
        super (titular);
    }

    public void renderJuros(){
        this.saldo *= 1.01;

    }



}
