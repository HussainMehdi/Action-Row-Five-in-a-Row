

package fiveinrow;


import javax.swing.JButton;

public class Game extends javax.swing.JFrame {

    
    
   public JButton[] Btn[];
   Grid Board=new Grid(15,15);
   int Player_Turn=0, level=-1 ;
   int[] RecentMove= new int[2];
   boolean Reset=false,Win=false,server=false,client=false,lan=false;
   Music BackgroundMusic;
   Game MySelf=this;
   
   
   class Animat extends Thread
   {
      public void run() {
          while(true){
            MySelf.setTitle("Action row !!!");
            try {sleep(100);} catch (InterruptedException ex) {}
            MySelf.setTitle("aCtion row !!!");
            try {sleep(100);} catch (InterruptedException ex) {}
            MySelf.setTitle("acTion row !!!");
            try {sleep(100);} catch (InterruptedException ex) {}
            MySelf.setTitle("actIon row !!!");
            try {sleep(100);} catch (InterruptedException ex) {}
            MySelf.setTitle("actiOn row !!!");
            try {sleep(100);} catch (InterruptedException ex) {}
            MySelf.setTitle("actioN row !!!");
            try {sleep(100);} catch (InterruptedException ex) {}
            MySelf.setTitle("action Row !!!");
            try {sleep(100);} catch (InterruptedException ex) {}
            MySelf.setTitle("action rOw !!!");
            try {sleep(100);} catch (InterruptedException ex) {}
            MySelf.setTitle("action RoW !!!");
            try {sleep(100);} catch (InterruptedException ex) {}
            MySelf.setTitle("action row .!!");
            try {sleep(100);} catch (InterruptedException ex) {}
            MySelf.setTitle("action row !.!");
            try {sleep(100);} catch (InterruptedException ex) {}
            MySelf.setTitle("action row !!.");
            try {sleep(100);} catch (InterruptedException ex) {}
          }
      }
      
      
   }
   
    //<editor-fold defaultstate="collapsed" desc="Networking">
   class Servr
   extends Thread {
       public void run() {
           if (lan){
               try{Thread.sleep(250);}catch(Exception ee){}
               DisableButtons();
               Turns.setText("Waiting For Player "+ ((Player_Turn%2)+1)+ "Move");
               Server SRVR = new Server();
               int mov[];//={3,4};
               mov=SRVR.GetMove();
               
               SRVR=null;
               EnableButtons();
               Board.MakeMove(mov, new Cell( (Player_Turn++%2)+1));
               
               new CheckWin(MySelf);
               UpdateButtons();
           }}
   }
   
   class Clint
   extends Thread {
       public void run() {
           if (lan){
               Client CLNT = new Client();
               CLNT.SendMove(RecentMove);
           }
       }
   }
//</editor-fold>
    
    public Game(int Level,Music BG,boolean srvr, boolean clnt, boolean Lan) {
        
        server=srvr;client=clnt;lan=Lan;
        BackgroundMusic=BG;
        level=Level;
        initComponents();
        SetLevelButtonFocus();
        Btn= new JButton[15][15];
        //<editor-fold defaultstate="collapsed" desc="Initializing Array for Buttons">
        Btn[0][0]=R00C0;   Btn[0][1]=R00C1;   Btn[0][2]=R00C2;
        Btn[0][3]=R00C3;   Btn[0][4]=R00C4;   Btn[0][5]=R00C5;
        Btn[0][6]=R00C6;   Btn[0][7]=R00C7;   Btn[0][8]=R00C8;
        Btn[0][9]=R00C9;   Btn[0][10]=R00C10; Btn[0][11]=R00C11;
        Btn[0][12]=R00C12; Btn[0][13]=R00C13; Btn[0][14]=R00C14;
        
        Btn[1][0]=R01C00;   Btn[1][1]=R01C01;   Btn[1][2]=R01C02;
        Btn[1][3]=R01C03;   Btn[1][4]=R01C04;   Btn[1][5]=R01C05;
        Btn[1][6]=R01C06;   Btn[1][7]=R01C07;   Btn[1][8]=R01C08;
        Btn[1][9]=R01C09;   Btn[1][10]=R01C10;  Btn[1][11]=R01C11;
        Btn[1][12]=R01C12;  Btn[1][13]=R01C13;  Btn[1][14]=R01C14;
        
        Btn[2][0]=R02C00;   Btn[2][1]=R02C01;   Btn[2][2]=R02C02;
        Btn[2][3]=R02C03;   Btn[2][4]=R02C04;   Btn[2][5]=R02C05;
        Btn[2][6]=R02C06;   Btn[2][7]=R02C07;   Btn[2][8]=R02C08;
        Btn[2][9]=R02C09;   Btn[2][10]=R02C10;  Btn[2][11]=R02C11;
        Btn[2][12]=R02C12;  Btn[2][13]=R02C13;  Btn[2][14]=R02C14;
        
        Btn[3][0]=R03C00;   Btn[3][1]=R03C01;   Btn[3][2]=R03C02;
        Btn[3][3]=R03C03;   Btn[3][4]=R03C04;   Btn[3][5]=R03C05;
        Btn[3][6]=R03C06;   Btn[3][7]=R03C07;   Btn[3][8]=R03C08;
        Btn[3][9]=R03C09;   Btn[3][10]=R03C10;  Btn[3][11]=R03C11;
        Btn[3][12]=R03C12;  Btn[3][13]=R03C13;  Btn[3][14]=R03C14;
        
        Btn[4][0]=R04C00;   Btn[4][1]=R04C01;   Btn[4][2]=R04C02;
        Btn[4][3]=R04C03;   Btn[4][4]=R04C04;   Btn[4][5]=R04C05;
        Btn[4][6]=R04C06;   Btn[4][7]=R04C07;   Btn[4][8]=R04C08;
        Btn[4][9]=R04C09;   Btn[4][10]=R04C10;  Btn[4][11]=R04C11;
        Btn[4][12]=R04C12;  Btn[4][13]=R04C13;  Btn[4][14]=R04C14;
        
        Btn[5][0]=R05C00;   Btn[5][1]=R05C01;   Btn[5][2]=R05C02;
        Btn[5][3]=R05C03;   Btn[5][4]=R05C04;   Btn[5][5]=R05C05;
        Btn[5][6]=R05C06;   Btn[5][7]=R05C07;   Btn[5][8]=R05C08;
        Btn[5][9]=R05C09;   Btn[5][10]=R05C10;  Btn[5][11]=R05C11;
        Btn[5][12]=R05C12;  Btn[5][13]=R05C13;  Btn[5][14]=R05C14;
        
        Btn[6][0]=R06C00;   Btn[6][1]=R06C01;   Btn[6][2]=R06C02;
        Btn[6][3]=R06C03;   Btn[6][4]=R06C04;   Btn[6][5]=R06C05;
        Btn[6][6]=R06C06;   Btn[6][7]=R06C07;   Btn[6][8]=R06C08;
        Btn[6][9]=R06C09;   Btn[6][10]=R06C10;  Btn[6][11]=R06C11;
        Btn[6][12]=R06C12;  Btn[6][13]=R06C13;  Btn[6][14]=R06C14;
        
        Btn[7][0]=R07C00;   Btn[7][1]=R07C01;   Btn[7][2]=R07C02;
        Btn[7][3]=R07C03;   Btn[7][4]=R07C04;   Btn[7][5]=R07C05;
        Btn[7][6]=R07C06;   Btn[7][7]=R07C07;   Btn[7][8]=R07C08;
        Btn[7][9]=R07C09;   Btn[7][10]=R07C10;  Btn[7][11]=R07C11;
        Btn[7][12]=R07C12;  Btn[7][13]=R07C13;  Btn[7][14]=R07C14;
        
        Btn[8][0]=R08C00;   Btn[8][1]=R08C01;   Btn[8][2]=R08C02;
        Btn[8][3]=R08C03;   Btn[8][4]=R08C04;   Btn[8][5]=R08C05;
        Btn[8][6]=R08C06;   Btn[8][7]=R08C07;   Btn[8][8]=R08C08;
        Btn[8][9]=R08C09;   Btn[8][10]=R08C10;  Btn[8][11]=R08C11;
        Btn[8][12]=R08C12;  Btn[8][13]=R08C13;  Btn[8][14]=R08C14;
        
        Btn[9][0]=R09C00;   Btn[9][1]=R09C01;   Btn[9][2]=R09C02;
        Btn[9][3]=R09C03;   Btn[9][4]=R09C04;   Btn[9][5]=R09C05;
        Btn[9][6]=R09C06;   Btn[9][7]=R09C07;   Btn[9][8]=R09C08;
        Btn[9][9]=R09C09;   Btn[9][10]=R09C10;  Btn[9][11]=R09C11;
        Btn[9][12]=R09C12;  Btn[9][13]=R09C13;  Btn[9][14]=R09C14;
        
        Btn[10][0]=R10C00;   Btn[10][1]=R10C01;   Btn[10][2]=R10C02;
        Btn[10][3]=R10C03;   Btn[10][4]=R10C04;   Btn[10][5]=R10C05;
        Btn[10][6]=R10C06;   Btn[10][7]=R10C07;   Btn[10][8]=R10C08;
        Btn[10][9]=R10C09;   Btn[10][10]=R10C10;  Btn[10][11]=R10C11;
        Btn[10][12]=R10C12;  Btn[10][13]=R10C13;  Btn[10][14]=R10C14;
        
        Btn[11][0]=R11C00;   Btn[11][1]=R11C01;   Btn[11][2]=R11C02;
        Btn[11][3]=R11C03;   Btn[11][4]=R11C04;   Btn[11][5]=R11C05;
        Btn[11][6]=R11C06;   Btn[11][7]=R11C07;   Btn[11][8]=R11C08;
        Btn[11][9]=R11C09;   Btn[11][10]=R11C10;  Btn[11][11]=R11C11;
        Btn[11][12]=R11C12;  Btn[11][13]=R11C13;  Btn[11][14]=R11C14;
        
        Btn[12][0]=R12C00;   Btn[12][1]=R12C01;   Btn[12][2]=R12C02;
        Btn[12][3]=R12C03;   Btn[12][4]=R12C04;   Btn[12][5]=R12C05;
        Btn[12][6]=R12C06;   Btn[12][7]=R12C07;   Btn[12][8]=R12C08;
        Btn[12][9]=R12C09;   Btn[12][10]=R12C10;  Btn[12][11]=R12C11;
        Btn[12][12]=R12C12;  Btn[12][13]=R12C13;  Btn[12][14]=R12C14;
        
        Btn[13][0]=R13C00;   Btn[13][1]=R13C01;   Btn[13][2]=R13C02;
        Btn[13][3]=R13C03;   Btn[13][4]=R13C04;   Btn[13][5]=R13C05;
        Btn[13][6]=R13C06;   Btn[13][7]=R13C07;   Btn[13][8]=R13C08;
        Btn[13][9]=R13C09;   Btn[13][10]=R13C10;  Btn[13][11]=R13C11;
        Btn[13][12]=R13C12;  Btn[13][13]=R13C13;  Btn[13][14]=R13C14;
        
        Btn[14][0]=R14C00;   Btn[14][1]=R14C01;   Btn[14][2]=R14C02;
        Btn[14][3]=R14C03;   Btn[14][4]=R14C04;   Btn[14][5]=R14C05;
        Btn[14][6]=R14C06;   Btn[14][7]=R14C07;   Btn[14][8]=R14C08;
        Btn[14][9]=R14C09;   Btn[14][10]=R14C10;  Btn[14][11]=R14C11;
        Btn[14][12]=R14C12;  Btn[14][13]=R14C13;  Btn[14][14]=R14C14;
//</editor-fold>
        if (level==-1){LevelSelect.setEnabled(false);}
        if (lan && server){
            
            
            new Servr().start(); 
           // try{Thread.sleep(1000);}catch(Exception ee){}
        }
    }
    void SetLevelButtonFocus()
    {   if (level==0)
        LevelSelect.setText("Blind");
        if (level==1)
        LevelSelect.setText("Learner");
        if (level==2)
        LevelSelect.setText("CPU");
    }
    void DoAI()
    {   new CheckWin(this);
        UpdateButtons();
        //if (lan && server)
        {   
       // try{Thread.sleep(1000);}catch(Exception ee){}
            new Servr().start();
            
        }
        //else
        if(level!=-1)
        if(!Win)
      { 
        int AIMove[];
        AI PC= new AI();
        if (level!=0 )
        AIMove = PC.LogicAI(Board,(Player_Turn%2)+1,level);
        else AIMove = PC.EasyAI(Board);
         if (!Board.MakeMove(AIMove, new Cell( (Player_Turn++%2)+1)))
      
        System.out.println("Problem in AI Move");
      }
        else { //Player_Turn++;
        }
        new CheckWin(this);
        
    }
    void UpdateButtons()
    {   Cell temp[][]=Board.Table;
        if ((Player_Turn%2)+1==1){Turns.setText("Player 1 Turn");}
        if (level==-1) if ((Player_Turn%2)+1==2){Turns.setText("Player 2 Turn");}
        
        String workingDir = System.getProperty("user.dir");
        workingDir+="\\sounds\\click.wav";
	   System.out.println("Current working directory : " + workingDir);
        
         new Music(workingDir).play(0);
        
        for (int i=0;i<15;i++)
        {
            for (int j=0;j<15;j++)
            {   if (temp[i][j]!=null)
                {
                if (temp[i][j].getinfo()==1 && Btn[i][j].isFocusable())
                {Btn[i][j].setIcon(WhiteCell.getIcon());
                 Btn[i][j].setFocusable(false); 
                 Btn[i][j].setRolloverEnabled(false);}
                
                if (temp[i][j].getinfo()==2 && Btn[i][j].isFocusable())
                {Btn[i][j].setIcon(BlackCell.getIcon());
                 Btn[i][j].setRolloverEnabled(false);
                 Btn[i][j].setFocusable(false);}
                
                if (temp[i][j].getinfo()==11 )
                {Btn[i][j].setIcon(WinWhiteCell.getIcon());
                 Btn[i][j].setFocusable(false); 
                 Btn[i][j].setRolloverEnabled(false);
                    System.out.println("inside");
                }
                
                if (temp[i][j].getinfo()==21 )
                {Btn[i][j].setIcon(WinBlackCell.getIcon());
                 Btn[i][j].setFocusable(false); 
                 Btn[i][j].setRolloverEnabled(false);}
                
                }
            
                
                
            else if(Reset)
            {
                Btn[i][j].setFocusable(true);
                Btn[i][j].setIcon(BasicCell.getIcon());
                Btn[i][j].setRolloverEnabled(true);
                Btn[i][j].updateUI();  // This thing animates Buttons :p
            }
            }
        }
        
        Reset=false;
        if(Win){DisableButtons();BackgroundMusic.stop();
        String workingDir1 = System.getProperty("user.dir");
        workingDir1+="\\sounds\\win.wav";
	   System.out.println("Current working directory : " + workingDir1);
            new Music(workingDir1).play(0);
        
        }
    }

