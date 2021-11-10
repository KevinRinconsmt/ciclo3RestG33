/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.restg33.service;

import co.edu.usa.restg33.model.Message;
import co.edu.usa.restg33.repository.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kevin
 */
@Service
public class MessageService {
    
    @Autowired
    private MessageRepository messageRepository;
    
    public List<Message> getAll(){
        return messageRepository.getAll();
    }
    
    public Optional<Message> getMessage (int id){
        return messageRepository.getMessage(id);
    }
    
    public Message save(Message message){
        if (message.getIdMessage()==null) {
            return messageRepository.save(message);
        }else{
            Optional<Message> paux = messageRepository.getMessage(message.getIdMessage());
            if (!paux.isPresent()) {
                return messageRepository.save(message);
            }else{
                return message;
            }
        }
    }
    
    public Message update (Message message){
        if (message.getIdMessage()!=null) {
            Optional<Message> comprobacion = messageRepository.getMessage(message.getIdMessage());
            if (comprobacion.isPresent()) {
                if (message.getMessageText()!=null) {
                    comprobacion.get().setMessageText(message.getMessageText());
                }
                if (message.getClient()!=null) {
                    comprobacion.get().setClient(message.getClient());
                }
                if (message.getQuadbike()!=null) {
                    comprobacion.get().setQuadbike(message.getQuadbike());
                }
                
                return messageRepository.save(comprobacion.get());
            }
        }
        return message;
    }
    
    public boolean deleteMessage(int id){
        Optional<Message> message = messageRepository.getMessage(id);
        if (message.isPresent()) {
            messageRepository.delete(message.get());
            return true;
        }
        return false;
    }

}
