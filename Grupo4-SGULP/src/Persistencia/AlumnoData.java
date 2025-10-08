package Persistencia;

import java.util.*;
import Conexion.Alumno;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AlumnoData {

    private Connection con;
    private AlumnoData alumno;

    public AlumnoData() {
        Conexion conexion = new Conexion("jdbc:mariadb://localhost:3306/grupo4-sgulp", "root", "");
        con = conexion.buscarconexion();
    }

    public void agregarAlumno(Alumno alu) {
        try {
            String sql = "INSERT INTO alumno(dni, apellido, nombre, fechaNacimiento, estado)"
                    + "VALUES (?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, alu.getDni());
            ps.setString(2, alu.getApellido());
            ps.setString(3, alu.getNombre());
            ps.setDate(4, Date.valueOf(alu.getFechaNacimiento()));
            ps.setBoolean(5, alu.isEstado());
            int registro = ps.executeUpdate();
            ps.close();

            if (registro > 0) {
                JOptionPane.showMessageDialog(null, "Alumno guardado correctamente!");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo guardar al alumno.");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar." + ex);
        }
    }
    
    public void eliminarAlumno(Alumno aluEliminar){
        try {
            String sql ="DELETE FROM alumno WHERE idAlumno= ?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, aluEliminar.getIdAlumno());
            int registro = ps.executeUpdate();
            ps.close();
            
            if (registro > 0) {
                JOptionPane.showMessageDialog(null, "Alumno eliminado correctamente!");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar al alumno.");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar. " + ex);
        }
    }

    public void actualizarAlumno(Alumno aluActualizado) {
        try {
            String sql = "UPDATE alumno SET dni= ?,apellido= ?,nombre= ?,fechaNacimiento= ?,estado= ? WHERE idAlumno = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, aluActualizado.getDni());
            ps.setString(2, aluActualizado.getApellido());
            ps.setString(3, aluActualizado.getNombre());
            ps.setDate(4, Date.valueOf(aluActualizado.getFechaNacimiento()));
            ps.setBoolean(5, aluActualizado.isEstado());
            int id = aluActualizado.getIdAlumno();
            ps.setInt(6, id);
            int registro = ps.executeUpdate();
            ps.close();

            if (registro > 0) {
                JOptionPane.showMessageDialog(null, "Alumno actualizado correctamente!");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar al alumno.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar. " + ex);
        }

    }

    public Alumno buscarAlumno(int id) {
        Alumno alu = null;
        try {
            String sql = "SELECT * FROM alumno WHERE idAlumno = ?;";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet resultado = ps.executeQuery();

            while (resultado.next()) {
                int ID = resultado.getInt("idAlumno");
                int dni = resultado.getInt("dni");
                String apellido = resultado.getString("apellido");
                String nombre = resultado.getString("nombre");
                Date fecha = resultado.getDate("fechaNacimiento");
                boolean estado = resultado.getBoolean("estado");

                alu = new Alumno(nombre, apellido, dni, fecha.toLocalDate(), estado);
                alu.setIdAlumno(ID);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar el alumno." + ex);
        }
        return alu;
    }

    public List<Alumno> cargarAlumnos() {
        List<Alumno> mostrar = new ArrayList();
        try {
            String sql = "SELECT * FROM alumno";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet resultado = ps.executeQuery();
            while (resultado.next()) {
                int id = resultado.getInt("idAlumno");
                int dni = resultado.getInt("dni");
                String apellido = resultado.getString("apellido");
                String nombre = resultado.getString("nombre");
                Date fecha = resultado.getDate("fechaNacimiento");
                boolean estado = resultado.getBoolean("estado");

                Alumno alu = new Alumno(nombre, apellido, dni, fecha.toLocalDate(), estado);
                alu.setIdAlumno(id);

                mostrar.add(alu);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar." + ex);
        }
        return mostrar;
    }

}
