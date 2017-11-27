package biblioteca_poo2;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

public class VisaoLivros extends JFrame {

	private JPanel contentPane;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisaoLivros frame = new VisaoLivros();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VisaoLivros() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		String column[]= {"ID", "Nome","Autor", "Editora", "Estoque"};
                Livro livro = null;
		try{
		    String path = Livro.class.getProtectionDomain().getCodeSource().getLocation().getPath();
	            FileInputStream fileIn = new FileInputStream(path + "Livros.txt");
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    livro = (Livro)in.readObject();
                    in.close();
                    fileIn.close();
                    Object[][] data = {{livro.callno, livro.name,livro.author,livro.publisher, livro.quantity}};
                table = new JTable(data,column);
		JScrollPane sp=new JScrollPane(table);
		
		contentPane.add(sp, BorderLayout.CENTER);
		}catch(Exception e){
                    System.out.println(e);
                }
	}

}
