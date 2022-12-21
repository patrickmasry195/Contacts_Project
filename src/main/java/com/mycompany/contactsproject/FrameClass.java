package com.mycompany.contactsproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

class FrameClass extends JFrame
{
//    Declaring Arraylist to hold names
    private ArrayList<String> contactsNames = new ArrayList<String>();
//    Declaring Labels
    private JLabel selectContLabel,
                   numberOfContLabel,
                   mobileContLabel,
                   workContLabel,
                   emailContLabel;
//    Declaring Text Fields
    private JTextField
                   mobileContTxtF,
                   workContTxtF,
                   emailContTxtF;   
//  Declaring list and search Button
    private JList namesContList = new JList ();
    private JButton searchButton = new JButton("Search");
//    Constructor
    public FrameClass()
    {
//   Setting the layout
        this.setLayout(null);
//   Setting a frame title
        this.setTitle("Contacts Application");
//   Calling a method to populate a list with names 
        listPopulation();
        
//   Initializing Labels
        
    selectContLabel = new JLabel ("Select Contact :");
    numberOfContLabel = new JLabel ("Number of Contacts :");
    mobileContLabel = new JLabel ("Mobile :");
    workContLabel = new JLabel ("Work :");
    emailContLabel = new JLabel ("Email :");
    
//    Declaring Text Fields

    mobileContTxtF = new JTextField ();
    workContTxtF = new JTextField ();
    emailContTxtF = new JTextField ();
    
//    Postioning the Jlabels 
    selectContLabel.setBounds(5, 5, 100, 30);
    numberOfContLabel.setBounds(5, 250, 200, 30);
    mobileContLabel.setBounds(240, 50, 100, 30);
    workContLabel.setBounds(240, 100, 100, 30); 
    emailContLabel.setBounds(240, 150, 100, 30);
    
//    Postioning and sizing Jtext Fields
    mobileContTxtF.setBounds(290, 50, 150, 30);
    workContTxtF.setBounds(290, 100, 150, 30);
    emailContTxtF.setBounds(290, 150, 150, 30);
    
//    Postioning and sizing Jlist
    namesContList.setBounds(5, 50, 200, 200);
    
//    Postioning and sizing Search Button   
    searchButton.setBounds(5, 300, 200, 30);
    
//    Adding new text to Labels 
    numberOfContLabel.setText("Number of Contacts : " + contactsNames.toArray().length);
//    Addinglistner action to search button 
    this.searchButton.addActionListener(
            new ActionListener()
            {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
//                if statement to check if the name is selected on the list
                  if (namesContList.getSelectedValue()!=null)
                  {
        int indexNumber = readFromFile().indexOf(namesContList.getSelectedValue());
                  mobileContTxtF.setText(readFromFile().toArray()[(indexNumber+1)]+"");
                  workContTxtF.setText(readFromFile().toArray()[(indexNumber+2)]+"");
                  emailContTxtF.setText(readFromFile().toArray()[(indexNumber+3)]+"");
                  }
                  else 
                  {
                  JOptionPane.showMessageDialog(null,"Please select the name from the list before you click the search button");
                  }      
            } 
    
            }
        );
            
//    Adding componets to JFrame
    this.add(selectContLabel);
    this.add(numberOfContLabel);
    this.add(mobileContLabel);
    this.add(workContLabel);
    this.add(emailContLabel);
    
//   Adding Text Fields

    this.add(mobileContTxtF);
    this.add(workContTxtF);
    this.add(emailContTxtF);
    
//  Adding list and search Button

    this.add(namesContList);
    this.add(searchButton);
    }
//  Method to read from file
    
    public List<String> readFromFile() 
    {
     try
     {    
          
        return Files.readAllLines(Paths.get("C:\\Users\\HP\\Documents\\NetBeansProjects\\contactsProject\\src\\main\\java\\TextFiles\\Contacts.txt"));
     }
     catch(Exception IO)
     {
     JOptionPane.showMessageDialog(null,"Error : "+IO);
     return null;
     }
        
    
    }
//    Method to populate the list with names 
    public void listPopulation()
    {
        for (int i=0 ; i<(readFromFile().toArray()).length; i+=4) 
        contactsNames.add((String) (readFromFile().toArray()[i]));
        namesContList.setListData(contactsNames.toArray());


    }
}
