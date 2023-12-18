package com.wmsoftware.safipo;

import java.sql.Connection;
import java.util.Scanner;

/**
 * @author mwarl
 */

public class SAFIPO {

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        
        Connection conexao = conexaoSql.getConnection();
        
        int processoAtual = 100;
        
        System.out.println("Olá! Bem-vindo ao SAFIPO, seu sistema de gerenciamento empresarial.");
        do {
            System.out.println("Você deseja cadastrar-se ou fazer login? Insira 1 para cadastro e 2 para login. Para sair, digite 0.");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 0:
                    processoAtual =0;
                    break;
                case 1:
                    System.out.println("Opção selecionada = Cadastro");
                    Cadastro cadastro = new Cadastro();
                    cadastro.fazerCadastro();
                    
                    System.out.println("Para sair, digite 0. Para se cadastrar, digite 1. Para login, digite 2: ");
                    processoAtual = scanner.nextInt();
                    break;
                case 2:
                    System.out.println("Opção selecionada = Login");
                    Login login = new Login();
                    login.fazerLogin();
                    
                    System.out.println("Para sair, digite 0. Para se cadastrar, digite 1. Para login, digite 2: ");
                    processoAtual = scanner.nextInt();
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, insira 1 para cadastro ou 2 para login.");
                    continue;
            }
            
            break;            
        }while (processoAtual != 0);
        
        System.out.println("Pressione Enter para encerrar...");
        scanner.nextLine();
        scanner.nextLine();
    }
}