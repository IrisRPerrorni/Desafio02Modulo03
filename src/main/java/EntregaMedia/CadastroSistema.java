package EntregaMedia;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CadastroSistema {
    private List<Cliente> clientes;
    private List<Vendedor> vendedores;
    private List<Produtos> produtosDeVendas;

    public CadastroSistema() {
        this.clientes = new ArrayList<Cliente>();
        this.vendedores = new ArrayList<Vendedor>();
        this.produtosDeVendas = new ArrayList<Produtos>();

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
        produtosDeVendas.add(vendas);
        System.out.println("Venda Registrada com sucesso!");
    }

    public boolean verificarCliente(String nomeCliente){
        if (nomeCliente == null){
            return false;
        }
        for (Cliente cliente:clientes) {
            if (cliente.getNomeCliente().equalsIgnoreCase(nomeCliente)){
                return true;
            }
        }
        return false;
    }

    public boolean verificarVendedor(String nomeVendedor){
        if (nomeVendedor == null){
            return false;
        }
        for (Vendedor vendedor: vendedores){
            if (vendedor.getNomeVendedor().equalsIgnoreCase(nomeVendedor)){
                return true;
            }
        }
        return false;
    }
    public void exibirVendas(){
        for (Produtos venda: produtosDeVendas) {
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




}

