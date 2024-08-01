import app.enums.ColorTipo;
import app.models.*;
import app.repositories.OrdenRepository;
import app.repositories.ProductoRepository;
import app.repositories.BolsaSupermercadoRepository;
import app.repositories.interfaces.BaseRepository;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        BolsaSupermercadoRepository<Fruta,Integer> frutaRepo = new ProductoRepository<>();
        BolsaSupermercadoRepository<Lacteo,Integer> lacteoRepo = new ProductoRepository<>();
        BolsaSupermercadoRepository<Limpieza,Integer> limpiezaRepo = new ProductoRepository<>();
        BolsaSupermercadoRepository<NoPerecible,Integer> noPerecibleRepo = new ProductoRepository<>();

        //creando 5 frutas
        frutaRepo.add(new Fruta("Manzana", 1.0,20, ColorTipo.ROJO));
        frutaRepo.add(new Fruta("Pera", 1.5,30, ColorTipo.VERDE));
        frutaRepo.add(new Fruta("Banana", 0.5,10, ColorTipo.AMARILLO));
        frutaRepo.add(new Fruta("Naranja", 2.0,25, ColorTipo.NARANJA));
        frutaRepo.add(new Fruta("Uva", 3.0,15, ColorTipo.MORADO));

        frutaRepo.findAll().forEach(e -> System.out.println(e.showDetails()));

        //encontrar por id
        System.out.println("\nEncontrar por id: ");
        System.out.println(frutaRepo.findById(3).showDetails());
        //verificando maximo de 5
        System.out.println("\nVerificando maximo de 5: ");
        frutaRepo.add(new Fruta("Kiwi", 1.0,20, ColorTipo.VERDE));

        //creando 5 lacteos
        lacteoRepo.add(new Lacteo("Leche", 2.0, 200 , 2));
        lacteoRepo.add(new Lacteo("Yogurt", 1.5, 150 , 1));
        lacteoRepo.add(new Lacteo("Queso", 3.0, 300 , 3));
        lacteoRepo.add(new Lacteo("Mantequilla", 2.5, 250 , 2));
        lacteoRepo.add(new Lacteo("Crema", 1.0, 100 , 1));

        System.out.println("\nLacteos en el repositorio: ");
        lacteoRepo.findAll().forEach(e -> System.out.println(e.showDetails()));

        //creando 5 productos de limpieza
        limpiezaRepo.add(new Limpieza("Detergente", 2.0, "Agua, sal", 1.0));
        limpiezaRepo.add(new Limpieza("Cloro", 1.5, "Agua, cloro", 0.5));
        limpiezaRepo.add(new Limpieza("Desinfectante", 3.0, "Agua, alcohol", 1.5));
        limpiezaRepo.add(new Limpieza("Jabon", 2.5, "Agua, jabon", 1.0));
        limpiezaRepo.add(new Limpieza("Suavizante", 1.0, "Agua, suavizante", 0.5));

        System.out.println("\nProductos de limpieza en el repositorio: ");
        limpiezaRepo.findAll().forEach(e -> System.out.println(e.showDetails()));

        //creando 5 productos no perecibles
        noPerecibleRepo.add(new NoPerecible("Papel higienico", 2.0, 500, 1));
        noPerecibleRepo.add(new NoPerecible("Pasta dental", 1.5, 100, 1));
        noPerecibleRepo.add(new NoPerecible("Shampoo", 3.0, 200, 1));
        noPerecibleRepo.add(new NoPerecible("Acondicionador", 2.5, 150, 1));
        noPerecibleRepo.add(new NoPerecible("Jabon de baño", 1.0, 100, 1));

        System.out.println("\nProductos no perecibles en el repositorio: ");
        noPerecibleRepo.findAll().forEach(e -> System.out.println(e.showDetails()));

        //ordenes de frutas
        System.out.println("\nOrdenes de frutas: ");
        BaseRepository<Orden<Fruta>,Integer> ordenFrutaRepo = new OrdenRepository<>();
        Orden<Fruta> orden1 = new Orden<>();
        orden1.setProducts(frutaRepo.findAll());
        ordenFrutaRepo.add(orden1);

        Orden<Fruta> orden2 = new Orden<>();
        Fruta[] frutas = new Fruta[]{frutaRepo.findById(1), frutaRepo.findById(2), frutaRepo.findById(3)};
        orden2.setProducts(Arrays.stream(frutas).toList());
        ordenFrutaRepo.add(orden2);

        //mostrar ordenes
        ordenFrutaRepo.findAll().forEach(e -> System.out.println(e.showDetails()));

        //orden de lacteos
        System.out.println("\nOrdenes de lacteos: ");
        BaseRepository<Orden<Lacteo>,Integer> ordenLacteoRepo = new OrdenRepository<>();
        Orden<Lacteo> orden3 = new Orden<>();
        orden3.setProducts(lacteoRepo.findAll());
        ordenLacteoRepo.add(orden3);

        //mostrar ordenes
        ordenLacteoRepo.findAll().forEach(e -> System.out.println(e.showDetails()));

        //orden de productos de limpieza
        System.out.println("\nOrdenes de productos de limpieza: ");
        BaseRepository<Orden<Limpieza>,Integer> ordenLimpiezaRepo = new OrdenRepository<>();
        Orden<Limpieza> orden4 = new Orden<>();
        orden4.setProducts(limpiezaRepo.findAll());
        ordenLimpiezaRepo.add(orden4);

        //mostrar ordenes
        ordenLimpiezaRepo.findAll().forEach(e -> System.out.println(e.showDetails()));

        //orden de productos no perecibles
        System.out.println("\nOrdenes de productos no perecibles: ");
        BaseRepository<Orden<NoPerecible>,Integer> ordenNoPerecibleRepo = new OrdenRepository<>();
        Orden<NoPerecible> orden5 = new Orden<>();
        orden5.setProducts(noPerecibleRepo.findAll());
        ordenNoPerecibleRepo.add(orden5);

        //mostrar ordenes
        ordenNoPerecibleRepo.findAll().forEach(e -> System.out.println(e.showDetails()));
    }
}