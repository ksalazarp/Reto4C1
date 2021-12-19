/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto4_Web.repositorio;

import Reto4_Web.modelo.Chocolate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import Reto4_Web.interfaces.InterfaceChocolate;

/**
 *
 * @author USUARIO
 */
@Repository
public class ChocolateRepositorio {
    @Autowired
    private InterfaceChocolate repository;

    public List<Chocolate> getAll() {
        return repository.findAll();
    }

    public Optional<Chocolate> getClothe(String reference) {
        return repository.findById(reference);
    }
    public Chocolate create(Chocolate clothe) {
        return repository.save(clothe);
    }

    public void update(Chocolate clothe) {
        repository.save(clothe);
    }
    
    public void delete(Chocolate clothe) {
        repository.delete(clothe);
    }
}
