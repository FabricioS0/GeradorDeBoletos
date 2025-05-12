package BoletoClass;

public class ContaBancaria {
    private String agencia;
    private String numero;
    private ContaEnum tipoConta;
    private String carteira;

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public void setTipoConta(ContaEnum tipoConta) {
        this.tipoConta = tipoConta;
    }

    public void setCarteira(String carteira) {
        this.carteira = carteira;
    }

    public String getAgencia() {
        return agencia;
    }

    public String getCarteira() {
        return carteira;
    }

    public ContaEnum getTipoConta() {
        return tipoConta;
    }

    public String getNumero() {
        return numero;
    }
}