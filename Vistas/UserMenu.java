
package Vistas;

import Modelo.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class UserMenu extends javax.swing.JFrame {
    //1.Instancia de la clase conexion
    Conexion conexion = new Conexion();
    Connection connection;
    //2. L a libreria Statement permite ejecutar los query SQL
    Statement st;
    ResultSet rs;
    //3. Creamos una instancia de la interfaz de la tabla empleados
    DefaultTableModel contenidoTablaEmpleados;
    
    
    
    
    public UserMenu() {
        initComponents();
        setLocationRelativeTo(null);
        listarEmpleados();
        }
    // 4. Metodo que trae todos los empleados existentes en la base de datos
    public void listarEmpleados(){
        String nombre = txtBuscarEmp.getText();
        if (nombre.isEmpty()){
        String queryConsulta = "SELECT * FROM empleados";
    // 5. Intentar ejecutar el query y obtener una respuesta de la base de datos
    try{
        connection = conexion.getConnection();
        st = connection.createStatement();
        rs = st.executeQuery(queryConsulta);
        //6. Crear un objeto donde se almacene el resultado de la consulta
        Object[] empleados = new Object[6];
        //7. Actualizar la propiedad Model de la tabla 
        contenidoTablaEmpleados = (DefaultTableModel)tblEmpleados.getModel();
        //8. Recorremos el resultado de la consulta del query
        while (rs.next()){
            empleados[0] = rs.getInt("idEmp");
            empleados[1] = rs.getString("nombreEmp");
            empleados[2] = rs.getString("apellidos");
            empleados[3] = rs.getString("tipoDocumento");
            empleados[4] = rs.getString("documento");
            empleados[5] = rs.getString("correo"); 
            System.out.println("id: " + empleados[0] + ", nombre: " + empleados[1] + " , apellido: " + empleados[2] + ", documento: "
			    + empleados[3] + " " + empleados[4] + ", correo: " + empleados[5]);
            //9.Creamos una fila   dentro de la tabla para cada elemento que devuelve
            //el query
            contenidoTablaEmpleados.addRow(empleados);
           
         }
         tblEmpleados.setModel(contenidoTablaEmpleados);
        }catch(SQLException e ){
            System.out.println("Error para generar tabla de datos ");
            System.out.println(e);
            
            
        }
    
    }else{
    String queryEncontrar = "SELECT * FROM empleados WHERE nombreEmp LIKE '% " + nombre + "%' OR apellidos LIKE '%" + nombre + "%';";
   try{
        connection = conexion.getConnection();
        st = connection.createStatement();
        rs = st.executeQuery(queryEncontrar);
        //6. Crear un objeto donde se almacene el resultado de la consulta
        Object[] empleados = new Object[6];
        //7. Actualizar la propiedad Model de la tabla 
        contenidoTablaEmpleados = (DefaultTableModel)tblEmpleados.getModel();
        //8. Recorremos el resultado de la consulta del query
        while (rs.next()){
            empleados[0] = rs.getInt("idEmp");
            empleados[1] = rs.getString("nombreEmp");
            empleados[2] = rs.getString("apellidos");
            empleados[3] = rs.getString("tipoDocumento");
            empleados[4] = rs.getString("documento");
            empleados[5] = rs.getString("correo"); 
        System.out.println("id: " + empleados[0] + ", nombre: " + empleados[1] + " , apellido: " + empleados[2] + ", documento: "
			    + empleados[3] + " " + empleados[4] + ", correo: " + empleados[5]);
            //9.Creamos una fila   dentro de la tabla para cada elemento que devuelve
            //el query
            contenidoTablaEmpleados.addRow(empleados);
           
         }
         tblEmpleados.setModel(contenidoTablaEmpleados);
        }catch(SQLException e ){
            System.out.println("Error para buscar empleado ");
            System.out.println(e);
            
            
        }
    }
    
}
    
    //Cuando añado un nuevo empleado bakground es el siguiente
    //1.Se almacena el nuevo empleado en la base de datos
    //2. Se eliminan los datos que tiene la tabla tblEmpleados
    //3.Se llama el metodolistarEmpleados para consultar nuevamente la bd
    //4. Se cargan los empleados en la tabla incluyendo el recien creado
    private void borrarDatosTabla(){
        //El metodo getRowCount devuelve la cantidad de registro existentes
        for (int i = 0; i < tblEmpleados.getRowCount(); i++) {
            contenidoTablaEmpleados.removeRow(i);
            i-=1;
            
        }
            
        }
    
   
  
    
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane4 = new javax.swing.JTabbedPane();
        jTabbedPane8 = new javax.swing.JTabbedPane();
        jTabbedPane10 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnAddUser = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtBuscarEmp = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEmpleados = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane8.setBackground(new java.awt.Color(186, 254, 254));

        jTabbedPane10.setBackground(new java.awt.Color(178, 254, 254));
        jTabbedPane8.addTab("Sucursales", jTabbedPane10);

        jPanel3.setBackground(new java.awt.Color(200, 255, 255));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setText("INFORMACION EMPLEADO");

        btnAddUser.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnAddUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/avatar.png"))); // NOI18N
        btnAddUser.setText("Nuevo");
        btnAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUserActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Nombre");

        btnSearch.setIcon(new javax.swing.ImageIcon("C:\\Users\\Usuario\\Downloads\\showUser (1).png")); // NOI18N
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchMouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(159, 247, 247));

        tblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Apellido(s)", "Tipo de Documento", "Documento", "Correo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblEmpleados);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(txtBuscarEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddUser)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 56, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(126, 126, 126)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(252, 252, 252))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel1))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(txtBuscarEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane8.addTab("Empleados", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane8)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 21, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUserActionPerformed
        // 1. Creamos uns instancia del dialogo
        AddUserForm addUserF = new AddUserForm(this,true);
        addUserF.setVisible(true);
        borrarDatosTabla();
        listarEmpleados();
      
        
    }//GEN-LAST:event_btnAddUserActionPerformed

    private void tblEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpleadosMouseClicked
        //1.Crear una variable que permite capturar la informacion seleccionada
        int row = tblEmpleados.getSelectedRow();
        System.out.println("Fila seleccionada n°: " + row);
        //2.Validar si el usuario ha seleccionado un empleado
        if (row < 0){
            JOptionPane.showMessageDialog(this,"Debes seleccionar un empleado", "", JOptionPane.WARNING_MESSAGE);
        }else{
        //3. Partiendo del hecho de que cada fila es un registro de empleado
        int idEmp = Integer.parseInt(tblEmpleados.getValueAt(row, 0).toString());
        String nombreEmp = tblEmpleados.getValueAt(row, 1).toString();
        String apellidos = tblEmpleados.getValueAt(row, 2).toString();
        String tipoDocumento = tblEmpleados.getValueAt(row, 3).toString();
        String documento = tblEmpleados.getValueAt(row, 4).toString();
        String correo = tblEmpleados.getValueAt(row, 5).toString();
        
            System.out.println("idEmp: " + idEmp + "\nnombre: " + nombreEmp + " " 
                    + apellidos + "\ndocumento: " + tipoDocumento + " " + documento 
                    + "\ncorreo: " + correo);
         ShowUserForm showUserForm  = new ShowUserForm(this, true);
         //Mediante la instancia del JDialog enviamos los datos del empleado
         //de esta vista actual a la vista que muestra la información en detalle
         showUserForm.recibeDatos(idEmp, nombreEmp, apellidos, tipoDocumento, documento, correo);
         showUserForm.setVisible(true);
         //Para que se actualice la informacion del empleado que se acaba de editar
         //se debe borar todos los datos de la tabla y volverlos a cargar
         borrarDatosTabla();
         listarEmpleados();
        } 
    }//GEN-LAST:event_tblEmpleadosMouseClicked

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
     borrarDatosTabla();
     listarEmpleados();
    }//GEN-LAST:event_btnSearchMouseClicked

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new UserMenu().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddUser;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane10;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane8;
    private javax.swing.JTable tblEmpleados;
    private javax.swing.JTextField txtBuscarEmp;
    // End of variables declaration//GEN-END:variables
}
