package pu.plovdiv.fmi.ToyStorePeni.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pu.plovdiv.fmi.ToyStorePeni.Entity.Toy;

public interface ToyRepository extends JpaRepository<Toy,Long> {

}
