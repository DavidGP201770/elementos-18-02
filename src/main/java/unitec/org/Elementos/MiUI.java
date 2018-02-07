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
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.components.grid.MultiSelectionModel;
import com.vaadin.ui.themes.ValoTheme;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author DavidUGP-Work
 */
@SpringUI
@Theme("valo")
public class MiUI extends UI {

    TextField t1;
    TextField t2;
    Integer myid;

    @Autowired
    RepositorioMensajitos repoMensa;

    @Override
    protected void init(VaadinRequest request) {
        //Agregaremos un layout vertical y dentro de el
        //las componentes que quedaran en orden descendente

        t1 = new TextField();
        t2 = new TextField();

        VerticalLayout layout = new VerticalLayout();
        Label e1 = new Label("David Uriel García Pérez");
        e1.addStyleName(ValoTheme.LABEL_H1);

        /*Button b1 = new Button("Guardar");
        b1.addStyleName(ValoTheme.BUTTON_PRIMARY);

        //vamos a programar el evento del boton usando prof funcional
        b1.addClickListener(algo -> {
            //aqui ponemos el evento
            e1.setValue("Mi primer programación funcional");
        });
         */
        List<Mensajitos> mensaj = (List<Mensajitos>) repoMensa.findAll();

        Grid<Mensajitos> grid = new Grid<>();
        grid.setItems(mensaj);
        grid.addColumn(Mensajitos::getId).setCaption("ID");
        grid.addColumn(Mensajitos::getTitulo).setCaption("Titulo");
        grid.addColumn(Mensajitos::getCuerpo).setCaption("Cuerpo");
        
        
        MultiSelectionModel<Mensajitos> selectionModel
                = (MultiSelectionModel<Mensajitos>) grid.setSelectionMode(SelectionMode.MULTI);

        grid.addSelectionListener(event -> {
            Set<Mensajitos> selected = event.getAllSelectedItems();
            Notification.show(selected.size() + " registro(s) seleccionados");
        });

        grid.setSelectionMode(SelectionMode.SINGLE);
        
        grid.addItemClickListener(evento -> {
            //Notification.show("Valor: " + evento.getItem().getTitulo());
            MiVentana sub = new MiVentana();

            myid = evento.getItem().getId();

            t1.setValue(evento.getItem().getTitulo());
            t2.setValue(evento.getItem().getCuerpo());

            UI.getCurrent().addWindow(sub);
            
        });

        
        grid.getDataProvider().refreshAll();
        grid.clearSortOrder();
        //AGREGAMOS LAS COMPONENTES DEL LAYOUT
        layout.addComponent(e1);
        //layout.addComponent(b1);
        layout.addComponent(grid);

        //esto solo se hace una vez agrega el layout a la index
        setContent(layout);

    }

    class MiVentana extends Window {

        public MiVentana() {
            super("Actualizar");
            center();
            VerticalLayout vl2 = new VerticalLayout();

            Button boton = new Button("Actualizar");
            boton.addClickListener(evento -> {
                //antes se invoca el
                repoMensa.save(new Mensajitos(myid, t1.getValue(), t2.getValue()));

                close();
            });
            vl2.addComponent(t1);
            vl2.addComponent(t2);
            vl2.addComponent(boton);

            setContent(vl2);
        }
    }

}
