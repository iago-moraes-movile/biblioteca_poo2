package biblioteca_poo2;

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
	public static int delete(int id){
		int status=0;
		//try{
		//	Connection con=DB.getConnection();
		//	PreparedStatement ps=con.prepareStatement("delete from librarian where id=?");
		//	ps.setInt(1,id);
		//	status=ps.executeUpdate();
		//	con.close();
		//}catch(Exception e){System.out.println(e);}
		return status;
	}

	public static boolean validate(String name,String password){
		boolean status=false;
		try{
		//	Connection con=DB.getConnection();
		//	PreparedStatement ps=con.prepareStatement("select * from librarian where name=? and password=?");
		//	ps.setString(1,name);
		//	ps.setString(2,password);
		//	ResultSet rs=ps.executeQuery();
		//	status=rs.next();
		//	con.close();
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
