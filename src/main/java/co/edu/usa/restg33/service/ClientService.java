/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.restg33.service;

import co.edu.usa.restg33.model.Client;
import co.edu.usa.restg33.repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kevin
 */
@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;
    
    public List<Client> getAll(){
        return clientRepository.getAll();
    }
    
    public Optional<Client> getClient (int id){
        return clientRepository.getClient(id);
    }
    
    public Client save(Client client){
        if (client.getIdClient()==null) {
            return clientRepository.save(client);
        }else{
            Optional<Client> paux = clientRepository.getClient(client.getIdClient());
            if (!paux.isPresent()) {
                return clientRepository.save(client);
            }else{
                return client;
            }
        }
    }
    
    public Client update (Client client){
        if (client.getIdClient()!=null) {
            Optional<Client> comprobacion = clientRepository.getClient(client.getIdClient());
            if (comprobacion.isPresent()) {
                if (client.getName()!=null) {
                    comprobacion.get().setName(client.getName());
                }
                if (client.getEmail()!=null) {
                    comprobacion.get().setEmail(client.getEmail());
                }
                if (client.getPassword()!=null) {
                    comprobacion.get().setPassword(client.getPassword());
                }
                if (client.getAge()!=null) {
                    comprobacion.get().setAge(client.getAge());
                }
                if (client.getMessages()!=null) {
                    comprobacion.get().setMessages(client.getMessages());
                }
                if (client.getReservations()!=null) {
                    comprobacion.get().setReservations(client.getReservations());
                }
                
                return clientRepository.save(comprobacion.get());
            }
        }
        return client;
    }
    
    public boolean deleteClient(int id){
        Optional<Client> client = clientRepository.getClient(id);
        if (client.isPresent()) {
            clientRepository.delete(client.get());
            return true;
        }
        return false;
    }
}