    void DisableButtons()
    {for (int i=0;i<15;i++) for (int j=0;j<15;j++)
    {Btn[i][j].setFocusable(false);Btn[i][j].setRolloverEnabled(false);}}
   
    void EnableButtons()
    {   Cell temp[][]=Board.Table;
        for (int i=0;i<15;i++) for (int j=0;j<15;j++)
    {   if(temp[i][j]==null){
        Btn[i][j].setFocusable(true);Btn[i][j].setRolloverEnabled(true);}
    }
    }
    
    void ResetGame()
    {   Cell temp[][]=Board.Table;
        for (int i=0;i<15;i++) for (int j=0;j<15;j++)temp[i][j]=null;
        Reset=true;
        Win=false;
        UpdateButtons();
        BackgroundMusic.play(9999);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        R00C0 = new javax.swing.JButton();
        R00C1 = new javax.swing.JButton();
        R00C2 = new javax.swing.JButton();
        R00C3 = new javax.swing.JButton();
        R00C4 = new javax.swing.JButton();
        R00C5 = new javax.swing.JButton();
        R00C6 = new javax.swing.JButton();
        R00C7 = new javax.swing.JButton();
        R00C8 = new javax.swing.JButton();
        R00C9 = new javax.swing.JButton();
        R00C10 = new javax.swing.JButton();
        R00C11 = new javax.swing.JButton();
        R00C12 = new javax.swing.JButton();
        R00C13 = new javax.swing.JButton();
        R00C14 = new javax.swing.JButton();
        R01C00 = new javax.swing.JButton();
        R01C01 = new javax.swing.JButton();
        R01C02 = new javax.swing.JButton();
        R01C03 = new javax.swing.JButton();
        R01C04 = new javax.swing.JButton();
        R01C05 = new javax.swing.JButton();
        R01C06 = new javax.swing.JButton();
        R01C07 = new javax.swing.JButton();
        R01C08 = new javax.swing.JButton();
        R01C09 = new javax.swing.JButton();
        R01C10 = new javax.swing.JButton();
        R01C11 = new javax.swing.JButton();
        R01C12 = new javax.swing.JButton();
        R01C13 = new javax.swing.JButton();
        R01C14 = new javax.swing.JButton();
        R02C00 = new javax.swing.JButton();
        R02C01 = new javax.swing.JButton();
        R02C02 = new javax.swing.JButton();
        R02C03 = new javax.swing.JButton();
        R02C04 = new javax.swing.JButton();
        R02C05 = new javax.swing.JButton();
        R02C06 = new javax.swing.JButton();
        R02C07 = new javax.swing.JButton();
        R02C08 = new javax.swing.JButton();
        R02C09 = new javax.swing.JButton();
        R02C10 = new javax.swing.JButton();
        R02C11 = new javax.swing.JButton();
        R02C12 = new javax.swing.JButton();
        R02C13 = new javax.swing.JButton();
        R02C14 = new javax.swing.JButton();
        R03C00 = new javax.swing.JButton();
        R03C01 = new javax.swing.JButton();
        R03C02 = new javax.swing.JButton();
        R03C03 = new javax.swing.JButton();
        R03C04 = new javax.swing.JButton();
        R03C05 = new javax.swing.JButton();
        R03C06 = new javax.swing.JButton();
        R03C07 = new javax.swing.JButton();
        R03C08 = new javax.swing.JButton();
        R03C09 = new javax.swing.JButton();
        R03C10 = new javax.swing.JButton();
        R03C11 = new javax.swing.JButton();
        R03C12 = new javax.swing.JButton();
        R03C13 = new javax.swing.JButton();
        R03C14 = new javax.swing.JButton();
        R04C00 = new javax.swing.JButton();
        R04C01 = new javax.swing.JButton();
        R04C02 = new javax.swing.JButton();
        R04C03 = new javax.swing.JButton();
        R04C04 = new javax.swing.JButton();
        R04C05 = new javax.swing.JButton();
        R04C06 = new javax.swing.JButton();
        R04C07 = new javax.swing.JButton();
        R04C08 = new javax.swing.JButton();
        R04C09 = new javax.swing.JButton();
        R04C10 = new javax.swing.JButton();
        R04C11 = new javax.swing.JButton();
        R04C12 = new javax.swing.JButton();
        R04C13 = new javax.swing.JButton();
        R04C14 = new javax.swing.JButton();
        R05C00 = new javax.swing.JButton();
        R05C01 = new javax.swing.JButton();
        R05C02 = new javax.swing.JButton();
        R05C03 = new javax.swing.JButton();
        R05C04 = new javax.swing.JButton();
        R05C05 = new javax.swing.JButton();
        R05C06 = new javax.swing.JButton();
        R05C07 = new javax.swing.JButton();
        R05C08 = new javax.swing.JButton();
        R05C09 = new javax.swing.JButton();
        R05C10 = new javax.swing.JButton();
        R05C11 = new javax.swing.JButton();
        R05C12 = new javax.swing.JButton();
        R05C13 = new javax.swing.JButton();
        R05C14 = new javax.swing.JButton();
        R06C00 = new javax.swing.JButton();
        R06C01 = new javax.swing.JButton();
        R06C02 = new javax.swing.JButton();
        R06C03 = new javax.swing.JButton();
        R06C04 = new javax.swing.JButton();
        R06C05 = new javax.swing.JButton();
        R06C06 = new javax.swing.JButton();
        R06C07 = new javax.swing.JButton();
        R06C08 = new javax.swing.JButton();
        R06C09 = new javax.swing.JButton();
        R06C10 = new javax.swing.JButton();
        R06C11 = new javax.swing.JButton();
        R06C12 = new javax.swing.JButton();
        R06C13 = new javax.swing.JButton();
        R06C14 = new javax.swing.JButton();
        R07C00 = new javax.swing.JButton();
        R07C01 = new javax.swing.JButton();
        R07C02 = new javax.swing.JButton();
        R07C03 = new javax.swing.JButton();
        R07C04 = new javax.swing.JButton();
        R07C05 = new javax.swing.JButton();
        R07C06 = new javax.swing.JButton();
        R07C07 = new javax.swing.JButton();
        R07C08 = new javax.swing.JButton();
        R07C09 = new javax.swing.JButton();
        R07C10 = new javax.swing.JButton();
        R07C11 = new javax.swing.JButton();
        R07C12 = new javax.swing.JButton();
        R07C13 = new javax.swing.JButton();
        R07C14 = new javax.swing.JButton();
        R08C00 = new javax.swing.JButton();
        R08C01 = new javax.swing.JButton();
        R08C02 = new javax.swing.JButton();
        R08C03 = new javax.swing.JButton();
        R08C04 = new javax.swing.JButton();
        R08C05 = new javax.swing.JButton();
        R08C06 = new javax.swing.JButton();
        R08C07 = new javax.swing.JButton();
        R08C08 = new javax.swing.JButton();
        R08C09 = new javax.swing.JButton();
        R08C10 = new javax.swing.JButton();
        R08C11 = new javax.swing.JButton();
        R08C12 = new javax.swing.JButton();
        R08C13 = new javax.swing.JButton();
        R08C14 = new javax.swing.JButton();
        R09C00 = new javax.swing.JButton();
        R09C01 = new javax.swing.JButton();
        R09C02 = new javax.swing.JButton();
        R09C03 = new javax.swing.JButton();
        R09C04 = new javax.swing.JButton();
        R09C05 = new javax.swing.JButton();
        R09C06 = new javax.swing.JButton();
        R09C07 = new javax.swing.JButton();
        R09C08 = new javax.swing.JButton();
        R09C09 = new javax.swing.JButton();
        R09C10 = new javax.swing.JButton();
        R09C11 = new javax.swing.JButton();
        R09C12 = new javax.swing.JButton();
        R09C13 = new javax.swing.JButton();
        R09C14 = new javax.swing.JButton();
        R10C00 = new javax.swing.JButton();
        R10C01 = new javax.swing.JButton();
        R10C02 = new javax.swing.JButton();
        R10C03 = new javax.swing.JButton();
        R10C04 = new javax.swing.JButton();
        R10C05 = new javax.swing.JButton();
        R10C06 = new javax.swing.JButton();
        R10C07 = new javax.swing.JButton();
        R10C08 = new javax.swing.JButton();
        R10C09 = new javax.swing.JButton();
        R10C10 = new javax.swing.JButton();
        R10C11 = new javax.swing.JButton();
        R10C12 = new javax.swing.JButton();
        R10C13 = new javax.swing.JButton();
        R10C14 = new javax.swing.JButton();
        R11C00 = new javax.swing.JButton();
        R11C01 = new javax.swing.JButton();
        R11C02 = new javax.swing.JButton();
        R11C03 = new javax.swing.JButton();
        R11C04 = new javax.swing.JButton();
        R11C05 = new javax.swing.JButton();
        R11C06 = new javax.swing.JButton();
        R11C07 = new javax.swing.JButton();
        R11C08 = new javax.swing.JButton();
        R11C09 = new javax.swing.JButton();
        R11C10 = new javax.swing.JButton();
        R11C11 = new javax.swing.JButton();
        R11C12 = new javax.swing.JButton();
        R11C13 = new javax.swing.JButton();
        R11C14 = new javax.swing.JButton();
        R12C00 = new javax.swing.JButton();
        R12C01 = new javax.swing.JButton();
        R12C02 = new javax.swing.JButton();
        R12C03 = new javax.swing.JButton();
        R12C04 = new javax.swing.JButton();
        R12C05 = new javax.swing.JButton();
        R12C06 = new javax.swing.JButton();
        R12C07 = new javax.swing.JButton();
        R12C08 = new javax.swing.JButton();
        R12C09 = new javax.swing.JButton();
        R12C10 = new javax.swing.JButton();
        R12C11 = new javax.swing.JButton();
        R12C12 = new javax.swing.JButton();
        R12C13 = new javax.swing.JButton();
        R12C14 = new javax.swing.JButton();
        R13C00 = new javax.swing.JButton();
        R13C01 = new javax.swing.JButton();
        R13C02 = new javax.swing.JButton();
        R13C03 = new javax.swing.JButton();
        R13C04 = new javax.swing.JButton();
        R13C05 = new javax.swing.JButton();
        R13C06 = new javax.swing.JButton();
        R13C07 = new javax.swing.JButton();
        R13C08 = new javax.swing.JButton();
        R13C09 = new javax.swing.JButton();
        R13C10 = new javax.swing.JButton();
        R13C11 = new javax.swing.JButton();
        R13C12 = new javax.swing.JButton();
        R13C13 = new javax.swing.JButton();
        R13C14 = new javax.swing.JButton();
        R14C00 = new javax.swing.JButton();
        R14C01 = new javax.swing.JButton();
        R14C02 = new javax.swing.JButton();
        R14C03 = new javax.swing.JButton();
        R14C04 = new javax.swing.JButton();
        R14C05 = new javax.swing.JButton();
        R14C06 = new javax.swing.JButton();
        R14C07 = new javax.swing.JButton();
        R14C08 = new javax.swing.JButton();
        R14C09 = new javax.swing.JButton();
        R14C10 = new javax.swing.JButton();
        R14C11 = new javax.swing.JButton();
        R14C12 = new javax.swing.JButton();
        R14C13 = new javax.swing.JButton();
        R14C14 = new javax.swing.JButton();
        WhiteCell = new javax.swing.JButton();
        BlackCell = new javax.swing.JButton();
        BasicCell = new javax.swing.JButton();
        ResetButton = new javax.swing.JButton();
        Go_Back = new javax.swing.JButton();
        LevelSelect = new javax.swing.JButton();
        WinBlackCell = new javax.swing.JButton();
        WinWhiteCell = new javax.swing.JButton();
        LSelect = new javax.swing.JLabel();
        Turns = new javax.swing.JLabel();
        BG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(null);

        R00C0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R00C0.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R00C0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R00C0ActionPerformed(evt);
            }
        });
        getContentPane().add(R00C0);
        R00C0.setBounds(10, 99, 44, 33);

        R00C1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R00C1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R00C1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R00C1ActionPerformed(evt);
            }
        });
        getContentPane().add(R00C1);
        R00C1.setBounds(55, 99, 44, 33);

        R00C2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R00C2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R00C2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R00C2ActionPerformed(evt);
            }
        });
        getContentPane().add(R00C2);
        R00C2.setBounds(100, 99, 44, 33);

        R00C3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R00C3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R00C3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R00C3ActionPerformed(evt);
            }
        });
        getContentPane().add(R00C3);
        R00C3.setBounds(145, 99, 44, 33);

        R00C4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R00C4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R00C4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R00C4ActionPerformed(evt);
            }
        });
        getContentPane().add(R00C4);
        R00C4.setBounds(190, 99, 44, 33);

        R00C5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R00C5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R00C5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R00C5ActionPerformed(evt);
            }
        });
        getContentPane().add(R00C5);
        R00C5.setBounds(235, 99, 44, 33);

        R00C6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R00C6.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R00C6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R00C6ActionPerformed(evt);
            }
        });
        getContentPane().add(R00C6);
        R00C6.setBounds(280, 99, 44, 33);

        R00C7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R00C7.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R00C7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R00C7ActionPerformed(evt);
            }
        });
        getContentPane().add(R00C7);
        R00C7.setBounds(325, 99, 44, 33);

        R00C8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R00C8.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R00C8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R00C8ActionPerformed(evt);
            }
        });
        getContentPane().add(R00C8);
        R00C8.setBounds(370, 99, 44, 33);

        R00C9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R00C9.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R00C9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R00C9ActionPerformed(evt);
            }
        });
        getContentPane().add(R00C9);
        R00C9.setBounds(415, 99, 44, 33);

        R00C10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R00C10.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R00C10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R00C10ActionPerformed(evt);
            }
        });
        getContentPane().add(R00C10);
        R00C10.setBounds(460, 99, 44, 33);

        R00C11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R00C11.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R00C11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R00C11ActionPerformed(evt);
            }
        });
        getContentPane().add(R00C11);
        R00C11.setBounds(505, 99, 44, 33);

        R00C12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R00C12.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R00C12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R00C12ActionPerformed(evt);
            }
        });
        getContentPane().add(R00C12);
        R00C12.setBounds(550, 99, 44, 33);

        R00C13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R00C13.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R00C13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R00C13ActionPerformed(evt);
            }
        });
        getContentPane().add(R00C13);
        R00C13.setBounds(595, 99, 44, 33);

        R00C14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R00C14.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R00C14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R00C14ActionPerformed(evt);
            }
        });
        getContentPane().add(R00C14);
        R00C14.setBounds(640, 99, 44, 33);

        R01C00.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R01C00.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R01C00.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R01C00ActionPerformed(evt);
            }
        });
        getContentPane().add(R01C00);
        R01C00.setBounds(10, 133, 44, 33);

        R01C01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R01C01.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R01C01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R01C01ActionPerformed(evt);
            }
        });
        getContentPane().add(R01C01);
        R01C01.setBounds(55, 133, 44, 33);

        R01C02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R01C02.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R01C02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R01C02ActionPerformed(evt);
            }
        });
        getContentPane().add(R01C02);
        R01C02.setBounds(100, 133, 44, 33);

        R01C03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R01C03.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R01C03.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R01C03ActionPerformed(evt);
            }
        });
        getContentPane().add(R01C03);
        R01C03.setBounds(145, 133, 44, 33);

        R01C04.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R01C04.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R01C04.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R01C04ActionPerformed(evt);
            }
        });
        getContentPane().add(R01C04);
        R01C04.setBounds(190, 133, 44, 33);

        R01C05.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R01C05.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R01C05.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R01C05ActionPerformed(evt);
            }
        });
        getContentPane().add(R01C05);
        R01C05.setBounds(235, 133, 44, 33);

        R01C06.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R01C06.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R01C06.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R01C06ActionPerformed(evt);
            }
        });
        getContentPane().add(R01C06);
        R01C06.setBounds(280, 133, 44, 33);

        R01C07.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R01C07.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R01C07.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R01C07ActionPerformed(evt);
            }
        });
        getContentPane().add(R01C07);
        R01C07.setBounds(325, 133, 44, 33);

        R01C08.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R01C08.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R01C08.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R01C08ActionPerformed(evt);
            }
        });
        getContentPane().add(R01C08);
        R01C08.setBounds(370, 133, 44, 33);

        R01C09.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R01C09.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R01C09.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R01C09ActionPerformed(evt);
            }
        });
        getContentPane().add(R01C09);
        R01C09.setBounds(415, 133, 44, 33);

        R01C10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R01C10.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R01C10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R01C10ActionPerformed(evt);
            }
        });
        getContentPane().add(R01C10);
        R01C10.setBounds(460, 133, 44, 33);

        R01C11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R01C11.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R01C11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R01C11ActionPerformed(evt);
            }
        });
        getContentPane().add(R01C11);
        R01C11.setBounds(505, 133, 44, 33);

        R01C12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R01C12.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R01C12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R01C12ActionPerformed(evt);
            }
        });
        getContentPane().add(R01C12);
        R01C12.setBounds(550, 133, 44, 33);

        R01C13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R01C13.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R01C13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R01C13ActionPerformed(evt);
            }
        });
        getContentPane().add(R01C13);
        R01C13.setBounds(595, 133, 44, 33);

        R01C14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R01C14.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R01C14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R01C14ActionPerformed(evt);
            }
        });
        getContentPane().add(R01C14);
        R01C14.setBounds(640, 133, 44, 33);

        R02C00.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R02C00.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R02C00.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R02C00ActionPerformed(evt);
            }
        });
        getContentPane().add(R02C00);
        R02C00.setBounds(10, 167, 44, 33);

        R02C01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R02C01.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R02C01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R02C01ActionPerformed(evt);
            }
        });
        getContentPane().add(R02C01);
        R02C01.setBounds(55, 167, 44, 33);

        R02C02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R02C02.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R02C02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R02C02ActionPerformed(evt);
            }
        });
        getContentPane().add(R02C02);
        R02C02.setBounds(100, 167, 44, 33);

        R02C03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R02C03.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R02C03.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R02C03ActionPerformed(evt);
            }
        });
        getContentPane().add(R02C03);
        R02C03.setBounds(145, 167, 44, 33);

        R02C04.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R02C04.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R02C04.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R02C04ActionPerformed(evt);
            }
        });
        getContentPane().add(R02C04);
        R02C04.setBounds(190, 167, 44, 33);

        R02C05.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R02C05.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R02C05.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R02C05ActionPerformed(evt);
            }
        });
        getContentPane().add(R02C05);
        R02C05.setBounds(235, 167, 44, 33);

        R02C06.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R02C06.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R02C06.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R02C06ActionPerformed(evt);
            }
        });
        getContentPane().add(R02C06);
        R02C06.setBounds(280, 167, 44, 33);

        R02C07.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R02C07.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R02C07.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R02C07ActionPerformed(evt);
            }
        });
        getContentPane().add(R02C07);
        R02C07.setBounds(325, 167, 44, 33);

        R02C08.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R02C08.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R02C08.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R02C08ActionPerformed(evt);
            }
        });
        getContentPane().add(R02C08);
        R02C08.setBounds(370, 167, 44, 33);

        R02C09.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R02C09.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R02C09.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R02C09ActionPerformed(evt);
            }
        });
        getContentPane().add(R02C09);
        R02C09.setBounds(415, 167, 44, 33);

        R02C10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R02C10.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R02C10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R02C10ActionPerformed(evt);
            }
        });
        getContentPane().add(R02C10);
        R02C10.setBounds(460, 167, 44, 33);

        R02C11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R02C11.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R02C11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R02C11ActionPerformed(evt);
            }
        });
        getContentPane().add(R02C11);
        R02C11.setBounds(505, 167, 44, 33);

        R02C12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R02C12.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R02C12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R02C12ActionPerformed(evt);
            }
        });
        getContentPane().add(R02C12);
        R02C12.setBounds(550, 167, 44, 33);

        R02C13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R02C13.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R02C13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R02C13ActionPerformed(evt);
            }
        });
        getContentPane().add(R02C13);
        R02C13.setBounds(595, 167, 44, 33);

        R02C14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R02C14.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R02C14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R02C14ActionPerformed(evt);
            }
        });
        getContentPane().add(R02C14);
        R02C14.setBounds(640, 167, 44, 33);

        R03C00.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R03C00.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R03C00.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R03C00ActionPerformed(evt);
            }
        });
        getContentPane().add(R03C00);
        R03C00.setBounds(10, 201, 44, 33);

        R03C01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R03C01.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R03C01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R03C01ActionPerformed(evt);
            }
        });
        getContentPane().add(R03C01);
        R03C01.setBounds(55, 201, 44, 33);

        R03C02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R03C02.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R03C02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R03C02ActionPerformed(evt);
            }
        });
        getContentPane().add(R03C02);
        R03C02.setBounds(100, 201, 44, 33);

        R03C03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R03C03.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R03C03.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R03C03ActionPerformed(evt);
            }
        });
        getContentPane().add(R03C03);
        R03C03.setBounds(145, 201, 44, 33);

        R03C04.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R03C04.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R03C04.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R03C04ActionPerformed(evt);
            }
        });
        getContentPane().add(R03C04);
        R03C04.setBounds(190, 201, 44, 33);

        R03C05.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R03C05.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R03C05.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R03C05ActionPerformed(evt);
            }
        });
        getContentPane().add(R03C05);
        R03C05.setBounds(235, 201, 44, 33);

        R03C06.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R03C06.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R03C06.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R03C06ActionPerformed(evt);
            }
        });
        getContentPane().add(R03C06);
        R03C06.setBounds(280, 201, 44, 33);

        R03C07.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R03C07.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R03C07.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R03C07ActionPerformed(evt);
            }
        });
        getContentPane().add(R03C07);
        R03C07.setBounds(325, 201, 44, 33);

        R03C08.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R03C08.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R03C08.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R03C08ActionPerformed(evt);
            }
        });
        getContentPane().add(R03C08);
        R03C08.setBounds(370, 201, 44, 33);

        R03C09.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R03C09.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R03C09.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R03C09ActionPerformed(evt);
            }
        });
        getContentPane().add(R03C09);
        R03C09.setBounds(415, 201, 44, 33);

        R03C10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R03C10.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R03C10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R03C10ActionPerformed(evt);
            }
        });
        getContentPane().add(R03C10);
        R03C10.setBounds(460, 201, 44, 33);

        R03C11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R03C11.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R03C11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R03C11ActionPerformed(evt);
            }
        });
        getContentPane().add(R03C11);
        R03C11.setBounds(505, 201, 44, 33);

        R03C12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R03C12.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R03C12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R03C12ActionPerformed(evt);
            }
        });
        getContentPane().add(R03C12);
        R03C12.setBounds(550, 201, 44, 33);

        R03C13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R03C13.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R03C13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R03C13ActionPerformed(evt);
            }
        });
        getContentPane().add(R03C13);
        R03C13.setBounds(595, 201, 44, 33);

        R03C14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R03C14.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R03C14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R03C14ActionPerformed(evt);
            }
        });
        getContentPane().add(R03C14);
        R03C14.setBounds(640, 201, 44, 33);

        R04C00.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R04C00.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R04C00.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R04C00ActionPerformed(evt);
            }
        });
        getContentPane().add(R04C00);
        R04C00.setBounds(10, 235, 44, 33);

        R04C01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R04C01.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R04C01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R04C01ActionPerformed(evt);
            }
        });
        getContentPane().add(R04C01);
        R04C01.setBounds(55, 235, 44, 33);

        R04C02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R04C02.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R04C02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R04C02ActionPerformed(evt);
            }
        });
        getContentPane().add(R04C02);
        R04C02.setBounds(100, 235, 44, 33);

        R04C03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R04C03.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R04C03.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R04C03ActionPerformed(evt);
            }
        });
        getContentPane().add(R04C03);
        R04C03.setBounds(145, 235, 44, 33);

        R04C04.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R04C04.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R04C04.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R04C04ActionPerformed(evt);
            }
        });
        getContentPane().add(R04C04);
        R04C04.setBounds(190, 235, 44, 33);

        R04C05.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R04C05.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R04C05.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R04C05ActionPerformed(evt);
            }
        });
        getContentPane().add(R04C05);
        R04C05.setBounds(235, 235, 44, 33);

        R04C06.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R04C06.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R04C06.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R04C06ActionPerformed(evt);
            }
        });
        getContentPane().add(R04C06);
        R04C06.setBounds(280, 235, 44, 33);

        R04C07.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R04C07.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R04C07.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R04C07ActionPerformed(evt);
            }
        });
        getContentPane().add(R04C07);
        R04C07.setBounds(325, 235, 44, 33);

        R04C08.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R04C08.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R04C08.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R04C08ActionPerformed(evt);
            }
        });
        getContentPane().add(R04C08);
        R04C08.setBounds(370, 235, 44, 33);

        R04C09.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R04C09.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R04C09.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R04C09ActionPerformed(evt);
            }
        });
        getContentPane().add(R04C09);
        R04C09.setBounds(415, 235, 44, 33);

        R04C10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R04C10.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R04C10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R04C10ActionPerformed(evt);
            }
        });
        getContentPane().add(R04C10);
        R04C10.setBounds(460, 235, 44, 33);

        R04C11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R04C11.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R04C11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R04C11ActionPerformed(evt);
            }
        });
        getContentPane().add(R04C11);
        R04C11.setBounds(505, 235, 44, 33);

        R04C12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R04C12.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R04C12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R04C12ActionPerformed(evt);
            }
        });
        getContentPane().add(R04C12);
        R04C12.setBounds(550, 235, 44, 33);

        R04C13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R04C13.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R04C13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R04C13ActionPerformed(evt);
            }
        });
        getContentPane().add(R04C13);
        R04C13.setBounds(595, 235, 44, 33);

        R04C14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R04C14.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R04C14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R04C14ActionPerformed(evt);
            }
        });
        getContentPane().add(R04C14);
        R04C14.setBounds(640, 235, 44, 33);

        R05C00.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R05C00.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R05C00.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R05C00ActionPerformed(evt);
            }
        });
        getContentPane().add(R05C00);
        R05C00.setBounds(10, 269, 44, 33);

        R05C01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R05C01.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R05C01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R05C01ActionPerformed(evt);
            }
        });
        getContentPane().add(R05C01);
        R05C01.setBounds(55, 269, 44, 33);

        R05C02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R05C02.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R05C02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R05C02ActionPerformed(evt);
            }
        });
        getContentPane().add(R05C02);
        R05C02.setBounds(100, 269, 44, 33);

        R05C03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R05C03.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R05C03.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R05C03ActionPerformed(evt);
            }
        });
        getContentPane().add(R05C03);
        R05C03.setBounds(145, 269, 44, 33);

        R05C04.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R05C04.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R05C04.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R05C04ActionPerformed(evt);
            }
        });
        getContentPane().add(R05C04);
        R05C04.setBounds(190, 269, 44, 33);

        R05C05.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R05C05.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R05C05.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R05C05ActionPerformed(evt);
            }
        });
        getContentPane().add(R05C05);
        R05C05.setBounds(235, 269, 44, 33);

        R05C06.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R05C06.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R05C06.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R05C06ActionPerformed(evt);
            }
        });
        getContentPane().add(R05C06);
        R05C06.setBounds(280, 269, 44, 33);

        R05C07.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R05C07.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R05C07.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R05C07ActionPerformed(evt);
            }
        });
        getContentPane().add(R05C07);
        R05C07.setBounds(325, 269, 44, 33);

        R05C08.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R05C08.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R05C08.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R05C08ActionPerformed(evt);
            }
        });
        getContentPane().add(R05C08);
        R05C08.setBounds(370, 269, 44, 33);

        R05C09.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R05C09.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R05C09.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R05C09ActionPerformed(evt);
            }
        });
        getContentPane().add(R05C09);
        R05C09.setBounds(415, 269, 44, 33);

        R05C10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R05C10.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R05C10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R05C10ActionPerformed(evt);
            }
        });
        getContentPane().add(R05C10);
        R05C10.setBounds(460, 269, 44, 33);

        R05C11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R05C11.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R05C11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R05C11ActionPerformed(evt);
            }
        });
        getContentPane().add(R05C11);
        R05C11.setBounds(505, 269, 44, 33);

        R05C12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R05C12.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R05C12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R05C12ActionPerformed(evt);
            }
        });
        getContentPane().add(R05C12);
        R05C12.setBounds(550, 269, 44, 33);

        R05C13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R05C13.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R05C13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R05C13ActionPerformed(evt);
            }
        });
        getContentPane().add(R05C13);
        R05C13.setBounds(595, 269, 44, 33);

        R05C14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R05C14.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R05C14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R05C14ActionPerformed(evt);
            }
        });
        getContentPane().add(R05C14);
        R05C14.setBounds(640, 269, 44, 33);

        R06C00.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R06C00.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R06C00.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R06C00ActionPerformed(evt);
            }
        });
        getContentPane().add(R06C00);
        R06C00.setBounds(10, 303, 44, 33);

        R06C01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R06C01.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R06C01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R06C01ActionPerformed(evt);
            }
        });
        getContentPane().add(R06C01);
        R06C01.setBounds(55, 303, 44, 33);

        R06C02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R06C02.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R06C02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R06C02ActionPerformed(evt);
            }
        });
        getContentPane().add(R06C02);
        R06C02.setBounds(100, 303, 44, 33);

        R06C03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R06C03.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R06C03.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R06C03ActionPerformed(evt);
            }
        });
        getContentPane().add(R06C03);
        R06C03.setBounds(145, 303, 44, 33);

        R06C04.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R06C04.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R06C04.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R06C04ActionPerformed(evt);
            }
        });
        getContentPane().add(R06C04);
        R06C04.setBounds(190, 303, 44, 33);

        R06C05.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R06C05.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R06C05.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R06C05ActionPerformed(evt);
            }
        });
        getContentPane().add(R06C05);
        R06C05.setBounds(235, 303, 44, 33);

        R06C06.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R06C06.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R06C06.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R06C06ActionPerformed(evt);
            }
        });
        getContentPane().add(R06C06);
        R06C06.setBounds(280, 303, 44, 33);

        R06C07.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R06C07.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R06C07.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R06C07ActionPerformed(evt);
            }
        });
        getContentPane().add(R06C07);
        R06C07.setBounds(325, 303, 44, 33);

        R06C08.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R06C08.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R06C08.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R06C08ActionPerformed(evt);
            }
        });
        getContentPane().add(R06C08);
        R06C08.setBounds(370, 303, 44, 33);

        R06C09.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R06C09.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R06C09.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R06C09ActionPerformed(evt);
            }
        });
        getContentPane().add(R06C09);
        R06C09.setBounds(415, 303, 44, 33);

        R06C10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R06C10.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R06C10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R06C10ActionPerformed(evt);
            }
        });
        getContentPane().add(R06C10);
        R06C10.setBounds(460, 303, 44, 33);

        R06C11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R06C11.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R06C11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R06C11ActionPerformed(evt);
            }
        });
        getContentPane().add(R06C11);
        R06C11.setBounds(505, 303, 44, 33);

        R06C12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R06C12.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R06C12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R06C12ActionPerformed(evt);
            }
        });
        getContentPane().add(R06C12);
        R06C12.setBounds(550, 303, 44, 33);

        R06C13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R06C13.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R06C13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R06C13ActionPerformed(evt);
            }
        });
        getContentPane().add(R06C13);
        R06C13.setBounds(595, 303, 44, 33);

        R06C14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R06C14.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R06C14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R06C14ActionPerformed(evt);
            }
        });
        getContentPane().add(R06C14);
        R06C14.setBounds(640, 303, 44, 33);

        R07C00.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R07C00.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R07C00.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R07C00ActionPerformed(evt);
            }
        });
        getContentPane().add(R07C00);
        R07C00.setBounds(10, 337, 44, 33);

        R07C01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R07C01.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R07C01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R07C01ActionPerformed(evt);
            }
        });
        getContentPane().add(R07C01);
        R07C01.setBounds(55, 337, 44, 33);

        R07C02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R07C02.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R07C02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R07C02ActionPerformed(evt);
            }
        });
        getContentPane().add(R07C02);
        R07C02.setBounds(100, 337, 44, 33);

        R07C03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R07C03.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R07C03.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R07C03ActionPerformed(evt);
            }
        });
        getContentPane().add(R07C03);
        R07C03.setBounds(145, 337, 44, 33);

        R07C04.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R07C04.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R07C04.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R07C04ActionPerformed(evt);
            }
        });
        getContentPane().add(R07C04);
        R07C04.setBounds(190, 337, 44, 33);

        R07C05.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R07C05.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R07C05.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R07C05ActionPerformed(evt);
            }
        });
        getContentPane().add(R07C05);
        R07C05.setBounds(235, 337, 44, 33);

        R07C06.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R07C06.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R07C06.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R07C06ActionPerformed(evt);
            }
        });
        getContentPane().add(R07C06);
        R07C06.setBounds(280, 337, 44, 33);

        R07C07.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R07C07.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R07C07.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R07C07ActionPerformed(evt);
            }
        });
        getContentPane().add(R07C07);
        R07C07.setBounds(325, 337, 44, 33);

        R07C08.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R07C08.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R07C08.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R07C08ActionPerformed(evt);
            }
        });
        getContentPane().add(R07C08);
        R07C08.setBounds(370, 337, 44, 33);

        R07C09.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R07C09.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R07C09.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R07C09ActionPerformed(evt);
            }
        });
        getContentPane().add(R07C09);
        R07C09.setBounds(415, 337, 44, 33);

        R07C10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R07C10.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R07C10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R07C10ActionPerformed(evt);
            }
        });
        getContentPane().add(R07C10);
        R07C10.setBounds(460, 337, 44, 33);

        R07C11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R07C11.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R07C11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R07C11ActionPerformed(evt);
            }
        });
        getContentPane().add(R07C11);
        R07C11.setBounds(505, 337, 44, 33);

        R07C12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R07C12.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R07C12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R07C12ActionPerformed(evt);
            }
        });
        getContentPane().add(R07C12);
        R07C12.setBounds(550, 337, 44, 33);

        R07C13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R07C13.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R07C13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R07C13ActionPerformed(evt);
            }
        });
        getContentPane().add(R07C13);
        R07C13.setBounds(595, 337, 44, 33);

        R07C14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R07C14.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R07C14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R07C14ActionPerformed(evt);
            }
        });
        getContentPane().add(R07C14);
        R07C14.setBounds(640, 337, 44, 33);

        R08C00.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R08C00.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R08C00.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R08C00ActionPerformed(evt);
            }
        });
        getContentPane().add(R08C00);
        R08C00.setBounds(10, 371, 44, 33);

        R08C01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R08C01.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R08C01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R08C01ActionPerformed(evt);
            }
        });
        getContentPane().add(R08C01);
        R08C01.setBounds(55, 371, 44, 33);

        R08C02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R08C02.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R08C02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R08C02ActionPerformed(evt);
            }
        });
        getContentPane().add(R08C02);
        R08C02.setBounds(100, 371, 44, 33);

        R08C03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R08C03.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R08C03.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R08C03ActionPerformed(evt);
            }
        });
        getContentPane().add(R08C03);
        R08C03.setBounds(145, 371, 44, 33);

        R08C04.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R08C04.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R08C04.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R08C04ActionPerformed(evt);
            }
        });
        getContentPane().add(R08C04);
        R08C04.setBounds(190, 371, 44, 33);

        R08C05.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R08C05.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R08C05.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R08C05ActionPerformed(evt);
            }
        });
        getContentPane().add(R08C05);
        R08C05.setBounds(235, 371, 44, 33);

        R08C06.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R08C06.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R08C06.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R08C06ActionPerformed(evt);
            }
        });
        getContentPane().add(R08C06);
        R08C06.setBounds(280, 371, 44, 33);

        R08C07.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R08C07.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R08C07.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R08C07ActionPerformed(evt);
            }
        });
        getContentPane().add(R08C07);
        R08C07.setBounds(325, 371, 44, 33);

        R08C08.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R08C08.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R08C08.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R08C08ActionPerformed(evt);
            }
        });
        getContentPane().add(R08C08);
        R08C08.setBounds(370, 371, 44, 33);

        R08C09.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R08C09.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R08C09.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R08C09ActionPerformed(evt);
            }
        });
        getContentPane().add(R08C09);
        R08C09.setBounds(415, 371, 44, 33);

        R08C10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R08C10.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R08C10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R08C10ActionPerformed(evt);
            }
        });
        getContentPane().add(R08C10);
        R08C10.setBounds(460, 371, 44, 33);

        R08C11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R08C11.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R08C11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R08C11ActionPerformed(evt);
            }
        });
        getContentPane().add(R08C11);
        R08C11.setBounds(505, 371, 44, 33);

        R08C12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R08C12.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R08C12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R08C12ActionPerformed(evt);
            }
        });
        getContentPane().add(R08C12);
        R08C12.setBounds(550, 371, 44, 33);

        R08C13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R08C13.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R08C13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R08C13ActionPerformed(evt);
            }
        });
        getContentPane().add(R08C13);
        R08C13.setBounds(595, 371, 44, 33);

        R08C14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R08C14.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R08C14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R08C14ActionPerformed(evt);
            }
        });
        getContentPane().add(R08C14);
        R08C14.setBounds(640, 371, 44, 33);

        R09C00.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R09C00.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R09C00.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R09C00ActionPerformed(evt);
            }
        });
        getContentPane().add(R09C00);
        R09C00.setBounds(10, 405, 44, 33);

        R09C01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R09C01.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R09C01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R09C01ActionPerformed(evt);
            }
        });
        getContentPane().add(R09C01);
        R09C01.setBounds(55, 405, 44, 33);

        R09C02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R09C02.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R09C02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R09C02ActionPerformed(evt);
            }
        });
        getContentPane().add(R09C02);
        R09C02.setBounds(100, 405, 44, 33);

        R09C03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R09C03.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R09C03.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R09C03ActionPerformed(evt);
            }
        });
        getContentPane().add(R09C03);
        R09C03.setBounds(145, 405, 44, 33);

        R09C04.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R09C04.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R09C04.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R09C04ActionPerformed(evt);
            }
        });
        getContentPane().add(R09C04);
        R09C04.setBounds(190, 405, 44, 33);

        R09C05.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R09C05.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R09C05.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R09C05ActionPerformed(evt);
            }
        });
        getContentPane().add(R09C05);
        R09C05.setBounds(235, 405, 44, 33);

        R09C06.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R09C06.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R09C06.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R09C06ActionPerformed(evt);
            }
        });
        getContentPane().add(R09C06);
        R09C06.setBounds(280, 405, 44, 33);

        R09C07.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R09C07.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R09C07.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R09C07ActionPerformed(evt);
            }
        });
        getContentPane().add(R09C07);
        R09C07.setBounds(325, 405, 44, 33);

        R09C08.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R09C08.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R09C08.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R09C08ActionPerformed(evt);
            }
        });
        getContentPane().add(R09C08);
        R09C08.setBounds(370, 405, 44, 33);

        R09C09.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R09C09.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R09C09.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R09C09ActionPerformed(evt);
            }
        });
        getContentPane().add(R09C09);
        R09C09.setBounds(415, 405, 44, 33);

        R09C10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R09C10.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R09C10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R09C10ActionPerformed(evt);
            }
        });
        getContentPane().add(R09C10);
        R09C10.setBounds(460, 405, 44, 33);

        R09C11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R09C11.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R09C11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R09C11ActionPerformed(evt);
            }
        });
        getContentPane().add(R09C11);
        R09C11.setBounds(505, 405, 44, 33);

        R09C12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R09C12.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R09C12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R09C12ActionPerformed(evt);
            }
        });
        getContentPane().add(R09C12);
        R09C12.setBounds(550, 405, 44, 33);

        R09C13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R09C13.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R09C13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R09C13ActionPerformed(evt);
            }
        });
        getContentPane().add(R09C13);
        R09C13.setBounds(595, 405, 44, 33);

        R09C14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R09C14.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R09C14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R09C14ActionPerformed(evt);
            }
        });
        getContentPane().add(R09C14);
        R09C14.setBounds(640, 405, 44, 33);

        R10C00.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R10C00.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R10C00.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R10C00ActionPerformed(evt);
            }
        });
        getContentPane().add(R10C00);
        R10C00.setBounds(10, 439, 44, 33);

        R10C01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R10C01.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R10C01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R10C01ActionPerformed(evt);
            }
        });
        getContentPane().add(R10C01);
        R10C01.setBounds(55, 439, 44, 33);

        R10C02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R10C02.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R10C02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R10C02ActionPerformed(evt);
            }
        });
        getContentPane().add(R10C02);
        R10C02.setBounds(100, 439, 44, 33);

        R10C03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R10C03.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R10C03.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R10C03ActionPerformed(evt);
            }
        });
        getContentPane().add(R10C03);
        R10C03.setBounds(145, 439, 44, 33);

        R10C04.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R10C04.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R10C04.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R10C04ActionPerformed(evt);
            }
        });
        getContentPane().add(R10C04);
        R10C04.setBounds(190, 439, 44, 33);

        R10C05.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R10C05.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R10C05.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R10C05ActionPerformed(evt);
            }
        });
        getContentPane().add(R10C05);
        R10C05.setBounds(235, 439, 44, 33);

        R10C06.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R10C06.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R10C06.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R10C06ActionPerformed(evt);
            }
        });
        getContentPane().add(R10C06);
        R10C06.setBounds(280, 439, 44, 33);

        R10C07.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R10C07.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R10C07.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R10C07ActionPerformed(evt);
            }
        });
        getContentPane().add(R10C07);
        R10C07.setBounds(325, 439, 44, 33);

        R10C08.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R10C08.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R10C08.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R10C08ActionPerformed(evt);
            }
        });
        getContentPane().add(R10C08);
        R10C08.setBounds(370, 439, 44, 33);

        R10C09.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R10C09.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R10C09.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R10C09ActionPerformed(evt);
            }
        });
        getContentPane().add(R10C09);
        R10C09.setBounds(415, 439, 44, 33);

        R10C10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R10C10.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R10C10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R10C10ActionPerformed(evt);
            }
        });
        getContentPane().add(R10C10);
        R10C10.setBounds(460, 439, 44, 33);

        R10C11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R10C11.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R10C11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R10C11ActionPerformed(evt);
            }
        });
        getContentPane().add(R10C11);
        R10C11.setBounds(505, 439, 44, 33);

        R10C12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R10C12.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R10C12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R10C12ActionPerformed(evt);
            }
        });
        getContentPane().add(R10C12);
        R10C12.setBounds(550, 439, 44, 33);

        R10C13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R10C13.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R10C13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R10C13ActionPerformed(evt);
            }
        });
        getContentPane().add(R10C13);
        R10C13.setBounds(595, 439, 44, 33);

        R10C14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R10C14.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R10C14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R10C14ActionPerformed(evt);
            }
        });
        getContentPane().add(R10C14);
        R10C14.setBounds(640, 439, 44, 33);

        R11C00.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R11C00.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R11C00.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R11C00ActionPerformed(evt);
            }
        });
        getContentPane().add(R11C00);
        R11C00.setBounds(10, 473, 44, 33);

        R11C01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R11C01.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R11C01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R11C01ActionPerformed(evt);
            }
        });
        getContentPane().add(R11C01);
        R11C01.setBounds(55, 473, 44, 33);

        R11C02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R11C02.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R11C02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R11C02ActionPerformed(evt);
            }
        });
        getContentPane().add(R11C02);
        R11C02.setBounds(100, 473, 44, 33);

        R11C03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R11C03.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R11C03.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R11C03ActionPerformed(evt);
            }
        });
        getContentPane().add(R11C03);
        R11C03.setBounds(145, 473, 44, 33);

        R11C04.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R11C04.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R11C04.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R11C04ActionPerformed(evt);
            }
        });
        getContentPane().add(R11C04);
        R11C04.setBounds(190, 473, 44, 33);

        R11C05.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R11C05.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R11C05.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R11C05ActionPerformed(evt);
            }
        });
        getContentPane().add(R11C05);
        R11C05.setBounds(235, 473, 44, 33);

        R11C06.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R11C06.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R11C06.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R11C06ActionPerformed(evt);
            }
        });
        getContentPane().add(R11C06);
        R11C06.setBounds(280, 473, 44, 33);

        R11C07.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R11C07.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R11C07.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R11C07ActionPerformed(evt);
            }
        });
        getContentPane().add(R11C07);
        R11C07.setBounds(325, 473, 44, 33);

        R11C08.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R11C08.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R11C08.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R11C08ActionPerformed(evt);
            }
        });
        getContentPane().add(R11C08);
        R11C08.setBounds(370, 473, 44, 33);

        R11C09.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R11C09.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R11C09.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R11C09ActionPerformed(evt);
            }
        });
        getContentPane().add(R11C09);
        R11C09.setBounds(415, 473, 44, 33);

        R11C10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R11C10.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R11C10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R11C10ActionPerformed(evt);
            }
        });
        getContentPane().add(R11C10);
        R11C10.setBounds(460, 473, 44, 33);

        R11C11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R11C11.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R11C11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R11C11ActionPerformed(evt);
            }
        });
        getContentPane().add(R11C11);
        R11C11.setBounds(505, 473, 44, 33);

        R11C12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R11C12.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R11C12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R11C12ActionPerformed(evt);
            }
        });
        getContentPane().add(R11C12);
        R11C12.setBounds(550, 473, 44, 33);

        R11C13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R11C13.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R11C13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R11C13ActionPerformed(evt);
            }
        });
        getContentPane().add(R11C13);
        R11C13.setBounds(595, 473, 44, 33);

        R11C14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R11C14.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R11C14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R11C14ActionPerformed(evt);
            }
        });
        getContentPane().add(R11C14);
        R11C14.setBounds(640, 473, 44, 33);

        R12C00.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R12C00.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R12C00.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R12C00ActionPerformed(evt);
            }
        });
        getContentPane().add(R12C00);
        R12C00.setBounds(10, 507, 44, 33);

        R12C01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R12C01.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R12C01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R12C01ActionPerformed(evt);
            }
        });
        getContentPane().add(R12C01);
        R12C01.setBounds(55, 507, 44, 33);

        R12C02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R12C02.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R12C02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R12C02ActionPerformed(evt);
            }
        });
        getContentPane().add(R12C02);
        R12C02.setBounds(100, 507, 44, 33);

        R12C03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R12C03.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R12C03.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R12C03ActionPerformed(evt);
            }
        });
        getContentPane().add(R12C03);
        R12C03.setBounds(145, 507, 44, 33);

        R12C04.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R12C04.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R12C04.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R12C04ActionPerformed(evt);
            }
        });
        getContentPane().add(R12C04);
        R12C04.setBounds(190, 507, 44, 33);

        R12C05.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R12C05.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R12C05.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R12C05ActionPerformed(evt);
            }
        });
        getContentPane().add(R12C05);
        R12C05.setBounds(235, 507, 44, 33);

        R12C06.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R12C06.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R12C06.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R12C06ActionPerformed(evt);
            }
        });
        getContentPane().add(R12C06);
        R12C06.setBounds(280, 507, 44, 33);

        R12C07.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R12C07.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R12C07.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R12C07ActionPerformed(evt);
            }
        });
        getContentPane().add(R12C07);
        R12C07.setBounds(325, 507, 44, 33);

        R12C08.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R12C08.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R12C08.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R12C08ActionPerformed(evt);
            }
        });
        getContentPane().add(R12C08);
        R12C08.setBounds(370, 507, 44, 33);

        R12C09.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R12C09.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R12C09.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R12C09ActionPerformed(evt);
            }
        });
        getContentPane().add(R12C09);
        R12C09.setBounds(415, 507, 44, 33);

        R12C10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R12C10.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R12C10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R12C10ActionPerformed(evt);
            }
        });
        getContentPane().add(R12C10);
        R12C10.setBounds(460, 507, 44, 33);

        R12C11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R12C11.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R12C11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R12C11ActionPerformed(evt);
            }
        });
        getContentPane().add(R12C11);
        R12C11.setBounds(505, 507, 44, 33);

        R12C12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R12C12.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R12C12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R12C12ActionPerformed(evt);
            }
        });
        getContentPane().add(R12C12);
        R12C12.setBounds(550, 507, 44, 33);

        R12C13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R12C13.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R12C13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R12C13ActionPerformed(evt);
            }
        });
        getContentPane().add(R12C13);
        R12C13.setBounds(595, 507, 44, 33);

        R12C14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R12C14.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R12C14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R12C14ActionPerformed(evt);
            }
        });
        getContentPane().add(R12C14);
        R12C14.setBounds(640, 507, 44, 33);

        R13C00.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R13C00.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R13C00.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R13C00ActionPerformed(evt);
            }
        });
        getContentPane().add(R13C00);
        R13C00.setBounds(10, 541, 44, 33);

        R13C01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R13C01.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R13C01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R13C01ActionPerformed(evt);
            }
        });
        getContentPane().add(R13C01);
        R13C01.setBounds(55, 541, 44, 33);

        R13C02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R13C02.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R13C02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R13C02ActionPerformed(evt);
            }
        });
        getContentPane().add(R13C02);
        R13C02.setBounds(100, 541, 44, 33);

        R13C03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R13C03.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R13C03.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R13C03ActionPerformed(evt);
            }
        });
        getContentPane().add(R13C03);
        R13C03.setBounds(145, 541, 44, 33);

        R13C04.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R13C04.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R13C04.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R13C04ActionPerformed(evt);
            }
        });
        getContentPane().add(R13C04);
        R13C04.setBounds(190, 541, 44, 33);

        R13C05.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R13C05.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R13C05.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R13C05ActionPerformed(evt);
            }
        });
        getContentPane().add(R13C05);
        R13C05.setBounds(235, 541, 44, 33);

        R13C06.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R13C06.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R13C06.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R13C06ActionPerformed(evt);
            }
        });
        getContentPane().add(R13C06);
        R13C06.setBounds(280, 541, 44, 33);

        R13C07.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R13C07.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R13C07.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R13C07ActionPerformed(evt);
            }
        });
        getContentPane().add(R13C07);
        R13C07.setBounds(325, 541, 44, 33);

        R13C08.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R13C08.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R13C08.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R13C08ActionPerformed(evt);
            }
        });
        getContentPane().add(R13C08);
        R13C08.setBounds(370, 541, 44, 33);

        R13C09.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R13C09.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R13C09.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R13C09ActionPerformed(evt);
            }
        });
        getContentPane().add(R13C09);
        R13C09.setBounds(415, 541, 44, 33);

        R13C10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R13C10.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R13C10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R13C10ActionPerformed(evt);
            }
        });
        getContentPane().add(R13C10);
        R13C10.setBounds(460, 541, 44, 33);

        R13C11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R13C11.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R13C11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R13C11ActionPerformed(evt);
            }
        });
        getContentPane().add(R13C11);
        R13C11.setBounds(505, 541, 44, 33);

        R13C12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R13C12.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R13C12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R13C12ActionPerformed(evt);
            }
        });
        getContentPane().add(R13C12);
        R13C12.setBounds(550, 541, 44, 33);

        R13C13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R13C13.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R13C13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R13C13ActionPerformed(evt);
            }
        });
        getContentPane().add(R13C13);
        R13C13.setBounds(595, 541, 44, 33);

        R13C14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R13C14.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R13C14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R13C14ActionPerformed(evt);
            }
        });
        getContentPane().add(R13C14);
        R13C14.setBounds(640, 541, 44, 33);

        R14C00.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R14C00.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R14C00.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R14C00ActionPerformed(evt);
            }
        });
        getContentPane().add(R14C00);
        R14C00.setBounds(10, 575, 44, 33);

        R14C01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R14C01.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R14C01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R14C01ActionPerformed(evt);
            }
        });
        getContentPane().add(R14C01);
        R14C01.setBounds(55, 575, 44, 33);

        R14C02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R14C02.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R14C02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R14C02ActionPerformed(evt);
            }
        });
        getContentPane().add(R14C02);
        R14C02.setBounds(100, 575, 44, 33);

        R14C03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R14C03.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R14C03.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R14C03ActionPerformed(evt);
            }
        });
        getContentPane().add(R14C03);
        R14C03.setBounds(145, 575, 44, 33);

        R14C04.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R14C04.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R14C04.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R14C04ActionPerformed(evt);
            }
        });
        getContentPane().add(R14C04);
        R14C04.setBounds(190, 575, 44, 33);

        R14C05.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R14C05.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R14C05.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R14C05ActionPerformed(evt);
            }
        });
        getContentPane().add(R14C05);
        R14C05.setBounds(235, 575, 44, 33);

        R14C06.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R14C06.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R14C06.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R14C06ActionPerformed(evt);
            }
        });
        getContentPane().add(R14C06);
        R14C06.setBounds(280, 575, 44, 33);

        R14C07.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R14C07.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R14C07.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R14C07ActionPerformed(evt);
            }
        });
        getContentPane().add(R14C07);
        R14C07.setBounds(325, 575, 44, 33);

        R14C08.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R14C08.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R14C08.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R14C08ActionPerformed(evt);
            }
        });
        getContentPane().add(R14C08);
        R14C08.setBounds(370, 575, 44, 33);

        R14C09.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R14C09.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R14C09.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R14C09ActionPerformed(evt);
            }
        });
        getContentPane().add(R14C09);
        R14C09.setBounds(415, 575, 44, 33);

        R14C10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R14C10.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R14C10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R14C10ActionPerformed(evt);
            }
        });
        getContentPane().add(R14C10);
        R14C10.setBounds(460, 575, 44, 33);

        R14C11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R14C11.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R14C11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R14C11ActionPerformed(evt);
            }
        });
        getContentPane().add(R14C11);
        R14C11.setBounds(505, 575, 44, 33);

        R14C12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R14C12.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R14C12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R14C12ActionPerformed(evt);
            }
        });
        getContentPane().add(R14C12);
        R14C12.setBounds(550, 575, 44, 33);

        R14C13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R14C13.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R14C13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R14C13ActionPerformed(evt);
            }
        });
        getContentPane().add(R14C13);
        R14C13.setBounds(595, 575, 44, 33);

        R14C14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        R14C14.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        R14C14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R14C14ActionPerformed(evt);
            }
        });
        getContentPane().add(R14C14);
        R14C14.setBounds(640, 575, 44, 33);

        WhiteCell.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/WhiteCell.png"))); // NOI18N
        getContentPane().add(WhiteCell);
        WhiteCell.setBounds(564, 31, 0, 0);

        BlackCell.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BlackCell.png"))); // NOI18N
        getContentPane().add(BlackCell);
        BlackCell.setBounds(564, 93, 0, 0);

        BasicCell.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cell.png"))); // NOI18N
        BasicCell.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glow_cell.png"))); // NOI18N
        getContentPane().add(BasicCell);
        BasicCell.setBounds(564, 62, 0, 0);

        ResetButton.setText("Reset");
        ResetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetButtonActionPerformed(evt);
            }
        });
        getContentPane().add(ResetButton);
        ResetButton.setBounds(610, 610, 73, 23);

        Go_Back.setText("Exit");
        Go_Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Go_BackActionPerformed(evt);
            }
        });
        getContentPane().add(Go_Back);
        Go_Back.setBounds(20, 610, 73, 23);

        LevelSelect.setText("Level");
        LevelSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LevelSelectActionPerformed(evt);
            }
        });
        getContentPane().add(LevelSelect);
        LevelSelect.setBounds(530, 610, 73, 23);

        WinBlackCell.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/WinBlackCell.png"))); // NOI18N
        getContentPane().add(WinBlackCell);
        WinBlackCell.setBounds(564, 93, 0, 0);

        WinWhiteCell.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/WinWhiteCell.png"))); // NOI18N
        getContentPane().add(WinWhiteCell);
        WinWhiteCell.setBounds(564, 93, 0, 0);

        LSelect.setText("Level Select");
        getContentPane().add(LSelect);
        LSelect.setBounds(460, 610, 70, 20);

        Turns.setText("Player 1 Turn");
        getContentPane().add(Turns);
        Turns.setBounds(310, 610, 120, 20);

        BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Main.png"))); // NOI18N
        getContentPane().add(BG);
        BG.setBounds(0, 0, 700, 650);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void R00C0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R00C0ActionPerformed
        if (R00C0.isFocusable())
        {
        RecentMove= new int []{0,0};
		
        if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
                System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();} 
        
        UpdateButtons();
        }
    }//GEN-LAST:event_R00C0ActionPerformed

    private void R00C1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R00C1ActionPerformed
        if (R00C1.isFocusable())
        {
        RecentMove= new int []{0,1};
        if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
                System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}
        UpdateButtons();
        }
    }//GEN-LAST:event_R00C1ActionPerformed

    private void R00C2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R00C2ActionPerformed
        if (R00C2.isFocusable())
        {
        RecentMove= new int []{0,2};
        if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
                System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}
        UpdateButtons();
        }
    }//GEN-LAST:event_R00C2ActionPerformed

    private void R00C3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R00C3ActionPerformed
        if (R00C3.isFocusable())
        {
        RecentMove= new int []{0,3};
        if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
                System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}
        UpdateButtons();
        }
    }//GEN-LAST:event_R00C3ActionPerformed

    private void R00C4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R00C4ActionPerformed
        if (R00C4.isFocusable())
        {
        RecentMove= new int []{0,4};
        if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
                System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}
        UpdateButtons();
        }
    }//GEN-LAST:event_R00C4ActionPerformed

    private void R00C5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R00C5ActionPerformed
        if (R00C5.isFocusable())
        {
        RecentMove= new int []{0,5};
        if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
                System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}
        UpdateButtons();
        }
    }//GEN-LAST:event_R00C5ActionPerformed

    private void R00C6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R00C6ActionPerformed
        if (R00C6.isFocusable())
        {
        RecentMove= new int []{0,6};
        if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
                System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}
        UpdateButtons();
        }
    }//GEN-LAST:event_R00C6ActionPerformed

    private void R00C7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R00C7ActionPerformed
       if (R00C7.isFocusable())
        {
        RecentMove= new int []{0,7};
        if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
                System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}
        UpdateButtons();
        }
    }//GEN-LAST:event_R00C7ActionPerformed

    private void R00C8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R00C8ActionPerformed
        if (R00C8.isFocusable())
        {
        RecentMove= new int []{0,8};
        if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
                System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}
        UpdateButtons();
        }
    }//GEN-LAST:event_R00C8ActionPerformed

    private void R00C9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R00C9ActionPerformed
