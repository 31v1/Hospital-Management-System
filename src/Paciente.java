public class Paciente {
    //Atributos
    
    private int id;
    private String nombre;
    private TipoAtencion tipoAtencion;
    
    //Setters

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipoAtencion(TipoAtencion tipoAtencion) {
        this.tipoAtencion = tipoAtencion;
    }
    
    //Getters

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoAtencion getTipoAtencion() {
        return tipoAtencion;
    }
    
    //Constructor

    public Paciente(int id, String nombre, TipoAtencion tipoAtencion) {
        this.id = id;
        this.nombre = nombre;
        this.tipoAtencion = tipoAtencion;
    }

    @Override
    public String toString() {
        return "Paciente{" + "id=" + id + ", nombre=" + nombre + ", tipoAtencion=" + tipoAtencion + '}';
    } 
}
