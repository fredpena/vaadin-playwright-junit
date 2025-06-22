package org.javadominicano;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

/**
 * @author me@fredpena.dev
 * @created 22/06/2025  - 18:52
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class MultiButtonViewTest extends PlaywrightIT {

    @LocalServerPort
    private int port;

    @Test
    void display_basic_view() {
        page.navigate("http://localhost:" + port + "/multi");

        assertThat(page).hasTitle("Multi Button Form");

        assertThat(page.locator("#name-field")).isVisible();
        assertThat(page.locator("#last-name-field")).isVisible();
        assertThat(page.locator("#btn1")).isVisible();
        assertThat(page.locator("#btn2")).isVisible();
        assertThat(page.locator("#btn3")).isVisible();

        page.locator("#btn1").click();
        assertThat(page.locator("#msg")).containsText("Button 1 Clicked!");

        page.locator("#btn2").click();
        assertThat(page.locator("#msg")).containsText("Button 2 Clicked!");

        page.fill("vaadin-text-field[id='name-field'] > input", "Fred");
        page.fill("vaadin-text-field[id='last-name-field'] > input", "Pena");

        page.locator("#btn3").click();
        assertThat(page.locator("#msg")).containsText("Button 3 Clicked! Name: Fred, Last Name: Pena");

    }
}
