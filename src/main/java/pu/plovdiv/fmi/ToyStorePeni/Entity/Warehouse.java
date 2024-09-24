package pu.plovdiv.fmi.ToyStorePeni.Entity;

import jakarta.persistence.*;
import pu.plovdiv.fmi.ToyStorePeni.Entity.Toy;

import java.util.Set;

@Entity
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String location;
    private Integer capacity;

    @OneToMany(mappedBy = "warehouse")
    private Set<Toy> toys;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Set<Toy> getToys() {
        return toys;
    }



    public void setToys(Set<Toy> toys) {
        this.toys = toys;
    }
}
