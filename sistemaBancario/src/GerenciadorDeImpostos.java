public class GerenciadorDeImpostos {
    private double totalImposto;

    public GerenciadorDeImpostos(){
        this.totalImposto = 0.0;
    }

    // O gerenciador NÃO recebe uma ContaCorrente ou um SeguroDeVida.
    // Ele recebe QUALQUER COISA que assine o contrato "Tributavel".
    public void registrar(Tributavel t){
        Double valorImposto = t.calcularImposto();
        this.totalImposto += valorImposto;
    }

    public double getTotalImpostos() {
        return this.totalImposto;
    }

}
