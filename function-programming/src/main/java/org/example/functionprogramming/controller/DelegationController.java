package org.example.functionprogramming.controller;

import org.example.functionprogramming.delegation.Printer;
import org.example.functionprogramming.delegation.PrinterHandler;
import org.example.functionprogramming.util.printer.PrinterFactory;
import org.example.functionprogramming.util.printer.Printers;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/delegation")
public class DelegationController {

    // todo: Handle the error for the following API.
    @PostMapping("/print/{printerType}")
    public void printApi(@RequestParam String message, @PathVariable String printerType) {
        Printer printer = PrinterFactory.getPrinter(Printers.valueOf(printerType));

        PrinterHandler teamLeader = new PrinterHandler(printer);
        teamLeader.print(message);

    }
}
