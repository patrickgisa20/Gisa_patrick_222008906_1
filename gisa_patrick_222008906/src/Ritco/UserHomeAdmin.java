package Ritco;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;


public class UserHomeAdmin extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserHomeAdmin frame = new UserHomeAdmin();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public UserHomeAdmin() {

    }

    /**
     * Create the frame.
     */
    public UserHomeAdmin(String userSes) {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBackground(Color.gray);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        
        JLabel lblNewLabel = new JLabel("ADMIN HOME PAGE");
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 26));
        lblNewLabel.setBounds(400, 8, 200, 50);
        contentPane.add(lblNewLabel);
        
        JButton btnNewButtonh = new JButton("continue");
        btnNewButtonh.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
//              int a = JOptionPane.showConfirmDialog(btnNewButton, "Are you sure?");
            
          
               Ticket ticketframe= new Ticket(); 
               ticketframe.getFrame().setVisible(true); 
          	 dispose(); 
              
         

          }
        });
        btnNewButtonh.setForeground(new Color(0, 0, 0));
        btnNewButtonh.setBackground(UIManager.getColor("pink"));
        btnNewButtonh.setFont(new Font("Tahoma", Font.PLAIN, 24));
        
        btnNewButtonh.setBounds(240, 50, 485, 110);
        btnNewButtonh.setBackground(new Color(0, 0, 128));
        btnNewButtonh.setForeground(Color.green); 
        contentPane.add(btnNewButtonh);
        
        JButton btnNewButton = new JButton("Logout");
        btnNewButton.setForeground(new Color(0, 0, 0));
        btnNewButton.setBackground(UIManager.getColor("pink"));
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(btnNewButton, "Are you sure?");
                // JOptionPane.setRootFrame(null);
                if (a == JOptionPane.YES_OPTION) {
                    dispose();
                    UserLogin obj = new UserLogin();
                    obj.setTitle("Student-Login");
                    obj.setVisible(true);
                }
               // dispose();
                UserLogin obj = new UserLogin();

                obj.setTitle("Student-Login");
                obj.setVisible(true);

            }
        });
        btnNewButton.setBounds(247, 208, 491, 114);
        btnNewButton.setBackground(new Color(0, 0, 128));
        btnNewButton.setForeground(Color.green); 
        contentPane.add(btnNewButton);
        JButton button = new JButton("Change-password\r\n");
        button.setBackground(UIManager.getColor("Button.disabledForeground"));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ChangePassword bo = new ChangePassword(userSes);
                bo.setTitle("Change Password");
                bo.setVisible(true);

            }
        });
        button.setFont(new Font("Tahoma", Font.PLAIN, 24));
        button.setBackground(new Color(0, 0, 128));
        button.setForeground(Color.WHITE); 
        button.setBounds(247, 360, 491, 114);
        contentPane.add(button);
        
    }
}

