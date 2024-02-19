package Ritco;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class customer2 {

	JFrame frame;
	
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
					customer2 window = new customer2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public customer2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(300, 20, 756, 630);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        JMenu menu = new JMenu("Menu");
        menuBar.add(menu);

        JMenuItem bus = new JMenuItem("bus");
        menu.add(bus);

        JMenuItem Ticket = new JMenuItem("Ticket");
        menu.add(Ticket);
        
        JMenuItem booking = new JMenuItem("driver");
        menu.add(booking);

        JMenuItem logout = new JMenuItem("logout");
        menu.add(logout);


        bus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); 
                Bus busFrame = new Bus(); 
                busFrame.getFrame().setVisible(true); 
            }
        });

        Ticket.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); 
                Ticket ticketFrame = new Ticket(); 
                ticketFrame.getFrame().setVisible(true); 
            }
        });

        driver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
         
                frame.dispose(); 
               driver bookingFrame = new driver();
                bookingFrame.getFrame().setVisible(true);
            }
        });

        logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(logout, "Are you sure?");
                // JOptionPane.setRootFrame(null);
                if (a == JOptionPane.YES_OPTION) {
//                    dispose();
                    Adminlogin obj = new Adminlogin();
                   // obj.setTitle("Student-Login");
                    obj.setVisible(true);
                    frame.dispose();
                }
