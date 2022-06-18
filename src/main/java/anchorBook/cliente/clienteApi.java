package anchorBook.cliente;


import anchorBook.modelo.Book;
import anchorBook.modelo.BookDetail;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Objects;

public class clienteApi {

    public static void main(String[] args) {
        List<Book> listaBook = obtenerPostBook();
        List<BookDetail> listaDetail= obtenerPostDetail();
        listaBook(listaBook);
        //listaAutorTitulo(listaBook);
        //print3y8(listaBook);
        //listaDetail(listaDetail);
        //listaAnonimos(listaDetail);
        //listaDelivery(listaDetail);
    }

    //_________________________Book__________________//
    private static List<Book> obtenerPostBook() {

        Client client = ClientBuilder.newClient();

        WebTarget target = client.target("https://my-json-server.typicode.com/Himuravidal/anchorBooks").path("books");

        Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
        Response respuestaBook = invocationBuilder.get();

        System.out.println(respuestaBook);

        return respuestaBook.readEntity(new GenericType<List<Book>>() {
        });
    }

    private static void listaBook(List<Book> lista) {
        for (Book Book : lista) {
            System.out.println(Book + "\n");
        }
    }

    private static void listaAutorTitulo(List<Book> lista) {
        for (Book Book : lista) {
            System.out.println(Book.getAuthor() + ": " + Book.getTitle());
        }
    }

    private static void print3y8(List<Book> lista) {
        Book libro3 = lista.get(3);
        Book libro8 = lista.get(8);
        System.out.println("Libro 3: " + libro3.getAuthor() + ", " + libro3.getTitle() + ", " + libro3.getCountry());
        System.out.println("Libro 8: " + libro8.getAuthor() + ", " + libro8.getTitle() + ", " + libro8.getCountry());
    }

    //_________________________BookDetail__________________//
    private static List<BookDetail> obtenerPostDetail() {
        Client client = ClientBuilder.newClient();

        WebTarget target = client.target("https://my-json-server.typicode.com/Himuravidal/anchorBooks").path("bookDetail");

        Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
        Response respuestaDetail = invocationBuilder.get();

        System.out.println(respuestaDetail);

        return respuestaDetail.readEntity(new GenericType<List<BookDetail>>() {
        });
    }

    private static void listaDetail(List<BookDetail> lista) {
        for (BookDetail Detail : lista) {
            System.out.println(Detail + "\n");
        }
    }

    private static void listaAnonimos(List<BookDetail> lista){
        System.out.println("Autores anónimos:\n");
        for (BookDetail Detail : lista) {
            if(Objects.equals(Detail.getAuthor(), "Unknown")){
                System.out.println("Autor: "+Detail.getAuthor()+" - libro: "+Detail.getTitle());
            }
        }
    }

    private static void listaDelivery(List<BookDetail> lista){
        System.out.println("Libros con delivery disponibles:\n");
        for (BookDetail Detail : lista) {
            if(Detail.isDelivery()){
                System.out.println("Libro: "+Detail.getTitle());
            }
        }
    }

}
