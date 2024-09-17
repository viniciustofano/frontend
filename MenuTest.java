//importação da biblioteca
import javax.swing.*;

//definição da classe
public class MenuTest
{
   public static void main(String[] args)//método principal
   { 
      MenuFrame menuFrame = new MenuFrame(); //cria uma janela
      menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//configuração da janela
      menuFrame.setSize(500, 200);//definição da janela
      menuFrame.setVisible(true);//mostrar a janela
   } 
} 

