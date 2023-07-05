package EntregaMínima;

import java.time.LocalDate;
public class Produtos {
    private String nomeProduto;
//    private Cliente cliente;
//    private Vendedor vendedor;
    private double valor ;
    private LocalDate dataRegistro;
    private String nomeCliente;
    private String nomeVendedor;

//    public Produtos(String nomeProduto, Cliente cliente, Vendedor vendedor, double valor, LocalDate dataRegistro) {
//        this.nomeProduto = nomeProduto;
//        this.cliente = cliente;
//        this.vendedor = vendedor;
//        this.valor = valor;
//        this.dataRegistro = dataRegistro;
//    }


    public Produtos(String nomeProduto, double valor, LocalDate dataRegistro, String nomeCliente, String nomeVendedor) {
        this.nomeProduto = nomeProduto;
        this.valor = valor;
        this.dataRegistro = dataRegistro;
        this.nomeCliente = nomeCliente;
        this.nomeVendedor = nomeVendedor;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

//    public Cliente getCliente() {
//        return cliente;
//    }

//    public Vendedor getVendedor() {
//        return vendedor;
//    }

    public double getValor() {
        return valor;
    }

    public LocalDate getDataRegistro() {
        return dataRegistro;
    }

    @Override
    public String toString() {
        return "Produtos{" +
                "nomeProduto='" + nomeProduto + '\'' +
//                ", cliente=" + cliente +
//                ", vendedor=" + vendedor +
                ", valor=" + valor +
                ", dataRegistro=" + dataRegistro +
                '}';
    }
}
