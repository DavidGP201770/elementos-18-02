/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitec.org.Elementos;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//TODAS LAS ENTIDADES CON JPA :V

@Entity
public class Mensajitos {
    @Id
    //@Column(name="nombredelidenlatabla") POR SI EL ID NO SE LLAMA IGUAL
    @GeneratedValue // id autoincrementado
    private Integer id;
    private String titulo;
    private String cuerpo;

    public Mensajitos() { //SELECT
    } 

    public Mensajitos(Integer id) { // DELETE / WHERE
        this.id = id;
    }

    public Mensajitos(String titulo, String cuerpo) { //CREATE
        this.titulo = titulo;
        this.cuerpo = cuerpo;
    }

    public Mensajitos(Integer id, String titulo, String cuerpo) { //UPDATE
        this.id = id;
        this.titulo = titulo;
        this.cuerpo = cuerpo;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }
}
