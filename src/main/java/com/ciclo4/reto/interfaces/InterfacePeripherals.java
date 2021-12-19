
package com.ciclo4.reto.interfaces;

import com.ciclo4.reto.modelo.Peripherals;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author Andrea
 */
public interface InterfacePeripherals extends MongoRepository <Peripherals, String> {
    public List<Peripherals> findByPriceLessThanEqual(double precio);
    //Reto 5
    @Query("{'description':{'$regex':'?0','$options':'i'}}")
    public List<Peripherals> findByDescriptionLike(String description);
}
