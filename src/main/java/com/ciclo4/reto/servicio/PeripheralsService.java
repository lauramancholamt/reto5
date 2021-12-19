
package com.ciclo4.reto.servicio;

import com.ciclo4.reto.modelo.Peripherals;
import com.ciclo4.reto.repositorio.PeripheralsRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andrea
 */
@Service
public class PeripheralsService {
    @Autowired
    private PeripheralsRepositorio peripheralsRepository;

    public List<Peripherals> getAll() {
        return peripheralsRepository.getAll();
    }

    public Optional<Peripherals> getsupplements(String reference) {
        return peripheralsRepository.getsupplements(reference);
    }

    public Peripherals create(Peripherals accesory) {
        if (accesory.getReference() == null) {
            return accesory;
        } else {
            return peripheralsRepository.create(accesory);
        }
    }

    public Peripherals update(Peripherals supplements) {

        if (supplements.getReference() != null) {
            Optional<Peripherals> supplementDb = peripheralsRepository.getsupplements(supplements.getReference());
            if (!supplementDb.isEmpty()) {
                if (supplements.getBrand() != null) {
                    supplementDb.get().setBrand(supplements.getBrand());
                }
                if (supplements.getCategory() != null) {
                    supplementDb.get().setCategory(supplements.getCategory());
                }

                if (supplements.getDescription() != null) {
                    supplementDb.get().setDescription(supplements.getDescription());
                }
                if (supplements.getPrice() != 0.0) {
                    supplementDb.get().setPrice(supplements.getPrice());
                }
                if (supplements.getQuantity() != 0) {
                    supplementDb.get().setQuantity(supplements.getQuantity());
                }
                if (supplements.getPhotography() != null) {
                    supplementDb.get().setPhotography(supplements.getPhotography());
                }
                supplementDb.get().setAvailability(supplements.isAvailability());
                peripheralsRepository.update(supplementDb.get());
                return supplementDb.get();
            } else {
                return supplements;
            }
        } else {
            return supplements;
        }
    }


    public boolean delete(String reference) {
        return getsupplements(reference).map(accesory -> {
            peripheralsRepository.delete(accesory);
            return true;
        }).orElse(false);
    }

    public List<Peripherals>findByPriceLessThanEqual(double price) {
        return peripheralsRepository.findByPriceLessThanEqual(price);
    }

    public List<Peripherals> findByDescriptionLike(String description) {
        return peripheralsRepository.findByDescriptionLike(description);
    } 
}
