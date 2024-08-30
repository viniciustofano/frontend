//importação da biblioteca swing
import javax.swing.*; 

//declaração da classe
public class ListTest 
{

   public static void main(String[] args)
   { 
      ListFrame listFrame = new ListFrame(); // criação de um objeto 
      listFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//configuração do comportamento de fechamento
      listFrame.setSize(350, 150);//definição do tamanho da janela 
      listFrame.setVisible(true);//definição de visibilidade
   } 
} //fim da classe principal

