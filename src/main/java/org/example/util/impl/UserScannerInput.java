package org.example.util.impl;

import org.example.util.UserInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class UserScannerInput implements UserInput {
    Scanner scanner;

    @Autowired
    public UserScannerInput(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public int getInt() {
        int nr = scanner.nextInt();
        scanner.nextLine();
        return nr;
    }

    @Override
    public String getString() {
        return scanner.nextLine();
    }
}
