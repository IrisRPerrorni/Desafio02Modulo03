package EntregaMínima;

import java.util.ArrayList;
import java.util.List;

public class CadastroSistema {
    private List<Cliente> clientes;
    private List<Vendedor> vendedores;
    private List<Produtos> produtosDeVendas;

    public CadastroSistema() {
        this.clientes = new ArrayList<Cliente>();
        this.produtosDeVendas = new ArrayList<Produtos>();
        this.vendedores = new ArrayList<Vendedor>();
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Vendedor> getVendedores() {
        return vendedores;
    }

    public List<Produtos> getProdutosDeVendas() {
        return produtosDeVendas;
    }

    public void cadastroCliente(Cliente cliente) {
        clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso " + cliente);

    }

    public void cadastroVendedor(Vendedor vendedor) {
        vendedores.add(vendedor);
        System.out.println("Vendedor: " + vendedor + "Cadastrado com sucesso");

    }
    public void verificacaoCLienteEVendedor(String nomeCliente, String nomeVendedor)
            throws VerificacaoCliente, VerificacaoVendedor {

        if (!verificarCliente(nomeCliente)) {
            throw new VerificacaoCliente("Não há registro desse cliente, por favor Cadastrar cliente !");
        }
        if (!verificarVendedor(nomeVendedor)) {
            throw new VerificacaoVendedor("Não há registro desse vendedor, por favor Cadastrar vendedor!");
        }
    }

    public void cadastrarVendas(Produtos venda){
        produtosDeVendas.add(venda);
        System.out.println("Venda Registrada com sucesso!");

    }

//    public void registroDeVendas(String nomeCliente, String nomeVendedor, Produtos vendas)
//            throws VerificacaoCliente, VerificacaoVendedor {
//
//        if (!verificarCliente(nomeCliente)) {
//            throw new VerificacaoCliente("Não há registro desse cliente, por favor Cadastrar cliente !");
//        }
//        if (!verificarVendedor(nomeVendedor)) {
//            throw new VerificacaoVendedor("Não há registro desse vendedor, por favor Cadastrar vendedor!");
//        }
//        produtosDeVendas.add(vendas);
//        System.out.println("Venda Registrada com sucesso!");
//    }

    public boolean verificarCliente(String nomeCliente) {
        if (nomeCliente == null) {
            return false;
        }
        for (Cliente cliente : clientes) {
            if (cliente.getNomeCliente().equalsIgnoreCase(nomeCliente)) {
                return true;
            }
        }
        return false;
    }

    public boolean verificarVendedor(String nomeVendedor) {
        if (nomeVendedor == null) {
            return false;
        }
        for (Vendedor vendedor : vendedores) {
            if (vendedor.getNomeVendedor().equalsIgnoreCase(nomeVendedor)) {
                return true;
            }

        }
        return false;
    }

    public void exibirClientes() {
        for (Cliente cliente : clientes) {
            String saida = cliente.toString();
            System.out.println(saida);

        }
    }

    public void exibirVendedor() {
        for (Vendedor vendedor : vendedores) {
            String saida = vendedor.toString();
            System.out.println(saida);
        }
    }

    public void exibirVendas() {
        for (Produtos venda : produtosDeVendas) {
            String saida = venda.toString();
            System.out.println(saida);
        }
    }

}
