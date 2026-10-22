public class GestorHospitales {
    private PilaHospitales pilaHospitales;
    private int siguienteIdHospital;
    private int siguienteIdPaciente;


    public GestorHospitales() {
    pilaHospitales = new PilaHospitales();
    siguienteIdHospital = 1;
    siguienteIdPaciente = 1;
    }
    
    
/**
* Registra un nuevo hospital en el sistema
* @param nombre Nombre del hospital
* @return Mensaje de éxito o error
*/
    
    public String registrarHospital(String nombre) {
        // Validar que el nombre no esté vacío
        if (!Validaciones.esValidoNombre(nombre)) {
            return "ERROR: El nombre del hospital no puede estar vacío";
        }

        // Validar que haya espacio en la pila
        if (!Validaciones.hayEspacioPila(pilaHospitales)) {
            return "ERROR: No se pueden registrar más hospitales (máximo 20)";
        }

        // Crear el hospital con ID autogenerado
        Hospital hospital = new Hospital(siguienteIdHospital, nombre);

        // Agregar a la pila
        pilaHospitales.push(hospital);

        // Incrementar el contador para el siguiente ID
        siguienteIdHospital++;

        return "ÉXITO: Hospital registrado correctamente";
    }
    
/**
* Busca un hospital por su ID (sin modificar la pila)
* @param id ID del hospital a buscar
* @return El hospital encontrado o null si no existe
*/
    private Hospital buscarHospital(int id) {
        // Pila temporal para no perder los datos
        PilaHospitales temp = new PilaHospitales();
        Hospital encontrado = null;

        // Recorre la pila original
        while (!pilaHospitales.estaVacia()) {
            Hospital h = pilaHospitales.pop();
            if (h.getId() == id) {
                encontrado = h;
            }
            temp.push(h);
        }

        // Restaura la pila original
        while (!temp.estaVacia()) {
            pilaHospitales.push(temp.pop());
        }

        return encontrado;
    }

/**
 * Elimina el primer paciente (FIFO) de un hospital
 * @param idHospital ID del hospital
 * @return Mensaje de éxito o error
 */
    public String eliminarPaciente(int idHospital) {
        // Buscar el hospital
        Hospital hospital = buscarHospital(idHospital);

        // Validar que exista
        if (hospital == null) {
            return "ERROR: El hospital no existe";
        }

        // Valida que tenga pacientes
        if (!Validaciones.hayPacientes(hospital)) {
            return "ERROR: No hay pacientes en este hospital";
        }

        // Desencolar al primer paciente
        Paciente paciente = hospital.desencolar();

        return "ÉXITO: Paciente " + paciente.getNombre() + " eliminado";
    }
    
/**
* Registra un nuevo paciente en un hospital específico
* @param idHospital ID del hospital
* @param nombre Nombre del paciente
* @param tipo Tipo de atención (CONSULTA, EMERGENCIA, CIRUGIA)
* @return Mensaje de éxito o error
*/
    public String registrarPaciente(int idHospital, String nombre, TipoAtencion tipo) {
        // Buscar el hospital
        Hospital hospital = buscarHospital(idHospital);

        // Validar que exista
        if (hospital == null) {
            return "ERROR: El hospital no existe";
        }

        // Validar que el nombre no esté vacío
        if (!Validaciones.esValidoNombre(nombre)) {
            return "ERROR: El nombre del paciente no puede estar vacío";
        }

        // Validar que la cola tenga espacio
        if (!Validaciones.hayEspacioCola(hospital)) {
            return "ERROR: La cola del hospital está llena (máximo 20)";
        }

        // Crear el paciente con ID autogenerado
        Paciente paciente = new Paciente(siguienteIdPaciente, nombre, tipo);

        // Encolar en el hospital
        hospital.encolar(paciente);

        // Incrementar el contador para el siguiente ID
        siguienteIdPaciente++;

        return "ÉXITO: Paciente registrado correctamente";
    }
    
/**
 * Traslada TODOS los pacientes del hospital origen al destino
 * @param idOrigen ID del hospital que envía pacientes
 * @param idDestino ID del hospital que recibe pacientes
 * @return Mensaje de éxito o error
 */
    public String trasladarPacientes(int idOrigen, int idDestino) {
        // 1. Buscar los hospitales
        Hospital origen = buscarHospital(idOrigen);
        Hospital destino = buscarHospital(idDestino);

        // 2. Validar que existan
        if (origen == null || destino == null) {
            return "ERROR: Hospital no encontrado";
        }

        // 3. Validar que sean diferentes
        if (origen == destino) {
            return "ERROR: El hospital origen y destino deben ser diferentes";
        }

        // 4. Validar que el origen tenga pacientes
        if (origen.estaVacia()) {
            return "ERROR: El hospital origen no tiene pacientes";
        }

        // 5. Validar que el destino tenga espacio
        int pacientesOrigen = origen.getTotalPacientes();
        if (pacientesOrigen > destino.espacioDisponible()) {
            return "ERROR: El hospital destino no tiene suficiente espacio";
        }

        // 6. Trasladar uno por uno (FIFO)
        while (!origen.estaVacia()) {
            // 6.1 Sacar paciente del origen
            Paciente p = origen.desencolar();

            // 6.2 Asignar nuevo ID (global)
            int nuevoId = siguienteIdPaciente;
            siguienteIdPaciente++;

            // 6.3 Crear nuevo paciente con nuevo ID
            Paciente nuevoPaciente = new Paciente(nuevoId, p.getNombre(), 
                    p.getTipoAtencion());

            // 6.4 Encolar en el destino
            destino.encolar(nuevoPaciente);
        }

        // 7. Mensaje de éxito
        return "ÉXITO: Se trasladaron " + pacientesOrigen + " pacientes";
    }
    
    
/** 
 * Recorre la pila de hospitales y devuelve todos los hospitales en un arreglo.
 * @return Arreglo con todos los hospitales en orden de registro (el más antiguo primero)
 */
    public Hospital[] listarHospitales() {
        // 1. Obtener el total de hospitales
        int total = pilaHospitales.getTotal();

        // 2. Validar si está vacío
        if (total == 0) {
            return new Hospital[0]; // Arreglo vacío, evita NullPointerException
        }

        // 3. Crear el arreglo donde se guardarán los hospitales en orden
        Hospital[] resultado = new Hospital[total];

        // 4. Pila temporal para no perder los datos
        PilaHospitales temp = new PilaHospitales();

        // 5. Índice que empieza en la última posición del arreglo
        int indice = total - 1;

        // 6. Recorrer la pila original y guardar en el arreglo
        while (!pilaHospitales.estaVacia()) {
            Hospital h = pilaHospitales.pop();  // Saca el hospital de arriba
            resultado[indice] = h;              // Lo guarda en la posición correcta
            temp.push(h);                       // Lo guarda en la pila temporal
            indice--;                           // Baja el índice para la siguiente posición
        }

        // 7. Restaurar la pila original con los datos de la pila temporal
        while (!temp.estaVacia()) {
            pilaHospitales.push(temp.pop());
        }

        // 8. Devolver el arreglo ya ordenado
        return resultado;
    }
    
/**
 * Elimina el ÚLTIMO hospital registrado (LIFO)
 * @param idHospital ID del hospital a eliminar
 * @return Mensaje de éxito o error
 */
    public String eliminarHospital(int idHospital) {
        // 1. Verificar que la pila no esté vacía
        if (pilaHospitales.estaVacia()) {
            return "ERROR: No hay hospitales registrados";
        }

        // 2. Obtener el último hospital de la pila (sin sacarlo aún)
        Hospital ultimo = pilaHospitales.top();

        // 3. Validar que el ID del último coincida con el solicitado (LIFO)
        if (ultimo.getId() != idHospital) {
            return "ERROR: Solo se puede eliminar el último hospital registrado";
        }

        // 4. Validar que la cola del hospital esté vacía
        if (!ultimo.estaVacia()) {
            return "ERROR: No se puede eliminar un hospital con pacientes";
        }

        // 5. Eliminar el hospital (pop)
        pilaHospitales.pop();

        // 6. Devolver mensaje de éxito
        return "ÉXITO: Hospital eliminado correctamente";
    }
}
