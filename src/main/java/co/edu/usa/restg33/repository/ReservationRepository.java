/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.restg33.repository;

import co.edu.usa.restg33.model.Client;
import co.edu.usa.restg33.model.Reservation;
import co.edu.usa.restg33.reports.CounterClient;
import co.edu.usa.restg33.repository.crud.ReservationCrudRepository;
import java.util.ArrayList;
import java.util.Date;
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
    
    public void delete(Reservation reservation){
        ReservationCrudRepository.delete(reservation);
    }
    
    public void deleteById(Integer id){
        ReservationCrudRepository.deleteById(id);
    }
    
    public List<Reservation> getReservationByStatus(String status){
        return ReservationCrudRepository.findAllByStatus(status);
    }
    
    public List<Reservation> getReservationPeriod (Date dateOne, Date dateTwo){
        return ReservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(dateOne, dateTwo);
    }
    
    public List<CounterClient> getTopClients (){
        List<CounterClient> res = new ArrayList<>();
        List<Object[]>report = ReservationCrudRepository.countTotalReservationByClient();
        for (int i = 0; i < report.size(); i++) {
            res.add(new CounterClient ((Long)report.get(i)[1],(Client) report.get(i)[0]));
            
        }
        return res;
    }
}
