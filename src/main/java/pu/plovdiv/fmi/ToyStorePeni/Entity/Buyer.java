package pu.plovdiv.fmi.ToyStorePeni.Entity;

import jakarta.persistence.*;
import pu.plovdiv.fmi.ToyStorePeni.Entity.Toy;

import java.util.Set;

@Entity
public class Buyer {


    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        public Long id;

        public String name;
        public String email;

        @ManyToMany
        @JoinTable(
                name = "buyer_toys",
                joinColumns = @JoinColumn(name = "buyer_id"),
                inverseJoinColumns = @JoinColumn(name = "toy_id")
        )
        private Set<Toy> toys;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Set<Toy> getToys() {
        return toys;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setToys(Set<Toy> toys) {
        this.toys = toys;
    }




}



