package com.example.livestockmanagment.Controller;

import com.example.livestockmanagment.ApiResponce.ApiResponce;
import com.example.livestockmanagment.Model.Seller;
import com.example.livestockmanagment.Model.Transcation;
import com.example.livestockmanagment.Repository.TranscationRepository;
import com.example.livestockmanagment.Service.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/trans")
@RequiredArgsConstructor
public class TranscationController {
    private final TransactionService transactionService;

    @GetMapping("/get")
    public ResponseEntity getTrans() {
        return ResponseEntity.status(200).body(transactionService.getTransaction());
    }

    @PostMapping("/add")
    public ResponseEntity addTrans(@Valid @RequestBody Transcation transcation) {

        transactionService.addTransaction(transcation);
        return ResponseEntity.status(200).body(new ApiResponce("is added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTrans(@PathVariable Integer id, @Valid @RequestBody Transcation transcation) {
        transactionService.updateTransaction(id, transcation);
        return ResponseEntity.status(200).body(new ApiResponce("is Updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTrans(@PathVariable Integer id) {
        transactionService.deleteTransaction(id);
        return ResponseEntity.status(200).body(new ApiResponce("is deleted"));
    }

    @GetMapping("/alltrans/{buyerId}")
    public ResponseEntity allTrans(@PathVariable Integer buyerId) {
        return ResponseEntity.status(200).body(transactionService.allTrarnsaction(buyerId));
    }
    //12:All transactions sold on a specific date
    @GetMapping("/trandate/{date}")
    public ResponseEntity transByDate(@PathVariable LocalDate date){
        return ResponseEntity.status(200).body(transactionService.getTransactionByDate(date));
    }
    //13: Get All transaction complete
    @GetMapping("/tran/{status}")
    public ResponseEntity transByStatus(@PathVariable String status){
        return ResponseEntity.status(200).body(transactionService.getTransactionCom(status));
    }

}
