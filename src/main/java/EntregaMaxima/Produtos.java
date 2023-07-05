package EntregaMaxima;

import java.time.LocalDate;

public class Produtos {
    private String nomeProduto;
    private double valor;
    private LocalDate dataRegistro;


    public Produtos(String nomeProduto, double valor, LocalDate dataRegistro) {
        this.nomeProduto = nomeProduto;
        this.valor = valor;
        this.dataRegistro = dataRegistro;

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


    @Override
    public String toString() {
        return "Produtos{" +
                "nomeProduto='" + nomeProduto + '\'' +
                ", valor=" + valor +
                ", dataRegistro=" + dataRegistro +
                '}';
    }
}
