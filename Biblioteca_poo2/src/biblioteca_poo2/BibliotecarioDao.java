package biblioteca_poo2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class BibliotecarioDao {

	
	public static int save(String name,String password,String email,String address,String city,String contact){
	int status=0;
            try{
             String path = Bibliotecario.class.getProtectionDomain().getCodeSource().getLocation().getPath();
             Bibliotecario bibliotecario = new Bibliotecario(name,password,email,address, city, contact);
	     FileOutputStream saveFile = new FileOutputStream(path + "Bibliotecario.txt");
             ObjectOutputStream stream = new ObjectOutputStream(saveFile);
             
             stream.writeObject(bibliotecario);
             stream.close();
             saveFile.close();
             status = 1;
		}
                catch(IOException e){
                    System.out.println(e);
                }
		return status;
	}
	public static int delete(String id){
		int status=0;
		try{
                    Bibliotecario bibliotecario = null;
                    String path = Bibliotecario.class.getProtectionDomain().getCodeSource().getLocation().getPath();
                    FileInputStream fileIn = new FileInputStream(path + "Bibliotecario.txt");
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    bibliotecario = (Bibliotecario)in.readObject();
                    in.close();
                    fileIn.close();
                    if (id.equals(bibliotecario.name)){
                        File arquivo = new File(path + "Bibliotecario.txt");
                        arquivo.delete();
                        status = 1;
                    }
                }
                catch(Exception e){
                    System.out.println(e);
                }
		return status;
	}

	public static boolean validate(String name,String password){
		boolean status=false;
		try{
                Bibliotecario bibliotecario = null;
                String path = Bibliotecario.class.getProtectionDomain().getCodeSource().getLocation().getPath();
	        FileInputStream fileIn = new FileInputStream(path + "Bibliotecario.txt");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                bibliotecario = (Bibliotecario)in.readObject();
                in.close();
                fileIn.close();
                if ((name.trim() == null ? bibliotecario.name == null : name.trim().equals(bibliotecario.name)) && password.equals(bibliotecario.password)){
                    status = true;
                }
		}catch(Exception e){
                    System.out.println(e);
                }
		return status;
	}

}
