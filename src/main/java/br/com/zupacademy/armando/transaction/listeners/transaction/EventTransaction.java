package br.com.zupacademy.armando.transaction.listeners.transaction;

import br.com.zupacademy.armando.transaction.entities.Transaction;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class EventTransaction {

    @JsonProperty
    private final String id;
    @JsonProperty
    private final BigDecimal valor;
    @JsonProperty
    private final Estabelecimento estabelecimento;
    @JsonProperty
    private final Cartao cartao;
    @JsonProperty
    private final LocalDateTime efetivadaEm;

    @JsonCreator
    public EventTransaction(
            @JsonProperty("id") String id,
            @JsonProperty("valor") BigDecimal valor,
            @JsonProperty("estabelecimento") Estabelecimento estabelecimento,
            @JsonProperty("cartao") Cartao cartao,
            @JsonProperty("efetivadaEm") LocalDateTime efetivadaEm
    ) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public Transaction toModel() {
        return new Transaction(
          this.id,
          this.valor,
          this.estabelecimento.nome,
          this.estabelecimento.cidade,
          this.estabelecimento.endereco,
          this.cartao.id,
          this.cartao.email,
          this.efetivadaEm
        );
    }

    private static class Estabelecimento {
        @JsonProperty
        private final String nome;
        @JsonProperty
        private final String cidade;
        @JsonProperty
        private final String endereco;

        @JsonCreator
        public Estabelecimento(
                @JsonProperty("nome") String nome,
                @JsonProperty("cidade") String cidade,
                @JsonProperty("endereco") String endereco
        ) {
            this.nome = nome;
            this.cidade = cidade;
            this.endereco = endereco;
        }

    }

    private static class Cartao {
        @JsonProperty
        private final String id;
        @JsonProperty
        private final String email;

        @JsonCreator
        public Cartao(
                @JsonProperty("id") String id,
                @JsonProperty("email") String email
        ) {
            this.id = id;
            this.email = email;
        }

    }

}
