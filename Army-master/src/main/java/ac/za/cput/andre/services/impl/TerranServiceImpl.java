package ac.za.cput.andre.services.impl;

import ac.za.cput.andre.domain.Terran;
import ac.za.cput.andre.repository.TerranRepository;
import ac.za.cput.andre.services.TerranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/21.
 */
@Service
public class TerranServiceImpl implements TerranService {
    @Autowired
    TerranRepository repository;
    public List<Terran> getTerran()
    {

        List<Terran> allTerranArmies = new ArrayList<>();
        Iterable<Terran> values = repository.findAll();

        for (Terran terran : values)
            allTerranArmies.add(terran);
        return allTerranArmies;
    }

    public Terran getSingleTerran(Long id)
    {
        return repository.findOne(id);
    }


}
