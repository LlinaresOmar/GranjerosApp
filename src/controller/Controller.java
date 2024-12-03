package controller;

import dto.Granjero;
import model.Model;

import java.util.ArrayList;
import java.util.Comparator;

public class Controller {

    private Model modelo;
    public Controller(){modelo = new Model();}

    // a. Que liste el contenido de una tabla granjeros, mostrando solamente su
    // nombre y el dinero, ordenado por este último campo.
    public ArrayList<Granjero> consultarNombreYDineroOrderByDinero() {
        ArrayList<Granjero> granjeros = modelo.consultar();
        granjeros.sort(Comparator.comparingInt(g ->  g.getDinero()));
        return granjeros;
    }

    // b. Añadir la opción de registrar nuevas filas en la tabla granjeros
    public void insertar(Granjero granjero){
        modelo.insertar(granjero);
    }

    // c. Añade la opción de subir el nivel de un granjero (incrementar su nivel en un unidad)
    public void subirNivel(Granjero granjero){
        Granjero newGranjero = new Granjero(
                granjero.getNombre(),
                granjero.getDescripcion(),
                granjero.getDinero(),
                granjero.getPuntos(),
                granjero.getNivel()+1
        );
        modelo.modificar(granjero, newGranjero);
    }

    // d. Añade la opción de buscar granjeros introduciendo su nombre.
    public ArrayList<Granjero> consultarPorNombre(String nombre) {
        ArrayList<Granjero> granjeros = modelo.consultar();
        ArrayList<Granjero> granjerosNombre = new ArrayList<>();
        for (Granjero granjero: granjeros) {
            if (granjero.getNombre().equals(nombre)){
                granjerosNombre.add(granjero);
            }
        }
        return granjerosNombre;
    }

    // e. Añade la opción de eliminar filas de la tabla granjeros
    public void eliminar(Granjero granjero){
        modelo.eliminar(granjero);
    }
}
