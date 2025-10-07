package Persistencia;

import Conexion.Conexion;
import Conexion.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MateriaData {

    private Connection con;

    public MateriaData() {
        Conexion conexion = new Conexion("jdbc:mariadb://localhost:3306/grupo4-sgulp", "root", "");
        con = conexion.buscarconexion();
    }

    public void insertarMateria(Materia mat) {
        try {
            String sql = "INSERT INTO materia(nombre, año, estado) VALUES (?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, mat.getNombre());
            ps.setInt(2, mat.getAño());
            ps.setBoolean(3, mat.isEstado());
            int registro = ps.executeUpdate();
            ps.close();

            if (registro > 0) {
                JOptionPane.showMessageDialog(null, "Materia guardada!");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar." + ex);
        }

    }
}
