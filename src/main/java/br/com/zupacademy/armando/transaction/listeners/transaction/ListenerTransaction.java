package br.com.zupacademy.armando.transaction.listeners.transaction;

import br.com.zupacademy.armando.transaction.entities.Transaction;
import br.com.zupacademy.armando.transaction.repositories.TransactionRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.stereotype.Component;

@Component
public class ListenerTransaction {

    private TransactionRepository transactionRepository;

    public ListenerTransaction(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Bean
    JsonMessageConverter jsonMessageConverter() {
        return new JsonMessageConverter();
    }

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void listen(EventTransaction eventTransaction) {
        Transaction newTransaction =eventTransaction.toModel();
        transactionRepository.save(newTransaction);
    }

}