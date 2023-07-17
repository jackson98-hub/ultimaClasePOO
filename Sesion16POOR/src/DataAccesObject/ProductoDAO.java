
package DataAccesObject;

import DataSource.Conexion;
import TransferObject.ProductoDTO;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.*;

public class ProductoDAO implements ICrud<ProductoDTO>{
    PreparedStatement ps; //insert, update, delete
    ResultSet rs; // select
    Conexion conexion;
    
    public ProductoDAO(){
        conexion= new Conexion();
    }   

    @Override
    public boolean agregar(ProductoDTO t) {
        int r = 0;
        try {
            ps = conexion.conectar().prepareStatement("insert into producto(codproducto,nombre,"
                    + "precio,stock,codcategoria)values(?,?,?,?,?)");
            ps.setInt(1, t.getCodproducto());
            ps.setString(2, t.getNombre());
            ps.setFloat(3, t.getPrecio());
            ps.setInt(4, t.getStock());
            ps.setInt(5, t.getCodcategoria());
            r = ps.executeUpdate();//ejecutar la sentencia sql
            return r == 1;
        } catch (SQLException ex) {
            return false;
        } finally {
            conexion.desconectar();
        }   
    }

    @Override
    public boolean actualizar(ProductoDTO t) {
        int r = 0;
        try {
            ps = conexion.conectar().prepareStatement("update producto set nombre=?,precio=?,stock=?,codcategoria=? where codproducto=?");
            ps.setString(1, t.getNombre());
            ps.setFloat(2, t.getPrecio());
            ps.setInt(3, t.getStock());
            ps.setInt(4, t.getCodcategoria());
            ps.setInt(5, t.getCodproducto());
            r = ps.executeUpdate();
            return r == 1;
        } catch (SQLException ex) {
            return false;
        } finally {
            conexion.desconectar();
        }
    }

    @Override
    public boolean eliminar(ProductoDTO t) {
         int r = 0;
        try {
            ps = conexion.conectar().prepareStatement("delete from producto where codproducto=?");
            ps.setInt(1, t.getCodproducto());
            r = ps.executeUpdate();
            return r == 1;
        } catch (SQLException ex) {
            return false;
        } finally {
            conexion.desconectar();
        }
    }

    @Override
    public ProductoDTO buscar(ProductoDTO t) {
        boolean encontrado = false;
        try {
            ps = conexion.conectar().prepareStatement("select * from producto where codproducto=?");
            ps.setInt(1, t.getCodproducto());
            rs = ps.executeQuery();
            while (rs.next()) {
                t.setCodproducto(rs.getInt(1));
                t.setNombre(rs.getString(2));
                t.setPrecio(rs.getFloat(3));
                t.setStock(rs.getInt(4));
                t.setCodcategoria(rs.getInt(5));
                encontrado=true;
            }
            if (encontrado) {
                return t;
            } else {
                return null;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        } finally {
            conexion.desconectar();
        }
    }

    @Override
    public List<ProductoDTO> listar() {
        List<ProductoDTO> lista = new ArrayList<>();
        try {
            ps = conexion.conectar().prepareStatement("select * from producto");
            rs=ps.executeQuery();
            while (rs.next()) {
                ProductoDTO t = new ProductoDTO();
                t.setCodproducto(rs.getInt(1));
                t.setNombre(rs.getString(2));
                t.setPrecio(rs.getFloat(3));
                t.setStock(rs.getInt(4));
                t.setCodcategoria(rs.getInt(5));
                lista.add(t);
            }
          } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }finally{
            conexion.desconectar();
        }
        return lista;
    
    }

      
}
