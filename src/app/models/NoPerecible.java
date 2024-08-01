package app.models;

import java.util.Objects;

public class NoPerecible extends Producto implements Imprimible {
    private Integer id;
    private int contenido;
    private int calorias;

    private static int countId = 0;

    public NoPerecible(String name, Double price, int contenido, int calorias) {
        super(name, price);
        this.id = ++countId;
        this.contenido = contenido;
        this.calorias = calorias;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getContenido() {
        return contenido;
    }

    public void setContenido(int contenido) {
        this.contenido = contenido;
    }

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    @Override
    public String showDetails() {
        return  "id= " + id + '\'' +
                ", name= " + nombre + '\'' +
                ", price= " + precio + '\'' +
                ", contenido= " + contenido + '\'' +
                ", calorias= " + calorias;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NoPerecible producto)) return false;
        return Objects.equals(id, producto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}

