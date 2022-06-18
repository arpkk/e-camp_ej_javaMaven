package ejemploMockito.repositorio;

import ejemploMockito.modelo.Persona;

import java.util.HashMap;
import java.util.Map;

public class RepositorioPersona {
    //crear - actualizar - liste -eliminar

    private Map<String,String> baseDeDatos = new HashMap<String,String>();

    public String crearPersona(Persona persona){
        baseDeDatos.put(persona.getRut(),persona.getNombre());
        return "Persona creada";
    }

    public String actualizarPersona(Persona persona){
        baseDeDatos.put(persona.getRut(),persona.getNombre());
        return "Persona actualizada";
    }

    public Map<String,String> listarPersonas(){
        return baseDeDatos;
    }

    public String eliminarPersona(Persona persona){
        baseDeDatos.remove(persona.getRut());
        return "Persona eliminada";
    }
}
