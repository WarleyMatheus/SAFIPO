/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wmsoftware.safipo;

/**
 *
 * @author mwarl
 */
public class Usuario {
    
    private String nome;
    private String email;
    private String senha;
    private String CNPJ;
    private String[] dataDeNasc = new String[3];
    private String nomeDaEmpresa;
    private String enderecoSede;
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getSenha(){
        return senha;
    }
    
    public void setSenha(String senha){
        this.senha = senha;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getDataDeNasc() {
        return this.dataDeNasc[0] + "/" + this.dataDeNasc[1] + "/" + this.dataDeNasc[2];
    }

    public void setDataDeNasc(String[] dataDeNasc) {
        this.dataDeNasc[0] = dataDeNasc[0];
        this.dataDeNasc[1] = dataDeNasc[1]; 
        this.dataDeNasc[2] = dataDeNasc[2];
    }

    public String getNomeDaEmpresa() {
        return nomeDaEmpresa;
    }

    public void setNomeDaEmpresa(String nomeDaEmpresa) {
        this.nomeDaEmpresa = nomeDaEmpresa;
    }

    public String getEnderecoSede() {
        return enderecoSede;
    }

    public void setEndereco(String endereco) {
        this.enderecoSede = endereco;
    }
    
}
