package User;

import Enterprise.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author ReinoYuki
 */
public class UserSurface {
    static JFrame window = new JFrame("Enterprise");
    static JButton B_EM = new JButton("Make An Order");
    static JButton B_OM = new JButton("Check Out Order");
    public UserSurface(String UserName) {
        window.setSize(208, 156);
        window.setLocationRelativeTo(null);
        B_EM.setBounds(8, 8, 180, 48);
        B_OM.setBounds(8, 64, 180, 48);
        
        window.add(B_EM);
        window.add(B_OM);
        
        window.setLayout(null);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        B_EM.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
		menu em = new menu(UserName);
                window.dispose();
            }
        });
        B_OM.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
		OrderCheck em = new OrderCheck(UserName);
                window.dispose();
            }
        });
    }
}
