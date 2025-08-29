package desafio_itau_trasacao.desafio_itau_transacao.controller;

import desafio_itau_trasacao.desafio_itau_transacao.dto.StatisticReponse;
import desafio_itau_trasacao.desafio_itau_transacao.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.DoubleSummaryStatistics;

@RestController
@RequestMapping("/estatistica")

public class StatistcsController {

    private final TransactionService transactionService;

    public StatistcsController(TransactionService transactionService ) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public ResponseEntity<StatisticReponse> getMethodName(){
        DoubleSummaryStatistics stats = transactionService.getStatistics();
        return ResponseEntity.ok(new StatisticReponse(stats));
    }
}
