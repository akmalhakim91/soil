package my.cwm.soil.info;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/soil")
@RequiredArgsConstructor

public class SoilController{
    final private SoilService svc;
    
    public String greeting = "hello";

    @GetMapping("")
    public String message(){
        return this.greeting;
    }

    @GetMapping("/1")
    public Soil getSoil(){
        Soil soil =new Soil();
        soil.setId(1l);
        soil.setName("Katerine");
        return soil;
    }


    @GetMapping("/all")
    public List<Soil> getAllSoil(){
        return this.svc.getAllSoil();
    }

    @Transactional
    @PostMapping("")
    public Soil save(@RequestBody Soil soil){
        return this.svc.save(soil);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        this.svc.delete(id);
    }

}