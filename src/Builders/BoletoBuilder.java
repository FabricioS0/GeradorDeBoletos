package Builders;
import BoletoClass.*;
import EntitiesClass.*;
import java.time.LocalDate;

public interface BoletoBuilder {
    void buildBeneficiario(entities beneficiario);
    void buildSacado(entities sacado);
    void buildTitulo(String numeroDocumento, LocalDate vencimento, double valor);
    void buildDadosBancarios(ContaBancaria contaBancaria);
    void buildBanco();

    Boleto getBoleto();

    String gerarCampoLivre(String agencia, String descricao, String numeroUnico, String carteira);
}