//                dispose();
//                LoginForm obj = new LoginForm();
//
//               // obj.setTitle("Student-Login");
//                obj.setVisible(true);

            }
        });

    	JLabel lblNewLabel = new JLabel("CUSTOMER FROM");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(213, -4, 374, 44);
		frame.getContentPane().add(lblNewLabel);
		
		
		JLabel custlb = new JLabel("Customerid");
		custlb.setFont(new Font("Tahoma", Font.BOLD, 16));
		custlb.setBounds(10, 88, 189, 39);
		frame.getContentPane().add(custlb);
		
		JLabel nalb = new JLabel("Names");
		nalb.setFont(new Font("Tahoma", Font.BOLD, 16));
		nalb.setBounds(10, 143, 189, 39);
		frame.getContentPane().add(nalb);
		
		JLabel emalb = new JLabel("Email");
		emalb.setFont(new Font("Tahoma", Font.BOLD, 16));
		emalb.setBounds(10, 198, 189, 39);
		frame.getContentPane().add(emalb);
		
		JLabel mobilb = new JLabel("Mobile");
		mobilb.setFont(new Font("Tahoma", Font.BOLD, 16));
		mobilb.setBounds(10, 250, 189, 39);
		frame.getContentPane().add(mobilb);
		
		JLabel addlb = new JLabel("Initial Address");
		addlb.setFont(new Font("Tahoma", Font.BOLD, 16));
		addlb.setBounds(10, 301, 189, 39);
		frame.getContentPane().add(addlb);
		
		JLabel finaladlb = new JLabel("Final address");
		finaladlb.setFont(new Font("Tahoma", Font.BOLD, 16));
		finaladlb.setBounds(10, 351, 189, 39);
		frame.getContentPane().add(finaladlb);
		
		
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
		insertbtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		insertbtn.setBounds(80, 400, 125, 44);
		frame.getContentPane().add(insertbtn);
		
		JButton Viewbtn = new JButton("VIEW");
		Viewbtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {   
		        try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gisa_patrick_r_s_m","222008906","222008906");
		            String sql = "SELECT * FROM customer";
		            try (PreparedStatement stm = con.prepareStatement(sql)) {
		                ResultSet rs = stm.executeQuery(); // Execute the query

		                // Process the result set and display records
		                while (rs.next()) {
		                    int customerid = rs.getInt("customerid");
		                    String Names = rs.getString("Names");
		                    String Email = rs.getString("Email");
		                    String mobile = rs.getString("mobile");
		                    String address = rs.getString("address");
		                    String addressto = rs.getString("addressto");

		                    // You can choose how to display the records, for example, print to console
		                    System.out.println("customerid : " + customerid);
		                    System.out.println("Names: " + Names);
		                    System.out.println("Email: " + Email);
		                    System.out.println("mobile: " + mobile);
		                    System.out.println("address: " + address);
		                    System.out.println("addressto: " + addressto);
		                  
		                    System.out.println("-----------------------------");
		                }
		            }
		        } catch (Exception e2) {
		            e2.printStackTrace();
		            JOptionPane.showMessageDialog(Viewbtn, "An error occurred. Please check the console for details.");
		        }
		    }
		});
		Viewbtn.setForeground(Color.BLUE);
		Viewbtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		Viewbtn.setBounds(200, 400, 125, 44);
		frame.getContentPane().add(Viewbtn);
		
		JButton Updatebtn = new JButton("UPDATE");
		Updatebtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {   
		        try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gisa_patrick_r_s_m","222008906","222008906");

		            con.setAutoCommit(true); // Set auto-commit to true

		            String sql = "UPDATE customer SET Names=?, Email=?, address=?, mobile=? WHERE customerid=?";
		            try (PreparedStatement stm = con.prepareStatement(sql)) {
		                stm.setString(1, namtxf.getText());
		                stm.setString(2, ematxf.getText());
		                stm.setString(3, mobitxf.getText());
		                stm.setString(4, addtxf.getText());
		                stm.setInt(5, Integer.parseInt(custtxf.getText()));
		                
		                int rowsAffected = stm.executeUpdate(); // Execute the update

		                if (rowsAffected > 0) {
		                    JOptionPane.showMessageDialog(Updatebtn, "Record updated successfully!");
		                } else {
		                    JOptionPane.showMessageDialog(Updatebtn, "No record found with the given driverid.");
		                }
		            }
		        } catch (Exception e2) {
		            e2.printStackTrace();
		            JOptionPane.showMessageDialog(Updatebtn, "An error occurred. Please check the console for details.");
		        }
		    }
		});
		Updatebtn.setForeground(Color.BLUE);
		Updatebtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		Updatebtn.setBounds(320, 400, 125, 44);
		frame.getContentPane().add(Updatebtn);
		
		JButton Deletebtn = new JButton("DELETE");
		Deletebtn.addActionListener(new ActionListener()  {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
				
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gisa_patrick_r_s_m","222008906","222008906");
					String sql="DELETE FROM customer WHERE customerid=?";
					int ttxf=Integer.parseInt(JOptionPane.showInputDialog("Enter customerid to delete:"));
					PreparedStatement stm=con.prepareStatement(sql);
					stm.setInt(1, ttxf);
					JOptionPane.showMessageDialog(Deletebtn, "data DELETED!!");
					stm.executeUpdate();
					stm.close();
					con.close();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(Deletebtn, "data NOT DELETED!!");
					// TODO: handle exception
				}
				// TODO Auto-generated method stub
				
			}
			
		});
		   
		
		Deletebtn.setForeground(new Color(255, 0, 0));
		Deletebtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		Deletebtn.setBounds(445, 400, 125, 44);
		frame.getContentPane().add(Deletebtn);

		custtxf = new JTextField();
		custtxf.setBounds(252, 95, 383, 31);
		frame.getContentPane().add(custtxf);
		custtxf.setColumns(10);
		
		namtxf = new JTextField();
		namtxf.setColumns(10);
		namtxf.setBounds(252, 154, 383, 31);
		frame.getContentPane().add(namtxf);
		
		ematxf = new JTextField();
		ematxf.setColumns(10);
		ematxf.setBounds(252, 203, 383, 31);
		frame.getContentPane().add(ematxf);
		
		mobitxf = new JTextField();
		mobitxf.setColumns(10);
		mobitxf.setBounds(252, 253, 383, 31);
		frame.getContentPane().add(mobitxf);
		
		addtxf = new JTextField();
		addtxf.setColumns(10);
		addtxf.setBounds(252, 303, 383, 31);
		frame.getContentPane().add(addtxf);
		
		finaladtxf = new JTextField();
		finaladtxf.setColumns(10);
		finaladtxf.setBounds(252, 353, 383, 31);
	    frame.getContentPane().add(finaladtxf);
		
		
	}

	public Window getFrame() {
		// TODO Auto-generated method stub
		return frame;
	}

//	public JTextField getBookingID() {
//		return Customerid;
//	}
//
//	public void setBookingID(JTextField bookingID) {
//		this.bookingID = bookingID;
//	}

}
