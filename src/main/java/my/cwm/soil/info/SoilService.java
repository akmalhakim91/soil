package my.cwm.soil.info;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class SoilService {
    final SoilRepository repo;

    public List<Soil> getAllSoil(){
        return this.repo.findAll();
        
    }

    public Soil save(Soil soil){
        return this.repo.save(soil);
    }

    public void delete(Long id){
        this.repo.deleteById(id);
    }

}
