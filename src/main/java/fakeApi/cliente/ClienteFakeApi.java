package fakeApi.cliente;

import fakeApi.modelo.Publicacion;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.client.Entity.entity;

public class ClienteFakeApi {

	public static void main(String[] args) {
		// controlador
		//obtenerPost();
		crearPost();
		System.out.println("---------------------------------------------------");
		actualizarPost();
		System.out.println("---------------------------------------------------");
		borrarPost();

	}
	
	//SIMULANDO UN CRUD (CREATE - READ - UPDATE - DELETE)
	
	//GET https://jsonplaceholder.typicode.com/posts --> endpoint
	private static void obtenerPost() {
		
		Client client = ClientBuilder.newClient();
		
		WebTarget target = client.target("https://jsonplaceholder.typicode.com").path("posts");
		
		Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
		
		Response respuestaPublicaciones =  invocationBuilder.get();
		
		System.out.println(respuestaPublicaciones);
		
		List<Publicacion> listaPublicaciones = respuestaPublicaciones.readEntity(new GenericType<List<Publicacion>>(){});


		for (Publicacion publicacion : listaPublicaciones) {
			System.out.println(publicacion + "\n");
		}
			
	}
	
	//POST
	private static void crearPost() {
		
		Publicacion publicacion = new Publicacion();
		publicacion.setTitle("Nueva pub");
		publicacion.setBody("el body de la pub");
		publicacion.setUserId(1);
		publicacion.setId(101);
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("https://jsonplaceholder.typicode.com").path("posts");
		Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
		Response respuestaPublicacion = invocationBuilder.post(entity(publicacion, MediaType.APPLICATION_JSON));
		
		if(respuestaPublicacion.getStatus() == 201) {
			System.out.println("publicacion titulo : " + publicacion.getTitle() + " guardado correctamente \n");
			obtenerPost();
		}
		
		
	}
	
	//PUT
	private static void actualizarPost() {
		Publicacion publicacion = new Publicacion();
		publicacion.setTitle("Nueva pub");
		publicacion.setBody("el body de la pub actualizado");
		publicacion.setUserId(1);
		publicacion.setId(101);
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("https://jsonplaceholder.typicode.com").path("posts").path("1");
		Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
		
		Response respuestaPublicacion = invocationBuilder.put(entity(publicacion, MediaType.APPLICATION_JSON));
		
		System.out.println(respuestaPublicacion);

	}
	
	//DELETE
	private static void borrarPost() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("https://jsonplaceholder.typicode.com").path("posts").path("101");
		Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
		Response respuestaPublicacion = invocationBuilder.delete();
		System.out.println(respuestaPublicacion);
	}

}
