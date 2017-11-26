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
public class Livro implements java.io.Serializable{
    String callno;
    String name;
    String author;
    String publisher;
    int quantity;
    boolean issued;
    
    Livro (String callno,String name,String author,String publisher,int quantity)
    {
        this.callno = callno;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.quantity = quantity;
    }
}
