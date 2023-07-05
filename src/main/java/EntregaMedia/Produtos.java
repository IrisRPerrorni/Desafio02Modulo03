package EntregaMedia;

import java.time.LocalDate;

public class Produtos {
    private String nomeProduto;
    private double valor;
    private LocalDate dataRegistro;
    private String nomeCliente;
    private String nomeVendedor;

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

    public double getValor() {
        return valor;
    }

    public LocalDate getDataRegistro() {
        return dataRegistro;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getNomeVendedor() {
        return nomeVendedor;
    }

    @Override
    public String toString() {
        return "Produtos{" +
                "nomeProduto='" + nomeProduto + '\'' +
                ", valor=" + valor +
                ", dataRegistro=" + dataRegistro +
                ", nomeCliente='" + nomeCliente + '\'' +
                ", nomeVendedor='" + nomeVendedor + '\'' +
                '}';
    }
}
