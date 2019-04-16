import javax.swing.*;

public class GameDatabaseApplication {  
    public static void main(String[] args) {
        JFrame f=new JFrame();//creating instance of JFrame  
        
        JButton executeQueryButton = new JButton("Execute query");
        executeQueryButton.setBounds(130,100,100, 40);//x axis, y axis, width, height  
          
        f.add(executeQueryButton);//adding button in JFrame  
          
        f.setSize(400,500);//400 width and 500 height
        f.setLayout(null);//using no layout managers  
        f.setVisible(true);//making the frame visible  
    }  
}