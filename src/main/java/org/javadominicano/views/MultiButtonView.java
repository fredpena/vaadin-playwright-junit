package org.javadominicano.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

/**
 * @author me@fredpena.dev
 * @created 22/06/2025  - 19:12
 */
@PageTitle("Multi Button Form")
@Route("multi")
public class MultiButtonView extends VerticalLayout {


    public MultiButtonView() {

        TextField nameField = new TextField("Name");
        nameField.setId("name-field");

        TextField lastNameField = new TextField("Last Name");
        lastNameField.setId("last-name-field");

        Paragraph paragraph = new Paragraph("");
        paragraph.setId("msg");


        Button button1 = new Button("Button 1", e -> {
            paragraph.setText("Button 1 Clicked!");
        });
        button1.setId("btn1");

        Button button2 = new Button("Button 2", e -> {
            paragraph.setText("Button 2 Clicked!");
        });
        button2.setId("btn2");

        Button button3 = new Button("Button 3", e -> {
            paragraph.setText("Button 3 Clicked! Name: " + nameField.getValue() + ", Last Name: " + lastNameField.getValue());
        });
        button3.setId("btn3");

        Button button4 = new Button();
        button4.setVisible(false);
        button4.setId("btn4");

        add(nameField, lastNameField, paragraph, button1, button2, button3, button4);

    }
}
