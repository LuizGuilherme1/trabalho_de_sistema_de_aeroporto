package Entities;

public class Usuario {
    private String nome;
    private int cpf;
    private String email;
    private int idade;

    public Usuario() {
    }

    public Usuario(String nome, int cpf, String email, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public int getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public int getIdade() {
        return idade;
    }
    
}