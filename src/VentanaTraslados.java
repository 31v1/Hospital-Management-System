 = gestor.trasladarPacientes(origen.getId(), destino.getId());
        if (resultado.startsWith("ERROR")) {
            JOptionPane.showMessageDialog(this, resultado, "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, resultado, "Éxito", JOptionPane.INFORMATION_MESSAGE);
            if (ventanaPrincipal != null) {
                ventanaPrincipal.actualizarTablas();
            }
}
    }                                           

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        this.dispose();
    }                                        

    private void cargarCombos() {
        cmbOrigen.removeAllItems();
        cmbDestino.removeAllItems();
        Hospital[] hospitales = gestor.listarHospitales();
        for (Hospital h : hospitales) {
            cmbOrigen.addItem(h);
            cmbDestino.addItem(h);
        }
        // Configurar renderer para mostrar solo el nombre
        cmbOrigen.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                if (value instanceof Hospital) {
                    setText(((Hospital) value).getNombreHospital());
                }
                return this;
            }
        });
        cmbDestino.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                if (value instanceof Hospital) {
                    setText(((Hospital) value).getNombreHospital());
                }
                return this;
            }
        });
    }
    /**
     * @param args the command line arguments
     */
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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {        
        GestorHospitales gestor = new GestorHospitales();
        new VentanaTraslados(gestor, null).setVisible(true);
    });
            
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnTraslado;
    private javax.swing.JComboBox<Hospital> cmbDestino;
    private javax.swing.JComboBox<Hospital> cmbOrigen;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration                   
    private GestorHospitales gestor;
    private VentanaPrincipal ventanaPrincipal;
}
