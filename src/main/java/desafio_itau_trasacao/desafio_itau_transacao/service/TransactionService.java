package desafio_itau_trasacao.desafio_itau_transacao.service;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.springframework.stereotype.Service;
import desafio_itau_trasacao.desafio_itau_transacao.entity.Transaction;

@Service

public class TransactionService {

    private final Queue<Transaction> transactions = new ConcurrentLinkedQueue<>();

    public boolean addTransaction(Transaction transaction ) {
        if (transaction.getValor() < 0 ||
        transaction.getDataHora().isAfter(OffsetDateTime.now())){
            return false;
        }
        transactions.add(transaction);
        return true;
    }

    public void clearTransaction(){
        transactions.clear();
    }

    public DoubleSummaryStatistics getStatistics() {
        OffsetDateTime now = OffsetDateTime.now();
        return transactions.stream()
                //.filter(t -> t.getDataHora().isAfter(now.minusSeconds(60)))
                .mapToDouble(Transaction:: getValor)
                .summaryStatistics();
    }
    
}
