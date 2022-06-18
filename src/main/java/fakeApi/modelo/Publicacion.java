package fakeApi.modelo;

public class Publicacion {

    //generando atributos privados en el pojo Publicacion,
    //para replicar la estructura del json a consumir
    private Integer userId;
    private Integer id;
    private String title;
    private String body;

    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Publicacion [userId=" + userId + ", id=" + id + ", title=" + title + ", body=" + body + "]";
    }

}