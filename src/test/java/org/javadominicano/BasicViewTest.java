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
public class BasicViewTest extends PlaywrightIT {

    @LocalServerPort
    private int port;

    @Test
    void display_basic_view() {
        page.navigate("http://localhost:" + port + "/basic");

        assertThat(page).hasTitle("Basic Form");

        assertThat(page.getByText("Click me")).isVisible();

        page.locator("vaadin-button").getByText("Click me").click();
//        page.locator("#btn").click();

        assertThat(page.locator("#msg")).containsText("Clicked!");

        var seriesLayouts = page.locator("vaadin-vertical-layout");
        assertThat(seriesLayouts).hasCount(1);
    }
}
