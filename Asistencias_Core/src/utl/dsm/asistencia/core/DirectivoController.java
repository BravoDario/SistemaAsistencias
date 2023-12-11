/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utl.dsm.asistencia.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utl.dsm.asistencia.bd.ConexionMySQL;
import utl.dsm.asistencia.model.Alumno;
import utl.dsm.asistencia.model.Asistencia;
<<<<<<< HEAD
import utl.dsm.asistencia.model.Calendario;
=======
>>>>>>> 6c57e664d688960caccdbbc1b510299e98f99c7c
import utl.dsm.asistencia.model.Carrera;
import utl.dsm.asistencia.model.Grupo;
import utl.dsm.asistencia.model.Horario;
import utl.dsm.asistencia.model.Maestro;
import utl.dsm.asistencia.model.Materia;
import utl.dsm.asistencia.model.Persona;

/**
 *
 * @author adria
 */
public class DirectivoController {

    public List<Grupo> getGrupos() throws SQLException {

        ConexionMySQL mysql = new ConexionMySQL();
        Connection conn = mysql.open();

        String sql = "select * from vistagrupos";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Grupo> groups = new ArrayList<>();

        while (rs.next()) {
            Grupo grupo = new Grupo(
                    rs.getInt("idGrupo"),
                    rs.getString("grado"),
                    rs.getString("grupo"),
                    new Carrera(rs.getInt("idCarrera"), rs.getString("carrera"), rs.getString("especialidad")));
<<<<<<< HEAD

            groups.add(grupo);
        }

        rs.close();
        pstmt.close();
        conn.close();

        return groups;
    }

=======
            
            groups.add(grupo);
        }
        
        rs.close();
        pstmt.close();
        conn.close();
        
        return groups;
    }
    
>>>>>>> 6c57e664d688960caccdbbc1b510299e98f99c7c
    public List<Horario> getHorario(int idGrupo) throws Exception, SQLException {
        ConexionMySQL mysql = new ConexionMySQL();
        Connection conn = mysql.open();

        String sql = "select * from vistahorario where idGrupo = " + idGrupo;

        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Horario> hors = new ArrayList<>();

        while (rs.next()) {

            Maestro maestro = new Maestro();
            maestro.setIdMaestro(rs.getInt("idMaestro"));
            maestro.setPersona(new Persona(rs.getString("nombreMaestro"), rs.getString("primerApellido"), rs.getString("segundoApellido"), "", ""));

            Horario horario = new Horario(
                    rs.getInt("idHorario"),
                    rs.getString("dia"),
                    rs.getString("horaInicio"),
                    rs.getString("horaFin"),
<<<<<<< HEAD
                    maestro,
                    new Grupo(rs.getInt("idGrupo"), rs.getString("grado"), rs.getString("grupo"),
                            new Carrera(rs.getInt("idcarrera"), rs.getString("carrera"), rs.getString("especialidad"))),
                    new Materia(rs.getInt("idMateria"), rs.getString("nombre")),
                    new Calendario(rs.getInt("idCalendario"), rs.getString("vacacionInicio"), rs.getString("vacacionFin"), rs.getString("periodoInicio"), rs.getString("periodoFin")));
=======
                    rs.getString("periodo"),
                    maestro,
                    new Grupo(rs.getInt("idGrupo"), rs.getString("grado"), rs.getString("grupo"),
                            new Carrera(rs.getInt("idcarrera"), rs.getString("carrera"), rs.getString("especialidad"))),
                    new Materia(rs.getInt("idMateria"), rs.getString("nombre")));
>>>>>>> 6c57e664d688960caccdbbc1b510299e98f99c7c

            hors.add(horario);
        }
        rs.close();
        pstmt.close();
        conn.close();

        return hors;
    }
<<<<<<< HEAD

    public List<Asistencia> getListaAsistencia(int idMateria, int idGrupo) throws SQLException {
        ConexionMySQL mysql = new ConexionMySQL();
        Connection conn = mysql.open();

        String sql = "select * from vistaasistencia where idmateria = " + idMateria + " and idGrupo = " + idGrupo;
=======
    
    public List<Asistencia> getListaAsistencia(int idMateria, int idGrupo) throws SQLException{
        ConexionMySQL mysql = new ConexionMySQL();
        Connection conn = mysql.open();

        String sql = "select * from vistaasistencia where idmateria = " + idMateria +" and idGrupo = " +idGrupo;
>>>>>>> 6c57e664d688960caccdbbc1b510299e98f99c7c

        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Asistencia> asistencias = new ArrayList<>();

        while (rs.next()) {
            Grupo grupo = new Grupo(
                    rs.getInt("idGrupo"),
                    rs.getString("grado"),
                    rs.getString("grupo"),
                    new Carrera(
                            rs.getInt("idcarrera"),
                            rs.getString("grupo"),
                            rs.getString("grupo")
                    )
            );
            Asistencia asistencia = new Asistencia(
                    rs.getInt("idAsistencia"),
                    new Alumno(
                            rs.getInt("idAlumno"),
                            new Persona(
                                    rs.getInt("idPersona"),
                                    rs.getString("nombreAlumno"),
                                    rs.getString("primApeAlumno"),
                                    rs.getString("seguApeAlumno"), "", ""), grupo),
                    new Horario(
                            rs.getInt("idHorario"),
                            rs.getString("dia"),
                            rs.getString("horaInicio"),
                            rs.getString("horaFin"),
<<<<<<< HEAD
=======
                            rs.getString("periodo"),
>>>>>>> 6c57e664d688960caccdbbc1b510299e98f99c7c
                            new Maestro(
                                    rs.getInt("idMaestro"),
                                    new Persona(0,
                                            rs.getString("nombreMaestro"),
                                            rs.getString("primerApellido"),
                                            rs.getString("segundoApellido"), "", "")
                            ),
                            grupo,
                            new Materia(
                                    rs.getInt("idMateria"),
                                    rs.getString("nombre")
<<<<<<< HEAD
                            ),
                            new Calendario(rs.getInt("idCalendario"), rs.getString("vacacionInicio"), rs.getString("vacacionFin"), rs.getString("periodoInicio"), rs.getString("periodoFin"))
=======
                            )
>>>>>>> 6c57e664d688960caccdbbc1b510299e98f99c7c
                    ),
                    rs.getString("fecha"),
                    rs.getString("estatus")
            );
            asistencias.add(asistencia);
        }

        rs.close();
        pstmt.close();
        conn.close();
<<<<<<< HEAD

        return asistencias;
    }

    public void justificarAsistencia(int idAsistencia) throws SQLException {
=======
        
        return asistencias;
    }
    
    public void justificarAsistencia(int idAsistencia) throws SQLException{
>>>>>>> 6c57e664d688960caccdbbc1b510299e98f99c7c
        ConexionMySQL mysql = new ConexionMySQL();
        Connection conn = mysql.open();

        String sql = "update asistencia set estatus = 'j' where idAsistencia = " + idAsistencia;
        PreparedStatement pstmt = conn.prepareStatement(sql);
<<<<<<< HEAD

        int i = pstmt.executeUpdate();

        pstmt.close();
        conn.close();
    }

=======
        
        int i = pstmt.executeUpdate();
        
        pstmt.close();
        conn.close();
    }
    
>>>>>>> 6c57e664d688960caccdbbc1b510299e98f99c7c
}
