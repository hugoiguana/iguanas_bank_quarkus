package br.com.iguana;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class MainQuarkusBackofficeApplication implements QuarkusApplication {

    @Override
    public int run(String... args) throws Exception {
        System.out.println("Running main method...");
        Quarkus.waitForExit();
        return 0;
    }
}
