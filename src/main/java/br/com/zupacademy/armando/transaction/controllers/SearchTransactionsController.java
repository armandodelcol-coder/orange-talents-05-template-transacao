package br.com.zupacademy.armando.transaction.controllers;

import br.com.zupacademy.armando.transaction.dtos.TransactionResponseDto;
import br.com.zupacademy.armando.transaction.entities.Transaction;
import br.com.zupacademy.armando.transaction.repositories.TransactionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class SearchTransactionsController {

    private TransactionRepository transactionRepository;

    public SearchTransactionsController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @GetMapping("/cartoes/{cardId}/transacoes")
    public ResponseEntity<List<TransactionResponseDto>> findLastTransactions(@PathVariable String cardId) {
        Optional<Transaction> foundByCardId = transactionRepository.findFirstByCardId(cardId);
        if (foundByCardId.isEmpty()) return ResponseEntity.notFound().build();

        List<TransactionResponseDto> lastTransactions = transactionRepository.findTop10ByCardIdOrderByEffectInDesc(cardId)
                .stream().map(TransactionResponseDto::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(lastTransactions);
    }

}
