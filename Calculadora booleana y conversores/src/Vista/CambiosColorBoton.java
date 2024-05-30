package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CambiosColorBoton {
    
    public static void configurarCambiosColor(JLabel label, JPanel panel) {
        
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                panel.setBackground(new Color(192,178,131));
                label.setForeground(new Color(55,55,55));
                Font font = label.getFont();
                label.setFont(new Font(font.getName(), Font.BOLD, font.getSize()));
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                panel.setBackground(new Color(220,208,192));
                label.setForeground(new Color(55,55,55));
                Font font = label.getFont();
                label.setFont(new Font(font.getName(), Font.PLAIN, font.getSize()));
            }
        });
    }
}