if (R00C9.isFocusable())
        {
        RecentMove= new int []{0,9};
        if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
                System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}
        UpdateButtons();
        }
    }//GEN-LAST:event_R00C9ActionPerformed

    private void R00C10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R00C10ActionPerformed
        if (R00C10.isFocusable())
        {
        RecentMove= new int []{0,10};
        if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
                System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}
        UpdateButtons();
        }
    }//GEN-LAST:event_R00C10ActionPerformed

    private void R00C11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R00C11ActionPerformed
         if (R00C11.isFocusable())
        {
        RecentMove= new int []{0,11};
        if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
                System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}
        UpdateButtons();
        }
    }//GEN-LAST:event_R00C11ActionPerformed

    private void R00C12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R00C12ActionPerformed
           if (R00C12.isFocusable())
        {
        RecentMove= new int []{0,12};
        if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
                System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}
        UpdateButtons();
        }
    }//GEN-LAST:event_R00C12ActionPerformed

    private void R00C13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R00C13ActionPerformed
           if (R00C13.isFocusable())
        {
        RecentMove= new int []{0,13};
        if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
                System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}
        UpdateButtons();
        }
    }//GEN-LAST:event_R00C13ActionPerformed

    private void R00C14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R00C14ActionPerformed
           if (R00C14.isFocusable())
        {
        RecentMove= new int []{0,14};
        if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
                System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}
        UpdateButtons();
        }
    }//GEN-LAST:event_R00C14ActionPerformed

