/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frame04;

/**
 *
 * @author MauricioAsenjo
 */
public class LivroBLL {
public static void validaDados(Livro umlivro)
{
 Erro.setErro(false);
 if (umlivro.getTitulo().equals(""))
   {Erro.setErro("O campo TITULO é de preenchimento obrigatório..."); return;}
 if (umlivro.getAutor().equals(""))
   {Erro.setErro("O campo AUTOR é de preenchimento obrigatório..."); return;}
 if (umlivro.getEditora().equals(""))
   {Erro.setErro("O campo EDITORA é de preenchimento obrigatório..."); return;}
 if (umlivro.getAnoEdicao().equals(""))
   {Erro.setErro("O campo ANO EDICAO é de preenchimento obrigatório..."); return;}
 else
   try
     {
     Integer.parseInt(umlivro.getAnoEdicao());
     }
   catch (Exception e)
     {
     Erro.setErro("O campo ANO EDICAO deve ser numerico!"); return;
     }
 if (umlivro.getLocalizacao().equals(""))
   {Erro.setErro("O campo LOCALIZACAO é de preenchimento obrigatório..."); return;}
 LivroDAL.conecta("Livros.mdb");
 if (Erro.getErro()) return;
 LivroDAL.inseriLivro(umlivro);
 if (Erro.getErro()) return;
 LivroDAL.desconecta();
}    

public static void validaTitulo(Livro umlivro)
{
 Erro.setErro(false);
 if (umlivro.getTitulo().equals(""))
   {Erro.setErro("O campo TITULO é de preenchimento obrigatório..."); return;}
 LivroDAL.conecta("Livros.mdb");
 if (Erro.getErro()) return;
 LivroDAL.consultaLivro(umlivro);
 if (Erro.getErro()) return;
 LivroDAL.desconecta();
}
}
