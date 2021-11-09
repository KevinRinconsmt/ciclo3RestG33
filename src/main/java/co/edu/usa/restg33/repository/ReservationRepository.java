/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.restg33.repository;

import co.edu.usa.restg33.model.Reservation;
import co.edu.usa.restg33.repository.crud.ReservationCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kevin
 */
@Repository
public class ReservationRepository {
    
    @Autowired
    private ReservationCrudRepository ReservationCrudRepository;
    
    public List<Reservation> getAll(){
        return (List<Reservation>) ReservationCrudRepository.findAll();
    }
    
    public Optional<Reservation> getReservation(int id){
        return ReservationCrudRepository.findById(id);
    }
    
    public Reservation save(Reservation reservation){
        return ReservationCrudRepository.save(reservation);
    }
}
