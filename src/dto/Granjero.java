package dto;

import java.util.Objects;

public class Granjero {

    private int id;
    private String nombre;
    private String descripcion;
    private int dinero;
    private int puntos;
    private int nivel;

    public Granjero(String nombre, String descripcion, int dinero, int puntos, int nivel) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.dinero = dinero;
        this.puntos = puntos;
        this.nivel = nivel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcione(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Granjero granjero = (Granjero) o;
        return id == granjero.id && Double.compare(granjero.dinero, dinero) == 0 && puntos == granjero.puntos && nivel == granjero.nivel && Objects.equals(nombre, granjero.nombre) && Objects.equals(descripcion, granjero.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, descripcion, dinero, puntos, nivel);
    }

    @Override
    public String toString() {
        return "Granjero{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", dinero=" + dinero +
                ", puntos=" + puntos +
                ", nivel=" + nivel +
                '}';
    }
}
