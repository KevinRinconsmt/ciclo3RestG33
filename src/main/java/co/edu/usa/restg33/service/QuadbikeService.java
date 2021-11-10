/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.restg33.service;

import co.edu.usa.restg33.model.Quadbike;
import co.edu.usa.restg33.repository.QuadbikeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kevin
 */
@Service
public class QuadbikeService {
    
    @Autowired
    private QuadbikeRepository quadbikeRepository;
    
    public List<Quadbike> getAll(){
        return quadbikeRepository.getAll();
    }
    
    public Optional<Quadbike> getQuadbike (int id){
        return quadbikeRepository.getQuadbike(id);
    }
    
    public Quadbike save(Quadbike quadbike){
        if (quadbike.getId()==null) {
            return quadbikeRepository.save(quadbike);
        }else{
            Optional<Quadbike> paux = quadbikeRepository.getQuadbike(quadbike.getId());
            if (!paux.isPresent()) {
                return quadbikeRepository.save(quadbike);
            }else{
                return quadbike;
            }
        }
    }
    
    public Quadbike update (Quadbike quadbike){
        if (quadbike.getId()!=null) {
            Optional<Quadbike> comprobacion = quadbikeRepository.getQuadbike(quadbike.getId());
            if (comprobacion.isPresent()) {
                if (quadbike.getName()!=null) {
                    comprobacion.get().setName(quadbike.getName());
                }
                if (quadbike.getBrand()!=null) {
                    comprobacion.get().setBrand(quadbike.getBrand());
                }
                if (quadbike.getYear()!=null) {
                    comprobacion.get().setYear(quadbike.getYear());
                }
                if (quadbike.getDescription()!=null) {
                    comprobacion.get().setDescription(quadbike.getDescription());
                }
                if (quadbike.getCategory()!=null) {
                    comprobacion.get().setCategory(quadbike.getCategory());
                }
           
                if (quadbike.getMessages()!=null) {
                    comprobacion.get().setMessages(quadbike.getMessages());
                }
                if (quadbike.getReservations()!=null) {
                    comprobacion.get().setReservations(quadbike.getReservations());
                }
                
                return quadbikeRepository.save(comprobacion.get());
            }
        }
        return quadbike;
    }
    
    public boolean deleteQuadbike(int id){
        Optional<Quadbike> quadbike = quadbikeRepository.getQuadbike(id);
        if (quadbike.isPresent()) {
            quadbikeRepository.delete(quadbike.get());
            return true;
        }
        return false;
    }
}
