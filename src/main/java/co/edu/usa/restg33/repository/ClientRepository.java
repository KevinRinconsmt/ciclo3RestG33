/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.restg33.repository;

import co.edu.usa.restg33.model.Client;
import co.edu.usa.restg33.repository.crud.ClientCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kevin
 */
@Repository
public class ClientRepository {
    
    @Autowired
    private ClientCrudRepository ClientCrudRepository;
    
    public List<Client> getAll(){
        return (List<Client>) ClientCrudRepository.findAll();
    }
    
    public Optional<Client> getClient(int id){
        return ClientCrudRepository.findById(id);
    }
    
    public Client save(Client client){
        return ClientCrudRepository.save(client);
    }
    
    public void delete(Client client){
        ClientCrudRepository.delete(client);
    }
    
    public void deleteById(Integer id){
        ClientCrudRepository.deleteById(id);
    }
}
