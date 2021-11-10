/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.restg33.repository;

import co.edu.usa.restg33.model.Category;
import co.edu.usa.restg33.repository.crud.CategoryCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kevin
 */
@Repository
public class CategoryRepository {
    
    @Autowired
    private CategoryCrudRepository CategoryCrudRepository;
    
    public List<Category> getAll(){
        return (List<Category>) CategoryCrudRepository.findAll();
    }
    
    public Optional<Category> getCategory(int id){
        return CategoryCrudRepository.findById(id);
    }
    
    public Category save (Category category){
        return CategoryCrudRepository.save(category);
    }
    
    public void delete(Category category){
        CategoryCrudRepository.delete(category);
    }
    
    public void deleteById(Integer id){
        CategoryCrudRepository.deleteById(id);
    }
}
