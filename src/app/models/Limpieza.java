package app.models;

import java.util.Objects;

public class Limpieza extends Producto implements Imprimible {

    private Integer id;
    private String componentes;
    private double litros;

    private static int countId = 0;

    public Limpieza(String name, Double price, String componentes, Double litros) {
        super(name, price);
        this.id = ++countId;
        this.componentes = componentes;
        this.litros = litros;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComponentes() {
        return componentes;
    }

    public void setComponentes(String componentes) {
        this.componentes = componentes;
    }

    public Double getLitros() {
        return litros;
    }

    public void setLitros(Double litros) {
        this.litros = litros;
    }
    @Override
    public String showDetails() {
        return  "id= " + id + '\'' +
                ", name= " + nombre + '\'' +
                ", price= " + precio + '\'' +
                ", componentes= " + componentes + '\'' +
                ", litros= " + litros;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Limpieza producto)) return false;
        return Objects.equals(id, producto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
