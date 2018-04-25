
package aula12_cadastroalunos;
import java.sql.*;


public class AlunoDAL {

    private static Connection con;
    
    public static void conecta(String _bd)
    {
        Erro.setErro(false);
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://" + _bd);
        }
        catch (Exception e)
        {
            Erro.setErro(e.getMessage());
        }
    }

    public static void desconecta()
    {
        Erro.setErro(false);
        try 
        {
            con.close();
        }
        catch (Exception e)
        {
            Erro.setErro(e.getMessage());
        }
    }

    public static void inseriLivro(Aluno umlivro)
    {
        Erro.setErro(false);
        try 
        {
            PreparedStatement st = con.prepareStatement("insert into TabLivros (matricula,nome,p1,p2,p3) values (?,?,?,?,?)");
            st.setString(1,umlivro.getMatricula());
            st.setString(2,umlivro.getNome());
            st.setString(3,umlivro.getP1());
            st.setString(4,umlivro.getP2());
            st.setString(5,umlivro.getP3());
            st.executeUpdate();
            st.close();
        }
        catch(Exception e)
        {
            Erro.setErro(e.getMessage());
        }
    }

    public static void consultaLivro(Aluno umlivro)
    {
        ResultSet rs;

        try
        {
            PreparedStatement st = con.prepareStatement("SELECT * FROM TabLivros WHERE matricula=?");
            st.setString(1,umlivro.getMatricula());
            rs = st.executeQuery();
            if (rs.next())
            {
                umlivro.setNome(rs.getString("nome"));
                umlivro.setP1(rs.getString("p1"));
                umlivro.setP2(rs.getString("p2"));
                umlivro.setP3(rs.getString("p3"));
            }
            else
            {
                Erro.setErro("Livro nao localizado.");
                return;
            }
            st.close();
        }
        catch(Exception e)
        {
            Erro.setErro(e.getMessage());
        }
    }
    
}
