
public class GuiBuilder {

   public void calculatorBuilder()
   {
      calcFrame = new JFrame("Java Swing Examples"); 
      //mainFrame.setSize(400,400); 
      calcFrame.setLayout(new GridBagLayout(8, 5));
      calcFrame.setVisible(true);
      
      JMenuBar chemBar = new JMenuBar();
      JMenu chemMenu = new JMenu("Chemistry");
      
      JMenuItem periodicItem = new JMenuItem("Periodic Table");
      JMenuItem molarMassItem = new JMenuItem("Molar Mass Calculator");
      JMenuItem molecularWeightItem = new JMenuItem("Molecular Weight Calculator");
      
      chemMenu.add(periodicItem);
      chemMenu.add(molarMassItem);
      chemMenu.add(molecularWeightItem);
      
      


   }
   
   

}
