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
public class RegistrationTest extends PlaywrightIT {

    @LocalServerPort
    private int port;

    @Test
    void display_term_view() {
        page.navigate("http://localhost:" + port + "/registration");

        assertThat(page).hasTitle("Registration Form");

        assertThat(page.locator("h1")).isVisible();
        assertThat(page.locator("#username")).isVisible();
        assertThat(page.locator("#email")).isVisible();
        assertThat(page.locator("#terms")).isVisible();
        assertThat(page.locator("#submit")).isVisible();

        page.fill("vaadin-text-field[id='username'] > input", "Fred");
        page.fill("vaadin-email-field[id='email'] > input", "me@fredpena.dev");

        page.locator("#terms").click();
        page.locator("#submit").click();

        assertThat(page.locator("#msg")).containsText("Registration successful! Username: Fred, Email: me@fredpena.dev");

    }

    @Test
    void display_no_term_view() {
        page.navigate("http://localhost:" + port + "/registration");

        assertThat(page).hasTitle("Registration Form");

        assertThat(page.locator("h1")).isVisible();
        assertThat(page.locator("#username")).isVisible();
        assertThat(page.locator("#email")).isVisible();
        assertThat(page.locator("#terms")).isVisible();
        assertThat(page.locator("#submit")).isVisible();

        page.fill("vaadin-text-field[id='username'] > input", "Fred");
        page.fill("vaadin-email-field[id='email'] > input", "me@fredpena.dev");

        page.locator("#submit").click();

        assertThat(page.locator("#msg")).containsText("Please fill out all fields and accept the terms and conditions.");

    }
}
