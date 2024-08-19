
 import java.awt.FlowLayout;
import javax.swing.*; // carrega todos os componentes do módulo swing da biblioteca javax

public class LabelFrame extends JFrame 
{
   // variável privada do tipo Jlabel dentro da classe LabelFrame
   private final JLabel label1;// JLabel com apenas texto
   private final JLabel label2;// JLabel com texto e ícone
   private final JLabel label3;// JLbael com texto e ícone adicionados 

   // qualquer método dentro de uma classe com o mesmo nome é um construtor 
   public LabelFrame()
   {
      super("Testing JLabel"); // super é um método herdado do JFrame que define o título
      setLayout(new FlowLayout()); // define o layout 

      // construtor com um argumento string
      label1 = new JLabel("Label with text");
      label1.setToolTipText("This is label1");
      add(label1); // adiciona label1 ao JFrame

      //declaracao da variavel
      Icon bug = new ImageIcon(getClass().getResource("bug1.png"));
      label2 = new JLabel("Label with text and icon", bug, 
         SwingConstants.LEFT);
      label2.setToolTipText("This is label2");
      add(label2); // adicionar label2

      //construtor sem argumentos
      label3 = new JLabel(); 
      label3.setText("Label with icon and text at bottom");
      label3.setIcon(bug); // add icon to JLabel
      label3.setHorizontalTextPosition(SwingConstants.CENTER);
      label3.setVerticalTextPosition(SwingConstants.BOTTOM);
      label3.setToolTipText("This is label3");
      add(label3); // add label3 to JFrame
   } 
} // fim da classe LabelFrame


