package app.models;

public class Producto extends BaseModel<Integer> {
    protected String nombre;
    protected Double precio;

    public Producto(String nombre, Double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public Integer getId(){
        return null;
    };
}
