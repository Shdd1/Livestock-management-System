package com.example.livestockmanagment.Controller;

import com.example.livestockmanagment.ApiResponce.ApiResponce;
import com.example.livestockmanagment.Model.Buyer;
import com.example.livestockmanagment.Model.Seller;
import com.example.livestockmanagment.Service.BuyerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/buyer")
@RequiredArgsConstructor
public class BuyerController {
    private final BuyerService buyerService;

    @GetMapping("/get")
    public ResponseEntity getBuyer(){
        return ResponseEntity.status(200).body(buyerService.getBuyer());
    }
    @PostMapping("/add")
    public ResponseEntity addBuyer(@Valid @RequestBody Buyer buyer){

        buyerService.addBuyer(buyer);
        return ResponseEntity.status(200).body(new ApiResponce("is added"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateBuyer(@PathVariable Integer id,@Valid@RequestBody Buyer buyer){

        buyerService.updateBuyer(id,buyer);
        return ResponseEntity.status(200).body(new ApiResponce("is Updated"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBuyer(@PathVariable Integer id){
        buyerService.deleteBuyer(id);
        return ResponseEntity.status(200).body(new ApiResponce("is deleted"));
    }
//3:Buying
    @PutMapping("/buy/{buyId}/{farmId}/{liveId}")
    public ResponseEntity buyLive(@PathVariable Integer buyId,@PathVariable Integer farmId,@PathVariable Integer liveId){
        buyerService.buyLivestock(buyId,farmId,liveId);
        return ResponseEntity.status(200).body(new ApiResponce("Successful buying"));
    }
}
