/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.restg33.repository;

import co.edu.usa.restg33.model.Message;
import co.edu.usa.restg33.repository.crud.MessageCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kevin
 */
@Repository
public class MessageRepository {
    
    @Autowired
    private MessageCrudRepository MessageCrudRepository;
    
    public List<Message> getAll(){
        return (List<Message>) MessageCrudRepository.findAll();
    }
    
    public Optional<Message> getMessage(int id){
        return MessageCrudRepository.findById(id);
    }
    
    public Message save(Message message){
        return MessageCrudRepository.save(message);
    }
    
    public void delete(Message message){
        MessageCrudRepository.delete(message);
    }
    
    public void deleteById(Integer id){
        MessageCrudRepository.deleteById(id);
    }
}
