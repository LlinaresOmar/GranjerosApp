package model;

import dto.Granjero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Model {

    private static Connection conexion;

    public Model(){conexion = Conexion.getConnection();}


    public static ArrayList<Granjero> consultar(){
        String sentenciaSql = "SELECT * FROM granjeros";
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        ArrayList<Granjero> granjeros = new ArrayList<>();

        try {
            sentencia = conexion.prepareStatement(sentenciaSql);
            resultado = sentencia.executeQuery();

            while (resultado.next()){
                String nombre = resultado.getString("nombre");
                String descripcion = resultado.getString("nombre");
                int dinero = resultado.getInt("dinero");
                int puntos = resultado.getInt("puntos");
                int nivel = resultado.getInt("nivel");

                Granjero granjero = new Granjero(nombre, descripcion, dinero, puntos, nivel);
                granjeros.add(granjero);
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            if (sentencia != null){
                try {
                    sentencia.close();
                    resultado.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
        } return granjeros;
    }

    public void insertar(Granjero granjero) {
        String sentenciaSQL = "INSERT INTO granjero(nombre, descripcion, dinero, puntos, nivel) VALUES (?,?,?,?,?)";
        PreparedStatement sentencia = null;
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            sentencia.setString(1, granjero.getNombre());
            sentencia.setString(2, granjero.getDescripcion());
            sentencia.setDouble(3, granjero.getDinero());
            sentencia.setInt(4, granjero.getPuntos());
            sentencia.setInt(5, granjero.getNivel());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (sentencia != null) {
                try {
                    sentencia.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public void modificar(Granjero granjero, Granjero granjeroTemp) {
        String sentenciaSQL = "UPDATE granjeros SET (nombre = ?, descripcion = ?, dinero = ?, puntos = ?, nivel = ?" + " WHERE  nombre = ?) VALUES";
        PreparedStatement sentencia = null;
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            sentencia.setString(1, granjero.getNombre());
            sentencia.setString(2, granjero.getDescripcion());
            sentencia.setInt(3, granjero.getDinero());
            sentencia.setInt(4, granjero.getPuntos());
            sentencia.setInt(5, granjero.getNivel());
            sentencia.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(sentencia != null){
                try {
                    sentencia.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }


    public void eliminar(Granjero granjero) {
        String sentenciaSQL = "DELETE FROM granjeros WHERE id = ?";
        PreparedStatement sentencia = null;
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            sentencia.setInt(1, granjero.getId());
            sentencia.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(sentencia != null){
                try {
                    sentencia.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
