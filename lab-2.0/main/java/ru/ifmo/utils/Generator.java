package ru.ifmo.utils;

import java.io.IOException;

public interface Generator {
    void generate(double from, double to, int parts) throws IOException;
}
