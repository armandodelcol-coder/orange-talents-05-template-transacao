package br.com.zupacademy.armando.transaction.dtos;

import br.com.zupacademy.armando.transaction.entities.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionResponseDto {

    private String id;
    private BigDecimal amount;
    private String locationName;
    private String locationCity;
    private String locationAddress;
    private String cardId;
    private String cardEmail;
    private LocalDateTime effectIn;

    public TransactionResponseDto(Transaction transaction) {
        this.id = transaction.getId();
        this.amount = transaction.getAmount();
        this.locationName = transaction.getLocationName();
        this.locationCity = transaction.getLocationCity();
        this.locationAddress = transaction.getLocationAddress();
        this.cardId = transaction.getCardId();
        this.cardEmail = transaction.getCardEmail();
        this.effectIn = transaction.getEffectIn();
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
