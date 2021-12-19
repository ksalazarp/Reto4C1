/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reto4_Web.interfaces;

import Reto4_Web.modelo.User;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author USUARIO
 */
public interface InterfaceUser extends MongoRepository<User, Integer> {
    
    Optional<User> findByEmail(String email);
    
    Optional<User> findByEmailAndPassword(String email,String password);
    
     //Para seleccionar el usuario con el id maximo
    Optional<User> findTopByOrderByIdDesc();
}
