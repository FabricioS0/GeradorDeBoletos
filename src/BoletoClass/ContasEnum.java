package BoletoClass;

public enum ContasEnum {
        CONTA_CORRENTE("Conta Corrente"),
        CONTA_POUPANCA("Conta Poupança");

        private final String descricao;

        ContasEnum(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }

        @Override
        public String toString() {
            return descricao;
        }
    }

