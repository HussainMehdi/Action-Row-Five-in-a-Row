package fiveinrow;

public class CheckWin {
    
    CheckWin(Game GameFile)
    {
        GridSize BoardSize=GameFile.Board.GetSize();
        
        Cell[] Cells[]=GameFile.Board.GetGrid();
        for(int i=0; i<BoardSize.getHeight(); i++)
           for(int j=0; j<BoardSize.getWidth(); j++)
               if (Cells[i][j]!=null)
               {
                   int player=Cells[i][j].info;
                   int count=1;
                   //<editor-fold defaultstate="collapsed" desc="Position To North & South">
                   try
                   {    while(true){
                       if(Cells[i][j-1].info==player)count++;
                       else break;
                       if(Cells[i][j-2].info==player)count++;
                       else break;
                       if(Cells[i][j-3].info==player)count++;
                       else break;
                       if(Cells[i][j-4].info==player)count++;
                       else break;
                       if (count==5)break;
                   }
                   if (count==5)
                   {   Cells[i][j].info=(player*10)+1;
                   Cells[i][j-1].info=(player*10)+1;
                   Cells[i][j-2].info=(player*10)+1;
                   Cells[i][j-3].info=(player*10)+1;
                   Cells[i][j-4].info=(player*10)+1;
                   GameFile.Win=true;
                   break;
                   }
                   }
                   catch (Exception e){}
//</editor-fold>
                   count=1;
                   //<editor-fold defaultstate="collapsed" desc="Position To West & East">
                   try
                   {    while(true){
                       if(Cells[i-1][j].info==player)count++;
                       else break;
                       if(Cells[i-2][j].info==player)count++;
                       else break;
                       if(Cells[i-3][j].info==player)count++;
                       else break;
                       if(Cells[i-4][j].info==player)count++;
                       else break;
                       if (count==5)break;
                   }
                   if (count==5)
                   {   Cells[i][j].info=(player*10)+1;
                   Cells[i-1][j].info=(player*10)+1;
                   Cells[i-2][j].info=(player*10)+1;
                   Cells[i-3][j].info=(player*10)+1;
                   Cells[i-4][j].info=(player*10)+1;
                   GameFile.Win=true;
                   break;
                   }
                   }
                   catch (Exception e){}
//</editor-fold>
                   count=1;
                   //<editor-fold defaultstate="collapsed" desc="Position To North-West & South East">
                   try
                   {    while(true){
                       if(Cells[i-1][j-1].info==player)count++;
                       else break;
                       if(Cells[i-2][j-2].info==player)count++;
                       else break;
                       if(Cells[i-3][j-3].info==player)count++;
                       else break;
                       if(Cells[i-4][j-4].info==player)count++;
                       else break;
                       if (count==5)break;
                   }
                   if (count==5)
                   {   Cells[i][j].info=(player*10)+1;
                   Cells[i-1][j-1].info=(player*10)+1;
                   Cells[i-2][j-2].info=(player*10)+1;
                   Cells[i-3][j-3].info=(player*10)+1;
                   Cells[i-4][j-4].info=(player*10)+1;
                   GameFile.Win=true;
                   break;
                   }
                   }
                   catch (Exception e){}
//</editor-fold>
                   count=1;
                   //<editor-fold defaultstate="collapsed" desc="Position To North-East & South-West">
                   try
                   {    while(true){
                       if(Cells[i-1][j+1].info==player)count++;
                       else break;
                       if(Cells[i-2][j+2].info==player)count++;
                       else break;
                       if(Cells[i-3][j+3].info==player)count++;
                       else break;
                       if(Cells[i-4][j+4].info==player)count++;
                       else break;
                       if (count==5)break;
                   }
                   if (count==5)
                   {   Cells[i][j].info=(player*10)+1;
                   Cells[i-1][j+1].info=(player*10)+1;
                   Cells[i-2][j+2].info=(player*10)+1;
                   Cells[i-3][j+3].info=(player*10)+1;
                   Cells[i-4][j+4].info=(player*10)+1;
                   GameFile.Win=true;
                   break;
                   }
                   }
                   catch (Exception e){}
//</editor-fold>
               }
    }
}
