public class producto {
    String nombre;
    int precio;
    public String getNombre() {
        return nombre;
    }
    public int getPrecio() {
        return precio;
    }
    public void setNombre(String nom)
    {
        this.nombre = nom;
    }
    public void setPrecio(int precio)
    {
        this.precio = precio;
    }
    public int compareTo(producto producto1, producto producto2)
    {
        return producto.getPrecio() - producto2.getPrecio();
    }
    public producto() {
    }
    public producto existeproducto(String nombre)
    {
        if
}
}
