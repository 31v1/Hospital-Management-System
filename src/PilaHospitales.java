public class PilaHospitales {
    
    //Atributos
    private Hospital[] hospitales;
    private int tope;
    
    //Constructor

    public PilaHospitales() {
        hospitales = new Hospital[20];
        tope = -1;
    }
        
    public boolean estaLlena(){
            return tope == 19;
        }
    
    public boolean estaVacia(){
        return tope == -1;
    }
    
    public boolean push(Hospital h) {
        if (estaLlena()) {
            return false;
        }
        tope++;
        hospitales[tope] = h;
        return true;
    }
    
    public Hospital pop() {
        if (estaVacia()) {
            return null;
        }
        Hospital h = hospitales[tope];
        tope--;
        return h;
    }
    
    public Hospital top() {
        if (estaVacia()) {
            return null;
        }
        return hospitales[tope];
    }
    
    public int getTotal(){
        return tope + 1;
    }
    
}
