import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Cliente william = new Cliente();
        william.setNome("William");


        Conta cc = new ContaCorrente(william);
        Conta poupanca = new ContaPoupanca(william);
        Scanner scan = new Scanner(System.in);

        System.out.println("");
        System.out.println("***** Bem vido ao Banco SAOGVS *****");
        System.out.println("");
        System.out.println("Escolha nas opções abaixo o que deseja fazer");
        System.out.println("");
        System.out.println(
                "1 - Ver saldo da conta corrente\n" +
                        "2 - Ver saldo da conta poupança\n" +
                        "3 - Ver saldo da conta corrente e da conta poupança\n" +
                        "4 - Realizar um deposito a conta\n" +
                        "5 - Realizar um saque da conta\n" +
                        "6 - Realizar uma tranferencia para da conta corrente para poupança\n" +
                        "7 - Sair");
        System.out.println("");
        System.out.println("Digite a opção desejada:");
        int opcao = scan.nextInt();

        cc.depositar(100);
        poupanca.depositar(100);

        //possiveis transações
        //cc.sacar(100)
        //cc.depositar(100);
        //cc.transferir(100, poupanca);

        if (opcao == 1) {
            cc.imprimirExtrato();
            System.out.println("\n\nFoi muito bom atender voce! Até mais!\n" + "\n" + "Encerrando\n");
        } else if (opcao == 2) {
            poupanca.imprimirExtrato();
            System.out.println("\n\nFoi muito bom atender voce! Até mais!\n" + "\n" + "Encerrando\n");
        } else if (opcao == 3) {
            cc.imprimirExtrato();
            poupanca.imprimirExtrato();
            System.out.println("\n\nFoi muito bom atender voce! Até mais!\n" + "\n" + "Encerrando\n");
        } else if (opcao == 4) {
            System.out.println("Qual valor deseja depositar?");
            int valorDep = scan.nextInt();
            System.out.println("Digite 1 para depositar na conta corrente ou 2 para depositar na conta poupança");
            int tipoConta = scan.nextInt();
            if (tipoConta == 1) {
                cc.depositar(valorDep);
                System.out.println("Ok, " + valorDep + " depositado na conta corrente.");
                System.out.println("");
                cc.imprimirExtrato();
                System.out.println("\n\nFoi muito bom atender voce! Até mais!\n" + "\n" + "Encerrando\n");
            } else if (tipoConta == 2) {
                poupanca.depositar(valorDep);
                System.out.println("Ok, " + valorDep + " depositado na conta poupança.");
                System.out.println("");
                poupanca.imprimirExtrato();
                System.out.println("\n\nFoi muito bom atender voce! Até mais!\n" + "\n" + "Encerrando\n");
            }
        } else if (opcao == 5) {
            System.out.println("Verifique antes o saldo de suas contas!");
            System.out.println("");
            cc.imprimirExtrato();
            poupanca.imprimirExtrato();
            System.out.println("");
            System.out.println("Qual valor deseja transferir?");
            int valorSac = scan.nextInt();
            System.out.println("Digite 1 para transferir da conta corrente para poupança\n" +
                    " ou 2 para transferir da conta poupança para a conta corrente.");
            int tipoConta = scan.nextInt();
            if (tipoConta == 1) {
                cc.sacar(valorSac);
                System.out.println("Ok, " + valorSac + " sacado da conta corrente.");
                System.out.println("");
                cc.imprimirExtrato();
                System.out.println("\n\nFoi muito bom atender voce! Até mais!\n" + "\n" + "Encerrando\n");
            } else if (tipoConta == 2) {
                poupanca.sacar(valorSac);
                System.out.println("Ok, " + valorSac + " sacado da conta poupança.");
                System.out.println("");
                poupanca.imprimirExtrato();
                System.out.println("\n\nFoi muito bom atender voce! Até mais!\n" + "\n" + "Encerrando\n");
            } else System.out.println("Opção invalida, transação encerrada.");
        } else if (opcao == 6) {
            System.out.println("Qual valor deseja transferir?");
            int valorTran = scan.nextInt();
            System.out.println("Digite 1 realizar tranferencia da conta corrente para a conta poupança.\n" +
                    "Digite 2 para realizar transferencia da conta poupança para a conta corente.");
            int tipoConta = scan.nextInt();
            if (tipoConta == 1) {
                cc.transferir(valorTran, poupanca);
                System.out.println("Ok, " + valorTran + " transferido da conta corrente para a poupança.");
                System.out.println("");
                poupanca.imprimirExtrato();
                System.out.println("\n\nFoi muito bom atender voce! Até mais!\n" + "\n" + "Encerrando\n");
            } else if (tipoConta == 2) {
                poupanca.transferir(valorTran, cc);
                System.out.println("Ok, " + valorTran + " transferido da conta poupança para a corrente.");
                System.out.println("");
                cc.imprimirExtrato();
                System.out.println("\n\nFoi muito bom atender voce! Até mais!\n" + "\n" + "Encerrando\n");
            } else System.out.println("Opção invalida, transação encerrada.");
        } else if (opcao == 7) {
            System.out.println("\nFoi muito bom atender voce! Até mais!\n" + "\n" + "Encerrando\n");
        }else System.out.println("Opção invalida, transação encerrada.\n");
    }
}
