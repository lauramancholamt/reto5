
package com.ciclo4.reto.controlador;

import com.ciclo4.reto.modelo.Peripherals;
import com.ciclo4.reto.servicio.PeripheralsService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Andrea
 */
@RestController
@RequestMapping("/api/peripherals")
@CrossOrigin("*")
public class PeripheralsController {
    @Autowired
    private PeripheralsService peripheralsService;

    @GetMapping("/all")
    public List<Peripherals> getAll() {
        return peripheralsService.getAll();
    }

    @GetMapping("/{reference}")
    public Optional<Peripherals> getsupplements(@PathVariable("reference") String reference) {
        return peripheralsService.getsupplements(reference);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Peripherals create(@RequestBody Peripherals gadget) {
        return peripheralsService.create(gadget);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Peripherals update(@RequestBody Peripherals gadget) {
        return peripheralsService.update(gadget);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference) {
        return peripheralsService.delete(reference);
    }
    @GetMapping("/price/{price}")
    public List<Peripherals> findByPriceLessThanEqual(@PathVariable("price") double precio) {
        return peripheralsService.findByPriceLessThanEqual(precio);
    }

    @GetMapping("/description/{description}")
    public List<Peripherals> findByDescriptionLike(@PathVariable("description") String description) {
        return peripheralsService.findByDescriptionLike(description);
    }
}
