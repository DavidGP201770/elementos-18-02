package unitec.org.Elementos;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ElementosApplication implements CommandLineRunner{ // simula comandos en desktop

@Autowired RepositorioMensajitos RepoMensa; // ENLAZA EL REPO QUE TIENE TODAS LAS CRUD

	public static void main(String[] args) {
		SpringApplication.run(ElementosApplication.class, args);
	}

    @Override
    public void run(String... strings) throws Exception {
        //UPDATE
        //Mensajitos m = new Mensajitos("primero","Mi primer mensajito con hiberante");
        //RepoMensa.save(m);
        
        //SELECT *
        
        /*ArrayList<Mensajitos> mensajitos =(ArrayList<Mensajitos>)RepoMensa.findAll();
        for(Mensajitos mensa:mensajitos){
        
            System.out.println(mensa.getTitulo());
            System.out.println(mensa.getCuerpo());
        
        }
        */
        
        //BUSCAR POR ID
           //Mensajitos m1=RepoMensa.findOne(1);
           //System.out.println(m1.getTitulo());
           
        //
          /*  RepoMensa.save(new Mensajitos(1,"otro",""));
            ArrayList<Mensajitos> mensajitos =(ArrayList<Mensajitos>)RepoMensa.findAll();
        for(Mensajitos mensa:mensajitos){
         
            System.out.println(mensa.getTitulo());
            System.out.println(mensa.getCuerpo());
        }
            */
        // BORRAR
        RepoMensa.delete(1);
        
        ArrayList<Mensajitos> mensajitos =(ArrayList<Mensajitos>)RepoMensa.findAll();
        for(Mensajitos mensa:mensajitos){
         
            System.out.println(mensa.getTitulo());
            System.out.println(mensa.getCuerpo());
        }
    }
}
