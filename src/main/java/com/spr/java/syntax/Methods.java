package com.spr.java.syntax;

import lombok.Getter;

/**
 * Demonstrates simple methods and properties.
 */
public class Methods {

    /**
     * Using Lombok, we can auto-generate a {@code getName()} method to access this property.
     */
    @Getter
    private final String name;

    /**
     * Alternatively, we can use the {@code @AllArgsConstructor} Lombok annotation to generate this constructor.
     */
    public Methods(final String name) {
        this.name = name;
    }

    /**
     * A default constructor.
     */
    public Methods() {
        this("world");
    }

    /**
     * A method on an instance.
     */
    public void instanceMethod() {
        System.out.printf("Hello, %s!", name);
    }

    /**
     * A method on a class.
     */
    public static void classMethod() {
        System.out.println("Hello, world!");
    }
}
