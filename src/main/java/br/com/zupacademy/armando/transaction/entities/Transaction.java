package br.com.zupacademy.armando.transaction.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_transaction")
public class Transaction {

    @Id
    private String id;

    @NotNull
    @Column(nullable = false, columnDefinition = "decimal", scale = 10, precision = 2)
    private BigDecimal amount;

    @NotBlank
    @Column(nullable = false)
    private String locationName;

    @NotBlank
    @Column(nullable = false)
    private String locationCity;

    @NotBlank
    @Column(nullable = false)
    private String locationAddress;

    @NotBlank
    @Column(nullable = false)
    private String cardId;

    @NotBlank
    @Column(nullable = false)
    private String cardEmail;

    @NotNull
    @Column(nullable = false, columnDefinition = "datetime")
    private LocalDateTime effectIn;

    @Deprecated
    public Transaction() {
    }

    public Transaction(String id,
                       BigDecimal amount,
                       String locationName,
                       String locationCity,
                       String locationAddress,
                       String cardId,
                       String cardEmail,
                       LocalDateTime effectIn) {
        this.id = id;
        this.amount = amount;
        this.locationName = locationName;
        this.locationCity = locationCity;
        this.locationAddress = locationAddress;
        this.cardId = cardId;
        this.cardEmail = cardEmail;
        this.effectIn = effectIn;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getLocationName() {
        return locationName;
    }

    public String getLocationCity() {
        return locationCity;
    }

    public String getLocationAddress() {
        return locationAddress;
    }

    public String getCardId() {
        return cardId;
    }

    public String getCardEmail() {
        return cardEmail;
    }

    public LocalDateTime getEffectIn() {
        return effectIn;
    }
}
