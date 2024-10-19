package br.com.fiap.locadora.main.funcionario;

import br.com.fiap.locadora.connection.ConnectionFactory;
import br.com.fiap.locadora.dao.FuncionarioDao;
import br.com.fiap.locadora.model.Funcionario;

import javax.swing.*;
import java.sql.Connection;
import java.util.List;

public class ListarPorNomeDaoTest {
    public static void main(String[] args) {

        // Pedir o nome ao usuário
        String nome = JOptionPane.showInputDialog("Qual o nome do funcionário?");

        // Usando try-with-resources para garantir que a conexão seja fechada
        try (Connection conn = ConnectionFactory.getConnection()) {
            // Criando o DAO de Funcionário
            FuncionarioDao dao = new FuncionarioDao(conn);

            // Criando a lista de exibição
            List<Funcionario> lista = dao.pesquisaNome(nome);

            if (lista.isEmpty()) {
                System.out.println("Nenhum funcionário encontrado com o nome: " + nome);
            } else {
                for (Funcionario f : lista) {
                    System.out.println(f + "\n");
                }
                System.out.println("Funcionários encontrados: " + lista.size());
            }
        } catch (Exception e) {
            System.err.println("Erro ao buscar funcionários: " + e.getMessage());
        }
    }
}
