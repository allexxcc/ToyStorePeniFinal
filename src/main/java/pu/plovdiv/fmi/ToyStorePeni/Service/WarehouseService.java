package pu.plovdiv.fmi.ToyStorePeni.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pu.plovdiv.fmi.ToyStorePeni.Entity.Warehouse;
import pu.plovdiv.fmi.ToyStorePeni.Repository.WarehouseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseService {
    private final WarehouseRepository warehouseRepository;

    @Autowired
    public WarehouseService(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    public List<Warehouse> getAllWarehouses() {
        return warehouseRepository.findAll();
    }

    public Warehouse getWarehouseById(Long id) {
        Optional<Warehouse> warehouse = warehouseRepository.findById(id);
        return warehouse.orElse(null);
    }

    public Warehouse createWarehouse(Warehouse warehouse) {
        return warehouseRepository.save(warehouse);
    }

    public Warehouse updateWarehouse(Long id, Warehouse warehouseDetails) {
        if (warehouseRepository.existsById(id)) {
            warehouseDetails.setId(id);
            return warehouseRepository.save(warehouseDetails);
        } else {
            return null;
        }
    }

    public void deleteWarehouse(Long id) {
        warehouseRepository.deleteById(id);
    }

}
