package fiveinrow;

public class AI {
    
   int[] EasyAI(Grid AIBoard) {
      Cell Board[][]=AIBoard.GetGrid();
      int[] playMove = new int[2];
      GridSize BoardSize=AIBoard.GetSize();
      
      for (int w = 0; w < BoardSize.getWidth(); w++) {
        for (int h = 0; h < BoardSize.getHeight(); h++) {
           if(Board[w][h]!=null)
             if (Board[w][h].getinfo() == 1) { // If found Player 1 Move              
                  if (w != 0 && h != 0 && w != BoardSize.getWidth() && BoardSize.getHeight() != 14) { // If not on the first or last element
                    //<editor-fold defaultstate="collapsed" desc="All Test Cases to find nearby empty Space">
                        if (Board[w - 1][h - 1] == null) {playMove[0] = w - 1;playMove[1] = h - 1;return playMove;}
                        
                        if (Board[w + 1][h + 1]== null) {playMove[0] = w + 1;playMove[1] = h + 1;return playMove;}
                        
                        if (Board[w + 1][h - 1]==null) {playMove[0] = w + 1;playMove[1] = h - 1;}
                        
                        if (Board[w - 1][h + 1] == null) {playMove[0] = w - 1;playMove[1] = h + 1;}
                        
                        if (Board[w][h - 1]  ==  null) {playMove[0] = w;playMove[1] = h - 1;return playMove;}
                        
                        if (Board[w][h + 1]==null) {playMove[0] = w;playMove[1] = h + 1; return playMove;}
                        
                        if (Board[w - 1][h]==null) {playMove[0] = w - 1;playMove[1] = h;return playMove;}
                        
                        if (Board[w + 1][h]==null) {playMove[0] = w + 1;playMove[1] = h;return playMove; }
//</editor-fold>
                    }}}}

      //Try to play in the middle when it fails to plot near user
      // When above conditions fails
      while(true){
       playMove[0] = 6 + (int) (Math.random() * 5)%(BoardSize.getWidth()-1);
       playMove[1] = 6 + (int) (Math.random() * 5)%(BoardSize.getHeight()-1);
       if (Board[playMove[0]][playMove[1]]==null)break;
      }
        return playMove;
  }
  
   int[] LogicAI(Grid AIBoard, int ai,int level)
   {   Cell Board[][]=AIBoard.GetGrid();
       int[] bestMove = new int[3];
        int score = 0, temp = 0;
        int[] position = new int[2];
        for (int width = 0; width < 15; width++) {
            for (int height = 0; height < 15; height++) {
                temp = GetGoodScoreMove(Board, width, height,ai,level);
                if (temp >= score) {
                    score = temp;
                    position[0] = width;
                    position[1] = height;
                }
            }
        }
        bestMove[0] = position[0];
        bestMove[1] = position[1];
        return bestMove;
   }
   
