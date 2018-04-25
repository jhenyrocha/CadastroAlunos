/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frame04;

import java.sql.*;

/**
 *
 * @author unisanta
 */
public class LivroDAL {

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

    public static void inseriLivro(Livro umlivro)
    {
        Erro.setErro(false);
        try 
        {
            PreparedStatement st = con.prepareStatement("insert into TabLivros (titulo,autor,editora,ano,localizacao) values (?,?,?,?,?)");
            st.setString(1,umlivro.getTitulo());
            st.setString(2,umlivro.getAutor());
            st.setString(3,umlivro.getEditora());
            st.setString(4,umlivro.getAnoEdicao());
            st.setString(5,umlivro.getLocalizacao());
            st.executeUpdate();
            st.close();
        }
        catch(Exception e)
        {
            Erro.setErro(e.getMessage());
        }
    }

    public static void consultaLivro(Livro umlivro)
    {
        ResultSet rs;

        try
        {
            PreparedStatement st = con.prepareStatement("SELECT * FROM TabLivros WHERE titulo=?");
            st.setString(1,umlivro.getTitulo());
            rs = st.executeQuery();
            if (rs.next())
            {
                umlivro.setAutor(rs.getString("autor"));
                umlivro.setEditora(rs.getString("editora"));
                umlivro.setAnoEdicao(rs.getString("ano"));
                umlivro.setLocalizacao(rs.getString("localizacao"));
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
