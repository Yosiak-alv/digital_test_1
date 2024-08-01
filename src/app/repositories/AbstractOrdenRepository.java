package app.repositories;

import app.models.BaseModel;
import app.repositories.interfaces.BaseRepository;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractOrdenRepository<T extends BaseModel<ID>,ID> implements BaseRepository<T, ID> {

    List<T> datasource = new ArrayList<>();

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
        this.datasource.add(model);
    }

    @Override
    public void update(ID id, T model) {
        T result = this.findById(id);
        if (result != null) {
            result = model;
        }
    }

    @Override
    public void delete(ID id) {
        this.datasource.removeIf(e -> e.getId().equals(id));
    }

    @Override
    public int count() {
        return datasource.size();
    }
}
