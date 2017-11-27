package biblioteca_poo2;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DevolverLivroDao {
    
	public static int delete(String bookcallno,int studentid){
		int status=0;
		try{
                Emprestimo emprestimo = null;
                String path = LivroEmprestadoDao.class.getProtectionDomain().getCodeSource().getLocation().getPath();
	        FileInputStream fileIn = new FileInputStream(path + "Emprestimo.txt");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                emprestimo = (Emprestimo)in.readObject();
                in.close();
                fileIn.close();
                if ((bookcallno == null ? emprestimo.callno == null : bookcallno.equals(emprestimo.callno))  && studentid == emprestimo.studentid){
                    File arquivo = new File(path + "Emprestimo.txt");
                    arquivo.delete();
                    status = 1;
                }
		}catch(Exception e){
                    System.out.println(e);
                }
		return status;
	}
}
