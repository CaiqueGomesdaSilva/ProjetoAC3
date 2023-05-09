/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastros;

/**
 *
 * @author Caiqu
 */
public class Usuario {
    private String nome;
    private String email;
    private String senha;
    private String Cpf;
    private String Tipo;

      public Usuario() {
 
    }
    
    public Usuario(String nome, String email, String senha, String Cpf, String Tipo) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.Cpf = Cpf;
        this.Tipo = Tipo;
    }

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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String Cpf) {
        this.Cpf = Cpf;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }
    
    
}
