package BoletoClass;

import EntitiesClass.entities;

public class Boleto {
    private entities beneficiario;
    private entities sacado;
    private Titulos titulo = new Titulos();
    private ContaBancaria conta;
    private Banco banco;
    private String linhaDigitavel;
    private String codigoBarras;
    private String numeroUnico = (int)(Math.random() * 99999) + 1 + "";

    // Getters e Setters

    public entities getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(entities beneficiario) {
        this.beneficiario = beneficiario;
    }

    public entities getSacado() {
        return sacado;
    }

    public void setSacado(entities sacado) {
        this.sacado = sacado;
    }

    public Titulos getTitulo() {
        return titulo;
    }

    public void setTitulo(Titulos titulo) {
        this.titulo = titulo;
    }

    public ContaBancaria getConta() {
        return conta;
    }

    public void setConta(ContaBancaria conta) {
        this.conta = conta;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public String getLinhaDigitavel() {
        return linhaDigitavel;
    }

    public void setLinhaDigitavel(String linhaDigitavel) {
        this.linhaDigitavel = linhaDigitavel;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getNumeroUnico() {
        return numeroUnico;
    }

    public void setNumeroUnico(String numeroUnico) {
        this.numeroUnico = numeroUnico;
    }

    // Método de resumo
    public void exibirResumo() {
        System.out.println("Boleto do banco: " + banco);
        System.out.println("Beneficiário: " + beneficiario);
        System.out.println("Sacado: " + sacado);
        System.out.println("Vencimento: " + titulo);
        System.out.println("Valor: R$ " + titulo.getDataVencimento());
        System.out.println("Linha Digitável: " + linhaDigitavel);
        System.out.println("Código de Barras: " + codigoBarras);
    }

    // toString manual (opcional, mas substitui o @ToString do Lombok)
    @Override
    public String toString() {
        return "Boleto{" +
                "beneficiario=" + beneficiario +
                ", sacado=" + sacado +
                ", titulo=" + titulo +
                ", conta=" + conta +
                ", banco=" + banco +
                ", linhaDigitavel='" + linhaDigitavel + '\'' +
                ", codigoBarras='" + codigoBarras + '\'' +
                ", numeroUnico='" + numeroUnico + '\'' +
                '}';
    }
}
