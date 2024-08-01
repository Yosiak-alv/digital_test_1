package app.models;

import java.util.Objects;

public class Lacteo extends Producto implements Imprimible {
    private Integer id;
    private int quantity;
    private int proteins;

    private static int countId = 0;

    public Lacteo(String name, Double price, int quantity, int proteins) {
        super(name,price);
        this.id = ++countId;
        this.quantity = quantity;
        this.proteins = proteins;
    }
    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getProteins() {
        return proteins;
    }

    public void setProteins(int proteins) {
        this.proteins = proteins;
    }

    public String showDetails() {
        return  "id= " + id + '\'' +
                ", name= " + nombre + '\'' +
                ", price= " + precio + '\'' +
                ", quantity= " + quantity + '\'' +
                ", proteins= " + proteins;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lacteo producto)) return false;
        return Objects.equals(id, producto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
