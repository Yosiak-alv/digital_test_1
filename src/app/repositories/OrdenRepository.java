package app.repositories;

import app.models.Imprimible;
import app.models.Orden;

public class OrdenRepository<T extends Imprimible> extends OrdenImpRepository<Orden<T>, Integer> {
}
