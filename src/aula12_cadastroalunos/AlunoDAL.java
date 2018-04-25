package aula12_cadastroalunos;

import static aula12_cadastroalunos.AlunoBLL.*;
import java.sql.*;
import javax.swing.JOptionPane;

public class AlunoDAL {

    private static Connection con;

    public static void conecta(String _bd) {
        Erro.setErro(false);
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://" + _bd);
        } catch (Exception e) {
            Erro.setErro(e.getMessage());
        }
    }

    public static void desconecta() {
        Erro.setErro(false);
        try {
            con.close();
        } catch (Exception e) {
            Erro.setErro(e.getMessage());
        }
    }

    public static void insereAluno(Aluno umaluno) {
        Erro.setErro(false);
        try {
            PreparedStatement st = con.prepareStatement("insert into TabAluno (matricula,nome,p1,p2,p3) values (?,?,?,?,?)");
            st.setString(1, umaluno.getMatricula());
            st.setString(2, umaluno.getNome());
            st.setString(3, umaluno.getP1());
            st.setString(4, umaluno.getP2());
            st.setString(5, umaluno.getP3());
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            Erro.setErro(e.getMessage());
        }
    }

    public static void consultaAluno(Aluno umaluno) {
        ResultSet rs;

        try {
            PreparedStatement st = con.prepareStatement("SELECT * FROM TabAluno WHERE matricula=?");
            st.setString(1, umaluno.getMatricula());
            rs = st.executeQuery();
            if (rs.next()) {
                umaluno.setNome(rs.getString("nome"));
                umaluno.setP1(rs.getString("p1"));
                umaluno.setP2(rs.getString("p2"));
                umaluno.setP3(rs.getString("p3"));
            } else {
                Erro.setErro("Livro nao localizado.");
                return;
            }
            st.close();
        } catch (Exception e) {
            Erro.setErro(e.getMessage());
        }
    }

    public static void deletaAluno(Aluno umaluno) {
       
        Erro.setErro(false);

        try {
            
            PreparedStatement st = con.prepareStatement("DELETE FROM TabAluno WHERE matricula=?");
            st.setString(1, umaluno.getMatricula());
            st.executeUpdate();
            st.close();

        } catch (Exception e) {

            Erro.setErro("Erro ao excluir");
        }
    }
    
    public static void updateAluno(Aluno umaluno) {
       
        Erro.setErro(false);

        try {
            
            PreparedStatement st = con.prepareStatement("UPDATE TabAluno SET nome=?,p1=?,p2=?,p3=? WHERE matricula=?");
            st.setString(1, umaluno.getMatricula());
            st.setString(2, umaluno.getNome());
            st.setString(3, umaluno.getP1());
            st.setString(4, umaluno.getP2());
            st.setString(5, umaluno.getP3());
            st.executeUpdate();
            st.close();

        } catch (Exception e) {

            Erro.setErro(e.getMessage());
        }
    }

}
