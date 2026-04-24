package biblioteca.models;

public class Cliente {
    private final int idCliente;
    private String nome;
    private String email;

    private static int contadorClienteId = 1;

    public Cliente (String nome, String email) {
        this.idCliente = contadorClienteId++;
        this.nome = nome;
        this.email = email;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
