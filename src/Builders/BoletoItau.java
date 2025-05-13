package Builders;

import BoletoClass.*;
import EntitiesClass.*;


import java.time.LocalDate;

public class BoletoItau implements BoletoBuilder {
    private final Boleto boleto;

    public BoletoItau() {
        this.boleto = new Boleto();
    }

    @Override
    public void buildBeneficiario(entities beneficiario) {
        boleto.setBeneficiario(beneficiario);
    }

    @Override
    public void buildSacado(entities sacado) {
        boleto.setSacado(sacado);
    }

    @Override
    public void buildTitulo(String doc, LocalDate vencimento, double valor) {
        boleto.getTitulo().setNumeroDocumento(doc);
        boleto.getTitulo().setDataVencimento(vencimento);
        boleto.getTitulo().setValor(valor);
    }

    @Override
    public void buildDadosBancarios(ContaBancaria contaBancaria) {
        boleto.setConta(contaBancaria);
    }

    @Override
    public void buildBanco() {
        boleto.setBanco(Banco.ITAU);
    }

    public String gerarCampoLivre(String agencia, String conta, String nossoNumero, String carteira) {
        return String.format("%04d%08d%011d%02d",
                Integer.parseInt(agencia),
                Integer.parseInt(conta),
                Long.parseLong(nossoNumero),
                Integer.parseInt(carteira));
    }

    @Override
    public Boleto getBoleto() {
        return this.boleto;
    }
}