private void R01C00ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R01C00ActionPerformed
if (R01C00.isFocusable())
{{
RecentMove= new int []{1,0};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R01C00ActionPerformed


private void R01C01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R01C01ActionPerformed
if (R01C01.isFocusable())
{{
RecentMove= new int []{1,1};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R01C01ActionPerformed


private void R01C02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R01C02ActionPerformed
if (R01C02.isFocusable())
{{
RecentMove= new int []{1,2};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R01C02ActionPerformed


private void R01C03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R01C03ActionPerformed
if (R01C03.isFocusable())
{{
RecentMove= new int []{1,3};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R01C03ActionPerformed


private void R01C04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R01C04ActionPerformed
if (R01C04.isFocusable())
{{
RecentMove= new int []{1,4};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R01C04ActionPerformed


private void R01C05ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R01C05ActionPerformed
if (R01C05.isFocusable())
{{
RecentMove= new int []{1,5};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R01C05ActionPerformed


private void R01C06ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R01C06ActionPerformed
if (R01C06.isFocusable())
{{
RecentMove= new int []{1,6};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R01C06ActionPerformed


private void R01C07ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R01C07ActionPerformed
if (R01C07.isFocusable())
{{
RecentMove= new int []{1,7};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R01C07ActionPerformed


private void R01C08ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R01C08ActionPerformed
if (R01C08.isFocusable())
{{
RecentMove= new int []{1,8};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R01C08ActionPerformed


private void R01C09ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R01C09ActionPerformed
if (R01C09.isFocusable())
{{
RecentMove= new int []{1,9};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R01C09ActionPerformed


private void R01C10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R01C10ActionPerformed
if (R01C10.isFocusable())
{{
RecentMove= new int []{1,10};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R01C10ActionPerformed


private void R01C11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R01C11ActionPerformed
if (R01C11.isFocusable())
{{
RecentMove= new int []{1,11};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R01C11ActionPerformed


private void R01C12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R01C12ActionPerformed
if (R01C12.isFocusable())
{{
RecentMove= new int []{1,12};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R01C12ActionPerformed


private void R01C13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R01C13ActionPerformed
if (R01C13.isFocusable())
{{
RecentMove= new int []{1,13};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R01C13ActionPerformed


private void R01C14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R01C14ActionPerformed
if (R01C14.isFocusable())
{{
RecentMove= new int []{1,14};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R01C14ActionPerformed


private void R02C00ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R02C00ActionPerformed
if (R02C00.isFocusable())
{{
RecentMove= new int []{2,0};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R02C00ActionPerformed


private void R02C01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R02C01ActionPerformed
if (R02C01.isFocusable())
{{
RecentMove= new int []{2,1};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R02C01ActionPerformed


private void R02C02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R02C02ActionPerformed
if (R02C02.isFocusable())
{{
RecentMove= new int []{2,2};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R02C02ActionPerformed


private void R02C03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R02C03ActionPerformed
if (R02C03.isFocusable())
{{
RecentMove= new int []{2,3};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R02C03ActionPerformed


private void R02C04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R02C04ActionPerformed
if (R02C04.isFocusable())
{{
RecentMove= new int []{2,4};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R02C04ActionPerformed


private void R02C05ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R02C05ActionPerformed
if (R02C05.isFocusable())
{{
RecentMove= new int []{2,5};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R02C05ActionPerformed


private void R02C06ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R02C06ActionPerformed
if (R02C06.isFocusable())
{{
RecentMove= new int []{2,6};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R02C06ActionPerformed


private void R02C07ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R02C07ActionPerformed
if (R02C07.isFocusable())
{{
RecentMove= new int []{2,7};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R02C07ActionPerformed


private void R02C08ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R02C08ActionPerformed
if (R02C08.isFocusable())
{{
RecentMove= new int []{2,8};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R02C08ActionPerformed


private void R02C09ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R02C09ActionPerformed
if (R02C09.isFocusable())
{{
RecentMove= new int []{2,9};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R02C09ActionPerformed


private void R02C10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R02C10ActionPerformed
if (R02C10.isFocusable())
{{
RecentMove= new int []{2,10};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R02C10ActionPerformed


private void R02C11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R02C11ActionPerformed
if (R02C11.isFocusable())
{{
RecentMove= new int []{2,11};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R02C11ActionPerformed


private void R02C12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R02C12ActionPerformed
if (R02C12.isFocusable())
{{
RecentMove= new int []{2,12};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R02C12ActionPerformed


private void R02C13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R02C13ActionPerformed
if (R02C13.isFocusable())
{{
RecentMove= new int []{2,13};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R02C13ActionPerformed


private void R02C14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R02C14ActionPerformed
if (R02C14.isFocusable())
{{
RecentMove= new int []{2,14};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R02C14ActionPerformed


private void R03C00ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R03C00ActionPerformed
if (R03C00.isFocusable())
{{
RecentMove= new int []{3,0};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R03C00ActionPerformed


private void R03C01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R03C01ActionPerformed
if (R03C01.isFocusable())
{{
RecentMove= new int []{3,1};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R03C01ActionPerformed


private void R03C02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R03C02ActionPerformed
if (R03C02.isFocusable())
{{
RecentMove= new int []{3,2};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R03C02ActionPerformed


private void R03C03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R03C03ActionPerformed
if (R03C03.isFocusable())
{{
RecentMove= new int []{3,3};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R03C03ActionPerformed


private void R03C04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R03C04ActionPerformed
if (R03C04.isFocusable())
{{
RecentMove= new int []{3,4};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R03C04ActionPerformed


private void R03C05ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R03C05ActionPerformed
if (R03C05.isFocusable())
{{
RecentMove= new int []{3,5};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R03C05ActionPerformed


private void R03C06ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R03C06ActionPerformed
if (R03C06.isFocusable())
{{
RecentMove= new int []{3,6};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R03C06ActionPerformed


private void R03C07ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R03C07ActionPerformed
if (R03C07.isFocusable())
{{
RecentMove= new int []{3,7};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R03C07ActionPerformed


private void R03C08ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R03C08ActionPerformed
if (R03C08.isFocusable())
{{
RecentMove= new int []{3,8};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R03C08ActionPerformed


private void R03C09ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R03C09ActionPerformed
if (R03C09.isFocusable())
{{
RecentMove= new int []{3,9};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R03C09ActionPerformed


private void R03C10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R03C10ActionPerformed
if (R03C10.isFocusable())
{{
RecentMove= new int []{3,10};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R03C10ActionPerformed


private void R03C11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R03C11ActionPerformed
if (R03C11.isFocusable())
{{
RecentMove= new int []{3,11};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R03C11ActionPerformed


private void R03C12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R03C12ActionPerformed
if (R03C12.isFocusable())
{{
RecentMove= new int []{3,12};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R03C12ActionPerformed


private void R03C13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R03C13ActionPerformed
if (R03C13.isFocusable())
{{
RecentMove= new int []{3,13};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R03C13ActionPerformed


private void R03C14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R03C14ActionPerformed
if (R03C14.isFocusable())
{{
RecentMove= new int []{3,14};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R03C14ActionPerformed


private void R04C00ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R04C00ActionPerformed
if (R04C00.isFocusable())
{{
RecentMove= new int []{4,0};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R04C00ActionPerformed


private void R04C01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R04C01ActionPerformed
if (R04C01.isFocusable())
{{
RecentMove= new int []{4,1};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R04C01ActionPerformed


private void R04C02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R04C02ActionPerformed
if (R04C02.isFocusable())
{{
RecentMove= new int []{4,2};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R04C02ActionPerformed


private void R04C03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R04C03ActionPerformed
if (R04C03.isFocusable())
{{
RecentMove= new int []{4,3};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R04C03ActionPerformed


private void R04C04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R04C04ActionPerformed
if (R04C04.isFocusable())
{{
RecentMove= new int []{4,4};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R04C04ActionPerformed


private void R04C05ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R04C05ActionPerformed
if (R04C05.isFocusable())
{{
RecentMove= new int []{4,5};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R04C05ActionPerformed


private void R04C06ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R04C06ActionPerformed
if (R04C06.isFocusable())
{{
RecentMove= new int []{4,6};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R04C06ActionPerformed


private void R04C07ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R04C07ActionPerformed
if (R04C07.isFocusable())
{{
RecentMove= new int []{4,7};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R04C07ActionPerformed


private void R04C08ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R04C08ActionPerformed
if (R04C08.isFocusable())
{{
RecentMove= new int []{4,8};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R04C08ActionPerformed


private void R04C09ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R04C09ActionPerformed
if (R04C09.isFocusable())
{{
RecentMove= new int []{4,9};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R04C09ActionPerformed


private void R04C10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R04C10ActionPerformed
if (R04C10.isFocusable())
{{
RecentMove= new int []{4,10};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R04C10ActionPerformed


private void R04C11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R04C11ActionPerformed
if (R04C11.isFocusable())
{{
RecentMove= new int []{4,11};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R04C11ActionPerformed


private void R04C12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R04C12ActionPerformed
if (R04C12.isFocusable())
{{
RecentMove= new int []{4,12};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R04C12ActionPerformed


private void R04C13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R04C13ActionPerformed
if (R04C13.isFocusable())
{{
RecentMove= new int []{4,13};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R04C13ActionPerformed


private void R04C14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R04C14ActionPerformed
if (R04C14.isFocusable())
{{
RecentMove= new int []{4,14};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R04C14ActionPerformed


private void R05C00ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R05C00ActionPerformed
if (R05C00.isFocusable())
{{
RecentMove= new int []{5,0};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R05C00ActionPerformed


private void R05C01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R05C01ActionPerformed
if (R05C01.isFocusable())
{{
RecentMove= new int []{5,1};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R05C01ActionPerformed


private void R05C02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R05C02ActionPerformed
if (R05C02.isFocusable())
{{
RecentMove= new int []{5,2};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R05C02ActionPerformed


private void R05C03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R05C03ActionPerformed
if (R05C03.isFocusable())
{{
RecentMove= new int []{5,3};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R05C03ActionPerformed


private void R05C04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R05C04ActionPerformed
if (R05C04.isFocusable())
{{
RecentMove= new int []{5,4};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R05C04ActionPerformed


private void R05C05ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R05C05ActionPerformed
if (R05C05.isFocusable())
{{
RecentMove= new int []{5,5};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R05C05ActionPerformed


private void R05C06ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R05C06ActionPerformed
if (R05C06.isFocusable())
{{
RecentMove= new int []{5,6};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R05C06ActionPerformed


private void R05C07ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R05C07ActionPerformed
if (R05C07.isFocusable())
{{
RecentMove= new int []{5,7};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R05C07ActionPerformed


private void R05C08ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R05C08ActionPerformed
if (R05C08.isFocusable())
{{
RecentMove= new int []{5,8};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R05C08ActionPerformed


private void R05C09ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R05C09ActionPerformed
if (R05C09.isFocusable())
{{
RecentMove= new int []{5,9};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R05C09ActionPerformed


private void R05C10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R05C10ActionPerformed
if (R05C10.isFocusable())
{{
RecentMove= new int []{5,10};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R05C10ActionPerformed


private void R05C11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R05C11ActionPerformed
if (R05C11.isFocusable())
{{
RecentMove= new int []{5,11};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R05C11ActionPerformed


private void R05C12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R05C12ActionPerformed
if (R05C12.isFocusable())
{{
RecentMove= new int []{5,12};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R05C12ActionPerformed


private void R05C13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R05C13ActionPerformed
if (R05C13.isFocusable())
{{
RecentMove= new int []{5,13};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R05C13ActionPerformed


private void R05C14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R05C14ActionPerformed
if (R05C14.isFocusable())
{{
RecentMove= new int []{5,14};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R05C14ActionPerformed


private void R06C00ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R06C00ActionPerformed
if (R06C00.isFocusable())
{{
RecentMove= new int []{6,0};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R06C00ActionPerformed


private void R06C01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R06C01ActionPerformed
if (R06C01.isFocusable())
{{
RecentMove= new int []{6,1};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R06C01ActionPerformed


private void R06C02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R06C02ActionPerformed
if (R06C02.isFocusable())
{{
RecentMove= new int []{6,2};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R06C02ActionPerformed


private void R06C03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R06C03ActionPerformed
if (R06C03.isFocusable())
{{
RecentMove= new int []{6,3};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R06C03ActionPerformed


private void R06C04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R06C04ActionPerformed
if (R06C04.isFocusable())
{{
RecentMove= new int []{6,4};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R06C04ActionPerformed


private void R06C05ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R06C05ActionPerformed
if (R06C05.isFocusable())
{{
RecentMove= new int []{6,5};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R06C05ActionPerformed


private void R06C06ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R06C06ActionPerformed
if (R06C06.isFocusable())
{{
RecentMove= new int []{6,6};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R06C06ActionPerformed


private void R06C07ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R06C07ActionPerformed
if (R06C07.isFocusable())
{{
RecentMove= new int []{6,7};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R06C07ActionPerformed


private void R06C08ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R06C08ActionPerformed
if (R06C08.isFocusable())
{{
RecentMove= new int []{6,8};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R06C08ActionPerformed


private void R06C09ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R06C09ActionPerformed
if (R06C09.isFocusable())
{{
RecentMove= new int []{6,9};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R06C09ActionPerformed


private void R06C10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R06C10ActionPerformed
if (R06C10.isFocusable())
{{
RecentMove= new int []{6,10};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R06C10ActionPerformed


private void R06C11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R06C11ActionPerformed
if (R06C11.isFocusable())
{{
RecentMove= new int []{6,11};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R06C11ActionPerformed


private void R06C12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R06C12ActionPerformed
if (R06C12.isFocusable())
{{
RecentMove= new int []{6,12};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R06C12ActionPerformed


private void R06C13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R06C13ActionPerformed
if (R06C13.isFocusable())
{{
RecentMove= new int []{6,13};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R06C13ActionPerformed


private void R06C14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R06C14ActionPerformed
if (R06C14.isFocusable())
{{
RecentMove= new int []{6,14};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R06C14ActionPerformed


private void R07C00ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R07C00ActionPerformed
if (R07C00.isFocusable())
{{
RecentMove= new int []{7,0};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R07C00ActionPerformed


private void R07C01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R07C01ActionPerformed
if (R07C01.isFocusable())
{{
RecentMove= new int []{7,1};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R07C01ActionPerformed


private void R07C02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R07C02ActionPerformed
if (R07C02.isFocusable())
{{
RecentMove= new int []{7,2};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R07C02ActionPerformed


private void R07C03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R07C03ActionPerformed
if (R07C03.isFocusable())
{{
RecentMove= new int []{7,3};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R07C03ActionPerformed


private void R07C04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R07C04ActionPerformed
if (R07C04.isFocusable())
{{
RecentMove= new int []{7,4};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R07C04ActionPerformed


private void R07C05ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R07C05ActionPerformed
if (R07C05.isFocusable())
{{
RecentMove= new int []{7,5};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R07C05ActionPerformed


private void R07C06ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R07C06ActionPerformed
if (R07C06.isFocusable())
{{
RecentMove= new int []{7,6};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R07C06ActionPerformed


private void R07C07ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R07C07ActionPerformed
if (R07C07.isFocusable())
{{
RecentMove= new int []{7,7};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R07C07ActionPerformed


private void R07C08ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R07C08ActionPerformed
if (R07C08.isFocusable())
{{
RecentMove= new int []{7,8};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R07C08ActionPerformed


private void R07C09ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R07C09ActionPerformed
if (R07C09.isFocusable())
{{
RecentMove= new int []{7,9};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R07C09ActionPerformed


private void R07C10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R07C10ActionPerformed
if (R07C10.isFocusable())
{{
RecentMove= new int []{7,10};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R07C10ActionPerformed


private void R07C11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R07C11ActionPerformed
if (R07C11.isFocusable())
{{
RecentMove= new int []{7,11};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R07C11ActionPerformed


private void R07C12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R07C12ActionPerformed
if (R07C12.isFocusable())
{{
RecentMove= new int []{7,12};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R07C12ActionPerformed


private void R07C13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R07C13ActionPerformed
if (R07C13.isFocusable())
{{
RecentMove= new int []{7,13};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R07C13ActionPerformed


private void R07C14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R07C14ActionPerformed
if (R07C14.isFocusable())
{{
RecentMove= new int []{7,14};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R07C14ActionPerformed


private void R08C00ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R08C00ActionPerformed
if (R08C00.isFocusable())
{{
RecentMove= new int []{8,0};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R08C00ActionPerformed


private void R08C01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R08C01ActionPerformed
if (R08C01.isFocusable())
{{
RecentMove= new int []{8,1};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R08C01ActionPerformed


private void R08C02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R08C02ActionPerformed
if (R08C02.isFocusable())
{{
RecentMove= new int []{8,2};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R08C02ActionPerformed


private void R08C03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R08C03ActionPerformed
if (R08C03.isFocusable())
{{
RecentMove= new int []{8,3};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R08C03ActionPerformed


private void R08C04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R08C04ActionPerformed
if (R08C04.isFocusable())
{{
RecentMove= new int []{8,4};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R08C04ActionPerformed


private void R08C05ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R08C05ActionPerformed
if (R08C05.isFocusable())
{{
RecentMove= new int []{8,5};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R08C05ActionPerformed


private void R08C06ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R08C06ActionPerformed
if (R08C06.isFocusable())
{{
RecentMove= new int []{8,6};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R08C06ActionPerformed


private void R08C07ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R08C07ActionPerformed
if (R08C07.isFocusable())
{{
RecentMove= new int []{8,7};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R08C07ActionPerformed


private void R08C08ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R08C08ActionPerformed
if (R08C08.isFocusable())
{{
RecentMove= new int []{8,8};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R08C08ActionPerformed


private void R08C09ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R08C09ActionPerformed
if (R08C09.isFocusable())
{{
RecentMove= new int []{8,9};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R08C09ActionPerformed


private void R08C10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R08C10ActionPerformed
if (R08C10.isFocusable())
{{
RecentMove= new int []{8,10};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R08C10ActionPerformed


private void R08C11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R08C11ActionPerformed
if (R08C11.isFocusable())
{{
RecentMove= new int []{8,11};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R08C11ActionPerformed


private void R08C12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R08C12ActionPerformed
if (R08C12.isFocusable())
{{
RecentMove= new int []{8,12};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R08C12ActionPerformed


private void R08C13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R08C13ActionPerformed
if (R08C13.isFocusable())
{{
RecentMove= new int []{8,13};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R08C13ActionPerformed


private void R08C14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R08C14ActionPerformed
if (R08C14.isFocusable())
{{
RecentMove= new int []{8,14};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R08C14ActionPerformed


private void R09C00ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R09C00ActionPerformed
if (R09C00.isFocusable())
{{
RecentMove= new int []{9,0};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R09C00ActionPerformed


private void R09C01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R09C01ActionPerformed
if (R09C01.isFocusable())
{{
RecentMove= new int []{9,1};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R09C01ActionPerformed


private void R09C02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R09C02ActionPerformed
if (R09C02.isFocusable())
{{
RecentMove= new int []{9,2};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R09C02ActionPerformed


private void R09C03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R09C03ActionPerformed
if (R09C03.isFocusable())
{{
RecentMove= new int []{9,3};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R09C03ActionPerformed


private void R09C04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R09C04ActionPerformed
if (R09C04.isFocusable())
{{
RecentMove= new int []{9,4};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R09C04ActionPerformed


private void R09C05ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R09C05ActionPerformed
if (R09C05.isFocusable())
{{
RecentMove= new int []{9,5};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R09C05ActionPerformed


private void R09C06ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R09C06ActionPerformed
if (R09C06.isFocusable())
{{
RecentMove= new int []{9,6};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R09C06ActionPerformed


private void R09C07ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R09C07ActionPerformed
if (R09C07.isFocusable())
{{
RecentMove= new int []{9,7};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R09C07ActionPerformed


private void R09C08ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R09C08ActionPerformed
if (R09C08.isFocusable())
{{
RecentMove= new int []{9,8};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R09C08ActionPerformed


private void R09C09ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R09C09ActionPerformed
if (R09C09.isFocusable())
{{
RecentMove= new int []{9,9};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R09C09ActionPerformed


private void R09C10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R09C10ActionPerformed
if (R09C10.isFocusable())
{{
RecentMove= new int []{9,10};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R09C10ActionPerformed


private void R09C11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R09C11ActionPerformed
if (R09C11.isFocusable())
{{
RecentMove= new int []{9,11};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R09C11ActionPerformed


private void R09C12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R09C12ActionPerformed
if (R09C12.isFocusable())
{{
RecentMove= new int []{9,12};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R09C12ActionPerformed


private void R09C13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R09C13ActionPerformed
if (R09C13.isFocusable())
{{
RecentMove= new int []{9,13};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R09C13ActionPerformed


private void R09C14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R09C14ActionPerformed
if (R09C14.isFocusable())
{{
RecentMove= new int []{9,14};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R09C14ActionPerformed


private void R10C00ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R10C00ActionPerformed
if (R10C00.isFocusable())
{{
RecentMove= new int []{10,0};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R10C00ActionPerformed


private void R10C01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R10C01ActionPerformed
if (R10C01.isFocusable())
{{
RecentMove= new int []{10,1};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R10C01ActionPerformed


private void R10C02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R10C02ActionPerformed
if (R10C02.isFocusable())
{{
RecentMove= new int []{10,2};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R10C02ActionPerformed


private void R10C03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R10C03ActionPerformed
if (R10C03.isFocusable())
{{
RecentMove= new int []{10,3};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R10C03ActionPerformed


private void R10C04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R10C04ActionPerformed
if (R10C04.isFocusable())
{{
RecentMove= new int []{10,4};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R10C04ActionPerformed


private void R10C05ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R10C05ActionPerformed
if (R10C05.isFocusable())
{{
RecentMove= new int []{10,5};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R10C05ActionPerformed


private void R10C06ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R10C06ActionPerformed
if (R10C06.isFocusable())
{{
RecentMove= new int []{10,6};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R10C06ActionPerformed


private void R10C07ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R10C07ActionPerformed
if (R10C07.isFocusable())
{{
RecentMove= new int []{10,7};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R10C07ActionPerformed


private void R10C08ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R10C08ActionPerformed
if (R10C08.isFocusable())
{{
RecentMove= new int []{10,8};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R10C08ActionPerformed


private void R10C09ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R10C09ActionPerformed
if (R10C09.isFocusable())
{{
RecentMove= new int []{10,9};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R10C09ActionPerformed


private void R10C10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R10C10ActionPerformed
if (R10C10.isFocusable())
{{
RecentMove= new int []{10,10};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R10C10ActionPerformed


private void R10C11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R10C11ActionPerformed
if (R10C11.isFocusable())
{{
RecentMove= new int []{10,11};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R10C11ActionPerformed


private void R10C12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R10C12ActionPerformed
if (R10C12.isFocusable())
{{
RecentMove= new int []{10,12};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R10C12ActionPerformed


private void R10C13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R10C13ActionPerformed
if (R10C13.isFocusable())
{{
RecentMove= new int []{10,13};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R10C13ActionPerformed


private void R10C14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R10C14ActionPerformed
if (R10C14.isFocusable())
{{
RecentMove= new int []{10,14};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R10C14ActionPerformed


private void R11C00ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R11C00ActionPerformed
if (R11C00.isFocusable())
{{
RecentMove= new int []{11,0};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R11C00ActionPerformed


private void R11C01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R11C01ActionPerformed
if (R11C01.isFocusable())
{{
RecentMove= new int []{11,1};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R11C01ActionPerformed


private void R11C02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R11C02ActionPerformed
if (R11C02.isFocusable())
{{
RecentMove= new int []{11,2};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R11C02ActionPerformed


private void R11C03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R11C03ActionPerformed
if (R11C03.isFocusable())
{{
RecentMove= new int []{11,3};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R11C03ActionPerformed


private void R11C04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R11C04ActionPerformed
if (R11C04.isFocusable())
{{
RecentMove= new int []{11,4};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R11C04ActionPerformed


private void R11C05ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R11C05ActionPerformed
if (R11C05.isFocusable())
{{
RecentMove= new int []{11,5};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R11C05ActionPerformed


private void R11C06ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R11C06ActionPerformed
if (R11C06.isFocusable())
{{
RecentMove= new int []{11,6};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R11C06ActionPerformed


private void R11C07ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R11C07ActionPerformed
if (R11C07.isFocusable())
{{
RecentMove= new int []{11,7};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R11C07ActionPerformed


private void R11C08ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R11C08ActionPerformed
if (R11C08.isFocusable())
{{
RecentMove= new int []{11,8};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R11C08ActionPerformed


private void R11C09ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R11C09ActionPerformed
if (R11C09.isFocusable())
{{
RecentMove= new int []{11,9};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R11C09ActionPerformed


private void R11C10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R11C10ActionPerformed
if (R11C10.isFocusable())
{{
RecentMove= new int []{11,10};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R11C10ActionPerformed


private void R11C11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R11C11ActionPerformed
if (R11C11.isFocusable())
{{
RecentMove= new int []{11,11};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R11C11ActionPerformed


private void R11C12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R11C12ActionPerformed
if (R11C12.isFocusable())
{{
RecentMove= new int []{11,12};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R11C12ActionPerformed


private void R11C13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R11C13ActionPerformed
if (R11C13.isFocusable())
{{
RecentMove= new int []{11,13};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R11C13ActionPerformed


private void R11C14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R11C14ActionPerformed
if (R11C14.isFocusable())
{{
RecentMove= new int []{11,14};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R11C14ActionPerformed


private void R12C00ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R12C00ActionPerformed
if (R12C00.isFocusable())
{{
RecentMove= new int []{12,0};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R12C00ActionPerformed


private void R12C01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R12C01ActionPerformed
if (R12C01.isFocusable())
{{
RecentMove= new int []{12,1};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R12C01ActionPerformed


private void R12C02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R12C02ActionPerformed
if (R12C02.isFocusable())
{{
RecentMove= new int []{12,2};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R12C02ActionPerformed


private void R12C03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R12C03ActionPerformed
if (R12C03.isFocusable())
{{
RecentMove= new int []{12,3};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R12C03ActionPerformed


private void R12C04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R12C04ActionPerformed
if (R12C04.isFocusable())
{{
RecentMove= new int []{12,4};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R12C04ActionPerformed


private void R12C05ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R12C05ActionPerformed
if (R12C05.isFocusable())
{{
RecentMove= new int []{12,5};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R12C05ActionPerformed


private void R12C06ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R12C06ActionPerformed
if (R12C06.isFocusable())
{{
RecentMove= new int []{12,6};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R12C06ActionPerformed


private void R12C07ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R12C07ActionPerformed
if (R12C07.isFocusable())
{{
RecentMove= new int []{12,7};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R12C07ActionPerformed


private void R12C08ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R12C08ActionPerformed
if (R12C08.isFocusable())
{{
RecentMove= new int []{12,8};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R12C08ActionPerformed


private void R12C09ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R12C09ActionPerformed
if (R12C09.isFocusable())
{{
RecentMove= new int []{12,9};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R12C09ActionPerformed


private void R12C10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R12C10ActionPerformed
if (R12C10.isFocusable())
{{
RecentMove= new int []{12,10};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R12C10ActionPerformed


private void R12C11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R12C11ActionPerformed
if (R12C11.isFocusable())
{{
RecentMove= new int []{12,11};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R12C11ActionPerformed


private void R12C12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R12C12ActionPerformed
if (R12C12.isFocusable())
{{
RecentMove= new int []{12,12};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R12C12ActionPerformed


private void R12C13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R12C13ActionPerformed
if (R12C13.isFocusable())
{{
RecentMove= new int []{12,13};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R12C13ActionPerformed


private void R12C14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R12C14ActionPerformed
if (R12C14.isFocusable())
{{
RecentMove= new int []{12,14};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R12C14ActionPerformed


private void R13C00ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R13C00ActionPerformed
if (R13C00.isFocusable())
{{
RecentMove= new int []{13,0};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R13C00ActionPerformed


private void R13C01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R13C01ActionPerformed
if (R13C01.isFocusable())
{{
RecentMove= new int []{13,1};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R13C01ActionPerformed


private void R13C02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R13C02ActionPerformed
if (R13C02.isFocusable())
{{
RecentMove= new int []{13,2};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R13C02ActionPerformed


private void R13C03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R13C03ActionPerformed
if (R13C03.isFocusable())
{{
RecentMove= new int []{13,3};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R13C03ActionPerformed


private void R13C04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R13C04ActionPerformed
if (R13C04.isFocusable())
{{
RecentMove= new int []{13,4};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R13C04ActionPerformed


private void R13C05ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R13C05ActionPerformed
if (R13C05.isFocusable())
{{
RecentMove= new int []{13,5};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R13C05ActionPerformed


private void R13C06ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R13C06ActionPerformed
if (R13C06.isFocusable())
{{
RecentMove= new int []{13,6};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R13C06ActionPerformed


private void R13C07ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R13C07ActionPerformed
if (R13C07.isFocusable())
{{
RecentMove= new int []{13,7};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R13C07ActionPerformed


private void R13C08ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R13C08ActionPerformed
if (R13C08.isFocusable())
{{
RecentMove= new int []{13,8};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R13C08ActionPerformed


private void R13C09ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R13C09ActionPerformed
if (R13C09.isFocusable())
{{
RecentMove= new int []{13,9};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R13C09ActionPerformed


private void R13C10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R13C10ActionPerformed
if (R13C10.isFocusable())
{{
RecentMove= new int []{13,10};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R13C10ActionPerformed


private void R13C11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R13C11ActionPerformed
if (R13C11.isFocusable())
{{
RecentMove= new int []{13,11};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R13C11ActionPerformed


private void R13C12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R13C12ActionPerformed
if (R13C12.isFocusable())
{{
RecentMove= new int []{13,12};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R13C12ActionPerformed


private void R13C13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R13C13ActionPerformed
if (R13C13.isFocusable())
{{
RecentMove= new int []{13,13};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R13C13ActionPerformed


private void R13C14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R13C14ActionPerformed
if (R13C14.isFocusable())
{{
RecentMove= new int []{13,14};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R13C14ActionPerformed


private void R14C00ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R14C00ActionPerformed
if (R14C00.isFocusable())
{{
RecentMove= new int []{14,0};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R14C00ActionPerformed


private void R14C01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R14C01ActionPerformed
if (R14C01.isFocusable())
{{
RecentMove= new int []{14,1};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R14C01ActionPerformed


private void R14C02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R14C02ActionPerformed
if (R14C02.isFocusable())
{{
RecentMove= new int []{14,2};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R14C02ActionPerformed


private void R14C03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R14C03ActionPerformed
if (R14C03.isFocusable())
{{
RecentMove= new int []{14,3};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R14C03ActionPerformed


private void R14C04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R14C04ActionPerformed
if (R14C04.isFocusable())
{{
RecentMove= new int []{14,4};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R14C04ActionPerformed


private void R14C05ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R14C05ActionPerformed
if (R14C05.isFocusable())
{{
RecentMove= new int []{14,5};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R14C05ActionPerformed


private void R14C06ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R14C06ActionPerformed
if (R14C06.isFocusable())
{{
RecentMove= new int []{14,6};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R14C06ActionPerformed


private void R14C07ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R14C07ActionPerformed
if (R14C07.isFocusable())
{{
RecentMove= new int []{14,7};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R14C07ActionPerformed


private void R14C08ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R14C08ActionPerformed
if (R14C08.isFocusable())
{{
RecentMove= new int []{14,8};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R14C08ActionPerformed


private void R14C09ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R14C09ActionPerformed
if (R14C09.isFocusable())
{{
RecentMove= new int []{14,9};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R14C09ActionPerformed


private void R14C10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R14C10ActionPerformed
if (R14C10.isFocusable())
{{
RecentMove= new int []{14,10};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R14C10ActionPerformed


private void R14C11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R14C11ActionPerformed
if (R14C11.isFocusable())
{{
RecentMove= new int []{14,11};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R14C11ActionPerformed


private void R14C12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R14C12ActionPerformed
if (R14C12.isFocusable())
{{
RecentMove= new int []{14,12};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R14C12ActionPerformed


private void R14C13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R14C13ActionPerformed
if (R14C13.isFocusable())
{{
RecentMove= new int []{14,13};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R14C13ActionPerformed


private void R14C14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R14C14ActionPerformed
if (R14C14.isFocusable())
{{
RecentMove= new int []{14,14};
if (!Board.MakeMove(RecentMove, new Cell( (Player_Turn++%2)+1)))
System.out.println("Problem in Making Move"); else  {DoAI(); new Clint().start();}  UpdateButtons();}
}
}//GEN-LAST:event_R14C14ActionPerformed




    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        new Animat().start();
    }//GEN-LAST:event_formWindowActivated

    private void ResetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetButtonActionPerformed
        ResetGame();
    }//GEN-LAST:event_ResetButtonActionPerformed

    private void LevelSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LevelSelectActionPerformed
        level= (level+1)%3;
        System.out.println("Level : "+level);
        SetLevelButtonFocus();
        
    }//GEN-LAST:event_LevelSelectActionPerformed

    private void Go_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Go_BackActionPerformed
        System.exit(0);
    }//GEN-LAST:event_Go_BackActionPerformed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // new Game().setVisible(true);
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BG;
    private javax.swing.JButton BasicCell;
    private javax.swing.JButton BlackCell;
    private javax.swing.JButton Go_Back;
    private javax.swing.JLabel LSelect;
    private javax.swing.JButton LevelSelect;
    private javax.swing.JButton R00C0;
    private javax.swing.JButton R00C1;
    private javax.swing.JButton R00C10;
    private javax.swing.JButton R00C11;
    private javax.swing.JButton R00C12;
    private javax.swing.JButton R00C13;
    private javax.swing.JButton R00C14;
    private javax.swing.JButton R00C2;
    private javax.swing.JButton R00C3;
    private javax.swing.JButton R00C4;
    private javax.swing.JButton R00C5;
    private javax.swing.JButton R00C6;
    private javax.swing.JButton R00C7;
    private javax.swing.JButton R00C8;
    private javax.swing.JButton R00C9;
    private javax.swing.JButton R01C00;
    private javax.swing.JButton R01C01;
    private javax.swing.JButton R01C02;
    private javax.swing.JButton R01C03;
    private javax.swing.JButton R01C04;
    private javax.swing.JButton R01C05;
    private javax.swing.JButton R01C06;
    private javax.swing.JButton R01C07;
    private javax.swing.JButton R01C08;
    private javax.swing.JButton R01C09;
    private javax.swing.JButton R01C10;
    private javax.swing.JButton R01C11;
    private javax.swing.JButton R01C12;
    private javax.swing.JButton R01C13;
    private javax.swing.JButton R01C14;
    private javax.swing.JButton R02C00;
    private javax.swing.JButton R02C01;
    private javax.swing.JButton R02C02;
    private javax.swing.JButton R02C03;
    private javax.swing.JButton R02C04;
    private javax.swing.JButton R02C05;
    private javax.swing.JButton R02C06;
    private javax.swing.JButton R02C07;
    private javax.swing.JButton R02C08;
    private javax.swing.JButton R02C09;
    private javax.swing.JButton R02C10;
    private javax.swing.JButton R02C11;
    private javax.swing.JButton R02C12;
    private javax.swing.JButton R02C13;
    private javax.swing.JButton R02C14;
    private javax.swing.JButton R03C00;
    private javax.swing.JButton R03C01;
    private javax.swing.JButton R03C02;
    private javax.swing.JButton R03C03;
    private javax.swing.JButton R03C04;
    private javax.swing.JButton R03C05;
    private javax.swing.JButton R03C06;
    private javax.swing.JButton R03C07;
    private javax.swing.JButton R03C08;
    private javax.swing.JButton R03C09;
    private javax.swing.JButton R03C10;
    private javax.swing.JButton R03C11;
    private javax.swing.JButton R03C12;
    private javax.swing.JButton R03C13;
    private javax.swing.JButton R03C14;
    private javax.swing.JButton R04C00;
    private javax.swing.JButton R04C01;
    private javax.swing.JButton R04C02;
    private javax.swing.JButton R04C03;
    private javax.swing.JButton R04C04;
    private javax.swing.JButton R04C05;
    private javax.swing.JButton R04C06;
    private javax.swing.JButton R04C07;
    private javax.swing.JButton R04C08;
    private javax.swing.JButton R04C09;
    private javax.swing.JButton R04C10;
    private javax.swing.JButton R04C11;
    private javax.swing.JButton R04C12;
    private javax.swing.JButton R04C13;
    private javax.swing.JButton R04C14;
    private javax.swing.JButton R05C00;
    private javax.swing.JButton R05C01;
    private javax.swing.JButton R05C02;
    private javax.swing.JButton R05C03;
    private javax.swing.JButton R05C04;
    private javax.swing.JButton R05C05;
    private javax.swing.JButton R05C06;
    private javax.swing.JButton R05C07;
    private javax.swing.JButton R05C08;
    private javax.swing.JButton R05C09;
    private javax.swing.JButton R05C10;
    private javax.swing.JButton R05C11;
    private javax.swing.JButton R05C12;
    private javax.swing.JButton R05C13;
    private javax.swing.JButton R05C14;
    private javax.swing.JButton R06C00;
    private javax.swing.JButton R06C01;
    private javax.swing.JButton R06C02;
    private javax.swing.JButton R06C03;
    private javax.swing.JButton R06C04;
    private javax.swing.JButton R06C05;
    private javax.swing.JButton R06C06;
    private javax.swing.JButton R06C07;
    private javax.swing.JButton R06C08;
    private javax.swing.JButton R06C09;
    private javax.swing.JButton R06C10;
    private javax.swing.JButton R06C11;
    private javax.swing.JButton R06C12;
    private javax.swing.JButton R06C13;
    private javax.swing.JButton R06C14;
    private javax.swing.JButton R07C00;
    private javax.swing.JButton R07C01;
    private javax.swing.JButton R07C02;
    private javax.swing.JButton R07C03;
    private javax.swing.JButton R07C04;
    private javax.swing.JButton R07C05;
    private javax.swing.JButton R07C06;
    private javax.swing.JButton R07C07;
    private javax.swing.JButton R07C08;
    private javax.swing.JButton R07C09;
    private javax.swing.JButton R07C10;
    private javax.swing.JButton R07C11;
    private javax.swing.JButton R07C12;
    private javax.swing.JButton R07C13;
    private javax.swing.JButton R07C14;
    private javax.swing.JButton R08C00;
    private javax.swing.JButton R08C01;
    private javax.swing.JButton R08C02;
    private javax.swing.JButton R08C03;
    private javax.swing.JButton R08C04;
    private javax.swing.JButton R08C05;
    private javax.swing.JButton R08C06;
    private javax.swing.JButton R08C07;
    private javax.swing.JButton R08C08;
    private javax.swing.JButton R08C09;
    private javax.swing.JButton R08C10;
    private javax.swing.JButton R08C11;
    private javax.swing.JButton R08C12;
    private javax.swing.JButton R08C13;
    private javax.swing.JButton R08C14;
    private javax.swing.JButton R09C00;
    private javax.swing.JButton R09C01;
    private javax.swing.JButton R09C02;
    private javax.swing.JButton R09C03;
    private javax.swing.JButton R09C04;
    private javax.swing.JButton R09C05;
    private javax.swing.JButton R09C06;
    private javax.swing.JButton R09C07;
    private javax.swing.JButton R09C08;
    private javax.swing.JButton R09C09;
    private javax.swing.JButton R09C10;
    private javax.swing.JButton R09C11;
    private javax.swing.JButton R09C12;
    private javax.swing.JButton R09C13;
    private javax.swing.JButton R09C14;
    private javax.swing.JButton R10C00;
    private javax.swing.JButton R10C01;
    private javax.swing.JButton R10C02;
    private javax.swing.JButton R10C03;
    private javax.swing.JButton R10C04;
    private javax.swing.JButton R10C05;
    private javax.swing.JButton R10C06;
    private javax.swing.JButton R10C07;
    private javax.swing.JButton R10C08;
    private javax.swing.JButton R10C09;
    private javax.swing.JButton R10C10;
    private javax.swing.JButton R10C11;
    private javax.swing.JButton R10C12;
    private javax.swing.JButton R10C13;
    private javax.swing.JButton R10C14;
    private javax.swing.JButton R11C00;
    private javax.swing.JButton R11C01;
    private javax.swing.JButton R11C02;
    private javax.swing.JButton R11C03;
    private javax.swing.JButton R11C04;
    private javax.swing.JButton R11C05;
    private javax.swing.JButton R11C06;
    private javax.swing.JButton R11C07;
    private javax.swing.JButton R11C08;
    private javax.swing.JButton R11C09;
    private javax.swing.JButton R11C10;
    private javax.swing.JButton R11C11;
    private javax.swing.JButton R11C12;
    private javax.swing.JButton R11C13;
    private javax.swing.JButton R11C14;
    private javax.swing.JButton R12C00;
    private javax.swing.JButton R12C01;
    private javax.swing.JButton R12C02;
    private javax.swing.JButton R12C03;
    private javax.swing.JButton R12C04;
    private javax.swing.JButton R12C05;
    private javax.swing.JButton R12C06;
    private javax.swing.JButton R12C07;
    private javax.swing.JButton R12C08;
    private javax.swing.JButton R12C09;
    private javax.swing.JButton R12C10;
    private javax.swing.JButton R12C11;
    private javax.swing.JButton R12C12;
    private javax.swing.JButton R12C13;
    private javax.swing.JButton R12C14;
    private javax.swing.JButton R13C00;
    private javax.swing.JButton R13C01;
    private javax.swing.JButton R13C02;
    private javax.swing.JButton R13C03;
    private javax.swing.JButton R13C04;
    private javax.swing.JButton R13C05;
    private javax.swing.JButton R13C06;
    private javax.swing.JButton R13C07;
    private javax.swing.JButton R13C08;
    private javax.swing.JButton R13C09;
    private javax.swing.JButton R13C10;
    private javax.swing.JButton R13C11;
    private javax.swing.JButton R13C12;
    private javax.swing.JButton R13C13;
    private javax.swing.JButton R13C14;
    private javax.swing.JButton R14C00;
    private javax.swing.JButton R14C01;
    private javax.swing.JButton R14C02;
    private javax.swing.JButton R14C03;
    private javax.swing.JButton R14C04;
    private javax.swing.JButton R14C05;
    private javax.swing.JButton R14C06;
    private javax.swing.JButton R14C07;
    private javax.swing.JButton R14C08;
    private javax.swing.JButton R14C09;
    private javax.swing.JButton R14C10;
    private javax.swing.JButton R14C11;
    private javax.swing.JButton R14C12;
    private javax.swing.JButton R14C13;
    private javax.swing.JButton R14C14;
    private javax.swing.JButton ResetButton;
    private javax.swing.JLabel Turns;
    private javax.swing.JButton WhiteCell;
    private javax.swing.JButton WinBlackCell;
    private javax.swing.JButton WinWhiteCell;
    // End of variables declaration//GEN-END:variables
}
