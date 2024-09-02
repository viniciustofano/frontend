//importação das bibliotecas
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//criação da classe com herança
public class MultipleSelectionFrame extends JFrame 
{
   //declaração de componentes
   private final JList<String> colorJList; 
   private final JList<String> copyJList; 
   private final JList<String> copyJList2; 
   private JButton copyJButton;
   private JButton copyJButton2; 
   private static final String[] colorNames = {"Black", "Blue", "Cyan",
      "Dark Gray", "Gray", "Green", "Light Gray", "Magenta", "Orange", 
      "Pink", "Red", "White", "Yellow"};

   //criação do construtor
   public MultipleSelectionFrame()
   {
      super("Multiple Selection Lists");
      setLayout(new FlowLayout());

      //configuração do colorJList
      colorJList = new JList<String>(colorNames); 
      colorJList.setVisibleRowCount(5); 
      colorJList.setSelectionMode(
         ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
      add(new JScrollPane(colorJList)); 

      //configuração do copyJButton
      copyJButton = new JButton("Copy >>>"); 
      copyJButton.addActionListener(
         new ActionListener() 
         {  
           
            @Override
            public void actionPerformed(ActionEvent event)
            {
              
               copyJList.setListData(
                  colorJList.getSelectedValuesList().toArray(
                     new String[0]));
            }
         } 
      ); 

      add(copyJButton); 
      
      //configuração do copyJList
      copyJList = new JList<String>(); 
      copyJList.setVisibleRowCount(5); 
      copyJList.setFixedCellWidth(100); 
      copyJList.setFixedCellHeight(15); 
      copyJList.setSelectionMode(
         ListSelectionModel.SINGLE_INTERVAL_SELECTION);
      add(new JScrollPane(copyJList)); 

      copyJButton2 = new JButton("Copy >>>"); 
      copyJButton2.addActionListener(
         new ActionListener() 
         {  
           
            @Override
            public void actionPerformed(ActionEvent event)
            {
              
               copyJList2.setListData(
                  copyJList.getSelectedValuesList().toArray(
                     new String[0]));
            }
         } 
      ); 

      add(copyJButton2); 
      
      //configuração do copyJList
      copyJList2 = new JList<String>(); 
      copyJList2.setVisibleRowCount(5); 
      copyJList2.setFixedCellWidth(100); 
      copyJList2.setFixedCellHeight(15); 
      copyJList2.setSelectionMode(
         ListSelectionModel.SINGLE_INTERVAL_SELECTION);
      add(new JScrollPane(copyJList2)); 
   } 
} 



