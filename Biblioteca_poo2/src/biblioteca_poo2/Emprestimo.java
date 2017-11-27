/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca_poo2;

/**
 *
 * @author filipipereira bookcallno,studentid,studentname,studentcontact
 */
public class Emprestimo implements java.io.Serializable{
    
    String callno;
    int studentid;
    String studentname;
    String studentcontact;
    
    public Emprestimo(String callno,int studentid,String studentname,String studentcontact){
        this.callno = callno;
        this.studentid = studentid;
        this.studentname = studentname;
        this.studentcontact = studentcontact;
    }
}
