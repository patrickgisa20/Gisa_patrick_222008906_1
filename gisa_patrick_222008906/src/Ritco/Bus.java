package Ritco;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

//import online_ticket_booking.Agency;
//import online_ticket_booking.Bus;
//import online_ticket_booking.LoginForm;
//import online_ticket_booking.orders;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Bus {

	private JFrame frame;
	private JTextField bustxf;
	private JTextField bntxf;
	private JTextField bpntxf;
	private JTextField bsntxf;

	/**
	 * Launch the application.
	 * 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bus window = new Bus();
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
	public Bus() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 860, 630);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		JMenuBar menuBar = new JMenuBar();
        getFrame().setJMenuBar(menuBar);
        JMenu menu = new JMenu("Menu");
        menuBar.add(menu);



        JMenuItem Customer = new JMenuItem("Customer");
        menu.add(Customer);
        
        JMenuItem driver = new JMenuItem("driver");
        menu.add(driver);
        
        JMenuItem TicketMenuItem = new JMenuItem("Ticket");
        menu.add(TicketMenuItem);
        JMenuItem logout = new JMenuItem("logout");
        menu.add(logout);


        TicketMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
         
                getFrame().dispose(); 
                Ticket ticketFrame = new Ticket();
                ticketFrame.getFrame().setVisible(true);
            }
        });

        Customer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	getFrame().dispose(); 
                customer2 agencyFrame = new customer2(); 
                agencyFrame.getFrame().setVisible(true); 
            }
        });

        driver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
         
                getFrame().dispose(); 
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
                    getFrame().dispose();
                }
//                dispose();
//                LoginForm obj = new LoginForm();
//
//               // obj.setTitle("Student-Login");
//                obj.setVisible(true);

            }
        });
		
		JLabel lblNewLabel = new JLabel("BUS FORM");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(178, 0, 430, 37);
		getFrame().getContentPane().add(lblNewLabel);
		
		JLabel buslb = new JLabel("Bus_id");
		buslb.setFont(new Font("Tahoma", Font.BOLD, 16));
		buslb.setBounds(10, 97, 161, 37);
		getFrame().getContentPane().add(buslb);
		
		JLabel bnlb = new JLabel("Name");
		bnlb.setFont(new Font("Tahoma", Font.BOLD, 16));
		bnlb.setBounds(10, 150, 161, 37);
		getFrame().getContentPane().add(bnlb);
		
		JLabel bpnlb = new JLabel("PlateNumber");
		bpnlb.setFont(new Font("Tahoma", Font.BOLD, 16));
		bpnlb.setBounds(10, 206, 161, 37);
		getFrame().getContentPane().add(bpnlb);
		
		JLabel bsnlb = new JLabel("SeatNumber");
		bsnlb.setFont(new Font("Tahoma", Font.BOLD, 16));
		bsnlb.setBounds(10, 260, 161, 37);
		getFrame().getContentPane().add(bsnlb);
		
		bustxf = new JTextField();
		bustxf.setBounds(241, 100, 350, 27);
		getFrame().getContentPane().add(bustxf);
		bustxf.setColumns(10);
		
		bntxf = new JTextField();
		bntxf.setColumns(10);
		bntxf.setBounds(241, 160, 350, 27);
		getFrame().getContentPane().add(bntxf);
		
		bpntxf = new JTextField();
		bpntxf.setColumns(10);
		bpntxf.setBounds(241, 216, 350, 27);
		getFrame().getContentPane().add(bpntxf);
		
		bsntxf = new JTextField();
		bsntxf.setColumns(10);
		bsntxf.setBounds(241, 270, 350, 27);
		getFrame().getContentPane().add(bsntxf);
		
		JButton Insertbtn = new JButton("INSERT");
		Insertbtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gisa_patrick_r_s_m","222008906","222008906");
					String sql="INSERT INTO bus VALUES(?,?,?,?)";
					PreparedStatement st=con.prepareStatement(sql);
					st.setInt(1, Integer.parseInt(bustxf.getText()));
					st.setString(2, bntxf.getText());
					st.setString(3, bpntxf.getText());
					st.setString(4, bsntxf.getText());
			
					st.executeUpdate();
					JOptionPane.showMessageDialog(Insertbtn, "data saved!!");
					st.close();
					con.close();
					
					
					
					
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(Insertbtn, "data NOT saved!!");
					// TODO: handle exception
				}
				
				
			}
		});
		
		
		
		Insertbtn.setForeground(new Color(0, 0, 255));
		Insertbtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		Insertbtn.setBounds(115, 320, 110, 37);
		getFrame().getContentPane().add(Insertbtn);
		
		JButton Viewbtn = new JButton("VIEW");
		Viewbtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {   
		        try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gisa_patrick_r_s_m","222008906","222008906");

		            String sql = "SELECT * FROM bus";
		            try (PreparedStatement stm = con.prepareStatement(sql)) {
		                ResultSet rs = stm.executeQuery(); // Execute the query

		                // Process the result set and display records
		                while (rs.next()) {
		                    int Bus_id = rs.getInt("Bus_id");
		                    String Names = rs.getString("Names");
		                    String platenumber= rs.getString("platenumber");
		                    String seatnumber= rs.getString("seatnumber");
		                    

		                    // You can choose how to display the records, for example, print to console
		                    System.out.println("Bus_id: " + Bus_id);
		                    System.out.println("Names: " + Names);
		                    System.out.println("platenumber: " + platenumber);
		                    System.out.println("seatnumber: " + seatnumber);
	
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
		Viewbtn.setBounds(243, 320, 110, 37);
		getFrame().getContentPane().add(Viewbtn);
		
		JButton Updatebtn = new JButton("UPDATE");
		Updatebtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {   
		        try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gisa_patrick_r_s_m","222008906","222008906");

		            con.setAutoCommit(true); // Set auto-commit to true

		            String sql = "UPDATE bus SET Names=?, platenumber=?, seatnumber=? WHERE Bus_id=?";
		            try (PreparedStatement stm = con.prepareStatement(sql)) {
		                stm.setString(1, bntxf.getText());
		                stm.setString(2, bpntxf.getText());
		                stm.setString(3, bsntxf.getText());
		                stm.setInt(4, Integer.parseInt(bustxf.getText()));
		                
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
		Updatebtn.setBounds(364, 320, 110, 37);
		getFrame().getContentPane().add(Updatebtn);
		
		JButton Deletebtn = new JButton("DELETE");
		Deletebtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
				
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gisa_patrick_r_s_m","222008906","222008906");
					String sql="DELETE FROM bus WHERE Bus_id=?";
					int ttxf=Integer.parseInt(JOptionPane.showInputDialog("Enter Bus_id to delete:"));
					PreparedStatement stm=con.prepareStatement(sql);
					stm.setInt(1, ttxf);
					JOptionPane.showMessageDialog(Deletebtn, "data DELETED!!");
					stm.executeUpdate();
					stm.close();
					con.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
		Deletebtn.setForeground(new Color(255, 0, 0));
		Deletebtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		Deletebtn.setBounds(484, 320, 110, 37);
		getFrame().getContentPane().add(Deletebtn);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}
