package Builders;

import BoletoClass.*;
import EntitiesClass.*;

import java.time.LocalDate;

public class BoletoBradesco implements BoletoBuilder {
    private final Boleto boleto;

    public BoletoBradesco() {
        this.boleto = new Boleto();
    }


    public Boleto getBoleto() {
        return boleto;
    }

    public void buildBeneficiario(entities beneficiario) {
        boleto.setBeneficiario(beneficiario);
    }

    public void buildSacado(entities sacado) {
        boleto.setSacado(sacado);
    }

    public void buildTitulo(String numeroDocumento, LocalDate dataVencimento, double valor) {
        boleto.getTitulo().setNumeroDocumento(numeroDocumento);
        boleto.getTitulo().setDataVencimento(dataVencimento);
        boleto.getTitulo().setValor(valor);
    }

    public void buildDadosBancarios(ContaBancaria contaBancaria) {
        boleto.setConta(contaBancaria);
    }

    public void buildBanco() {
        boleto.setBanco(Banco.BRADESCO);
    }

    public String gerarCampoLivre(String agencia, String conta, String nossoNumero, String carteira) {
        return String.format("%04d%08d%011d%02d",
                Integer.parseInt(agencia),
                Integer.parseInt(conta),
                Long.parseLong(nossoNumero),
                Integer.parseInt(carteira));
    }
}