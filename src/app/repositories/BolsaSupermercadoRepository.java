package app.repositories;

import app.models.Producto;
import app.repositories.interfaces.BaseRepository;

import java.util.ArrayList;
import java.util.List;

public class BolsaSupermercadoRepository<T extends Producto,ID> implements BaseRepository<T,ID> {

    private static final int MAX_BAG_CAPACITY = 5;
    List<T> datasource = new ArrayList<>(MAX_BAG_CAPACITY);

    @Override
    public List<T> findAll() {
        return datasource;
    }

    @Override
    public T findById(ID id) {
        return this.datasource.stream().filter(e -> e.getId().equals(id)).findFirst()
                .orElse(null);
    }

    @Override
    public void add(T model) {
        if (datasource.size() < MAX_BAG_CAPACITY) {
            this.datasource.add(model);
        } else {
            System.out.println("Lo sentimos, la bolsa de la compra está llena.");
        }
    }

    @Override
    public void update(ID id, T model) {
        T result = this.findById(id);
        if (result != null) {
            this.delete(id);
            this.add(model);
        }
    }

    @Override
    public void delete(ID id) {
        this.datasource.removeIf(e -> e.getId().equals(id));
    }

    @Override
    public int count() {
        return this.datasource.size();
    }
}
