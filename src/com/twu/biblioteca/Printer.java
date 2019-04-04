package com.twu.biblioteca;

import java.io.PrintStream;

public class Printer {

    private PrintStream printStream;

    public Printer(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void print(String text) {
        this.printStream.println(text);
    }
}