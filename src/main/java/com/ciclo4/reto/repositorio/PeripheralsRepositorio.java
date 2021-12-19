
package com.ciclo4.reto.repositorio;

import com.ciclo4.reto.interfaces.InterfacePeripherals;
import com.ciclo4.reto.modelo.Peripherals;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Andrea
 */
@Repository
public class PeripheralsRepositorio {
    @Autowired
    private InterfacePeripherals repository;

    public List<Peripherals> getAll() {
        return repository.findAll();
    }

    public Optional<Peripherals> getsupplements(String reference) {
        return repository.findById(reference);
    }

    public Peripherals create(Peripherals clothe) {
        return repository.save(clothe);
    }

    public void update(Peripherals clothe) {
        repository.save(clothe);
    }

    public void delete(Peripherals clothe) {
        repository.delete(clothe);
    }
    public List<Peripherals> findByPriceLessThanEqual(double precio) {
        return repository.findByPriceLessThanEqual(precio);
    }

    public List<Peripherals> findByDescriptionLike(String description) {
        return repository.findByDescriptionLike(description);
    }
}
