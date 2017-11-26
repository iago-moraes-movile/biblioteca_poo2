/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca_poo2;

/**
 *
 * @author filipi
 */
public class Bibliotecario implements java.io.Serializable{
    String name;
    String password;
    String email;
    String address;
    String city;
    String contact;

    public Bibliotecario(String name, String password, String email, String address, String city, String contact) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.address = address;
        this.city = city;
        this.contact = contact;
    }
    
    public Bibliotecario(String name, String password){
        this.name = name;
        this.password = password;
    }
}
