package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    
    private String url = "jdbc:mariadb://localhost:3306/grupo4-sgulp";
    private String usuario = "root";
    private String contra = "";
            
            
    private static Connection conexion = null;

    public Conexion(String url, String usuario, String contra) {
        this.url=url;
        this.usuario=usuario;
        this.contra=contra;
    }
    
    

    public Connection buscarconexion() {
        if (conexion == null){
            
        try {

            Class.forName("org.mariadb.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, contra);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion" + ex);

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar drive" + ex);
        }
        }
        return conexion;
    }
    
}
