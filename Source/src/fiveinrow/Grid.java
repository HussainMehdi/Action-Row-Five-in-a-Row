package fiveinrow;

class Cell
{
   int info;
   Cell(int in){info=in;}
   int getinfo(){return info;}
}

class GridSize
{   
    private int width,height;
    GridSize(int x, int y){width=x;height=y;}
    int getWidth(){return width;}
    int getHeight(){return height;}
}

public class Grid {
   int width,height;
   Cell Table[][]=null;
   Grid(int x,int y){Table= new Cell[x][y];width=x;height=y;}
   
   boolean MakeMove(int element[], Cell insert) {
      if (Table[element[0]][element[1]]==null)
      { Table[element[0]][element[1]]=insert; return true;}
      return false; 
   }
   Cell[][] GetGrid(){return Table;}  
   GridSize GetSize(){return new GridSize(width,height);}
}
