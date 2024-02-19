package Ritco;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Ticket {

	private JFrame frame;
	private JTextField tickettxf;
	private JTextField bustxf;
	private JTextField custtxf;
	private JTextField drtxf;
	private JTextField tftxf;
	private JTextField tictxf;
	private JTextField tdtxf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ticket window = new Ticket();
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
	public Ticket() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 804, 571);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JMenuBar menuBar = new JMenuBar();
        getFrame().setJMenuBar(menuBar);
        JMenu menu = new JMenu("Menu");
        menuBar.add(menu);

        JMenuItem bus = new JMenuItem("bus");
        menu.add(bus);

        JMenuItem Customer = new JMenuItem("Customer");
        menu.add(Customer);
        
        JMenuItem driver = new JMenuItem("driver");
        menu.add(driver);
        
        JMenuItem TicketMenuItem = new JMenuItem("Ticket");
        menu.add(TicketMenuItem);

        JMenuItem logout = new JMenuItem("logout");
        menu.add(logout);


        bus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                getFrame().dispose(); 
                Bus busFrame = new Bus(); 
                busFrame.getFrame().setVisible(true); 
            }
        });

        Customer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	getFrame().dispose(); 
                customer2 customerFrame = new customer2(); 
                customerFrame.getFrame().setVisible(true); 
            }
        });

        driver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
         
                getFrame().dispose(); 
                driver driverFrame = new driver();
                driverFrame.getFrame().setVisible(true);
            }
        });
        TicketMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
         
                getFrame().dispose(); 
                Ticket ticketFrame = new Ticket();
                ticketFrame.getFrame().setVisible(true);
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
		
		JLabel lblNewLabel = new JLabel("TICKET FORM.");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(117, 0, 396, 37);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel buslb = new JLabel("BUS_ID");
		buslb.setFont(new Font("Times New Roman", Font.BOLD, 15));
		buslb.setBounds(20, 100, 127, 37);
		frame.getContentPane().add(buslb);
		
		JLabel custlb = new JLabel("CUSTOMER_ID");
		custlb.setFont(new Font("Times New Roman", Font.BOLD, 15));
		custlb.setBounds(20, 148, 127, 37);
		frame.getContentPane().add(custlb);
		
		JLabel drlb = new JLabel("DRIVER_ID");
		drlb.setFont(new Font("Times New Roman", Font.BOLD, 15));
		drlb.setBounds(20, 193, 127, 37);
		frame.getContentPane().add(drlb);
		
		JLabel tflb = new JLabel("START");
		tflb.setFont(new Font("Times New Roman", Font.BOLD, 15));
		tflb.setBounds(20, 238, 127, 37);
		frame.getContentPane().add(tflb);
		
		JLabel ticlb = new JLabel("STOP");
		ticlb.setFont(new Font("Times New Roman", Font.BOLD, 15));
		ticlb.setBounds(20, 281, 127, 37);
		frame.getContentPane().add(ticlb);
		
		JLabel tdlb = new JLabel("TICKET_DATE");
		tdlb.setFont(new Font("Times New Roman", Font.BOLD, 15));
		tdlb.setBounds(20, 328, 127, 37);
		frame.getContentPane().add(tdlb);
		
		JLabel ticketlb = new JLabel("TICKET_ID");
		ticketlb.setFont(new Font("Times New Roman", Font.BOLD, 15));
		ticketlb.setBounds(20, 48, 127, 37);
		frame.getContentPane().add(ticketlb);
		
		tickettxf = new JTextField();
		tickettxf.setBounds(189, 57, 307, 28);
		frame.getContentPane().add(tickettxf);
		tickettxf.setColumns(10);
		
		bustxf = new JTextField();
		bustxf.setColumns(10);
		bustxf.setBounds(189, 105, 307, 28);
		frame.getContentPane().add(bustxf);
		
		custtxf = new JTextField();
		custtxf.setColumns(10);
		custtxf.setBounds(189, 153, 307, 28);
		frame.getContentPane().add(custtxf);
		
		drtxf = new JTextField();
		drtxf.setColumns(10);
		drtxf.setBounds(189, 197, 307, 28);
		frame.getContentPane().add(drtxf);
		
		tftxf = new JTextField();
		tftxf.setColumns(10);
		tftxf.setBounds(189, 243, 307, 28);
		frame.getContentPane().add(tftxf);
		
		tictxf = new JTextField();
		tictxf.setColumns(10);
		tictxf.setBounds(189, 284, 307, 28);
		frame.getContentPane().add(tictxf);
		
		tdtxf = new JTextField();
		tdtxf.setColumns(10);
		tdtxf.setBounds(189, 327, 307, 28);
		frame.getContentPane().add(tdtxf);
		
		JButton Insertbtn = new JButton("INSERT");
		Insertbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String ticket_id = Ticket.this.tickettxf.getText();
                String Bus_id = Ticket.this.bustxf.getText();
                String customerid = Ticket.this.custtxf.getText();
                String driver_id=Ticket.this.drtxf.getText();
                String start = Ticket.this.tftxf.getText();
                String stop = Ticket.this.tftxf.getText();
                String Date = Ticket.this.tdtxf.getText();
                

                String msg = "" + ticket_id;
                msg += " \n";

                try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gisa_patrick_r_s_m", "222008906", "222008906")) {
                    String query = "INSERT INTO ticket (ticket_id,Bus_id, customerid , driver_id, start, stop, Date) " +
                                   "VALUES (?, ?, ?, ?, ?, ?, ?)";

                    try (PreparedStatement sta = connection.prepareStatement(query)) {
                    	sta.setInt(1, Integer.parseInt(tickettxf.getText()));
                        sta.setString(2, Bus_id);
                        sta.setString(3, customerid );
                        sta.setString(4, driver_id);
                        sta.setString(5, start);
                        sta.setString(6, stop);
                        sta.setString(7, Date);
                        
        
                        int x = sta.executeUpdate();

                        if (x == 0) {
                            JOptionPane.showMessageDialog(Insertbtn, "This is already exist");
                        } else {
                            JOptionPane.showMessageDialog(Insertbtn,
                                                          "Welcome, " + msg + "Your account is successfully created");
                        }
                    }
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            }
        });
		
		Insertbtn.setForeground(new Color(0, 0, 255));
		Insertbtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		Insertbtn.setBounds(80,370, 125, 44);
		frame.getContentPane().add(Insertbtn);;
		
		
		JButton Viewbtn = new JButton("VIEW");
		Viewbtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {   
		        try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gisa_patrick_r_s_m", "222008906", "222008906");

		            String sql = "SELECT * FROM ticket";
		            try (PreparedStatement stm = con.prepareStatement(sql)) {
		                ResultSet rs = stm.executeQuery(); // Execute the query

		                // Process the result set and display records
		                while (rs.next()) {
		                    int ticket_id = rs.getInt("ticket_id");
		                    String Bus_id = rs.getString("Bus_id");
		                    String customerid = rs.getString("customerid");
		                    String driver_id = rs.getString("driver_id");
		                    String start = rs.getString("start");
		                    String stop = rs.getString("stop");
		                    String Date = rs.getString("Date");
		                    

		                    // You can choose how to display the records, for example, print to console
		                    System.out.println("ticket_id : " + ticket_id);
		                    System.out.println("Bus_id: " +Bus_id);
		                    System.out.println("customerid: " + customerid);
		                    System.out.println("driver_id: " + driver_id);
		                    System.out.println("start: " + start);
		                    System.out.println("stop: " + stop);
		                    System.out.println("Date: " + Date);
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
		Viewbtn.setBounds(200, 370, 125, 44);
		frame.getContentPane().add(Viewbtn);
		
		JButton Updatebtn = new JButton("UPDATE");
		Updatebtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {   
		        try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gisa_patrick_r_s_m", "222008906", "222008906");

		            con.setAutoCommit(true); // Set auto-commit to true

		            String sql = "UPDATE ticket SET start=?, stop=?, Date=?  WHERE ticket_id=?";
		            try (PreparedStatement stm = con.prepareStatement(sql)) {
		                stm.setString(1, tftxf.getText());
		                stm.setString(2, tictxf.getText());
		                stm.setString(3, tdtxf.getText());
		                stm.setInt(4, Integer.parseInt(tickettxf.getText()));
		                int rowsAffected = stm.executeUpdate(); // Execute the update

		                if (rowsAffected > 0) {
		                    JOptionPane.showMessageDialog(Updatebtn, "Record updated successfully!");
		                } else {
		                    JOptionPane.showMessageDialog(Updatebtn, "No record found with the given bookingID.");
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
		Updatebtn.setBounds(320, 370, 125, 44);
		frame.getContentPane().add(Updatebtn);
		
		JButton Deletebtn = new JButton("DELETE");
		Deletebtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
				
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gisa_patrick_r_s_m","222008906","222008906");
					String sql="DELETE FROM ticket WHERE ticket_id=?";
					int ttxf=Integer.parseInt(JOptionPane.showInputDialog("Enter ticket_id to delete:"));
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
		Deletebtn.setBounds(445, 370, 125, 44);
		frame.getContentPane().add(Deletebtn);
	}

	JFrame getFrame() {
		// TODO Auto-generated method stub
		return frame;
	}

	public static void addActionListener(ActionListener actionListener) {
		// TODO Auto-generated method stub
		
	}
}
