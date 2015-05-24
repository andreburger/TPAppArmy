package ac.za.cput.andre.api;

import ac.za.cput.andre.domain.Protoss;
import ac.za.cput.andre.domain.Terran;
import ac.za.cput.andre.domain.Zerg;
import ac.za.cput.andre.model.ProtossResource;
import ac.za.cput.andre.model.TerranResource;
import ac.za.cput.andre.model.ZergResource;
import ac.za.cput.andre.services.ProtossService;
import ac.za.cput.andre.services.TerranService;
import ac.za.cput.andre.services.ZergService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.hateoas.Link;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/24.
 */
@RestController
@RequestMapping("api/home/**")
public class DisplayArmies {

    @Autowired
    private TerranService serviceT;
    @Autowired
    private ProtossService serviceP;
    @Autowired
    private ZergService serviceZ;


    @RequestMapping(value="/Terran/{id}", method= RequestMethod.GET)
    public Terran getSingleTerran(@PathVariable Long id) {

        return serviceT.getSingleTerran(id);
    }

    @RequestMapping(value = "/Terran", method = RequestMethod.GET)
    public List<TerranResource> getTerran(){
        List<TerranResource> hatoes = new ArrayList<>();
        List<Terran> ter = serviceT.getTerran();
        for(Terran terran: ter)
        {
            TerranResource res = new TerranResource
                    .Builder(terran.getArmyName())
                    .resid(terran.getID())
                    .build();

            Link link = new Link("http://localhost:8080/api/home/Terran/"+res.getResID().toString()).withRel("depts");
            res.add(link);
            hatoes.add(res);
        }

        return hatoes;
    }

    @RequestMapping(value="/Zerg/{id}", method= RequestMethod.GET)
    public Zerg getSingleZerg(@PathVariable Long id) {

        return serviceZ.getSingleZerg(id);
    }

    @RequestMapping(value = "/Zerg", method = RequestMethod.GET)
    public List<ZergResource> getZerg(){
        List<ZergResource> hatoes = new ArrayList<>();
        List<Zerg> zer = serviceZ.getZerg();
        for(Zerg zerg: zer)
        {
            ZergResource res = new ZergResource
                    .Builder(zerg.getArmyName())
                    .resid(zerg.getID())
                    .build();

            Link link = new Link("http://localhost:8080/api/home/Zerg/"+res.getResID().toString()).withRel("depts");
            res.add(link);
            hatoes.add(res);
        }

        return hatoes;
    }

   @RequestMapping(value="/Protoss/{id}", method= RequestMethod.GET)
    public Protoss getSingleProtoss(@PathVariable Long id) {

        return serviceP.getSingleProtoss(id);
    }

    @RequestMapping(value = "/Protoss", method = RequestMethod.GET)
    public List<ProtossResource> getProtoss(){
        List<ProtossResource> hatoes = new ArrayList<>();
        List<Protoss> pro = serviceP.getProtoss();
        for(Protoss protoss: pro)
        {
            ProtossResource res = new ProtossResource
                    .Builder(protoss.getArmyName())
                    .resid(protoss.getID())
                    .build();

            Link link = new Link("http://localhost:8080/api/home/Protoss/"+res.getResID().toString()).withRel("depts");
            res.add(link);
            hatoes.add(res);
        }

        return hatoes;
    }
}
