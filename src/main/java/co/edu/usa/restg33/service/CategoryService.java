/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.restg33.service;

import co.edu.usa.restg33.model.Category;
import co.edu.usa.restg33.repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kevin
 */
@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository CategoryRepository;
    
    public List<Category> getAll(){
        return CategoryRepository.getAll();
    }
    
    public Optional<Category> getCategory (int id){
        return CategoryRepository.getCategory(id);
    }
    
    public Category save(Category category){
        if (category.getId()==null) {
            return CategoryRepository.save(category);
        }else{
            Optional<Category> paux = CategoryRepository.getCategory(category.getId());
            if (paux.isPresent()) {
                return CategoryRepository.save(category);
            }else{
                return category;
            }
        }
    }
    
    
    
}
