/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

import cadastros.Usuario;
import connDB.DB;
import gui.Cadastro;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Caiqu
 */
public class Program {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Deseja executar a aplicação com interface gráfica ou via terminal?");
        System.out.println("1 - Interface gráfica");
        System.out.println("2 - via terminal");

        Integer opcaoUsuario = sc.nextInt();
        switch (opcaoUsuario) {
            case 1 -> {
                DB banco = new DB();
                Cadastro test = new Cadastro();

                test.setVisible(true);
                banco.createTable();
            }
            case 2 -> {
                Scanner scUsuario = new Scanner(System.in);
                Usuario user = new Usuario();
                System.out.println("Aplicação rodando via console\n");
                
                System.out.println("----- > Cadastro Usuario < -----\n");
                System.out.println("Insira o nome:");
                String nome = scUsuario.nextLine();
                user.setNome(nome);
                System.out.println("Insira o email:");
                String email = scUsuario.nextLine();
                user.setEmail(email);
                System.out.println("Insira a senha:");
                String senha = scUsuario.nextLine();
                user.setSenha(senha);
                System.out.println("Insira o cpf:");
                String cpf = scUsuario.nextLine();
                user.setCpf(cpf);
                System.out.println("Insira o Tipo:");
                String tipo = scUsuario.nextLine();
                user.setTipo(tipo);
                
                System.out.println("\nRealizando cadastro....");
                
                DB banco = new DB();
                banco.createTable();
                banco.insertUsuario(user.getNome(), user.getEmail(), user.getSenha(), user.getCpf(), user.getTipo());
                scUsuario.close();
            }
        }

    }
}
