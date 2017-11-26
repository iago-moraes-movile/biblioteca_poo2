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

public class VisaoBibliotecario extends JFrame {

	private JPanel contentPane;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisaoBibliotecario frame = new VisaoBibliotecario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}



	public VisaoBibliotecario() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		String data[][]=null;
		String column[]=null;
                Bibliotecario bibliotecario = null;
		try{
                    String path = Bibliotecario.class.getProtectionDomain().getCodeSource().getLocation().getPath();
	            FileInputStream fileIn = new FileInputStream(path + "Bibliotecario.txt");
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    bibliotecario = (Bibliotecario)in.readObject();
                    in.close();
                    fileIn.close();
		}catch(Exception e){
                    System.out.println(e);
                }
		
		table = new JTable(data,column);
		JScrollPane sp=new JScrollPane(table);
		
		contentPane.add(sp, BorderLayout.CENTER);
	}

}
