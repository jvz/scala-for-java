package com.spr.java.syntax;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Demonstrates various ways to create anonymous functions.
 */
public class AnonymousFunctions {

    public static Function<String, Integer> anonymousClassSyntax() {
        return new Function<String, Integer>() {
            @Override
            public Integer apply(final String s) {
                return Integer.parseInt(s);
            }
        };
    }

    public static Function<String, Integer> lambdaSyntax() {
        return s -> Integer.parseInt(s);
    }

    public static Function<String, Integer> altLambdaSyntax() {
        return s -> {
            return Integer.parseInt(s);
        };
    }

    public static Function<String, Integer> functionReferenceSyntax() {
        return Integer::parseInt;
    }

    public static BiFunction<String, Integer, Boolean> multiParamLambdaSyntax() {
        return (s, i) -> Integer.parseInt(s) == i;
    }
}