   private int GetGoodScoreMove(Cell[][] Board,int x,int y,int ai,int level)
   {
       int valueS = 0, valueN = 0, valueNE = 0, valueSE = 0, valueNW = 0, valueSW = 0, valueE = 0, valueW = 0, MyBug=0;
        int[] scoreOther=new int[4];
        int[] scoreOwn=new int[4];
        int player=1; // Who you want to lose 
     //   System.out.println(ai);
        if( ai==1)player=2;else player=1;
        
//  System.out.println(ai);
        //<editor-fold defaultstate="collapsed" desc="Level 1 Easy enough">
        if (level==1){
            scoreOther[0] =2;
            scoreOther[1] =6;
            scoreOther[2] =9;
            scoreOther[3] =100;
            
            scoreOwn[0]=1;
            scoreOwn[1]=3;
            scoreOwn[2]=19;
            scoreOwn[3]=51;
          //  player=1;
        }
//</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Level 2 (Dnt make Player Win)">
        if (level==2){
            scoreOther[0] =2;
            scoreOther[1] =4;
            scoreOther[2] =6;
            scoreOther[3] =100;
            
            scoreOwn[0]=1;
            scoreOwn[1]=3;
            scoreOwn[2]=7;
            scoreOwn[3]=51;
       //     player=1;
        }
//</editor-fold>
      
        
        // We compute our score with Player score because we have to see also that is he winning !!
        
        if (Board[x][y] == null) {  // We found empty cell to place element
            try {
                //<editor-fold defaultstate="collapsed" desc="position to upper elements (NORTH)->valueN">
                if (Board[x][y - 1].info == player) {
                    valueN = scoreOther[0];
                    // Check whether plot other ball
                    if (Board[x][y - 2].info == player) {
                        valueN = scoreOther[1];
                        // What if I find next step :)
                        if (Board[x][y - 3].info == player) {
                            valueN = scoreOther[2];
                            // I am computer I can win
                            if (Board[x][y - 4].info == player) {
                                valueN = scoreOther[3];
                            }
                        }
                    }
                } else if (Board[x][y - 1].info == ai) {
                    valueN = scoreOwn[0];
                    if (Board[x][y - 2].info == ai) {
                        valueN = scoreOwn[1];
                        if (Board[x][y - 3].info == ai) {
                            valueN = scoreOwn[2];
                            if (Board[x][y - 4].info == ai) {
                                valueN = scoreOwn[3];
                            }
                        }
                    }
                }//</editor-fold>
                } catch (Exception e) {}
            
            try {
                //<editor-fold defaultstate="collapsed" desc="From position to downer elements (SOUTH)->valueS">
                if (Board[x][y + 1].info == player) {
                    valueS = scoreOther[0];
                    if (Board[x][y + 2].info == player) {
                        valueS = scoreOther[1];
                        if (Board[x][y + 3].info == player) {
                            valueS = scoreOther[2];
                            if (Board[x][y + 3].info == player) {
                                valueS = scoreOther[3];
                            }
                        }
                    }
                } else if (Board[x][y + 1].info == ai) {
                    valueS = scoreOwn[0];
                    if (Board[x][y + 2].info == ai) {
                        valueS = scoreOwn[1];
                        if (Board[x][y + 3].info == ai) {
                            valueS = scoreOwn[2];
                            if (Board[x][y + 4].info == ai) {
                                valueS = scoreOwn[3];
                            }
                        }
                    }
                }
//</editor-fold>
                } catch (Exception e) {}
            
            try {
                
                //<editor-fold defaultstate="collapsed" desc="From position to Left (WEST)->valueW">
                if (Board[x - 1][y].info == player) {
                    valueW = scoreOther[0];
                    if (Board[x - 2][y].info == player) {
                        valueW = scoreOther[1];
                        if (Board[x - 3][y].info == player) {
                            valueW = scoreOther[2];
                            if (Board[x - 4][y].info == player) {
                                valueW = scoreOther[3];
                            }
                        }
                    }
                } else if (Board[x - 1][y].info == ai) {
                    valueW = scoreOwn[0];
                    if (Board[x - 2][y].info == ai) {
                        valueW = scoreOwn[1];
                        if (Board[x - 3][y].info == ai) {
                            valueW = scoreOwn[2];
                            if (Board[x - 4][y].info == ai) {
                                valueW = scoreOwn[3];
                            }
                        }
                    }
                }
//</editor-fold>
                } catch (Exception e) {}
            
            try {
                //<editor-fold defaultstate="collapsed" desc="From Position to Right (EAST)->valueE">
                if (Board[x + 1][y].info == player) {
                    valueE = scoreOther[0];
                    if (Board[x + 2][y].info == player) {
                        valueE = scoreOther[1];
                        if (Board[x + 3][y].info == player) {
                            valueE = scoreOther[2];
                            if (Board[x + 4][y].info == player) {
                                valueE = scoreOther[3];
                            }
                        }
                    }
                } else if (Board[x + 1][y].info == ai) {
                    valueE = scoreOwn[0];
                    if (Board[x + 2][y].info == ai) {
                        valueE = scoreOwn[1];
                        if (Board[x + 3][y].info == ai) {
                            valueE = scoreOwn[2];
                            if (Board[x + 4][y].info == ai) {
                                valueE = scoreOwn[3];
                            }
                        }
                    }
                }
//</editor-fold>
                } catch (Exception e) {}
            
            try {
                //<editor-fold defaultstate="collapsed" desc="From position to Up-Left (NorthWest)->valueNW">
                if (Board[x - 1][y - 1].info == player) {
                    valueNW = scoreOther[0];
                    if (Board[x - 2][y - 2].info == player) {
                        valueNW = scoreOther[1];
                        if (Board[x - 3][y - 3].info == player) {
                            valueNW = scoreOther[2];
                            if (Board[x - 4][y - 4].info == player) {
                                valueNW = scoreOther[3];
                            }
                        }
                    }
                } else if (Board[x - 1][y - 1].info == ai) {
                    valueNW = scoreOwn[0];
                    if (Board[x - 2][y - 2].info == ai) {
                        valueNW = scoreOwn[1];
                        if (Board[x - 3][y - 3].info == ai) {
                            valueNW = scoreOwn[2];
                            if (Board[x - 4][y - 4].info == ai) {
                                valueNW = scoreOwn[3];
                            }
                        }
                    }
                }
//</editor-fold>
                } catch (Exception e) {}
            
            try {
                //<editor-fold defaultstate="collapsed" desc="From Position to Down-Right(SouthEast)->valueSE">
                if (Board[x + 1][y + 1].info == player) {
                    valueSE = scoreOther[0];
                    if (Board[x + 2][y + 2].info == player) {
                        valueSE = scoreOther[1];
                        if (Board[x + 3][y + 3].info == player) {
                            valueSE = scoreOther[2];
                            if (Board[x + 4][y + 4].info == player) {
                                valueSE = scoreOther[3];
                            }
                        }
                    }
                } else if (Board[x + 1][y + 1].info == ai) {
                    valueSE = scoreOwn[0];
                    if (Board[x + 2][y + 2].info == ai) {
                        valueSE = scoreOwn[1];
                        if (Board[x + 3][y + 3].info == ai) {
                            valueSE = scoreOwn[2];
                            if (Board[x + 4][y + 4].info == ai) {
                                valueSE = scoreOwn[3];
                            }
                        }
                    }
                    
                }
//</editor-fold>
                } catch (Exception e) {}

            
            try {
                //<editor-fold defaultstate="collapsed" desc="From Position to Up-Right(NorthEast)->valueNE">
                if (Board[x + 1][y - 1].info == player) {
                    valueNE = scoreOther[0];
                    if (Board[x + 2][y - 2].info == player) {
                        valueNE = scoreOther[1];
                        if (Board[x + 3][y - 3].info == player) {
                            valueNE = scoreOther[2];
                            if (Board[x + 4][y - 4].info == player) {
                                valueNE = scoreOther[3];
                            }
                        }
                    }
                } else if (Board[x + 1][y - 1].info == ai) {
                    valueNE = scoreOwn[0];
                    if (Board[x + 2][y - 2].info == ai) {
                        valueNE = scoreOwn[1];
                        if (Board[x + 3][y - 3].info == ai) {
                            valueNE = scoreOwn[2];
                            if (Board[x + 4][y - 4].info == ai) {
                                valueNE = scoreOwn[3];
                            }
                        }
                    }
                }
//</editor-fold>
                } catch (Exception e) {}
            
            try {
                //<editor-fold defaultstate="collapsed" desc="From Position to Down-Left(SouthWest)->valueSW">
                if (Board[x - 1][y + 1].info == player) {
                    valueSW = scoreOther[0];
                    if (Board[x - 2][y + 2].info == player) {
                        valueSW = scoreOther[1];
                        if (Board[x - 3][y + 3].info == player) {
                            valueSW = scoreOther[2];
                            if (Board[x - 4][y + 4].info == player) {
                                valueSW = scoreOther[3];
                            }
                        }
                    }
                } else if (Board[x - 1][y - 1].info == ai) {
                    valueSW = scoreOwn[0];
                    if (Board[x - 2][y + 2].info == ai) {
                        valueSW = scoreOwn[1];
                        if (Board[x - 3][y + 3].info == ai) {
                            valueSW = scoreOwn[2];
                            if (Board[x - 4][y + 4].info == ai) {
                                valueSW = scoreOwn[3];
                            }
                        }
                    }
                }
//</editor-fold>
                } catch (Exception e) {}
        }
       
        try{  
       if(Board[x-1][y+1].info==player && 
               Board[x+1][y-1].info==player &&
                 Board[x-3][y+3].info==player &&
                   Board[x][y]==null){MyBug=220;}
       
      }
      catch(Exception aa){}
       
         try{  
       if(Board[x-1][y+1].info==player && 
               Board[x+1][y-1].info==player &&
                 Board[x-2][y+2].info==player &&
                   Board[x+2][y-2].info==player &&
                     Board[x][y]==null){MyBug=140;}
       
      }
      catch(Exception aa){}
       try{  
       if(Board[x][y-1].info==player && 
               Board[x][y-2].info==player &&
                 Board[x][y-3].info==player &&
                   Board[x][y+1].info==player &&
                     Board[x][y]==null){MyBug=160;}
       
      }
      catch(Exception aa){}
      
       
      
      //<editor-fold defaultstate="collapsed" desc="Get Max score and store in s">
        int s = Math.max(valueS, Math.max(valueN, Math.max(valueSE, Math.max(valueSW,
                Math.max(valueNE, Math.max(valueNW, Math.max(valueE, Math.max(MyBug, valueW))))))));
//</editor-fold>
        return s; //Returns the max score found.
    }
}
