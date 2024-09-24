package pu.plovdiv.fmi.ToyStorePeni.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pu.plovdiv.fmi.ToyStorePeni.Entity.Toy;
import pu.plovdiv.fmi.ToyStorePeni.Repository.ToyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ToyService {

    private final ToyRepository toyRepository;

    @Autowired
    public ToyService(ToyRepository toyRepository) {
        this.toyRepository = toyRepository;
    }

    public List<Toy> getAllToys() {
        return toyRepository.findAll();
    }

    public Toy getToyById(Long id) {
        Optional<Toy> toy = toyRepository.findById(id);
        return toy.orElse(null);
    }

    public Toy createToy(Toy toy) {
        return toyRepository.save(toy);
    }

    public Toy updateToy(Long id, Toy toyDetails) {
        if (toyRepository.existsById(id)) {
            toyDetails.setId(id);
            return toyRepository.save(toyDetails);
        } else {
            return null;
        }
    }

    public void deleteToy(Long id) {
        toyRepository.deleteById(id);
    }
}
