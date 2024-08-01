package app.models;

import app.enums.ColorTipo;

import java.util.Objects;

public class Fruta extends Producto implements Imprimible {
    private Integer id;
    private double peso;
    private ColorTipo color;

    private static int countId = 0;

    public Fruta(String name, double price, double peso, ColorTipo color){
        super(name, price);
        this.id = ++countId;
        this.peso = peso;
        this.color = color;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public ColorTipo getColor() {
        return color;
    }

    public void setColor(ColorTipo color) {
        this.color = color;
    }
    @Override
    public String showDetails() {
        return  "id= " + id + '\'' +
                ", name= " + nombre + '\'' +
                ", price= " + precio + '\'' +
                ", peso= " + peso + '\'' +
                ", color= " + color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fruta producto)) return false;
        return Objects.equals(id, producto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
