package main;

import Generator.Generator;

/**
 *
 * @author craci
 */
public class MyMain {
    public static void main(String[] args) {
        Generator gen = new Generator();
        System.out.println(gen.generate(100, 1000));
    }
}
