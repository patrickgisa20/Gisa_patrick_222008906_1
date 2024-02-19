package Ritco;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Adminlogin extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton btnNewButton;
    private JButton btnNewButton1;
    private JLabel label;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Adminlogin frame = new Adminlogin();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Adminlogin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBackground(Color.GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("ADMIN LOGIN");
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 26));
        lblNewLabel.setBounds(423, 13, 273, 93);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        textField.setBounds(481, 170, 281, 68);
        contentPane.add(textField);
        textField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        passwordField.setBounds(481, 286, 281, 68);
        contentPane.add(passwordField);
        
        textField.setBackground(Color.LIGHT_GRAY);
        passwordField.setBackground(Color.LIGHT_GRAY);

        JLabel lblUsername = new JLabel("E-mail");
        lblUsername.setBackground(Color.BLACK);
        lblUsername.setForeground(Color.BLACK);
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblUsername.setBounds(250, 166, 193, 52);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setForeground(Color.BLACK);
        lblPassword.setBackground(Color.CYAN);
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblPassword.setBounds(250, 286, 193, 52);
        contentPane.add(lblPassword);
        
        btnNewButton1 = new JButton("Sign Up");
        btnNewButton1.addActionListener(new ActionListener() {
        	
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gisa_patrick_r_s_m","222008906","222008906");
					String sql="INSERT INTO admin VALUES(?,?)";
					PreparedStatement st=con.prepareStatement(sql);
					st.setString(1, textField.getText());
					st.setString(2, passwordField.getText());
					st.executeUpdate();
					JOptionPane.showMessageDialog(btnNewButton1, "ACCOUNT CREATED !!");
					st.close();
					con.close();
					
					
					
					
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(btnNewButton1, "ACCOUNT NOT CREATED  !!");
					// TODO: handle exception
				}
				
				
			}
		});
        
        btnNewButton1.setBackground(new Color(0, 0, 128));
        btnNewButton1.setForeground(Color.PINK); 
        btnNewButton1.setFont(new Font("Tahoma", Font.PLAIN, 26));
        btnNewButton1.setBounds(350,392 , 162, 60);
        contentPane.add(btnNewButton1);

        btnNewButton = new JButton("Login");
        btnNewButton.setBackground(new Color(0, 0, 128));
        btnNewButton.setForeground(Color.PINK); 
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
        btnNewButton.setBounds(545, 392, 162, 60);
        btnNewButton.addActionListener(new ActionListener() {

            @SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
                String Email = textField.getText();
				String password = passwordField.getText();
                try {
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gisa_patrick_r_s_m",
                        "222008906", "222008906");

                    PreparedStatement st = (PreparedStatement) connection
                        .prepareStatement("Select email, password from admin where email=? and password=?");

                    st.setString(1, Email);
                    st.setString(2, password);
                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        dispose();
                        UserHomeAdmin ah = new UserHomeAdmin(Email);
                        ah.setTitle("Welcome");
                        ah.setVisible(true);
                        JOptionPane.showMessageDialog(btnNewButton, "You have successfully logged in");
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton, "Wrong Username & Password");
                    }
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
        });

        contentPane.add(btnNewButton);

        label = new JLabel("");
        label.setBounds(0, 0, 1008, 562);
        contentPane.add(label);
    }
}

