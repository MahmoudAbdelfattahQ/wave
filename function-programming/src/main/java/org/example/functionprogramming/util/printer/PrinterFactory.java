package org.example.functionprogramming.util.printer;

import org.example.functionprogramming.delegation.ConsolePrinter;
import org.example.functionprogramming.delegation.FilePrinter;
import org.example.functionprogramming.delegation.Printer;
import org.example.functionprogramming.delegation.RealPrinter;

/**
 * Factory Class for Printers
 *
 * @author Abdelaziz Said
 */
public class PrinterFactory {

    private PrinterFactory() {
    }

    /**
     * Retrieves an instance of a Printer based on the specified type.
     *
     * @param type the type of Printer to retrieve.
     *             Valid values are "filePrinter", "consolePrinter", and "realPrinter".
     * @return an instance of the requested Printer type.
     * Returns null if an invalid type is provided.
     */
    public static Printer getPrinter(Printers type) {
        return switch (type) {
            case FILE_PRINTER -> new FilePrinter();
            case CONSOLE_PRINTER -> new ConsolePrinter();
            case REAL_PRINTER -> new RealPrinter();
        };
    }
}
