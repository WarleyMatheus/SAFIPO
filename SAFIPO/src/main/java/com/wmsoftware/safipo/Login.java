/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wmsoftware.safipo;

import java.util.Scanner;

/**
 *
 * @author mwarl
 */
public class Login {
    Scanner scanner = new Scanner(System.in);
    
    public void fazerLogin() {
        System.out.print("Insira seu e-mail: ");
        scanner.next();
        
        System.out.print("Insira sua senha: ");
        scanner.next();
        
    }
}
