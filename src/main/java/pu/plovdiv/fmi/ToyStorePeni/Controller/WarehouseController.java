package pu.plovdiv.fmi.ToyStorePeni.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pu.plovdiv.fmi.ToyStorePeni.Entity.Warehouse;
import pu.plovdiv.fmi.ToyStorePeni.Service.WarehouseService;

import java.util.List;

@RestController
@RequestMapping("/api/warehouses")

public class WarehouseController {
    @Autowired
    private WarehouseService warehouseService;


    @GetMapping
    public List<Warehouse> getAllWarehouses() {
        return warehouseService.getAllWarehouses();


    }


    @GetMapping("/{id}")
    public ResponseEntity<Warehouse> getWarehouseById(@PathVariable Long id) {
        Warehouse warehouse = warehouseService.getWarehouseById(id);
        if (warehouse != null) {
            return ResponseEntity.ok(warehouse);
        } else {
            return ResponseEntity.notFound().build();

        }
    }


    @PostMapping
    public ResponseEntity<Warehouse> createWarehouse(@RequestBody Warehouse warehouse) {
        Warehouse newWarehouse = warehouseService.createWarehouse(warehouse);
        return ResponseEntity.ok(newWarehouse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Warehouse> updateWarehouse(@PathVariable Long id, @RequestBody Warehouse warehouseDetails) {
        Warehouse updatedWarehouse = warehouseService.updateWarehouse(id, warehouseDetails);
        if (updatedWarehouse != null) {
            return ResponseEntity.ok(updatedWarehouse);
        } else {
            return ResponseEntity.notFound().build();

        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWarehouse(@PathVariable Long id) {
        warehouseService.deleteWarehouse(id);
        return ResponseEntity.noContent().build();


    }
}
