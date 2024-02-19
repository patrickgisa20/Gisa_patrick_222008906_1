package Ritco;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Customerreq {

	private JFrame frame;
	private JTextField custtxf;
	private JTextField namtxf;
	private JTextField ematxf;
	private JTextField mobitxf;
	private JTextField addtxf;
	private JTextField finaladtxf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customerreq window = new Customerreq();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Customerreq() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setTitle("CUSTOMER FORM");
		getFrame().setBounds(100, 100, 913, 607);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		JMenuBar menuBar = new JMenuBar();
        getFrame().setJMenuBar(menuBar);
        JMenu menu = new JMenu("Menu");
        menuBar.add(menu);

        JMenuItem logout = new JMenuItem("logout");
        menu.add(logout);

        logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(logout, "Are you sure?");
                // JOptionPane.setRootFrame(null);
                if (a == JOptionPane.YES_OPTION) {
//                    dispose();
                    UserLogin obj = new UserLogin();
                   // obj.setTitle("Student-Login");
                    obj.setVisible(true);
                    getFrame().dispose();
                }
//                dispose();
//                LoginForm obj = new LoginForm();
//
//               // obj.setTitle("Student-Login");
//                obj.setVisible(true);

            }
        });
		
		
		JLabel lblNewLabel = new JLabel("CUSTOMER FORM");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(149, 0, 527, 39);
		getFrame().getContentPane().add(lblNewLabel);
		
		JLabel custlb = new JLabel("Customerid");
		custlb.setFont(new Font("Tahoma", Font.BOLD, 16));
		custlb.setBounds(10, 88, 189, 39);
		getFrame().getContentPane().add(custlb);
		
		JLabel nalb = new JLabel("Names");
		nalb.setFont(new Font("Tahoma", Font.BOLD, 16));
		nalb.setBounds(10, 143, 189, 39);
		getFrame().getContentPane().add(nalb);
		
		JLabel emalb = new JLabel("Email");
		emalb.setFont(new Font("Tahoma", Font.BOLD, 16));
		emalb.setBounds(10, 198, 189, 39);
		getFrame().getContentPane().add(emalb);
		
		JLabel mobilb = new JLabel("Mobile");
		mobilb.setFont(new Font("Tahoma", Font.BOLD, 16));
		mobilb.setBounds(10, 250, 189, 39);
		getFrame().getContentPane().add(mobilb);
		
		JLabel addlb = new JLabel("Initial Address");
		addlb.setFont(new Font("Tahoma", Font.BOLD, 16));
		addlb.setBounds(10, 301, 189, 39);
		getFrame().getContentPane().add(addlb);
		
		JLabel finaladlb = new JLabel("Final address");
		finaladlb.setFont(new Font("Tahoma", Font.BOLD, 16));
		finaladlb.setBounds(10, 351, 189, 39);
		getFrame().getContentPane().add(finaladlb);
		
	
		JButton insertbtn = new JButton("INSERT");
		insertbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gisa_patrick_r_s_m","222008906","222008906");
			String sql="INSERT INTO customer VALUES(?,?,?,?,?,?)";	
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(1, Integer.parseInt(custtxf.getText()));
			st.setString(2, namtxf.getText());
			st.setString(3, ematxf.getText());
			st.setString(5, mobitxf.getText());
			st.setString(4, addtxf.getText());
			st.setString(6, finaladtxf.getText());
			st.executeUpdate();
			JOptionPane.showMessageDialog(insertbtn, "data saved!!");
			
			con.close();
			st.close();
			
			
			
		
				
			} catch (Exception e2) {
				// TODO: handle exception
			}	
				
				
			}
			
			
			
			
		});
		
		
		
		insertbtn.setForeground(new Color(0, 0, 255));
		insertbtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		insertbtn.setBounds(289, 418, 120, 39);
		getFrame().getContentPane().add(insertbtn);
		
		
		custtxf = new JTextField();
		custtxf.setBounds(252, 95, 383, 31);
		getFrame().getContentPane().add(custtxf);
		custtxf.setColumns(10);
		
		namtxf = new JTextField();
		namtxf.setColumns(10);
		namtxf.setBounds(252, 154, 383, 31);
		getFrame().getContentPane().add(namtxf);
		
		ematxf = new JTextField();
		ematxf.setColumns(10);
		ematxf.setBounds(252, 203, 383, 31);
		getFrame().getContentPane().add(ematxf);
		
		mobitxf = new JTextField();
		mobitxf.setColumns(10);
		mobitxf.setBounds(252, 253, 383, 31);
		getFrame().getContentPane().add(mobitxf);
		
		addtxf = new JTextField();
		addtxf.setColumns(10);
		addtxf.setBounds(252, 303, 383, 31);
		getFrame().getContentPane().add(addtxf);
		
		finaladtxf = new JTextField();
		finaladtxf.setColumns(10);
		finaladtxf.setBounds(252, 353, 383, 31);
		getFrame().getContentPane().add(finaladtxf);
		
	}

	public JTextField getFinaladtxf() {
		return finaladtxf;
	}

	public void setFinaladtxf(JTextField finaladtxf) {
		this.finaladtxf = finaladtxf;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}
