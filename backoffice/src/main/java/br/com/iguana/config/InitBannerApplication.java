package br.com.iguana.config;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import io.quarkus.runtime.configuration.ProfileManager;
import org.jboss.logging.Logger;

@ApplicationScoped
public class InitBannerApplication {

    private static final Logger LOGGER = Logger.getLogger(InitBannerApplication.class);

    void onStart(@Observes StartupEvent ev) {
        LOGGER.info("Powered by Iguana");

        LOGGER.info(".__                                         ___.                  __    ");
        LOGGER.info("|__| ____  __ _______    ____ _____    _____\\_ |__ _____    ____ |  | __");
        LOGGER.info("|  |/ ___\\|  |  \\__  \\  /    \\__  \\  /  ___/| __ \\__  \\  /    \\|  |/ /");
        LOGGER.info("|  / /_/  >  |  // __ \\|   |  \\/ __ \\_\\___ \\ | \\_\\ \\/ __ \\|   |  \\    < ");
        LOGGER.info("|__\\___  /|____/(____  /___|  (____  /____  >|___  (____  /___|  /__|_ \\");
        LOGGER.info("  /_____/            \\/     \\/     \\/     \\/     \\/     \\/     \\/     \\/");

        LOGGER.info("The application IguanasBank is starting with profile " + ProfileManager.getActiveProfile());
    }

    void onStop(@Observes ShutdownEvent ev) {
        LOGGER.info("The application IguanasBank is stopping...");
    }
}
