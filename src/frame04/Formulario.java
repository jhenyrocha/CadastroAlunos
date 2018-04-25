/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frame04;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.*;


/**
 *
 * @author MauricioAsenjo
 */
public class Formulario extends JFrame implements ActionListener{

private JLabel  l1=new JLabel("Titulo..........: ",JLabel.LEFT);
private JLabel  l2=new JLabel("Autor...........: ",JLabel.LEFT);
private JLabel  l3=new JLabel("Editora.........: ",JLabel.LEFT);
private JLabel  l4=new JLabel("Ano Edicao......: ",JLabel.LEFT);
private JLabel  l5=new JLabel("Localizacao.....: ",JLabel.LEFT);
private JTextField tf1=new JTextField(30);
private JTextField tf2=new JTextField(30);
private JTextField tf3=new JTextField(30);
private JTextField tf4=new JTextField(30);
private JTextField tf5=new JTextField(30);
private JButton b1=new JButton("Salvar");
private JButton b2=new JButton("Ler");
private JButton b3=new JButton("Limpar");
private JPanel p1=new JPanel(new GridLayout(5,2));
private JPanel p2=new JPanel(new GridLayout(1,3));

private Livro umlivro = new Livro();

public Formulario(String titulo, int largura, int altura)
  {
  setTitle(titulo);
  setSize(largura,altura);
  setLayout(new BorderLayout());
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  b1.addActionListener(this);
  b2.addActionListener(this);
  b3.addActionListener(this);
  
  p1.add(l1);
  p1.add(tf1);
  p1.add(l2);
  p1.add(tf2);
  p1.add(l3);
  p1.add(tf3);
  p1.add(l4);
  p1.add(tf4);
  p1.add(l5);
  p1.add(tf5);

  p2.add(b1);
  p2.add(b2);
  p2.add(b3);

  add(BorderLayout.CENTER,p1);
  add(BorderLayout.SOUTH,p2);
  }    

public void actionPerformed(ActionEvent e)
  {
  if (e.getSource()==b1)
    {
    umlivro.setTitulo(tf1.getText());
    umlivro.setAutor(tf2.getText());
    umlivro.setEditora(tf3.getText());
    umlivro.setAnoEdicao(tf4.getText());
    umlivro.setLocalizacao(tf5.getText());
    LivroBLL.validaDados(umlivro);
    if (Erro.getErro())
       JOptionPane.showMessageDialog(null,Erro.getMens());
    else
       JOptionPane.showMessageDialog(null,"Dados Salvos com sucesso!");
    }
  else
    if (e.getSource()==b2)
    {
        umlivro.setTitulo(tf1.getText());
        LivroBLL.validaTitulo(umlivro);
        if (Erro.getErro())
            JOptionPane.showMessageDialog(null,Erro.getMens());
        else
        {
            tf1.setText(umlivro.getTitulo());
            tf2.setText(umlivro.getAutor());
            tf3.setText(umlivro.getEditora());
            tf4.setText(umlivro.getAnoEdicao());
            tf5.setText(umlivro.getLocalizacao());
        }    
    }
    else
      if (e.getSource()==b3)
        {
        tf1.setText("");
        tf2.setText("");
        tf3.setText("");
        tf4.setText("");
        tf5.setText("");
        }
  }

}
