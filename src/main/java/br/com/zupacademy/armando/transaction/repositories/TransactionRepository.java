package br.com.zupacademy.armando.transaction.repositories;

import br.com.zupacademy.armando.transaction.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {

    Optional<Transaction> findFirstByCardId(String cardId);

    List<Transaction> findTop10ByCardIdOrderByEffectInDesc(String cardId);

}
