package ru.ifmo.utils;

import ru.ifmo.math.Function;

import java.io.IOException;
import java.io.OutputStream;

public class CsvGenerator implements Generator {
    private final Function function;
    private final OutputStream outputStream;

    private Delimiter delimiter = Delimiter.COMMA;

    public CsvGenerator(Function function, OutputStream outputStream) {
        this.function = function;
        this.outputStream = outputStream;
    }

    public CsvGenerator(Function function, OutputStream outputStream, Delimiter delimiter) {
        this.function = function;
        this.outputStream = outputStream;
        this.delimiter = delimiter;
    }

    @Override
    public void generate(double from, double to, int parts) throws IOException {
        var builder = new StringBuilder();

        builder.append("x").append(delimiter.value).append("f(x)\n");
        for (double x = from; x <= to; x += (to - from) / parts) {
            builder.append(x).append(delimiter.value).append(function.apply(x)).append("\n");
        }

        outputStream.write(builder.toString().getBytes());
    }

    public enum Delimiter {
        COMMA(','),
        SEMICOLON(';'),
        TAB('\t'),
        SPACE(' '),
        PIPE('|');

        private final char value;

        Delimiter(char value) {
            this.value = value;
        }

        public char getValue() {
            return value;
        }
    }
}
