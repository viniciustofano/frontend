
import javax.swing.JOptionPane; 

public class Addition //criação da classe addition
{
   
   public static void main(String[] args)//criação do método executor main
   /**
     * static: declaração de método somente leitura, o qual não poderá ser editado
     * void: modo protegido de um método, o qual não retornará qlqr valor
     * main: nome do método "executor"             
   */
   {
      //espera a entrada do usuário armazenando os dados 
      String firstNumber = 
         JOptionPane.showInputDialog("Enter first integer");
      String secondNumber =
         JOptionPane.showInputDialog("Enter second integer");

      //conversão dos dados do usuário em números inteiros 
      int number1 = Integer.parseInt(firstNumber); 
      int number2 = Integer.parseInt(secondNumber);
      
      //realiza a soma entre os dois números inteiros solicitados pelo usuário
      int sum = number1 + number2; 

      //exibe o resultado da soma com as mensagens "the sum is" + soma sendo o resultado
      JOptionPane.showMessageDialog(null, "The sum is " + sum, 
         "Sum of Two Integers", JOptionPane.PLAIN_MESSAGE);
   } 
} 