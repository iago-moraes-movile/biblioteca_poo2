package biblioteca_poo2;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class LivroDao {
public static int save(String callno,String name,String author,String publisher,int quantity){
	int status=0;
	try{
            String path = Livro.class.getProtectionDomain().getCodeSource().getLocation().getPath();
             Livro livro = new Livro(callno,name,author,publisher,quantity);
	     FileOutputStream saveFile = new FileOutputStream(path + "Livros.txt");
             ObjectOutputStream stream = new ObjectOutputStream(saveFile);
             
             stream.writeObject(livro);
             stream.close();
             saveFile.close();
             status = 1;
	}catch(Exception e)
        {
            System.out.println(e);
        }
	return status;
}
}
