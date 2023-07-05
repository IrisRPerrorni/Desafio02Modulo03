package EntregaMínima;

public class Cliente {
    private String nomeCliente;
    private String cpf;
    private String email;

    public Cliente(String nomeCliente, String cpf, String email) {
        this.nomeCliente = nomeCliente;
        this.cpf = cpf;
        this.email = email;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nomeCliente='" + nomeCliente + '\'' +
                ", cpf=" + cpf +
                ", email='" + email + '\'' +
                '}';
    }
}
