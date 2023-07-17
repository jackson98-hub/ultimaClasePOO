
package TransferObject;

public class ProductoDTO {
    private int codproducto;
    private String nombre;
    private float precio;
    private int stock;
    private int codcategoria;

    public ProductoDTO() {
    }

    public ProductoDTO(int codproducto) {
        this.codproducto = codproducto;
    }

    public ProductoDTO(int codproducto, String nombre, float precio, int stock, int codcategoria) {
        this.codproducto = codproducto;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.codcategoria = codcategoria;
    }

    public int getCodproducto() {
        return codproducto;
    }

    public void setCodproducto(int codproducto) {
        this.codproducto = codproducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getCodcategoria() {
        return codcategoria;
    }

    public void setCodcategoria(int codcategoria) {
        this.codcategoria = codcategoria;
    }
    
    
}
