/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula12_cadastroalunos;

/**
 *
 * @author unisanta
 */
public class AlunoBLL {
    public static void validaDados(Aluno aluno)
    {
        Erro.setErro(false);
        try
        {
            if (Integer.parseInt(aluno.getMatricula()) == 0 || Character.isDigit(Integer.parseInt(aluno.getMatricula())))
                {Erro.setErro("O campo MATRICULA é de preenchimento obrigatório..."); return;}  
        }catch(Exception e)
        {
            Erro.setErro("O campo Matricula é letra  de preenchimento obrigatório..."); return;
        }     
            
        if (aluno.getNome().equals(""))
          {Erro.setErro("O campo NOME é de preenchimento obrigatório..."); return;}
                try
                {
                    if ((Float.parseFloat(aluno.getP1())<0 || Float.parseFloat(aluno.getP1())>10) || Character.isDigit(Integer.parseInt(aluno.getP1())))
                        {Erro.setErro("O campo P1 é de preenchimento obrigatório..."); return;}
                }catch(Exception e)
                {
                    Erro.setErro("O campo P1 é de preenchimento obrigatório..."); return;
                }

                    try
                {
                    if ((Float.parseFloat(aluno.getP2())<0 || Float.parseFloat(aluno.getP2())>10) || Character.isDigit(Integer.parseInt(aluno.getP2())))
                        {Erro.setErro("O campo P2 é de preenchimento obrigatório..."); return;}
                }catch(Exception e)
                {
                    Erro.setErro("O campo P2 é de preenchimento obrigatório..."); return;
                }


            
            AlunoDAL.inseriLivro(aluno);
            if (Erro.getErro()) 
                return;
    }

}
    
