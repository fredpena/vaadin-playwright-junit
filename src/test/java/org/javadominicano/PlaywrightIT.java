package org.javadominicano;

import com.microsoft.playwright.*;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

/**
 * @author me@fredpena.dev
 * @created 22/06/2025  - 18:42
 */
public class PlaywrightIT {

    private static Playwright playwright;
    private static Browser browser;
    protected Page page;
    private BrowserContext browserContext;

    @BeforeAll
    public static void beforeAll() {
        playwright = Playwright.create();
        BrowserType browserType = playwright.chromium();

        Dotenv dotenv = Dotenv.load();

        boolean headless = Boolean.parseBoolean(
                dotenv.get("HEADLESS", "true")
        );

        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions()
                .setHeadless(headless);

        browser = browserType.launch(launchOptions);
    }

    @AfterAll
    public static void afterAll() {
        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
    }

    @BeforeEach
    void beforeEach() {
        browserContext = browser.newContext();

        // Start tracing before creating / navigating a page.
        // browserContext.tracing().start(new Tracing.StartOptions()
        //         .setScreenshots(true)
        //         .setSnapshots(true)
        //         .setSources(true));

        page = browserContext.newPage();
    }


    @AfterEach
    void afterEach() {
        if (page != null) page.close();
        if (browserContext != null) browserContext.close();
    }

}
