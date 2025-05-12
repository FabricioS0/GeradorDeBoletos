package EntitiesClass;

public class entities {
    private String nome;
    private String razaoSocial;
    private String cnpjOrCpf;
    private Enderecos enderecos;

    // Getters
    public String getNome() {
        return nome;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public String getCnpjOrCpf() {
        return cnpjOrCpf;
    }

    public Enderecos getEndereco() {
        return enderecos;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public void setCnpjOrCpf(String cnpjOrCpf) {
        this.cnpjOrCpf = cnpjOrCpf;
    }

    public void setEndereco(Enderecos enderecos) {
        this.enderecos = enderecos;
    }

    // toString
    @Override
    public String toString() {
        return "Entidade{" +
                "nome='" + nome + '\'' +
                ", razaoSocial='" + razaoSocial + '\'' +
                ", cnpjOrCpf='" + cnpjOrCpf + '\'' +
                ", endereco=" + enderecos +
                '}';
    }
}
