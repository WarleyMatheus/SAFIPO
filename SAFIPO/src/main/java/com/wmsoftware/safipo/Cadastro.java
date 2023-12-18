/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wmsoftware.safipo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.sql.SQLException;

/**
 *
 * @author mwarl
 */
public class Cadastro {
    Scanner scanner = new Scanner(System.in);
    
    public void fazerCadastro() throws InterruptedException {
        Usuario novoUsuario = new Usuario();
        System.out.println("Vamos iniciar seu cadastro!");
        System.out.println("Os dados solicitados vão ser verificados posteriormente! Portanto, para agilizar a sua validação, certifique-se de fornecer os dados corretos!");
        
        System.out.print("Para começarmos, diga-nos seu primeiro nome: ");
        String nome = scanner.next();
        novoUsuario.setNome(nome);
        
        System.out.print("Certo, " + nome + ", agora, forneça-nos seu melhor e-mail: ");
        String email = scanner.next();
        novoUsuario.setEmail(email);
        
        System.out.print("Agora, digite uma senha forte");
        String senha = scanner.next();
        novoUsuario.setSenha(senha);
        
        System.out.print("Ótimo! Forneça agora seu CNPJ: ");
        String CNPJ = scanner.next();
        novoUsuario.setCNPJ(CNPJ);
        
        System.out.print("Insira o dia do seu nascimento: ");
        String dia = scanner.next();
        
        System.out.print("Agora, o mês (não se esqueça do 0. Ex.: 03): ");
        String mes = scanner.next();
        
        System.out.print("Agora, o ano, com os 4 dígitos: ");
        String ano = scanner.next();
        
        String[] dataDeNasc = new String[] { dia, mes, ano };
        novoUsuario.setDataDeNasc(dataDeNasc);
        
        System.out.print("Agora, diga-nos o nome da sua empresa: ");
        String nomeEmp = scanner.next();
        novoUsuario.setNomeDaEmpresa(nomeEmp);
        
        System.out.print("Por fim, nos informe o endereço da sede da sua empresa (caso você não possua um endereço físico, informe \"Sem endereço físico\"): ");
        String enderecoSede = scanner.next();
        novoUsuario.setEndereco(enderecoSede);
        
        System.out.println("Aguarde...");
        Thread.sleep(3000);
        System.out.println("Cadastro finalizado com sucesso! Assim que a verificação for concluída, iremos enviar um e-mail. Obrigado!");
        
        try {
            inserirUsuarioNoBanco(novoUsuario);
        } catch (SQLException e) {
            System.out.println("Falha ao inserir o usuário no banco de dados: " + e.getMessage());
        }
    }
    
    private void inserirUsuarioNoBanco(Usuario usuario) throws SQLException {
        // Obtém uma conexão com o banco de dados
        Connection conexao = conexaoSql.getConnection();

        // Cria uma string SQL para inserir um novo usuário
        String sql = "INSERT INTO usuarios (nome, email, senha, CNPJ, data_de_nascimento, nome_da_empresa, enderecoSede) VALUES (?, ?, ?, ?, ?, ?, ?)";

        // Cria um objeto PreparedStatement para executar a consulta SQL
        PreparedStatement stmt = conexao.prepareStatement(sql);

        // Define os valores dos parâmetros da consulta SQL
        stmt.setString(1, usuario.getNome());
        stmt.setString(2, usuario.getEmail());
        stmt.setString(3, usuario.getSenha());
        stmt.setString(4, usuario.getCNPJ());
        stmt.setDate(5, java.sql.Date.valueOf(String.join("-", usuario.getDataDeNasc()))); // Converte a data de nascimento para o formato yyyy-mm-dd
        stmt.setString(6, usuario.getNomeDaEmpresa());
        stmt.setString(7, usuario.getEnderecoSede());

        // Executa a consulta SQL
        stmt.executeUpdate();

        // Fecha o objeto PreparedStatement e a conexão
        stmt.close();
        conexao.close();
    }
}
