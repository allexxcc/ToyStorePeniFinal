package pu.plovdiv.fmi.ToyStorePeni.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pu.plovdiv.fmi.ToyStorePeni.Entity.Buyer;

public interface BuyerRepository extends JpaRepository <Buyer, Long>  {

}
