package BoletoClass;

import java.time.LocalDate;

public class Titulos {
    private String numeroDocumento;
    private LocalDate dataVencimento;
    private Double valor;


    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public Double getValor() {
        return valor;
    }


    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }


    @Override
    public String toString() {
        return "Titulo{" +
                "numeroDocumento='" + numeroDocumento + '\'' +
                ", dataVencimento=" + dataVencimento +
                ", valor=" + valor +
                '}';
    }
}
