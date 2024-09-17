//importação das bibliotecas
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


//criação da classe principal
public class MenuFrame extends JFrame 
   // Aqui vão os atributos e o construtor
{
   //declaração das variaveis
   private final Color[] colorValues = {Color.BLACK, Color.BLUE, Color.RED, Color.GREEN}; 

private final JRadioButtonMenuItem[] colorItems; // Itens de menu para cores
private final JRadioButtonMenuItem[] fonts; // Itens de menu para fontes

private final JCheckBoxMenuItem[] styleItems; // Itens de menu para estilos (bold/italic)

private final JLabel displayJLabel; // Exibe o texto na tela

private final ButtonGroup fontButtonGroup; // Agrupa botões de fonte
private final ButtonGroup colorButtonGroup; // Agrupa botões de cor

private int style; // Estilo do texto (negrito, itálico, etc.)


   //criação do construtor
   public MenuFrame() {
      super("Using JMenus"); // Define o título da janela
  
      // Cria o menu "File"
      JMenu fileMenu = new JMenu("File"); 
      fileMenu.setMnemonic('F'); // Define uma tecla de atalho
  
      // Cria a opção "About..." no menu "File"
      JMenuItem aboutItem = new JMenuItem("About...");
      aboutItem.setMnemonic('A'); // Atalho
      fileMenu.add(aboutItem); // Adiciona ao menu
  
      // Mostra uma mensagem quando "About..." é clicado
      aboutItem.addActionListener(
          new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent event) {
                  JOptionPane.showMessageDialog(MenuFrame.this, "This is an example\nof using menus", "About", JOptionPane.PLAIN_MESSAGE);
              } 
          }
      );
  
      // Cria a opção "Exit" no menu "File"
      JMenuItem exitItem = new JMenuItem("Exit");
      exitItem.setMnemonic('x'); // Atalho
      fileMenu.add(exitItem);
  
      // Fecha o programa quando "Exit" é clicado
      exitItem.addActionListener(
          new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent event) {
                  System.exit(0); // Encerra o programa
              } 
          }
      );
  
      // Cria uma barra de menus e adiciona o menu "File" nela
      JMenuBar bar = new JMenuBar();
      setJMenuBar(bar); 
      bar.add(fileMenu);
  
      // Cria o menu "Format"
      JMenu formatMenu = new JMenu("Format");
      formatMenu.setMnemonic('r');
  
      // Adiciona ao menu uma opção de cor
      JMenu colorMenu = new JMenu("Color");
      colorMenu.setMnemonic('C');
  
      // Define as opções de cor
      String[] colors = {"Black", "Blue", "Red", "Green"};
      colorItems = new JRadioButtonMenuItem[colors.length];
      colorButtonGroup = new ButtonGroup();
      ItemHandler itemHandler = new ItemHandler(); // Manipula cliques nos itens de menu
  
      for (int count = 0; count < colors.length; count++) {
          colorItems[count] = new JRadioButtonMenuItem(colors[count]);
          colorMenu.add(colorItems[count]); // Adiciona ao submenu "Color"
          colorButtonGroup.add(colorItems[count]); // Agrupa as opções de cor
          colorItems[count].addActionListener(itemHandler); // Adiciona um listener para cada cor
      }
  
      colorItems[0].setSelected(true); // Deixa a primeira cor selecionada por padrão
      formatMenu.add(colorMenu); // Adiciona o menu de cores ao menu "Format"
  
     
      // Cria o submenu para fontes
String[] fontNames = {"Serif", "Monospaced", "SansSerif", "Arial"}; // Adiciona a fonte Arial
JMenu fontMenu = new JMenu("Font");
fontMenu.setMnemonic('n');

fonts = new JRadioButtonMenuItem[fontNames.length];
fontButtonGroup = new ButtonGroup();

for (int count = 0; count < fonts.length; count++) {
    fonts[count] = new JRadioButtonMenuItem(fontNames[count]);
    fontMenu.add(fonts[count]); // Adiciona as fontes ao submenu
    fontButtonGroup.add(fonts[count]); // Agrupa as opções de fontes
    fonts[count].addActionListener(new ItemHandler()); // Adiciona o listener para cada fonte
}

// Seleciona a primeira fonte (Serif) como padrão
fonts[0].setSelected(true); 
formatMenu.add(fontMenu); // Adiciona o menu de fontes ao menu "Format"

  
      // Cria opções para estilo (Bold e Italic)
      String[] styleNames = {"Bold", "Italic"};
      styleItems = new JCheckBoxMenuItem[styleNames.length];
      StyleHandler styleHandler = new StyleHandler();
  
      for (int count = 0; count < styleNames.length; count++) {
          styleItems[count] = new JCheckBoxMenuItem(styleNames[count]);
          fontMenu.add(styleItems[count]); // Adiciona as opções ao menu de fontes
          styleItems[count].addItemListener(styleHandler); // Adiciona o listener
      }
  
      bar.add(formatMenu); // Adiciona o menu "Format" à barra de menus
  
      // Cria um label para exibir o texto
      displayJLabel = new JLabel("Sample Text", SwingConstants.
      CENTER);
      displayJLabel.setForeground(colorValues[0]); // Cor inicial
      displayJLabel.setFont(new Font("Serif", Font.PLAIN, 72)); // Fonte inicial
  
      getContentPane().setBackground(Color.CYAN); // Cor de fundo da janela
      add(displayJLabel, BorderLayout.CENTER); // Adiciona o label à janela
  }
  

   //classe privada invocando o objeto action listener
   private class ItemHandler implements ActionListener 
   {
      @Override
      public void actionPerformed(ActionEvent event)
      {
         //Muda a cor do texto 
         for (int count = 0; count < colorItems.length; count++)
         {
            if (colorItems[count].isSelected()) 
            {
               displayJLabel.setForeground(colorValues[count]);
               break;
            } 
         } 

       
         for (int count = 0; count < fonts.length; count++)
         {
            if (event.getSource() == fonts[count]) 
            {
               displayJLabel.setFont(
                  new Font(fonts[count].getText(), style, 72));
            }
         }

         repaint(); 
      } 
   } 

   
   private class StyleHandler implements ItemListener 
   {
      
      @Override
      public void itemStateChanged(ItemEvent e)
      {
         String name = displayJLabel.getFont().getName(); 
         Font font; 

         // Aplica estilos combinados ou individuais ao texto
         if (styleItems[0].isSelected() && 
              styleItems[1].isSelected())
            font = new Font(name, Font.BOLD + Font.ITALIC, 72);
         else if (styleItems[0].isSelected())
            font = new Font(name, Font.BOLD, 72);
         else if (styleItems[1].isSelected())
            font = new Font(name, Font.ITALIC, 72);
         else
            font = new Font(name, Font.PLAIN, 72);

         displayJLabel.setFont(font);//Atualiza a fonte
         repaint();//Atualiza a tela 
      } 
   } 
}



