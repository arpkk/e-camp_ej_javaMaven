package ejemploMockito.repositorio;

import ejemploMockito.modelo.Persona;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class RepositorioPersonaTest {
    private RepositorioPersona repositorioPersona = mock(RepositorioPersona.class);

    @Test
    public void crearPersona() {
        Persona juan = new Persona("123453-2","Juan");
        when(repositorioPersona.crearPersona(juan)).thenReturn("Persona creada");
        String respuesta = repositorioPersona.crearPersona(juan);
        assertEquals("Persona creada",respuesta);
        verify(repositorioPersona).crearPersona(juan);
    }

    @Test
    public void crearPersonaNull() {
        when(repositorioPersona.crearPersona(null)).thenThrow(new NullPointerException());
    }

    @Test
    public void actualizarPersona() {
        Persona juan = new Persona("123453-2","Juan");
        when(repositorioPersona.actualizarPersona(juan)).thenReturn("Persona actualizada");
        String respuesta = repositorioPersona.actualizarPersona(juan);
        assertEquals("Persona actualizada",respuesta);
        verify(repositorioPersona).actualizarPersona(juan);

    }

    @Test
    public void listarPersonas() {
    }

    @Test
    public void eliminarPersona() {
    }
}