package pu.plovdiv.fmi.ToyStorePeni.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pu.plovdiv.fmi.ToyStorePeni.Entity.Buyer;
import pu.plovdiv.fmi.ToyStorePeni.Service.BuyerService;

import java.util.List;

@RestController
@RequestMapping("/api/buyers")
public class BuyerController {

    @Autowired
    private BuyerService buyerService;


    @GetMapping
    public List<Buyer> getAllBuyers() {
        return buyerService.getAllBuyers();
    }



    @GetMapping("/{id}")
    public ResponseEntity<Buyer> getBuyerById(@PathVariable Long id) {
        Buyer buyer = buyerService.getBuyerById(id);
        if (buyer != null) {
            return ResponseEntity.ok(buyer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



    @PostMapping
    public ResponseEntity<Buyer> createBuyer(@RequestBody Buyer buyer) {
        Buyer newBuyer = buyerService.createBuyer(buyer);
        return ResponseEntity.ok(newBuyer);
    }



    @PutMapping("/{id}")
    public ResponseEntity<Buyer> updateBuyer(@PathVariable Long id, @RequestBody Buyer buyerDetails) {
        Buyer updatedBuyer = buyerService.updateBuyer(id, buyerDetails);
        if (updatedBuyer != null) {
            return ResponseEntity.ok(updatedBuyer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBuyer(@PathVariable Long id) {
        buyerService.deleteBuyer(id);
        return ResponseEntity.noContent().build();
    }

}
