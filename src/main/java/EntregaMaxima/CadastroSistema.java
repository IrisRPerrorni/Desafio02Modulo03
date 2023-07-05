package EntregaMaxima;

import java.util.ArrayList;
import java.util.List;

public class CadastroSistema {
    private List<Cliente> clientes;
    private List<Vendedor> vendedores;
    private List<Pedido> pedidos;
    private List<Pedido> pedidosporClientes = new ArrayList<>();
    private List<Pedido> pedidosporVendedor = new ArrayList<>();

    public CadastroSistema() {
        this.clientes = new ArrayList<Cliente>();
        this.vendedores = new ArrayList<Vendedor>();
        this.pedidos = new ArrayList<Pedido>();

    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Vendedor> getVendedores() {
        return vendedores;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void verificarCadastroCliente(String emailCliente, String cpfCLiente, Cliente cliente)
            throws VerificacaoEmail, VerificacaoEmailRepetido, VerificacaoCpfRepetido {
        if (!verificarEmailValidoCliente(emailCliente)) {
            throw new VerificacaoEmail("Email invalido!");
        }
        if (verificarEmailRepetidoCliente(emailCliente)) {
            throw new VerificacaoEmailRepetido("Não é possivel cadastrar o cliente , email já existente!");
        }
        if (verificarCPFrepetidoCliente(cpfCLiente)) {
            throw new VerificacaoEmailRepetido("Não é possivel cadastrar o cliente, cpf já cadastrado!");
        }
        clientes.add(cliente);
        System.out.println("cliente cadastrado");
    }


    public boolean verificarEmailValidoCliente(String emailCliente) {
        if (emailCliente.contains("@")) {
            return true;
        }
        return false;
    }

    public boolean verificarEmailRepetidoCliente(String emailCliente) {
        if (clientes.size() == 0) return false;

        for (Cliente email : clientes) {
            if (email.getEmail().equalsIgnoreCase(emailCliente)) {
                return true;
            }
        }
        return false;
    }

    public boolean verificarCPFrepetidoCliente(String cpfCliente) {
        if (clientes.size() == 0) return false;

        for (Cliente cpf : clientes) {
            if (cpf.getCpf().equalsIgnoreCase(cpfCliente)) {
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

    public void cadastroVendedor(String emailVendedor, String cpfVendedor, Vendedor vendedor)
            throws VerificacaoEmail, VerificacaoEmailRepetido, VerificacaoCpfRepetido {
        if (!verificarEmailValidoVendedor(emailVendedor)) {
            throw new VerificacaoEmail("Email invalido!");
        }
        if (verificarEmailRepetidoVendedor(emailVendedor)) {
            throw new VerificacaoEmailRepetido("Nâo é possivel cadastrar o cliente , email já existente!");
        }
        if (verificarCPFrepetidoVendedor(cpfVendedor)) {
            throw new VerificacaoCpfRepetido("Não é possivel cadastrar o cliente, CPF já cadastrado!");
        }
        vendedores.add(vendedor);
        System.out.println("Vendedor cadastrado!");

    }

    public boolean verificarEmailValidoVendedor(String emailVendedor) {
        if (emailVendedor.contains("@")) {
            return true;
        }
        return false;
    }

    public boolean verificarEmailRepetidoVendedor(String emailVendedor) {
        if (vendedores.size() == 0) return false;

        for (Vendedor email : vendedores) {
            if (email.getEmail().equalsIgnoreCase(emailVendedor)) {
                return true;
            }

        }
        return false;
    }

    public boolean verificarCPFrepetidoVendedor(String cpfVendedor) {
        if (vendedores.size() == 0) return false;
        for (Vendedor cpf : vendedores) {
            if (cpf.getCpf().equalsIgnoreCase(cpfVendedor)) {
                return true;
            }
        }
        return false;
    }

    public void exibirVendedores() {
        for (Vendedor vendedor : vendedores) {
            String saida = vendedor.toString();
            System.out.println(saida);
        }

    }

    public void cadastroVendas(String cpfCliente, String cpfVendedor, Produtos vendas)
            throws VerificacaoCliente, VerificacaoVendedor {
        if (!verificarCliente(cpfCliente)){
            throw new VerificacaoCliente("Não há registro desse cliente, por favor Cadastrar cliente !");
        }
        if (!verificarVendedor(cpfVendedor)) {
            throw new VerificacaoVendedor("Não há registro desse vendedor, por favor Cadastrar vendedor!");
        }

        Cliente cliente = buscaClientePorCPF(cpfCliente);
        Vendedor vendedor = buscaVendedorPorCPF(cpfVendedor);

        if(cliente != null && vendedor != null){
            Pedido pedido = new Pedido(cliente,vendedor);
            pedido.adicionaProduto(vendas);
            pedidos.add(pedido);
            System.out.println("Venda Registrada com sucesso!");
        }
    }

    public boolean verificarCliente(String cpfCliente){
        if (cpfCliente == null){
            return false;
        }
        for (Cliente cliente:clientes) {
            if (cliente.getCpf().equalsIgnoreCase(cpfCliente)){
                return true;
            }
        }
        return false;
    }

    public boolean verificarVendedor(String cpfeVendedor){
        if (cpfeVendedor == null){
            return false;
        }
        for (Vendedor vendedor: vendedores){
            if (vendedor.getCpf().equalsIgnoreCase(cpfeVendedor)){
                return true;
            }
        }
        return false;
    }
    public void exibirVendas(){
        for (Pedido venda: pedidos) {
            String saida = venda.toString();
            System.out.println(saida);
        }
    }
    public Cliente buscaClientePorCPF(String cpfCliente){
        for (Cliente cliente : clientes){
            if (cliente.getCpf().equalsIgnoreCase(cpfCliente)){
                return cliente;
            }
        }
        return null;
    }

    public Vendedor buscaVendedorPorCPF(String cpfVendedor){
        for (Vendedor vendedor : vendedores){
            if (vendedor.getCpf().equalsIgnoreCase(cpfVendedor)){
                return vendedor;
            }
        }
        return null;
    }
    public void pesquisarCompraPorCLienteCPF(String cpfCliente){
        for (Pedido pedido : pedidos){
            if (pedido.getCliente() != null && pedido.getCliente().getCpf().equalsIgnoreCase(cpfCliente)){
                pedidosporClientes.add(pedido);


            }
        }

    }
    public void exibirCompraCLiente(){
        for (Pedido pedido : pedidosporClientes){
            String saida = pedido.toString();
            System.out.println(saida);
        }
    }

    public void pesquisarVendaVendedorEmail(String email){
        pedidosporVendedor.clear();
        for (Pedido pedido : pedidos){
            if (pedido.getVendedor() != null && pedido.getVendedor().getEmail().equalsIgnoreCase(email)){
                pedidosporVendedor.add(pedido);
            }
        }

    }

    public void exibirVendasCLientes(){
        pedidosporClientes.clear();
        for (Pedido pedido : pedidosporVendedor){
            String saida = pedido.toString();
            System.out.println(saida);
        }
    }
}

