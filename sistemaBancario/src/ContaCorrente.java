public class ContaCorrente extends Conta implements Tributavel{

    public ContaCorrente(String titular) {
        super(titular);

    }
    @Override
    public void sacar(double valor){
        this.saldo -= (valor + 2.0);

    }

    @Override
     public Double calcularImposto(){
        return this.saldo * 0.01;
    }
}
