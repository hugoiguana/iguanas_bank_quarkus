package br.com.iguana;

import io.quarkus.runtime.Quarkus;

public class MainTransactionValidatorApplication {
    public static void main(String... args) {
        System.out.println("Convenient to run inside an IDE");
        Quarkus.run(args);
    }
}
