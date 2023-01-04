
   
    import java.awt.*;
    import java.awt.event.*;
    import java.applet.*;
    
     /*<applet code="TextCounterApplet.class" width="600" height="600"> </applet>  */
    public class TextCounterApplet extends Applet 
                                      implements ActionListener {
    
       TextArea textInput; 
       
       Label lineCountLabel;   
       Label wordCountLabel;   
       Label charCountLabel;   
    
    
       public void init() {
          
          setBackground(Color.darkGray);
          
       
          
          textInput = new TextArea();
          textInput.setBackground(Color.white);
          
         
          
          Panel south = new Panel();
          south.setLayout( new GridLayout(4,1,2,2) );
          
        
          Button countButton = new Button("Process the Text");
          countButton.setBackground(Color.lightGray);
          countButton.addActionListener(this);
          south.add(countButton);
          
        
          
          lineCountLabel = new Label("  Number of lines:");
          lineCountLabel.setBackground(Color.white);
          lineCountLabel.setForeground(Color.blue);
          south.add(lineCountLabel);
          
          wordCountLabel = new Label("  Number of words:");
          wordCountLabel.setBackground(Color.white);
          wordCountLabel.setForeground(Color.blue);
          south.add(wordCountLabel);
          
          charCountLabel = new Label("  Number of chars:");
          charCountLabel.setBackground(Color.white);
          charCountLabel.setForeground(Color.blue);
          south.add(charCountLabel);
          
      
          
          setLayout( new BorderLayout(2,2) );
          add(textInput, BorderLayout.CENTER);
          add(south, BorderLayout.SOUTH);
          
       }
       
       
       public Insets getInsets() {
             
          return new Insets(2,2,2,2);
       }
       
    
       public void actionPerformed(ActionEvent evt) {
           
           
           String text; 
           
           int charCt, wordCt, lineCt;  
           
           text = textInput.getText();
           
           charCt = text.length();  
                                   
                                    
      
           
           wordCt = 0;
           for (int i = 0; i < charCt; i++) {
              boolean startOfWord;  // Is character i the start of a word?
              if ( Character.isLetter(text.charAt(i)) == false )
                 startOfWord = false;  // No.  It's not a letter.
              else if (i == 0)
                 startOfWord = true;   // Yes.  It's a letter at start of text.
              else if ( Character.isLetter(text.charAt(i-1)) )
                 startOfWord = false;  // No.  It's a letter preceded by a letter.
              else if ( text.charAt(i-1) == '\'' && i > 1 
                                   && Character.isLetter(text.charAt(i-2)) )
                 startOfWord = false;  // No.  It's a continuation of a word
                                       //      after an apostrophe.
              else
                 startOfWord = true;   // Yes.  It's a letter preceded by
                                       //       a non-letter.
              if (startOfWord)
                 wordCt++;
           }
           
           
           
           lineCt = 1;
           for (int i = 0; i < charCt; i++) {
              if (text.charAt(i) == '\n')
                 lineCt++;
           }
           
          
           
           lineCountLabel.setText("  Number of Lines:  " + lineCt);
           wordCountLabel.setText("  Number of Words:  " + wordCt);
           charCountLabel.setText("  Number of Chars:  " + charCt);
    
       }  
    
       
    } 
