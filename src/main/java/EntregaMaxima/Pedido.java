package EntregaMaxima;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pedido {
    private Cliente cliente;
    private Vendedor vendedor;
    private List<Produtos> produtos = new ArrayList<>();

    public Pedido(Cliente cliente, Vendedor vendedor) {
        this.cliente = cliente;
        this.vendedor = vendedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public List<Produtos> getProdutos() {
        return produtos;
    }

    public void adicionaProduto(Produtos produto){
        produtos.add(produto);
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "cliente=" + cliente +
                ", vendedor=" + vendedor +
                ", produtos=" + produtos +
                '}';
    }
}
