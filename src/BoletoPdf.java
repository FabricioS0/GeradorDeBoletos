
import itextpdf.text.*;
import itextpdf.text.pdf.*;
import BoletoClass.*;

import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BoletoPdf{

    public static void gerar(Boleto boleto, String caminho) {
        try {
            Document document = new Document(PageSize.A4);
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(caminho));
            document.open();

            Font titulo = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);
            Font texto = new Font(Font.FontFamily.HELVETICA, 10);
            Font campo = new Font(Font.FontFamily.HELVETICA, 9);

            PdfPTable cabecalho = new PdfPTable(new float[]{2, 6, 2});
            cabecalho.setWidthPercentage(100);
            cabecalho.setSpacingAfter(8f);
            cabecalho.addCell(celula(boleto.getBanco().getNome() + " " + boleto.getBanco().getCodigo(), titulo, Element.ALIGN_CENTER));
            cabecalho.addCell(celula(boleto.getLinhaDigitavel(), texto, Element.ALIGN_CENTER));
            cabecalho.addCell(celula("Vencimento:\n" + formatDate(boleto.getTitulo().getDataVencimento()), texto, Element.ALIGN_CENTER));
            document.add(cabecalho);

            PdfPTable cedente = new PdfPTable(new float[]{7, 3});
            cedente.setWidthPercentage(100);
            cedente.addCell(celula("Cedente: " + boleto.getBeneficiario().getNome(), campo, Element.ALIGN_LEFT));
            cedente.addCell(celula("Agência/Cód. Cedente: " + boleto.getConta().getAgencia(), campo, Element.ALIGN_LEFT));
            document.add(cedente);

            PdfPTable info = new PdfPTable(new float[]{2, 2, 2});
            info.setWidthPercentage(100);
            addCampo(info, "Número do documento", boleto.getTitulo().getNumeroDocumento());
            addCampo(info, "Nosso número", boleto.getNumeroUnico());
            addCampo(info, "Valor", "R$ " + boleto.getTitulo().getValor());
            document.add(info);

            PdfContentByte cb = writer.getDirectContent();
            BarcodeInter25 barcode = new BarcodeInter25();
            String codigo = boleto.getCodigoBarras();
            if (codigo.length() < 44) {
                codigo = String.format("%044d", Long.parseLong(codigo));
            } else if (codigo.length() > 44) {
                codigo = codigo.substring(codigo.length() - 44);
            }
            barcode.setCode(codigo);
            barcode.setBarHeight(40f);
            barcode.setX(1.2f);

            Image img = barcode.createImageWithBarcode(cb, null, null);
            img.setAlignment(Element.ALIGN_CENTER);
            document.add(img);

            document.close();
            writer.close();
            System.out.println("PDF gerado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static PdfPCell celula(String texto, Font fonte, int alinhamento) {
        PdfPCell cell = new PdfPCell(new Phrase(texto, fonte));
        cell.setPadding(5);
        cell.setHorizontalAlignment(alinhamento);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        return cell;
    }

    private static void addCampo(PdfPTable tabela, String label, String valor) {
        PdfPCell cell = new PdfPCell();
        Paragraph p = new Paragraph();
        p.setFont(new Font(Font.FontFamily.HELVETICA, 8));
        p.add(new Chunk(label + "\n", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 7)));
        p.add(new Chunk(valor));
        cell.setPadding(4);
        cell.addElement(p);
        tabela.addCell(cell);
    }

    private static String formatDate(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
