/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto4_Web.controlador;

import Reto4_Web.servicio.UserService;
import Reto4_Web.modelo.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Indica que UserController va ser un servicio
 * @author Grupo 1 G18 Karen Salazar
 */
@RestController
/**
 * Endpoint /api/user
 */
@RequestMapping("/api/user")
/**
 * Permite realizar cualquier tipo de peticion sin restriccion de los cors
 */
@CrossOrigin("*")
/**
 * clase UserController
 */
public class UserController {
   @Autowired
    private UserService userService;
    /**
    * Metodo que permite obetner todos los usuarios
    * @return retorna todos los usuarios
    */
    @GetMapping("/all")
    public List<User> getAll() {
        return userService.getAll();
    }
    /**
     * Metodo que permite obetner un usuario por id
     * @param id del usuario
     * @return el usuario
     */
    @GetMapping("/{id}")
    public Optional <User> getUser(@PathVariable("id") int id) {
        return userService.getUser(id);
    }
     /**
    * Metodo post para agregar un usuario
    * @param user usuario 
    * @return retorna el usuario creado
    */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user) {
        return userService.create(user);
    }
    /**
     * Metodo post para actualizar un usuario
     * @param user datos del usuria para actualizar
     * @return el usuario actualizado
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user) {
        return userService.update(user);
    }
    /**
     * Metodo para eliminar un usuario
     * @param id del ususario a eliminar
     * @return el id del usuario eliminado
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return userService.delete(id);
    }
    /**
     * Metodo para el correo y contraseña 
     * @param email correo del usuario
     * @param password contraseña del usuario
     * @return el correo y la contraseña usuario
     */
    @GetMapping("/{email}/{password}")
    public User authenticateUser(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.authenticateUser(email, password);
    }
    /**
     * Meotodo para obetener el correo si existe
     * @param email 
     * @return el email si exisite
     */
    @GetMapping("/emailexist/{email}")
    public boolean emailExists(@PathVariable("email") String email) {
        return userService.emailExists(email);
    }
 /**
  * Fin de la clase
  */   
}
