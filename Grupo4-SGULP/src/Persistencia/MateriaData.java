package Persistencia;

import Conexion.Conexion;
import Conexion.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.util.*;

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

    public List<Materia> cargarMaterias() {
        List<Materia> materias = null;
        try {
            String sql = "SELECT * FROM materia";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet resultado = ps.executeQuery();
            while (resultado.next()) {
                int id = resultado.getInt("idMateria");
                String nombre = resultado.getString("nombre");
                int año = resultado.getInt("año");
                boolean estado = resultado.getBoolean("estado");

                Materia mat = new Materia(nombre, año, estado);
                mat.setIdMateria(id);
                materias.add(mat);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar." + ex);
        }
        return materias;
    }
}
