package app.repositories.interfaces;

public interface BaseRepository<T,ID>
        extends CrudListRepository<T,ID>, TotalListCount {
}
