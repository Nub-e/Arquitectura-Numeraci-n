package Vista;

public class MenuPrincipal extends javax.swing.JFrame {
    
    public MenuPrincipal() {
        initComponents();
        this.setLocationRelativeTo(this);
        CambiosColorBoton.configurarCambiosColor(jLcalculadoraBooleana, jPcalculadoraBooleana);
        CambiosColorBoton.configurarCambiosColor(jLconversores, jPconversores);
        
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLsalir1 = new javax.swing.JLabel();
        jPconversores = new javax.swing.JPanel();
        jLconversores = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPcalculadoraBooleana = new javax.swing.JPanel();
        jLcalculadoraBooleana = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(244, 244, 244));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(55, 55, 55));

        jLsalir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Salie.png"))); // NOI18N
        jLsalir1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLsalir1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLsalir1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLsalir1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(447, Short.MAX_VALUE)
                .addComponent(jLsalir1)
                .addGap(15, 15, 15))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 140, 500));

        jPconversores.setBackground(new java.awt.Color(220, 208, 192));

        jLconversores.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLconversores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLconversores.setText("CONVERSORES");
        jLconversores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLconversores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLconversoresMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPconversoresLayout = new javax.swing.GroupLayout(jPconversores);
        jPconversores.setLayout(jPconversoresLayout);
        jPconversoresLayout.setHorizontalGroup(
            jPconversoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPconversoresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLconversores, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPconversoresLayout.setVerticalGroup(
            jPconversoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPconversoresLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLconversores, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPconversores, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 280, 40));

        jPanel3.setBackground(new java.awt.Color(192, 178, 131));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 2, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MENÚ PRINCIPAL");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 360, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo Arquitectura Computadoresn FINAL (3).png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 290, 290));

        jPcalculadoraBooleana.setBackground(new java.awt.Color(220, 208, 192));

        jLcalculadoraBooleana.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLcalculadoraBooleana.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLcalculadoraBooleana.setText("CALCULADORA BOOLEANA");
        jLcalculadoraBooleana.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLcalculadoraBooleana.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLcalculadoraBooleanaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPcalculadoraBooleanaLayout = new javax.swing.GroupLayout(jPcalculadoraBooleana);
        jPcalculadoraBooleana.setLayout(jPcalculadoraBooleanaLayout);
        jPcalculadoraBooleanaLayout.setHorizontalGroup(
            jPcalculadoraBooleanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPcalculadoraBooleanaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLcalculadoraBooleana, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPcalculadoraBooleanaLayout.setVerticalGroup(
            jPcalculadoraBooleanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPcalculadoraBooleanaLayout.createSequentialGroup()
                .addComponent(jLcalculadoraBooleana, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPcalculadoraBooleana, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jLconversoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLconversoresMouseClicked
        
        MenuConversores menuCon = new MenuConversores();
        menuCon.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_jLconversoresMouseClicked

    private void jLsalir1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLsalir1MouseClicked

        System.exit(0);
        
    }//GEN-LAST:event_jLsalir1MouseClicked

    private void jLcalculadoraBooleanaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLcalculadoraBooleanaMouseClicked
   
        CalculadorBooleana calBoo = new CalculadorBooleana();
        calBoo.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_jLcalculadoraBooleanaMouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLcalculadoraBooleana;
    private javax.swing.JLabel jLconversores;
    private javax.swing.JLabel jLsalir1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPcalculadoraBooleana;
    private javax.swing.JPanel jPconversores;
    // End of variables declaration//GEN-END:variables
}
