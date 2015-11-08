/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

/**
 *
 * @author Maria Lucia
 */

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import javax.swing.JOptionPane;

public class Conexao {
	
	//MÃ©todo para Conectar ao Banco de Dados Local chamado 'cadastro', usuÃ¡rio 'root' e senha em branco!
	public static Connection conectar() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1/bibliotecamusical", "root","");
			return(c);
		} catch (ClassNotFoundException e) {
                        JOptionPane.showMessageDialog(null,"Problema na configuraÃ§Ã£o do Driver do MySQL!");
		} catch (SQLException e) {
                        JOptionPane.showMessageDialog(null,"Problema na conexÃ£o com o banco de dados!");
		}
		return(null);
	}

	public static ResultSet relatorio(String sql) {
		Connection con = conectar();
		Statement st;
		try {
			st = con.createStatement();
			return(st.executeQuery(sql));
		} catch (SQLException e) {
                        JOptionPane.showMessageDialog(null,"Problema na consulta!");
		}
		return(null);
	}
	
	//MÃ©todo para inserir no banco uma Pessoa passada como parï¿½metro
	public static int inserir(String ins) {
		Connection con = conectar();
		Statement st;
		try {
			st = con.createStatement();
			return(st.executeUpdate(ins));
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Problema no cadastro!");
		}
		return(0);
	}
	

}
