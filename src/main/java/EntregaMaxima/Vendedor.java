package EntregaMaxima;

public class Vendedor {
    public String nomeVendedor;
    public String email;
    public String cpf;

    public Vendedor(String nomeVendedor, String email, String cpf) {
        this.nomeVendedor = nomeVendedor;
        this.email = email;
        this.cpf = cpf;
    }

    public String getNomeVendedor() {
        return nomeVendedor;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return "Vendedor{" +
                "nomeVendedor='" + nomeVendedor + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
