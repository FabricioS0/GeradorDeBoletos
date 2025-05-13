package Builders;

import BoletoClass.*;
import EntitiesClass.*;
import BoletoClass.ContaBancaria;

import java.time.LocalDate;

public class BoletoBancoBrasil implements BoletoBuilder {
    private final Boleto boleto;

    public BoletoBancoBrasil() {
        this.boleto = new Boleto();
    }

    // Getter substituindo o @Getter do Lombok
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
        boleto.setBanco(Banco.BANCO_DO_BRASIL);
    }

    public String gerarCampoLivre(String agencia, String conta, String nossoNumero, String carteira) {
        return String.format("%04d%08d%011d%02d",
                Integer.parseInt(agencia),
                Integer.parseInt(conta),
                Long.parseLong(nossoNumero),
                Integer.parseInt(carteira));
    }
}
