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
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;


public class driver {

	private JFrame frame;
	private JTextField dritxf;
	private JTextField namtxf;
	private JTextField mobtxf;
	private JTextField ematxf;
	private JTextField adtxf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					driver window = new driver();
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
	public driver() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 903, 577);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		JMenuBar menuBar = new JMenuBar();
        getFrame().setJMenuBar(menuBar);
        JMenu menu = new JMenu("Menu");
        menuBar.add(menu);

        JMenuItem bus = new JMenuItem("bus");
        menu.add(bus);

        JMenuItem Customer = new JMenuItem("Customer");
        menu.add(Customer);
        
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
                customer2 agencyFrame = new customer2(); 
                agencyFrame.getFrame().setVisible(true); 
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
		
		JLabel lblNewLabel = new JLabel("DRIVER FORM");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(213, -4, 374, 44);
		getFrame().getContentPane().add(lblNewLabel);
		
		JLabel drilb = new JLabel("Driverid");
		drilb.setFont(new Font("Tahoma", Font.BOLD, 16));
		drilb.setBounds(30, 92, 159, 34);
		getFrame().getContentPane().add(drilb);
		
		JLabel namlb = new JLabel("Names");
		namlb.setFont(new Font("Tahoma", Font.BOLD, 16));
		namlb.setBounds(28, 143, 159, 34);
		getFrame().getContentPane().add(namlb);
		
		JLabel moblb = new JLabel("Mobile");
		moblb.setFont(new Font("Tahoma", Font.BOLD, 16));
		moblb.setBounds(28, 191, 159, 34);
		getFrame().getContentPane().add(moblb);
		
		JLabel emalb = new JLabel("email");
		emalb.setFont(new Font("Tahoma", Font.BOLD, 16));
		emalb.setBounds(30, 237, 159, 34);
		getFrame().getContentPane().add(emalb);
		
		JLabel lilb = new JLabel("licence");
		lilb.setFont(new Font("Tahoma", Font.BOLD, 16));
		lilb.setBounds(30, 294, 159, 34);
		getFrame().getContentPane().add(lilb);
		
		JButton Insertbtn = new JButton("INSERT");
		Insertbtn.addActionListener(new ActionListener() {
	
			public void actionPerformed(ActionEvent e) {
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gisa_patrick_r_s_m","222008906","222008906");
					String sql="INSERT INTO driver VALUES(?,?,?,?,?)";
					PreparedStatement st=con.prepareStatement(sql);
					st.setInt(1, Integer.parseInt(dritxf.getText()));
					st.setString(2, namtxf.getText());
					st.setString(3, mobtxf.getText());
					st.setString(4, ematxf.getText());
					st.setString(5, adtxf.getText());
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
		Insertbtn.setBounds(115, 370, 110, 37);
		getFrame().getContentPane().add(Insertbtn);
		
		JButton Viewbtn = new JButton("VIEW");
		Viewbtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {   
		        try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gisa_patrick_r_s_m","222008906","222008906");

		            String sql = "SELECT * FROM driver";
		            try (PreparedStatement stm = con.prepareStatement(sql)) {
		                ResultSet rs = stm.executeQuery(); // Execute the query

		                // Process the result set and display records
		                while (rs.next()) {
		                    int Driver_id = rs.getInt("Driver_id");
		                    String Names = rs.getString("Names");
		                    String Mobile= rs.getString("Mobile");
		                    String email= rs.getString("email");
		                    String license = rs.getString("license");

		                    // You can choose how to display the records, for example, print to console
		                    System.out.println("Driver_id: " + Driver_id);
		                    System.out.println("Names: " + Names);
		                    System.out.println("Mobile: " + Mobile);
		                    System.out.println("email: " + email);
		                    System.out.println("license: " + license);
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
		Viewbtn.setBounds(243, 370, 110, 37);
		getFrame().getContentPane().add(Viewbtn);
		
		JButton Updatebtn = new JButton("UPDATE");
		Updatebtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {   
		        try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gisa_patrick_r_s_m","222008906","222008906");

		            con.setAutoCommit(true); // Set auto-commit to true

		            String sql = "UPDATE driver SET Names=?, Mobile=?, email=?, license=? WHERE Driver_id=?";
		            try (PreparedStatement stm = con.prepareStatement(sql)) {
		                stm.setString(1, namtxf.getText());
		                stm.setString(2, mobtxf.getText());
		                stm.setString(3, ematxf.getText());
		                stm.setString(4, adtxf.getText());
		                stm.setInt(5, Integer.parseInt(dritxf.getText()));
		                
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
		Updatebtn.setBounds(364, 370, 110, 37);
		getFrame().getContentPane().add(Updatebtn);
		
		JButton Deletebtn = new JButton("DELETE");
		Deletebtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
				
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gisa_patrick_r_s_m","222008906","222008906");
					String sql="DELETE FROM driver WHERE Driver_id=?";
					int ttxf=Integer.parseInt(JOptionPane.showInputDialog("Enter Driver_id to delete:"));
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
		Deletebtn.setBounds(484, 370, 110, 37);
		getFrame().getContentPane().add(Deletebtn);
		
		dritxf = new JTextField();
		dritxf.setBounds(198, 91, 389, 34);
		getFrame().getContentPane().add(dritxf);
		dritxf.setColumns(10);
		
		namtxf = new JTextField();
		namtxf.setColumns(10);
		namtxf.setBounds(198, 144, 389, 34);
		getFrame().getContentPane().add(namtxf);
		
		mobtxf = new JTextField();
		mobtxf.setColumns(10);
		mobtxf.setBounds(198, 189, 389, 34);
		getFrame().getContentPane().add(mobtxf);
		
		ematxf = new JTextField();
		ematxf.setColumns(10);
		ematxf.setBounds(198, 234, 389, 34);
		getFrame().getContentPane().add(ematxf);
		
		adtxf = new JTextField();
		adtxf.setColumns(10);
		adtxf.setBounds(198, 294, 389, 34);
		getFrame().getContentPane().add(adtxf);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public static void addActionListener(ActionListener actionListener) {
		// TODO Auto-generated method stub
		
	}

}
