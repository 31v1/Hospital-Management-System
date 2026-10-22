public class Hospital {
    //Atributos
    
    private int id;
    private String nombreHospital;
    private ColaPacientes cola;
    
    //Setters

    public void setNombreHospital(String nombreHospital) {
        this.nombreHospital = nombreHospital;
    }

    //Getters
    
    public int getId() {
        return id;
    }

    public String getNombreHospital() {
        return nombreHospital;
    }
    
    public ColaPacientes getCola(){
        return cola;
    }

    
    //Constructor

    public Hospital(int id, String nombreHospital) {
        this.id = id;
        this.nombreHospital = nombreHospital;
        this.cola = new ColaPacientes(); // // Cada hospital crea su propia cola
    }
    
    public void encolar (Paciente p) {
        cola.encolar(p);
    }
    
    public Paciente desencolar(){
        return cola.desencolar();
    }
    
    public boolean estaVacia(){
        return cola.estaVacia();
    }    
    
    public boolean estaLlena(){
        return cola.estaLlena();
    }
    
    public int getTotalPacientes(){
        return cola.getTotal();
    }
    
    public int espacioDisponible(){
        return cola.espacioDisponible();
    }
    
    @Override
    public String toString() {
        return "Hospital{id=" + id + ", nombre=" + nombreHospital 
                + ", pacientes=" + cola.getTotal() + "}";
    }
    
}
