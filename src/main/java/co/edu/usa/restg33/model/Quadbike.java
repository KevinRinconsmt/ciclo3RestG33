/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.restg33.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Clase Motorbike.java
 * Permite crear la tabla Motorbike, crear los atributos, crear las relaciones de
 * esta tabla con las tablas categorias, message y reservations
 * y los metodos para recuperar los valores de los atributos y asignar valores
 * @author kevin
 */
@Entity
@Table(name= "Quadbike")
public class Quadbike implements Serializable {
    
    /**
     * id de la cuatrimoto
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * Nombre de la cuatrimoto
     */
    private String name;
    /**
     * Marca de la cuatrimoto
     */
    private String brand;
    /**
     * Año de la cuatrimoto
     */
    private Integer year;
    /**
     * Descripcion de la cuatrimoto 
     */
    private String description;
    
    /**
     * Categoria de la cuatrimoto
     */
    @ManyToOne
    @JoinColumn(name = "categoryId", nullable = false)
    @JsonIgnoreProperties("quadbikes")
    private Category category;
    
    /**
     * Mensajes de la cuatrimoto
     */
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "quadbike")
    @JsonIgnoreProperties({"quadbike", "client"})
    private List<Message> messages;
    
    /**
     * Reservaciones de la cuatrimoto
     */
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "quadbike")
    @JsonIgnoreProperties({"quadbike", "client"})
    private List<Reservation> reservations;

    /**
     * Obtiene el id de la cuatrimoto
     * @return Id de la cuatrimoto
     */
    public Integer getId() {
        return id;
    }
    
    /**
     * Define el id de la cuatrimoto
     * @param id de la cuatrimoto
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre de la cuatrimoto
     * @return Nombre de la cuatrimoto
     */
    public String getName() {
        return name;
    }

    /**
     * Define el nombre de la cuatrimoto
     * @param name Nombre de la cuatrimoto
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtiene la marca de la cuatrimoto
     * @return Marca de la cuatrimoto
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Define la marca de la cuatrimoto
     * @param brand Marca de la cuatrimoto
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Obtiene el año de la cuatrimoto
     * @return Año de la cuatrimoto
     */
    public Integer getYear() {
        return year;
    }

    /**
     * Define el año de la cuatrimoto
     * @param year Año de la cuatrimoto
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * Obtienen la descripcion de la cuatrimoto
     * @return Descripcion de la cuatrimoto
     */
    public String getDescription() {
        return description;
    }

    /**
     * Define la descripcion de la cuatrimoto
     * @param description Descripcion de la cuatrimoto
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Obtiene la cateogoria de la cuatrimoto
     * @return Categoria de la cuatrimoto
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Define la categoria de la cuatrimoto
     * @param category Categoria de la cuatrimoto
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * Obtiene el mensaje de la cuatrimoto
     * @return Mensaje de la cuatrimoto
     */
    public List<Message> getMessages() {
        return messages;
    }

    /**
     * Define el mensaje de la cuatrimoto
     * @param messages Mensaeje de la cuatrimoto
     */
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    /**
     * Obtinene la reservacion de la cuatrimoto
     * @return Reservacion de la cuatrimoto
     */
    public List<Reservation> getReservations() {
        return reservations;
    }

    /**
     * Define la reservacion de la cuatrimoto
     * @param reservations Reservacion de la cuatrimoto
     */
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    
}
