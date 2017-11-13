

import java.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class ProductManagerImpl implements Fachada {

    private static final Logger logger = LogManager.getLogger(ProductManager.class.getName());
    HashMap<String,Usuario> usuarios;
    HashMap<String,producto> productos;
    private static ProductManagerImpl miManager;

    //private static final Logger logger = LogManager.getLogger(EtakemonManager.class.getName());

    private ProductManagerImpl() {
        this.usuarios = new HashMap<String, Usuario>();
    }

    public static ProductManagerImpl getInstance() {
        if(miManager ==null)
            miManager = new ProductManagerImpl();
        return miManager;
    }

    //public Collection<Usuario> listaUsuariosAlfabetica() {


    public ArrayList<producto> listarPorPrecio() {
        ArrayList<producto> productosporprecio = new ArrayList<producto>(productos.values());
        Collections.sort(productosporprecio, new Comparator(){
            public int compare(producto p1, producto p2) {
                return new Integer(p1.getPrecio()).compareTo(new Integer(p2.getPrecio()));
            }
        };
        logger.info("retornem llistat ordenat");
        return productosporprecio;}
    public void RealizarPedido(String nombrecliente, String nombreproducto, int cantidad) {
        Usuario misuario = new Usuario();
        producto miproducto = new producto();
        int i = 0;
        if (usuarios.containsKey(nombrecliente)) {
            misuario = usuarios.get(nombrecliente);
            while (i < cantidad) {
                miproducto = productos.get(nombreproducto);
                if (miproducto == null) {
                    logger.error("el producte no existeix");
                    i=cantidad;
                } else {
                    misuario.añadirproducto(miproducto);
                    i++;

                }
            }
        } else {

            logger.info("el usuari no existeix");
        }
    }
    public ArrayList<producto> misPedidos(String nombre)
    {
        if(usuarios.get(nombre)==null) {
            logger.error("este usuario no ha realizado ningun pedido");
            return null;
        }
        for (producto miproducto :usuarios.get(nombre).getProductos()) {
            logger.info("misproductos pedidods son"+miproducto);
        }

        return usuarios.get(nombre).getProductos();
    }
    public void reiniciarSingleton()
    {
        miManager = null;
    }
}
