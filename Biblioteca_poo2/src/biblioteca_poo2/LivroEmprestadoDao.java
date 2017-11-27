package biblioteca_poo2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class LivroEmprestadoDao {
	
public static boolean checkBook(String bookcallno){
	boolean status=false;
	try{
		Livro livro = null;
                String path = Emprestimo.class.getProtectionDomain().getCodeSource().getLocation().getPath();
	        FileInputStream fileIn = new FileInputStream(path + "Livros.txt");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                livro = (Livro)in.readObject();
                in.close();
                fileIn.close();
                if (livro.callno.equals(bookcallno)){
                    status = true;
                }
	}catch(Exception e){System.out.println(e);}
	return status;
}

public static int save(String bookcallno,int studentid,String studentname,String studentcontact){
	int status=0;
	try{
             String path = Emprestimo.class.getProtectionDomain().getCodeSource().getLocation().getPath();
             Emprestimo emprestimo = new Emprestimo(bookcallno,studentid,studentname,studentcontact);
	     FileOutputStream saveFile = new FileOutputStream(path + "Emprestimo.txt");
             ObjectOutputStream stream = new ObjectOutputStream(saveFile);
             
             stream.writeObject(emprestimo);
             stream.close();
             saveFile.close();
             status = 1;
             
	}catch(Exception e){System.out.println(e);}
	return status;
}
public static int updatebook(String bookcallno){
	int status=0;
	/*int quantity=0,issued=0;
	try{
		Connection con=DB.getConnection();
		
		PreparedStatement ps=con.prepareStatement("select quantity,issued from books where callno=?");
		ps.setString(1,bookcallno);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			quantity=rs.getInt("quantity");
			issued=rs.getInt("issued");
		}
		
		if(quantity>0){
		PreparedStatement ps2=con.prepareStatement("update books set quantity=?,issued=? where callno=?");
		ps2.setInt(1,quantity-1);
		ps2.setInt(2,issued+1);
		ps2.setString(3,bookcallno);
		
		status=ps2.executeUpdate();
		}
		con.close();
	}catch(Exception e){System.out.println(e);}*/
	return status;
}
}
