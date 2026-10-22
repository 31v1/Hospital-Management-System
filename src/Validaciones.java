public class Validaciones {
 
/**
 * Valida si el nombre es válido (no nulo y no vacío)
 * @param nombre el nombre a validar
 * @return true si es válido, false si está vacío o nulo
 */
    public static boolean esValidoNombre(String nombre) {
        return nombre != null && !nombre.trim().isEmpty();        
    }
    
/**
* Valida si hay espacio disponible en la pila de hospitales
* @param pila la pila a verificar
* @return true si hay espacio (no está llena), false si está llena
*/    
    public static boolean hayEspacioPila(PilaHospitales pila){
        return !pila.estaLlena();
    }

/**
* Valida si hay al menos un hospital registrado en la pila
* @param pila la pila a verificar
* @return true si hay hospitales, false si está vacía
*/
    public static boolean hayHospitales(PilaHospitales pila){
        return !pila.estaVacia();
    }

/**
 * Valida si hay espacio disponible en la cola de pacientes del hospital
 * @param hospital el hospital a verificar
 * @return true si hay espacio, false si está llena
 */    
    public static boolean hayEspacioCola(Hospital hospital){
        return !hospital.estaLlena();
    }
    
/**
* Valida si hay pacientes en la cola del hospital
* @param hospital el hospital a verificar
* @return true si hay pacientes, false si está vacía
*/   
    public static boolean hayPacientes(Hospital hospital){
        return !hospital.estaVacia();
    }
    
/**
* Valida si hay al menos algun hospital registrado
* @param pila la pila de hospitales
* @param minimo el número mínimo requerido (ej: 2)
* @return true si hay suficientes, false si no
*/
    public static boolean hayMinimoHospitales(PilaHospitales pila, int minimo) {
        return pila.getTotal() >= minimo;
    } 
    
/**
 * Valida si dos IDs de hospital son diferentes
 * @param idOrigen ID del hospital origen
 * @param idDestino ID del hospital destino
 * @return true si son diferentes, false si son iguales
 */
    public static boolean sonDiferentes(int idOrigen, int idDestino) {
        return idOrigen != idDestino;
    }
    
/**
* Valida si el hospital destino tiene suficiente espacio para recibir pacientes
* @param destino el hospital destino
* @param pacientesOrigen cantidad de pacientes a trasladar
* @return true si cabe, false si no hay suficiente espacio
*/
    public static boolean cabeEnDestino(Hospital destino, int pacientesOrigen) {
        return pacientesOrigen <= destino.espacioDisponible();
    }
    

}
