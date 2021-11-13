/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.restg33.service;

import co.edu.usa.restg33.model.Reservation;
import co.edu.usa.restg33.reports.CounterClient;
import co.edu.usa.restg33.reports.StatusReservation;
import co.edu.usa.restg33.repository.ReservationRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kevin
 */
@Service
public class ReservationService {
    
    /**
     * 
     */
    @Autowired
    private ReservationRepository reservationRepository;
    
    /**
     * 
     * @return 
     */
    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }
    
    /**
     * 
     * @param id
     * @return 
     */
    public Optional<Reservation> getReservation (int id){
        return reservationRepository.getReservation(id);
    }
    
    /**
     * 
     * @param reservation
     * @return 
     */
    public Reservation save(Reservation reservation){
        if (reservation.getIdReservation()==null) {
            return reservationRepository.save(reservation);
        }else{
            Optional<Reservation> paux = reservationRepository.getReservation(reservation.getIdReservation());
            if (!paux.isPresent()) {
                return reservationRepository.save(reservation);
            }else{
                return reservation;
            }
        }
    }
    
    /**
     * 
     * @param reservation
     * @return 
     */
    public Reservation update (Reservation reservation){
        if (reservation.getIdReservation()!=null) {
            Optional<Reservation> comprobacion = reservationRepository.getReservation(reservation.getIdReservation());
            if (comprobacion.isPresent()) {
                if (reservation.getStartDate()!=null) {
                    comprobacion.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate()!=null) {
                    comprobacion.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getScore()!=null) {
                    comprobacion.get().setScore(reservation.getScore());
                }
                if (reservation.getStatus()!=null) {
                    comprobacion.get().setStatus(reservation.getStatus());
                }
                if (reservation.getQuadbike()!=null) {
                    comprobacion.get().setQuadbike(reservation.getQuadbike());
                }
                if (reservation.getClient()!=null) {
                    comprobacion.get().setClient(reservation.getClient());
                }
                
                return reservationRepository.save(comprobacion.get());
            }
        }
        return reservation;
    }
    
    /**
     * 
     * @param id
     * @return 
     */
    public boolean deleteReservation(int reservationId){
        Optional<Reservation> reservation = reservationRepository.getReservation(reservationId);
        if (reservation.isPresent()) {
            reservationRepository.delete(reservation.get());
            return true;
        }
        return false;
    }
    
    public StatusReservation getReservationStatusReport(){
        List<Reservation>completed = reservationRepository.getReservationByStatus("completed");
        List<Reservation> cancelled = reservationRepository.getReservationByStatus("cancelled");
        return new StatusReservation(completed.size(),cancelled.size());
    }
    
    public List<Reservation> getReservationPeriod(String dateOne, String dateTwo){
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date oneDate = new Date();
        Date twoDate = new Date();
        
        try{
            oneDate = parser.parse(dateOne);
            twoDate = parser.parse(dateTwo);
        }catch(ParseException evt){
            evt.printStackTrace();
        }
        if (oneDate.before(twoDate)) {
            return reservationRepository.getReservationPeriod(oneDate, twoDate);
            
        }else{
            return new ArrayList<>();
        }
    }
    
    public List<CounterClient> getTopClient (){
        return reservationRepository.getTopClients();
    }
}
