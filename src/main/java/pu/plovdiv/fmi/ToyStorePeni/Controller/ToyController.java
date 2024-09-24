package pu.plovdiv.fmi.ToyStorePeni.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pu.plovdiv.fmi.ToyStorePeni.Entity.Toy;
import pu.plovdiv.fmi.ToyStorePeni.Service.ToyService;

import java.util.List;

@RestController
@RequestMapping("/api/toys")

public class ToyController {

    @Autowired
    private ToyService toyService;

    @GetMapping
    public List<Toy> getAllToys() {
        return toyService.getAllToys();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Toy> getToyById(@PathVariable Long id) {
        Toy toy = toyService.getToyById(id);
        if (toy != null) {
            return ResponseEntity.ok(toy);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Toy> createToy(@RequestBody Toy toy) {
        Toy newToy = toyService.createToy(toy);
        return ResponseEntity.ok(newToy);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Toy> updateToy(@PathVariable Long id, @RequestBody Toy toyDetails) {
        Toy updatedToy = toyService.updateToy(id, toyDetails);
        if (updatedToy != null) {
            return ResponseEntity.ok(updatedToy);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteToy(@PathVariable Long id) {
        toyService.deleteToy(id);
        return ResponseEntity.noContent().build();
    }

}
