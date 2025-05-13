import BoletoClass.*;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BoletoPdf {

    public static void gerar(Boleto boleto, String caminho) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminho))) {
            writer.write("==============================================\n");
            writer.write("                  BOLETO BANCÁRIO              \n");
            writer.write("==============================================\n");
            writer.write("Banco: " + boleto.getBanco().getNome() + " (" + boleto.getBanco().getCodigo() + ")\n");
            writer.write("Linha Digitável: " + boleto.getLinhaDigitavel() + "\n");
            writer.write("Vencimento: " + formatDate(boleto.getTitulo().getDataVencimento()) + "\n");
            writer.write("----------------------------------------------\n");
            writer.write("Cedente: " + boleto.getBeneficiario().getNome() + "\n");
            writer.write("Agência/Cód. Cedente: " + boleto.getConta().getAgencia() + "\n");
            writer.write("----------------------------------------------\n");
            writer.write("Número do Documento: " + boleto.getTitulo().getNumeroDocumento() + "\n");
            writer.write("Nosso Número: " + boleto.getNumeroUnico() + "\n");
            writer.write("Valor: R$ " + boleto.getTitulo().getValor() + "\n");
            writer.write("----------------------------------------------\n");
            writer.write("Código de Barras: \n");
            writer.write(boleto.getCodigoBarras() + "\n");
            writer.write("==============================================\n");
            System.out.println("Boleto gerado com sucesso em: " + caminho);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String formatDate(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
