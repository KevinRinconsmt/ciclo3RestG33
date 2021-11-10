/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.restg33.repository;

import co.edu.usa.restg33.model.Quadbike;
import co.edu.usa.restg33.repository.crud.QuadbikeCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kevin
 */
@Repository
public class QuadbikeRepository {
    
    @Autowired
    private QuadbikeCrudRepository QuadbikeCrudRepository;
    
    public List<Quadbike> getAll(){
        return (List<Quadbike>) QuadbikeCrudRepository.findAll();
    }
    
    public Optional<Quadbike> getQuadbike(int id){
        return QuadbikeCrudRepository.findById(id);
    }
    
    public Quadbike save(Quadbike quadbike){
        return QuadbikeCrudRepository.save(quadbike);
    }
    
    public void delete(Quadbike quadbike){
        QuadbikeCrudRepository.delete(quadbike);
    }
    
    public void deleteById(Integer id){
        QuadbikeCrudRepository.deleteById(id);
    }
    
}
