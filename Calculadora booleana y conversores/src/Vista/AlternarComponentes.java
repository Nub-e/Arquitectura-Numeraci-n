package Vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlternarComponentes {

    public static void configurarAlternar   (JRadioButton radioButton, //boton de seleccion
                                            JLabel label1, JLabel label2,JLabel label3, //labels a ocultar
                                            JTextField textField1, JTextField textField2, JTextField textField3, //textfields a ocultar
                                            JTextField textField4) //textfiel a mostrar
    
    {
        radioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean selected = radioButton.isSelected();
                label1.setVisible(selected);
                label2.setVisible(selected);
                label3.setVisible(selected);
                textField1.setVisible(selected);
                textField2.setVisible(selected);
                textField3.setVisible(selected);
                textField4.setVisible(!selected);
            }
        });
    }
}


