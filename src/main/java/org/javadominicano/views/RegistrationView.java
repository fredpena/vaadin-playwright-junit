package org.javadominicano.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

/**
 * @author me@fredpena.dev
 * @created 22/06/2025  - 19:37
 */
@PageTitle("Registration Form")
@Route("registration")
public class RegistrationView extends VerticalLayout {

    public RegistrationView() {
        H1 title = new H1("Registration Form");

        TextField username = new TextField("Username");
        username.setId("username");

        EmailField email = new EmailField("Email");
        email.setId("email");

        Checkbox terms = new Checkbox("I accept the terms and conditions");
        terms.setId("terms");

        Button submit = new Button("Submit");
        submit.setId("submit");

        Paragraph description = new Paragraph();
        description.setId("msg");

        submit.addClickListener(event -> {
            if (username.isEmpty() || email.isEmpty() || !terms.getValue()) {
                description.setText("Please fill out all fields and accept the terms and conditions.");
            } else {
                description.setText("Registration successful! Username: " + username.getValue() + ", Email: " + email.getValue());
            }
        });

        add(title, username, email, terms, submit, description);

    }

}
