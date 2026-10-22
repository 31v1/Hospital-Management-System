public class ColaPacientes {
    //Atributos
    
    private Paciente[] pacientes;
    private int inicio;
    private int fin;
    private int total;
    
    //Constructor
    
    public ColaPacientes(){
        pacientes = new Paciente[20];
        inicio = 0;
        fin = -1;
        total = 0;
    }
    
    //Metodos
    
    public boolean estaVacia(){
        return total == 0;
    }
    
    public boolean estaLlena(){
        return total == pacientes.length;
    }
    
    public void encolar (Paciente p){
        if (estaLlena()){
            return;
        }
        fin++;
        pacientes[fin] = p;
        total++;
    }
    
    public Paciente desencolar() {
        if (estaVacia()){
            return null;
        }
        Paciente p = pacientes[inicio];
        inicio++;
        total--;
        return p;     
    }
    
    public int getTotal() {
        return total;
    }
    
    public int espacioDisponible() {
        return pacientes.length - total;
    }
    
    

}
