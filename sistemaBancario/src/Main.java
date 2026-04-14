//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ContaCorrente cc = new ContaCorrente("Vitor Samuel Ribeiro de Souza");
        cc.depositar(1000);
        cc.sacar(500);



        SeguroDeVida seguro = new SeguroDeVida();

        GerenciadorDeImpostos gerenciador = new GerenciadorDeImpostos();

        // 2. Registrando os impostos (Polimorfismo em ação!)
        gerenciador.registrar(cc);     // Conta paga 1% de 898 = 8.98
        gerenciador.registrar(seguro); // Seguro paga 42.0

        // 3. Imprimindo os resultados no console
        System.out.println("--- Sistema Bancário ---");
        System.out.println("Titular: " + cc.getTitular());
        System.out.println("Saldo Final: R$ " + cc.getSaldo());

        System.out.println("------------------------");
        System.out.println("Total de Impostos Recolhidos: R$ " + gerenciador.getTotalImpostos());
        // A soma deve dar 50.98 (8.98 da conta + 42.0 do seguro)
    }
}
