package Enterprise;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author ReinoYuki
 */

public class EnterpriseSurface {
    static JFrame window = new JFrame("Enterprise");
    static JButton B_EM = new JButton("Merchant Management");
    static JButton B_OM = new JButton("Order Management");
    public EnterpriseSurface(String UserName) {
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
		EnterpriseManagement em = new EnterpriseManagement(UserName);
                window.dispose();
            }
        });
        B_OM.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
		OrderSet os = new OrderSet(UserName);
                window.dispose();
            }
        });
    }
}
