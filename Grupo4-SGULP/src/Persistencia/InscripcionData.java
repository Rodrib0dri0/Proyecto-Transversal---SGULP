package Persistencia;

import Conexion.Alumno;
import Conexion.Conexion;
import java.util.*;
import Conexion.Inscripcion;
import Conexion.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class InscripcionData {

    private Connection con;

    public InscripcionData() {
        Conexion conexion = new Conexion("jdbc:mariadb://localhost:3306/grupo4-sgulp", "root", "");
        con = conexion.buscarconexion();
    }

    public void Inscribir(Inscripcion ins) {
        try {
            String sql = "INSERT INTO inscripcion(idAlumno, idMateria, anioCursada) VALUES (?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, ins.getAlumno().getIdAlumno());
            ps.setInt(2, ins.getMateria().getIdMateria());
            ps.setInt(3, ins.getAñoCursada());

            int registro = ps.executeUpdate();

            if (registro > 0) {
                JOptionPane.showMessageDialog(null, "Alumno guardado correctamente!");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo guardar al alumno.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al inscribir.");
        }
    }

    public List<Materia> inscripto(int id) {
        List<Materia> mates = new ArrayList();
        try {
            String sql = "SELECT m.idMateria,m.nombre,m.año,m.estado "
                    + "FROM inscripcion i "
                    + "JOIN materia m ON i.idMateria = m.idMateria "
                    + "WHERE i.idAlumno = ?;";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet resultado = ps.executeQuery();

            while (resultado.next()) {
                int ID = resultado.getInt("idMateria");
                String nombre = resultado.getString("nombre");
                int anio = resultado.getInt("año");
                boolean estado = resultado.getBoolean("estado");

                Materia materia = new Materia(nombre, anio, estado);
                materia.setIdMateria(ID);

                mates.add(materia);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar.");
        }
        return mates;
    }

    public List<Materia> noInscripto(int id) {
        List<Materia> mates = new ArrayList();
        try {
            String sql = "SELECT * FROM materia WHERE idMateria NOT IN (SELECT idMateria FROM inscripcion WHERE idAlumno = ?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet resultado = ps.executeQuery();

            while (resultado.next()) {
                int ID = resultado.getInt("idMateria");
                String nombre = resultado.getString("nombre");
                int anio = resultado.getInt("año");
                boolean estado = resultado.getBoolean("estado");

                Materia materia = new Materia(nombre, anio, estado);
                materia.setIdMateria(ID);

                mates.add(materia);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar.");
        }
        return mates;
    }
}
