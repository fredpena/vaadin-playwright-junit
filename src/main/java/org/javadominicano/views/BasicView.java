package org.javadominicano.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

/**
 * @author me@fredpena.dev
 * @created 22/06/2025  - 18:32
 */
@PageTitle("Basic Form")
@Route("basic")
@RouteAlias("")
public class BasicView extends VerticalLayout {

    public BasicView() {
        Paragraph paragraph = new Paragraph("");
        paragraph.setId("msg");

        Button button = new Button("Click me");
        button.setId("btn");
        button.addClickListener(event -> {
            paragraph.setText("Clicked!");
        });

        add(paragraph, button);
    }
}
