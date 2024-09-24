package pu.plovdiv.fmi.ToyStorePeni.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pu.plovdiv.fmi.ToyStorePeni.Entity.Supplier;

public interface SupplierRepository extends JpaRepository <Supplier, Long> {

}
