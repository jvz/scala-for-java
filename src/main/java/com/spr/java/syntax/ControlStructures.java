package com.spr.java.syntax;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Overview of control structures and basic methods.
 */
public class ControlStructures {

    // the ternary operator can be used as an if/else expression
    public static int parseInt(String s) {
        return s == null ? 0 : Integer.parseInt(s);
    }

    // while loops
    public static long copy(InputStream in, OutputStream out) throws IOException {
        byte[] buf = new byte[8192];
        long count = 0;
        int read;
        while ((read = in.read(buf)) != -1) {
            count += read;
            out.write(buf, 0, read);
        }
        return count;
    }

    // for loops
    public static void printNLines(String line, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(n + ": " + line);
        }
    }

    // switch statements
    public static Class<?> parsePrimitiveName(char c) {
        switch (c) {
            case 'Z': return Boolean.class;
            case 'B': return Byte.class;
            case 'C': return Character.class;
            case 'S': return Short.class;
            case 'I': return Integer.class;
            case 'L': return Long.class;
            case 'F': return Float.class;
            case 'D': return Double.class;
            default: throw new IllegalArgumentException("Invalid type: " + c);
        }
    }

    // foreach loops
    public static String joinLines(Iterable<String> lines) {
        StringBuilder sb = new StringBuilder();
        for (String line : lines) {
            sb.append(line).append('\n');
        }
        return sb.toString();
    }
}
