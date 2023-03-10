import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.io.*;

class SimpleTextEditor implements ActionListener {
     JFrame frame;
     JTextArea jTextArea;
     JMenuBar jMenuBar;
     JMenu File,Edit,Close;

     JMenuItem NewFile,OpenFile,SaveFile,PrintFile;

     JMenuItem Cut,Copy,Paste;

     JMenuItem Exit;
    SimpleTextEditor()
    {    //create frame
        frame=new JFrame("Simple Text Editor");

        //create textarea and setboundaries
        jTextArea=new JTextArea("Welcome to the Editor");
        jTextArea.setBounds(0,0,800,1000);

       //create menu bar
        jMenuBar=new JMenuBar();
        File=new JMenu("File");
        Edit=new JMenu("Edit");
        Close=new JMenu("Close");

        //add file,edit ,close in menubar
        jMenuBar.add(File);
        jMenuBar.add( Edit);
        jMenuBar.add(Close);

        //add new,open,save,close in file   with actionlitsner add
        NewFile=new JMenuItem("New");

        OpenFile=new JMenuItem("Open");

        SaveFile=new JMenuItem("Save");

        PrintFile=new JMenuItem("Print");

         File.add(NewFile);
         File.add(OpenFile);
         File.add(SaveFile);
         File.add(PrintFile);

         NewFile.addActionListener(this);
         OpenFile.addActionListener((this));
         SaveFile.addActionListener(this);
         PrintFile.addActionListener(this);

         //add cut,copy,paste to edit and add actionlistener

          Cut=new JMenuItem("Cut");

          Copy=new JMenuItem("Copy");

          Paste=new JMenuItem("Paste");

          Edit.add(Cut);
          Edit.add(Copy);
          Edit.add(Paste);

          Cut.addActionListener(this);
          Copy.addActionListener(this);
          Paste.addActionListener(this);

          //add closeEditor to close in menu bar and add actionListener
          Exit=new JMenuItem("Close");

          Exit.addActionListener(this);
          Close.add(Exit);



        // this is important if we add Menubar to frame use (setJMenuBar)
        frame.setJMenuBar(jMenuBar);

        //close program execution automatically
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //frame is visible by setvisible
        frame.setVisible(true);

        //add textarea to frame
        frame.add(jTextArea);


    }

    public static void main(String[] args) {
       new SimpleTextEditor();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String s=e.getActionCommand();
        if(s.equals("Copy"))
        {
            jTextArea.copy();
        }
        else if(s.equals("Cut"))
        {
            jTextArea.cut();
        }
        else if(s.equals("Paste"))
        {
            jTextArea.paste();
        }
        else if(s.equals("Print"))
        { try {
                jTextArea.print();
            } catch (PrinterException ex) {
                throw new RuntimeException(ex);
            }
        }
        else if(s.equals("New"))
        {
            jTextArea.setText("");
        }
        else if(s.equals("Close"))
        {
            frame.setVisible(false);
        }
        else if(s.equals("Open"))
        { //in this line click " " for dir
            JFileChooser jFileChooser=new JFileChooser("U:");
            int ans=jFileChooser.showOpenDialog(null);
            if(ans==jFileChooser.APPROVE_OPTION)
            {
                File file=new File(jFileChooser.getSelectedFile().getAbsolutePath());
                String s1,s2;
                try {
                    BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
                    s2=bufferedReader.readLine();
                    while((s1=bufferedReader.readLine())!=null)
                    {
                            s2+= s1 + "\n";
                    }
                    jTextArea.setText(s2);
                }
                catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        else if(s.equals("Save"))
        {
            JFileChooser jFileChooser=new JFileChooser(":U");
            int ans=jFileChooser.showSaveDialog(null);
            if(ans==JFileChooser.APPROVE_OPTION)
            {File file=new File(jFileChooser.getSelectedFile().getAbsolutePath());
                BufferedWriter writer=null;
                try {
                    writer=new BufferedWriter(new FileWriter(file,false));
                    writer.write((jTextArea.getText()));
                    writer.flush();
                    writer.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }
}