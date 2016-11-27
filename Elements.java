/**
Build an array of Periodic Table information

@author dsims 
@version 1.0

CEN3031    Chemistry Calculator
File Name: Elements.java
*/

import java.util.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
 /** Collect element data*/
public class Elements extends JPanel 
{
    private boolean DEBUG = false;
    
    public Elements()
    {
      super(new GridLayout(1,0));
    
    String[] columnNames = {"Atomic Number", "Symbol", "Name", "Mass", "Group", "Period", "Family", "Etymology"};
    
    Object[][] data =
      {
      {new Integer(1),"H","Hydrogen",new Integer(1),new Integer(1),new Integer(1),"Non-Metals","Greek hydrogenes"},  
      {new Integer(2),"He","Helium",new Integer(4),new Integer(1),new Integer(18),"Nobel Gases","Greek helios"},
      {new Integer(3),"Li","Lithium",new Integer(7),new Integer(2),new Integer(1),"Alkali Metals","Greek lithos"},
      {new Integer(4),"Be","Beryllium",new Integer(9),new Integer(2),new Integer(2),"Alkaline Earth Metals","beryl"},
      {new Integer(5),"B","Boron",new Integer(11),new Integer(2),new Integer(13),"Metalloids","borax"},
      {new Integer(6),"C","Carbon",new Integer(12),new Integer(2),new Integer(14),"Non-Metals","Latin carbo"},
      {new Integer(7),"N","Nitrogen",new Integer(14),new Integer(2),new Integer(15),"Non-Metals","Greek nitron"},
      {new Integer(8),"O","Oxygen",new Integer(16),new Integer(2),new Integer(16),"Non-Metals","Greek oxys"},
      {new Integer(9),"F","Fluorine",new Integer(19),new Integer(2),new Integer(17),"Halogens","Latin fluo"},
      {new Integer(10),"Ne","Neon",new Integer(20),new Integer(2),new Integer(18),"Nobel Gases","Greek neos"},
      {new Integer(11),"Na","Sodium",new Integer(23),new Integer(3),new Integer(1),"Alkali Metals","Latin natrium"},
      {new Integer(12),"Mg","Magnesium",new Integer(24),new Integer(3),new Integer(2),"Alkaline Earth Metals","Magnesia Greece"},
      {new Integer(13),"Al","Aluminium (Aluminum)",new Integer(27),new Integer(3),new Integer(13),"Other Metals","Latin alumen"},
      {new Integer(14),"Si","Silicon",new Integer(28),new Integer(3),new Integer(14),"Metalloids","Latin silex"},
      {new Integer(15),"P","Phosphorus",new Integer(231),new Integer(3),new Integer(15),"Non-Metals","Greek phosphoros"},
      {new Integer(16),"S","Sulfur (Sulphur)",new Integer(32),new Integer(3),new Integer(16),"Non-Metals","Latin sulfur"},
      {new Integer(17),"Cl","Chlorine",new Integer(35),new Integer(3),new Integer(17),"Halogens","Greek chloros"},
      {new Integer(18),"Ar","Argon",new Integer(40),new Integer(3),new Integer(18),"Nobel Gases","Greek argon"},
      {new Integer(19),"K","Potassium (Kalium)",new Integer(39),new Integer(4),new Integer(1),"Alkali Metals","Latin kalium"},
      {new Integer(20),"Ca","Calcium",new Integer(40),new Integer(4),new Integer(2),"Alkaline Earth Metals","Latin calx"},
      {new Integer(21),"Sc","Scandium",new Integer(45),new Integer(4),new Integer(3),"Transition Metals","Scandinavia"},
      {new Integer(22),"Ti","Titanium",new Integer(48),new Integer(4),new Integer(4),"Transition Metals","the Titans"},
      {new Integer(23),"V","Vanadium",new Integer(51),new Integer(4),new Integer(5),"Transition Metals","Vanadis"},
      {new Integer(24),"Cr","Chromium",new Integer(52),new Integer(4),new Integer(6),"Transition Metals","Greek chroma"},
      {new Integer(25),"Mn","Manganese",new Integer(55),new Integer(4),new Integer(7),"Transition Metals","Latin magnes"},
      {new Integer(26),"Fe","Iron",new Integer(56),new Integer(4),new Integer(8),"Transition Metals","Latin ferrum"},
      {new Integer(27),"Co","Cobalt",new Integer(59),new Integer(4),new Integer(9),"Transition Metals","from German kobold"},
      {new Integer(28),"Ni","Nickel",new Integer(59),new Integer(4),new Integer(10),"Transition Metals","German kupfernickel"},
      {new Integer(29),"Cu","Copper",new Integer(64),new Integer(4),new Integer(11),"Transition Metals","Latin Cuprum"},
      {new Integer(30),"Zn","Zinc",new Integer(65),new Integer(4),new Integer(12),"Transition Metals","German zink"},
      {new Integer(31),"Ga","Gallium",new Integer(70),new Integer(4),new Integer(13),"Other Metals","Latin Gallia"},
      {new Integer(32),"Ge","Germanium",new Integer(73),new Integer(4),new Integer(14),"Metalloids","Germany"},
      {new Integer(33),"As","Arsenic",new Integer(75),new Integer(4),new Integer(15),"Metalloids","Greek arsenikos"},
      {new Integer(34),"Se","Selenium",new Integer(79),new Integer(4),new Integer(16),"Non-Metals","Greek selene"},
      {new Integer(35),"Br","Bromine",new Integer(80),new Integer(4),new Integer(17),"Halogens","Greek bromos"},
      {new Integer(36),"Kr","Krypton",new Integer(84),new Integer(4),new Integer(18),"Nobel Gases","Greek kryptos"},
      {new Integer(37),"Rb","Rubidium",new Integer(85),new Integer(5),new Integer(1),"Alkali Metals","Latin rubidus"},
      {new Integer(38),"Sr","Strontium",new Integer(88),new Integer(5),new Integer(2),"Alkaline Earth Metals","Gaelic Strontian"},
      {new Integer(39),"Y","Yttrium",new Integer(89),new Integer(5),new Integer(3),"Transition Metals","Ytterby Sweden"},
      {new Integer(40),"Zr","Zirconium",new Integer(91),new Integer(5),new Integer(4),"Transition Metals","zircon"},
      {new Integer(41),"Nb","Niobium",new Integer(93),new Integer(5),new Integer(5),"Transition Metals","Niobe"},
      {new Integer(42),"Mo","Molybdenum",new Integer(96),new Integer(5),new Integer(6),"Transition Metals","Greek molybdos"},
      {new Integer(43),"Tc","Technetium",new Integer(98),new Integer(5),new Integer(7),"Transition Metals","Greek technetos"},
      {new Integer(44),"Ru","Ruthenium",new Integer(101),new Integer(5),new Integer(8),"Transition Metals","Latin Ruthenia"},
      {new Integer(45),"Rh","Rhodium",new Integer(103),new Integer(5),new Integer(9),"Transition Metals","Greek rhodon"},
      {new Integer(46),"Pd","Palladium",new Integer(106),new Integer(5),new Integer(10),"Transition Metals","Pallas (genitive Pallados)"},
      {new Integer(47),"Ag","Silver",new Integer(108),new Integer(5),new Integer(11),"Transition Metals","Latin argentum"},
      {new Integer(48),"Cd","Cadmium",new Integer(12),new Integer(5),new Integer(12),"Transition Metals","from Greek kadmia"},
      {new Integer(49),"In","Indium",new Integer(115),new Integer(5),new Integer(13),"Other Metals","indigo blue"},
      {new Integer(50),"Sn","Tin",new Integer(119),new Integer(5),new Integer(14),"Other Metals","Latin stannum"},
      {new Integer(51),"Sb","Antimony",new Integer(122),new Integer(5),new Integer(15),"Metalloids","Latin stibium"},
      {new Integer(52),"Te","Tellurium",new Integer(128),new Integer(5),new Integer(16),"Metalloids","Greek tellus"},
      {new Integer(53),"I","Iodine",new Integer(127),new Integer(5),new Integer(17),"Halogens","Greek ioeides"},
      {new Integer(54),"Xe","Xenon",new Integer(131),new Integer(5),new Integer(18),"Nobel Gases","Greek xenos"},
      {new Integer(55),"Cs","Caesium (Cesium)",new Integer(133),new Integer(6),new Integer(1),"Alkali Metals","Latin caesius"},
      {new Integer(56),"Ba","Barium",new Integer(137),new Integer(6),new Integer(2),"Alkaline Earth Metals","Greek barys"},
      {new Integer(57),"La","Lanthanum",new Integer(139),new Integer(6),new Integer(3),"Rare Earth Lanthanide","Greek lanthanien"},
      {new Integer(58),"Ce","Cerium",new Integer(140),new Integer(6),new Integer(3),"Rare Earth Lanthanide","Ceres"},
      {new Integer(59),"Pr","Praseodymium",new Integer(141),new Integer(6),new Integer(3),"Rare Earth Lanthanide","Greek prasios"},
      {new Integer(60),"Nd","Neodymium",new Integer(144),new Integer(6),new Integer(3),"Rare Earth Lanthanide","Greek neos didymos"},
      {new Integer(61),"Pm","Promethium",new Integer(145),new Integer(6),new Integer(3),"Rare Earth Lanthanide","Prometheus"},
      {new Integer(62),"Sm","Samarium",new Integer(150),new Integer(6),new Integer(3),"Rare Earth Lanthanide","samarskite"},
      {new Integer(63),"Eu","Europium",new Integer(152),new Integer(6),new Integer(3),"Rare Earth Lanthanide","Europe"},
      {new Integer(64),"Gd","Gadolinium",new Integer(157),new Integer(6),new Integer(3),"Rare Earth Lanthanide","gadolinite"},
      {new Integer(65),"Tb","Terbium",new Integer(159),new Integer(6),new Integer(3),"Rare Earth Lanthanide","Ytterby Sweden"},
      {new Integer(66),"Dy","Dysprosium",new Integer(162),new Integer(6),new Integer(3),"Rare Earth Lanthanide","Greek dysprositos"},
      {new Integer(67),"Ho","Holmium",new Integer(165),new Integer(6),new Integer(3),"Rare Earth Lanthanide","Latin Holmia"},
      {new Integer(68),"Er","Erbium",new Integer(167),new Integer(6),new Integer(3),"Rare Earth Lanthanide","Ytterby Sweden"},
      {new Integer(69),"Tm","Thulium",new Integer(169),new Integer(6),new Integer(3),"Rare Earth Lanthanide","Thule and the traditional -ium ending"},
      {new Integer(70),"Yb","Ytterbium",new Integer(173),new Integer(6),new Integer(3),"Rare Earth Lanthanide","Ytterby Sweden"},
      {new Integer(71),"Lu","Lutetium",new Integer(175),new Integer(6),new Integer(3),"Rare Earth Lanthanide","Latin Lutetia"},
      {new Integer(72),"Hf","Hafnium",new Integer(178),new Integer(6),new Integer(4),"Transition Metals","Latin Hafnia"},
      {new Integer(73),"Ta","Tantalum",new Integer(181),new Integer(6),new Integer(5),"Transition Metals","King Tantalus"},
      {new Integer(74),"W","Tungsten",new Integer(184),new Integer(6),new Integer(6),"Transition Metals","German wolfram"},
      {new Integer(75),"Re","Rhenium",new Integer(186),new Integer(6),new Integer(7),"Transition Metals","German Rheinprovinz"},
      {new Integer(76),"Os","Osmium",new Integer(190),new Integer(6),new Integer(8),"Transition Metals","Greek osme"},
      {new Integer(77),"Ir","Iridium",new Integer(192),new Integer(6),new Integer(9),"Transition Metals","Greek iris"},
      {new Integer(78),"Pt","Platinum",new Integer(195),new Integer(6),new Integer(10),"Transition Metals","Greek platina"},
      {new Integer(79),"Au","Gold",new Integer(197),new Integer(6),new Integer(11),"Transition Metals","Latin aurum"},
      {new Integer(80),"Hg","Mercury",new Integer(200),new Integer(6),new Integer(12),"Transition Metals","Latin hydrargyrum"},
      {new Integer(81),"Tl","Thallium",new Integer(204),new Integer(6),new Integer(13),"Other Metals","Greek thallos"},
      {new Integer(82),"Pb","Lead",new Integer(207),new Integer(6),new Integer(14),"Other Metals","Latin plumbum"},
      {new Integer(83),"Bi","Bismuth",new Integer(208),new Integer(6),new Integer(15),"Other Metals","from German wissmuth"},
      {new Integer(84),"Po","Polonium",new Integer(210),new Integer(6),new Integer(16),"Metalloids","Poland"},
      {new Integer(85),"At","Astatine",new Integer(210),new Integer(6),new Integer(17),"Halogens","Greek astatos"},
      {new Integer(86),"Rn","Radon",new Integer(220),new Integer(6),new Integer(18),"Nobel Gases","radium and emanation"},
      {new Integer(87),"Fr","Francium",new Integer(223),new Integer(7),new Integer(1),"Alkali Metals","France"},
      {new Integer(88),"Ra","Radium",new Integer(226),new Integer(7),new Integer(2),"Alkaline Earth Metals","Latin radius"},
      {new Integer(89),"Ac","Actinium",new Integer(227),new Integer(7),new Integer(3),"Rare Earth Actinide","from Greek aktinos"},
      {new Integer(90),"Th","Thorium",new Integer(232),new Integer(7),new Integer(3),"Rare Earth Actinide","Thor"},
      {new Integer(91),"Pa","Protactinium",new Integer(231),new Integer(7),new Integer(3),"Rare Earth Actinide","Greek protos and actinium"},
      {new Integer(92),"U","Uranium",new Integer(238),new Integer(7),new Integer(3),"Rare Earth Actinide","Uranus"},
      {new Integer(93),"Np","Neptunium",new Integer(237),new Integer(7),new Integer(3),"Rare Earth Actinide","Neptune"},
      {new Integer(94),"Pu","Plutonium",new Integer(244),new Integer(7),new Integer(3),"Rare Earth Actinide","Pluto"},
      {new Integer(95),"Am","Americium",new Integer(243),new Integer(7),new Integer(3),"Rare Earth Actinide","the Americas"},
      {new Integer(96),"Cm","Curium",new Integer(247),new Integer(7),new Integer(3),"Rare Earth Actinide","Pierre and Marie Curie and the traditional -um ending"},
      {new Integer(97),"Bk","Berkelium",new Integer(247),new Integer(7),new Integer(3),"Rare Earth Actinide","Berkeley California"},
      {new Integer(98),"Cf","Californium",new Integer(251),new Integer(7),new Integer(3),"Rare Earth Actinide","State and University of California"},
      {new Integer(99),"Es","Einsteinium",new Integer(252),new Integer(7),new Integer(3),"Rare Earth Actinide","Albert Einstein"},
      {new Integer(100),"Fm","Fermium",new Integer(257),new Integer(7),new Integer(3),"Rare Earth Actinide","Enrico Fermi"},
      {new Integer(101),"Md","Mendelevium",new Integer(258),new Integer(7),new Integer(3),"Rare Earth Actinide","Dmitri Mendeleyev"},
      {new Integer(102),"No","Nobelium",new Integer(259),new Integer(7),new Integer(3),"Rare Earth Actinide","Alfred Nobel"},
      {new Integer(103),"Lr","Lawrencium",new Integer(262),new Integer(7),new Integer(3),"Rare Earth Actinide","Ernest O. Lawrence"},
      {new Integer(104),"Rf","Rutherfordium",new Integer(261),new Integer(7),new Integer(4),"Transition Metals","Ernest Rutherford"},
      {new Integer(105),"Db","Dubnium",new Integer(262),new Integer(7),new Integer(5),"Transition Metals","Dubna Russia"},
      {new Integer(106),"Sg","Seaborgium",new Integer(266),new Integer(7),new Integer(6),"Transition Metals","Glenn T. Seaborg"},
      {new Integer(107),"Bh","Bohrium",new Integer(264),new Integer(7),new Integer(7),"Transition Metals","Niels Bohr"},
      {new Integer(108),"Hs","Hassium",new Integer(277),new Integer(7),new Integer(8),"Transition Metals","Hesse Germany"},
      {new Integer(109),"Mt","Meitnerium",new Integer(268),new Integer(7),new Integer(9),"Transition Metals","Lise Meitner"},
      {new Integer(110),"Ds","Darmstadtium",new Integer(271),new Integer(7),new Integer(10),"Transition Metals","Darmstadt Germany"},
      {new Integer(111),"Uuu (Rg)","Unununium (Roentgenium)",new Integer(272),new Integer(7),new Integer(11),"Transition Metals","Un (one) un (one) un (one) ium (Wilhelm Conrad Röntgen)"},
      {new Integer(112),"Cn","Copernicium",new Integer(285),new Integer(7),new Integer(12),"Transition Metals","Nicolaus Copernicus"},
      {new Integer(113),"Uut","Ununtrium",new Integer(284),new Integer(7),new Integer(13),"Transition Metals","Latin uni uni and Greek tri"},
      {new Integer(114),"Uuq","Ununquadium",new Integer(289),new Integer(7),new Integer(14),"Transition Metals","Latin uni uni and quadr"},
      {new Integer(115),"Uup","Ununpentium",new Integer(288),new Integer(7),new Integer(15),"Transition Metals","Latin uni uni and Greek pent"},
      {new Integer(116),"Uuh","Ununhexium",new Integer(292),new Integer(7),new Integer(16),"Transition Metals","Latin uni uni and Greek hex"},
      {new Integer(117),"Uus","Ununseptium",new Integer(295),new Integer(7),new Integer(17),"Metalloids","Latin uni uni and Greek sept"},
      {new Integer(118),"Uuo","Ununoctium",new Integer(294),new Integer(7),new Integer(18),"Nobel Gases","Latin uni uni and oct"}
      };
        final JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(1500, 500));
        table.setFillsViewportHeight(true);
        if (DEBUG) 
        {
            table.addMouseListener(new MouseAdapter() 
            {
                public void mouseClicked(MouseEvent e) 
                {
                    printDebugData(table);
                }
            });
                if (DEBUG) 
                {
                  table.addMouseListener(new MouseAdapter() 
                  {
                     public void mouseClicked(MouseEvent e) 
                     {
                      printDebugData(table);
                     }
                  });
               }
          }
        if (DEBUG) 
        {
            table.addMouseListener(new MouseAdapter() 
            {
                public void mouseClicked(MouseEvent e) 
                {
                    printDebugData(table);
                }
            });
        }
        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);
 
        //Add the scroll pane to this panel.
        add(scrollPane);        
    }
    private void printDebugData(JTable table) {
        int numRows = table.getRowCount();
        int numCols = table.getColumnCount();
        javax.swing.table.TableModel model = table.getModel();
 
        System.out.println("Value of data: ");
        for (int i=0; i < numRows; i++) 
        {
            System.out.print("    row " + i + ":");
            for (int j=0; j < numCols; j++) 
            {
                System.out.print("  " + model.getValueAt(i, j));
            }
            System.out.println();
        }
        System.out.println("--------------------------");            
      }
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Elements");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Create and set up the content pane.
        Elements newContentPane = new Elements();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
 
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });

    }
}