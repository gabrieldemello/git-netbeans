/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author Gabriel Carneiro
 */
public class PessoaFisica extends Pessoa {
    private Integer Pessoa_idPessoa;
    private String nome;
    private String cpf;

    public Integer getPessoa_idPessoa() {
        return Pessoa_idPessoa;
    }

    public void setPessoa_idPessoa(Integer Pessoa_idPessoa) {
        this.Pessoa_idPessoa = Pessoa_idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "PessoaFisica{" + "Pessoa_idPessoa=" + Pessoa_idPessoa + ", nome=" + nome + ", cpf=" + cpf + '}';
    }

    
    
}
