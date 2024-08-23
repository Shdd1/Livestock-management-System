package com.example.livestockmanagment.Controller;

import com.example.livestockmanagment.ApiResponce.ApiResponce;
import com.example.livestockmanagment.Model.Seller;
import com.example.livestockmanagment.Service.SellerService;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/seller")
@RequiredArgsConstructor
public class SellerController {
    private final SellerService sellerService;
    @GetMapping("/get")
    public ResponseEntity getSeller(){
        return ResponseEntity.status(200).body(sellerService.getSeller());
    }
    @PostMapping("/add")
    public ResponseEntity addSeller(@Valid @RequestBody Seller seller){
        sellerService.addSeller(seller);
        return ResponseEntity.status(200).body(new ApiResponce("is added"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateSeller(@PathVariable Integer id,@Valid@RequestBody Seller seller){

        sellerService.updateSeller(id,seller);
        return ResponseEntity.status(200).body(new ApiResponce("is Updated"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteSeller(@PathVariable Integer id){
        sellerService.deleteSeller(id);
        return ResponseEntity.status(200).body(new ApiResponce("is deleted"));
    }

    //4:change status of transaction to complete
    @PutMapping("/change/{sellerId}/{transId}")
    public ResponseEntity changeStatus(@PathVariable Integer sellerId,@PathVariable Integer transId){
        sellerService.changeStatus(sellerId,transId);
        return ResponseEntity.status(200).body(new ApiResponce("is updated"));
    }
    //5:Transfer of ownership
    @PutMapping("/owner/{sellerId}/{liveId}/{tranId}")
    public ResponseEntity owner(@PathVariable Integer sellerId,@PathVariable Integer liveId,@PathVariable Integer tranId){
        sellerService.TransferOfOwnership(sellerId,liveId,tranId);
        return ResponseEntity.status(200).body(new ApiResponce("Ownership has been transferred successfully"));
    }
}
