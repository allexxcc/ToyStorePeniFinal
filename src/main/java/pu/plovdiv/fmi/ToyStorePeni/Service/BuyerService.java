package pu.plovdiv.fmi.ToyStorePeni.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pu.plovdiv.fmi.ToyStorePeni.Entity.Buyer;
import pu.plovdiv.fmi.ToyStorePeni.Repository.BuyerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BuyerService {
    private final BuyerRepository buyerRepository;

    @Autowired
    public BuyerService(BuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
    }

    public List<Buyer> getAllBuyers() {
        return buyerRepository.findAll();
    }

    public Buyer getBuyerById(Long id) {
        Optional<Buyer> buyer = buyerRepository.findById(id);
        return buyer.orElse(null);
    }

    public Buyer createBuyer(Buyer buyer) {
        return buyerRepository.save(buyer);
    }

    public Buyer updateBuyer(Long id, Buyer buyerDetails) {
        if (buyerRepository.existsById(id)) {
            buyerDetails.setId(id);
            return buyerRepository.save(buyerDetails);
        } else {
            return null;
        }
    }

    public void deleteBuyer(Long id) {
        buyerRepository.deleteById(id);

    }
}
