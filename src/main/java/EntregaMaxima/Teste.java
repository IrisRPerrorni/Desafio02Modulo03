package EntregaMaxima;

import java.time.LocalDate;
import java.util.Scanner;

public class Teste {
    public static void exibirMenu() {
        System.out.println("\n========== CadastroCandidato Produtos =========\n");
        System.out.println(" 1 - Cadastrar Clientes");
        System.out.println(" 2 - Cadastrar Vendedores");
        System.out.println(" 3 - Cadastrar vendas");
        System.out.println(" 4 - Exibir clientes cadastrados");
        System.out.println(" 5 - Exibir vendedores cadastrados");
        System.out.println(" 6 - Exibir vendas registradas");
        System.out.println(" 7 - Buscar vendas por cliente ");
        System.out.println(" 8 - Buscar vendas por vendedor ");
        System.out.println(" 9 - Sair  ");
        System.out.println(" Escolha uma opção");

    }

    public static void main(String[] args) {
        CadastroSistema cadastroSistema = new CadastroSistema();

        Scanner entrada = new Scanner(System.in);

        String cpf;
        String nome;
        String email;
        int num;
        boolean continuar = true;

        while (continuar) {
            exibirMenu();
            int opcao = entrada.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("\n==========Cadastro de clientes======\n");
                    System.out.println("\nDigite quantos cliente quer cadastrar: ");
                    num = entrada.nextInt();
                    for (int i = 0; i < num; i++) {
                        try {
                            System.out.println("Digite o nome do Cliente a cadastrar");
                            nome = entrada.next();
                            System.out.println("Digite o CPF do cliente: ");
                            cpf = entrada.next();
                            System.out.println("Digite o email do cliente: ");
                            email = entrada.next();
                            Cliente cliente = new Cliente(nome, cpf, email);
                            cadastroSistema.verificarCadastroCliente(email, cpf, cliente);
                        } catch (VerificacaoEmail | VerificacaoEmailRepetido | VerificacaoCpfRepetido e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;

                case 2:
                    System.out.println("\n==========Cadastro de vendedores======\n");
                    System.out.println("\nDigite quantos vendedores quer cadastrar: ");
                    num = entrada.nextInt();
                    for (int i = 0; i < num; i++) {
                        try {
                            System.out.println("Digite o nome do Vendedor a cadastrar");
                            nome = entrada.next();
                            System.out.println("Digite o CPF do Vendedor: ");
                            cpf = entrada.next();
                            System.out.println("Digite o email do Vendedor: ");
                            email = entrada.next();
                            Vendedor vendedor = new Vendedor(nome, email, cpf);
                            cadastroSistema.cadastroVendedor(email, cpf, vendedor);
                        } catch (VerificacaoEmail | VerificacaoEmailRepetido | VerificacaoCpfRepetido e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;

                case 3:
                    System.out.println("\n==========Cadastro de vendas======\n");
                    System.out.println("\nDigite quantas vendas quer cadastrar: ");
                    num = entrada.nextInt();

                    for (int i = 0; i < num; i++) {
                        try {

                            System.out.println("Digite o CPF do vendedor responsável pela venda");
                            String cpfVendedor = entrada.next();
                            System.out.println("Digite o cpf do cliente ");
                            String cpfCLiente = entrada.next();
                            System.out.println("Digite o produto vendido");
                            String nomeProduto = entrada.next();
                            System.out.println("Digite o valor do produto");
                            double valor = entrada.nextDouble();
                            System.out.println("Digite o ano do registro do produto");
                            int ano = entrada.nextInt();
                            System.out.println("Digite mes do registro do produto");
                            int mes = entrada.nextInt();
                            System.out.println("Digite o dia do registro do produto");
                            int dia = entrada.nextInt();
                            LocalDate data = LocalDate.of(ano, mes, dia);
                            Produtos venda = new Produtos(nomeProduto, valor, data);
                            cadastroSistema.cadastroVendas(cpfCLiente, cpfVendedor, venda);
                        } catch (VerificacaoCliente | VerificacaoVendedor e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;

                case 4:
                    System.out.println("\n--------exibir lista de clientes------\n");
                    cadastroSistema.exibirClientes();
                    break;

                case 5:
                    System.out.println("\n--------exibir lista de vendedores------\n");
                    cadastroSistema.exibirVendedores();
                    break;

                case 6:
                    System.out.println("\n--------exibir registro de vendas------\n");
                    cadastroSistema.exibirVendas();
                    break;

                case 7:
                    System.out.println("\n-------Exibir compras por cliente -----\n");
                    System.out.println("Digite o cpf do cliente que deseja buscar a compra:");
                    cpf = entrada.next();
                    cadastroSistema.pesquisarCompraPorCLienteCPF(cpf);
                    cadastroSistema.exibirCompraCLiente();
                    break;

                case 8:
                    System.out.println("\n-------Exibir vendas por vendedor -----\n");
                    System.out.println("Digite o email do vendedor que deseja buscar a compra:");
                    email = entrada.next();
                    cadastroSistema.pesquisarVendaVendedorEmail(email);
                    cadastroSistema.exibirVendasCLientes();
                    break;

                case 9:
                    System.out.println("\n++++++++Saindo++++++++\n");
                    entrada.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("opção invalida!!!!");

            }
        }
    }
}