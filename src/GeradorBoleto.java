import Builders.*;


import BoletoClass.*;
import EntitiesClass.*;



import java.time.LocalDate;

public class GeradorBoleto {
    private final BoletoBuilder builder;

    public GeradorBoleto(BoletoBuilder builder) {
        this.builder = builder;
    }

    public Boleto gerarBoleto(
            entities beneficiario,
            entities sacado,
            String numeroDocumento,
            LocalDate dataVencimento,
            double valor,
            String agencia,
            ContasEnum tipoConta,
            String carteira,
            String numeroConta
    ) {
        builder.buildBeneficiario(beneficiario);
        builder.buildSacado(sacado);
        builder.buildTitulo(numeroDocumento, dataVencimento, valor);

        ContaBancaria contaBancaria = new ContaBancaria();
        contaBancaria.setAgencia(agencia);
        contaBancaria.setTipoConta(tipoConta);
        contaBancaria.setCarteira(carteira);
        contaBancaria.setNumero(numeroConta);

        builder.buildDadosBancarios(contaBancaria);
        builder.buildBanco();

        builder.getBoleto().setLinhaDigitavel(CodigoBarra.gerarCodigoBarras(builder.getBoleto(), builder));
        builder.getBoleto().setCodigoBarras(CodigoBarra.gerarCodigoBarras(builder.getBoleto(), builder));
        return builder.getBoleto();

    }
}
