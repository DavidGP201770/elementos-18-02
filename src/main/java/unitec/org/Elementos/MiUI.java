/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitec.org.Elementos;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.GridContextClickEvent;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.components.grid.MultiSelectionModel;
import com.vaadin.ui.themes.ValoTheme;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author DavidUGP-Work
 */

@SpringUI
@Theme("valo")
public class MiUI extends UI {
@Autowired RepositorioMensajitos repoMensa;
    @Override
    protected void init(VaadinRequest request) {
        //Agregaremos un layout vertical y dentro de el
        //las componentes que quedaran en orden descendente
        
        VerticalLayout layout=new VerticalLayout();
        Label e1=new Label("David Uriel García Pérez");
        e1.addStyleName(ValoTheme.LABEL_H1);
        
        Button b1=new Button("Guardar");
        b1.addStyleName(ValoTheme.BUTTON_PRIMARY);
        
        //vamos a programar el evento del boton usando prof funcional
        b1.addClickListener(algo->{
            //aqui ponemos el evento
            e1.setValue("Mi primer programación funcional");
        });
        
        List<Mensajitos> mensaj = (List<Mensajitos>) repoMensa.findAll();
    
        Grid<Mensajitos> grid = new Grid<>();
        grid.setItems(mensaj);
        grid.addColumn(Mensajitos::getId).setCaption("ID");
        grid.addColumn(Mensajitos::getTitulo).setCaption("Titulo");
        grid.addColumn(Mensajitos::getCuerpo).setCaption("Cuerpo");
        
        MultiSelectionModel<Mensajitos> selectionModel =
      (MultiSelectionModel<Mensajitos>) grid.setSelectionMode(SelectionMode.MULTI);
        
        grid.addContextClickListener(event -> Notification.show(
        ((GridContextClickEvent<Mensajitos>)event).getItem() + " Clicked")
  );
    
        //AGREGAMOS LAS COMPONENTES DEL LAYOUT
        layout.addComponent(e1);
        layout.addComponent(b1);
        layout.addComponent(grid);
         
        //esto solo se hace una vez agrega el layout a la index
        setContent(layout);
        
    }
    
}
