package app.models;

import java.util.Date;
import java.util.List;

public class Orden<T extends Imprimible> extends BaseModel<Integer> implements Comparable<Orden<T>> , Imprimible {

    private Integer id;
    private List<T> products;
    private Date date;
    private static int countId = 0;

    public Orden() {
        this.id = ++countId;
        this.date = new Date();
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<T> getProducts() {
        return products;
    }

    public void setProducts(List<T> products) {
        this.products = products;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String showDetails() {
        StringBuilder sb = new StringBuilder();
        sb.append("Orden ID: ").append(id).append("\n")
                .append("Fecha: ").append(date).append("\n")
                .append("Productos: ").append("\n");

        for(T product : products){
            sb.append(product.showDetails()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public int compareTo(Orden<T> o) {
        return this.id.compareTo(o.id);
    }
}
