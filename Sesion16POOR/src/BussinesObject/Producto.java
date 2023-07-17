package BussinesObject;

import DataAccesObject.ProductoDAO;
import TransferObject.ProductoDTO;
import java.util.List;

public class Producto {

    private ProductoDAO productoDAO;
    private ProductoDTO productoDTO;

    public Producto() {
        productoDAO = new ProductoDAO();
    }

    public String agregar(int codproducto, String nombre, float precio, int stock, int codcategoria) {
        String mensaje;
        productoDTO = new ProductoDTO(codproducto, nombre, precio, stock, codcategoria);
        if (productoDAO.agregar(productoDTO)) {
            mensaje = "Registro Insertado";
        } else {
            mensaje = "Registro no Insertado";
        }
        return mensaje;
    }

    public String actualizar(int codproducto, String nombre, float precio, int stock, int codcategoria) {
        String mensaje;
        productoDTO = new ProductoDTO(codproducto, nombre, precio, stock, codcategoria);
        if (productoDAO.actualizar(productoDTO)) {
            mensaje = " se actualizó exitosamente";
        } else {
            mensaje = "Error , no se pudo actualizar";
        }
        return mensaje;
    }

    public String eliminar(int codproducto) {
        String mensaje;
        productoDTO = new ProductoDTO(codproducto);
        if (productoDAO.eliminar(productoDTO)) {
            mensaje = "Registro Eliminado";
        } else {
            mensaje = "Registro no eliminado";
        }
        return mensaje;
    }

    public ProductoDTO buscar(int codproducto) {
        productoDTO = productoDAO.buscar(new ProductoDTO(codproducto));
        if (productoDTO != null) {
            return productoDTO;
        }

        return null;

    }

    public List<ProductoDTO> listar() {
        if (productoDAO.listar() != null) {
            List<ProductoDTO> lista = productoDAO.listar();
            return lista;
        }
        return null;
    }
}
