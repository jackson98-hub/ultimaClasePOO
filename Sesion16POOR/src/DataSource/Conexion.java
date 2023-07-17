
package DataSource;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.*;
import java.sql.Connection;

public class Conexion {
    private Connection conex;
    private String url ="jdbc:sqlserver://localhost:1433;databaseName=Venta;trustServerCertificate=true";
    private String user="sa";
    private String password="Ajar7323$";

    public Conexion() {
    }
    
    public Connection conectar(){
         try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conex = DriverManager.getConnection(url, user, password);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Error en la conexión");
            return null;   
        }
      return conex;
    }
    public void desconectar(){
        if(conex!=null){
            try {
                conex.close();
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
}
