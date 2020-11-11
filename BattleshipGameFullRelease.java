import java.util.Scanner;
public class BattleshipGameFullRelease{
  
  public static void main(String[] args){
    
    Scanner in = new Scanner(System.in);
    
    //introduction
    System.out.println("Hello and welcome to the simple Java Battleship game!");
    System.out.println("This game was made by students of BRACU CSE department as a group project of CSE110 course!");
    System.out.println("Thank you for trying this out. Hope you'll enjoy!");
    System.out.println();
    System.out.println("To start the game, enter 1");
    System.out.println("To see the credits, enter 2");
    System.out.println("To see the instructions, enter 3");
    System.out.println("To exit the program, enter 0");
    
    while(true){
      
      int userInStartVar = 0, userInSize = 0, userInShipNum = 0, userInPosition = 0, oppPosition = 0;
      int gameMode = 0, playCount = 0, atkCount = 0, atkPosition = 0, atkPosition2 = 0;
      int userInShipSize = 0, placeBlock = 0, totalHit = 0, playerHit = 0, opponentHit = 0;
      
      userInStartVar = in.nextInt();
      if(userInStartVar == 0){//exit
        break;
      }else if(userInStartVar == 1){//game
        playCount++;
        // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        System.out.println();
        
        System.out.println("In the default game 7 ships of length 1, 2, 3, 4, 5, 6 and 7 tiles will be plaved randomly through the battlefield of 100 tiles length.");
        System.out.println("In the custom game, number of ships and the ships' length and position will be user defined.");
        System.out.println("Please enter:\n01 - for default single player game\n02 - for default multiplayer game\n11 - for custom single player game\n12 - for custom multiplayer game.\n");
        while(true){
          gameMode = in.nextInt();
          
          // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
          // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
          //             S I N G L E      P L A Y E R      C U S T O M
          // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
          // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
          if(gameMode == 11){//single player custom
            System.out.println("You have selected to play single player vs computer");
            
            while(true){
              //creating the field based on input
              System.out.println("Please enter a positive integer greater than 1:");
              System.out.println("How many tiles would you like in your field?");
              userInSize = in.nextInt();
              
              if(userInSize > 1){
                break;
              }else{
                System.out.println("Invalid input! Please retry.");
              }
            }
            String [] ownField = new String[userInSize];
            String [] oppField = new String[userInSize];
            String [] atkField = new String[userInSize];
            
            // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
            for(int i = 0; i < userInSize; i++){
              //filling the Fields with O and atk field with ?
              ownField[i] = oppField[i] = "O";
              atkField[i] = "?";
            }
            // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
            System.out.println();
            System.out.println("Please enter a non zero positive integer which is less than the field size:\n");
            
            while(true){
              //input ship number
              System.out.println("How many ships would you like to use?");
              userInShipNum = in.nextInt();
              
              if((userInShipNum < userInSize) && (userInShipNum > 0)){
                break;
              }else{
                System.out.println("Invalid input! Please retry.");
              }
            }
            // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
            System.out.println();

            
            for(int i = 1; i <= userInShipNum; i++){
              System.out.println("Ship "+i+":");
              System.out.println("What would you like to be the ship size?\nMinimum size: 1 tile and maximum size: 10 tiles");
              while(true){
                //input ship size
                userInShipSize = in.nextInt();
                if(userInShipSize<1){
                  System.out.println("Invalid input! Please retry.");
                }else if(userInShipSize>10){
                  System.out.println("Ship is too big! Please retry.");
                }else{
                  break;
                }
              }
              // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
              totalHit += userInShipSize;
              while(true){
                //input ships in ownField
                System.out.println("Where would you like to place this ship?");
                System.out.println("Please enter numbers which signify the tile number of the ships.\nThe number should be between 1 to "+(userInSize-userInShipSize+1)+" inclusive.");
                while(true){
                  //input ship position
                  userInPosition = in.nextInt();
                  if(userInPosition <= 0){
                    System.out.println("Invalid input! Please retry.");
                  }else if(userInPosition + userInShipSize -1 > userInSize){
                    System.out.println("Out of bounds! Please retry.");
                  }else{
                    break;
                  }
                }
                placeBlock = 0;
                //block check
                for(int q = userInPosition; q<userInPosition+userInShipSize; q++){
                  if(ownField[q-1].equals("S")){
                    placeBlock++;
                  }else{}
                }
                if(placeBlock > 0){
                  System.out.println("That position is already occupied. Please retry.");
                }else{
                  break;
                }
              }
              //place ship
              for(int q = userInPosition; q<userInPosition+userInShipSize; q++){
                ownField[q-1] = "S";
              }
              // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
              //view own field - ORGANIZED
              System.out.println("Your current field:    O = Empty Field,    S = Ship");
              for(int j = 0; j < userInSize; j+=25){
                for(int x = 0; x<25&&((j+x)<userInSize);x++){
                    System.out.print("   "+ownField[j+x]);
                }
                System.out.println();
                for(int x = 0; x<25&&((j+x)<userInSize);x++){
                  System.out.printf(" %3d",(j+x+1));
                }
                System.out.println();
              }
              // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
              while(true){
                while(true){
                  //randomized ship position in opponentField
                  oppPosition = (int)(Math.random()*(userInSize-1));
                  if(oppPosition+userInShipSize<userInSize){
                    break;
                  }
                }
                
                placeBlock = 0;
                //block check
                for(int q = oppPosition; q<oppPosition+userInShipSize; q++){
                  if(oppField[q].equals("S")){
                    placeBlock++;
                  }else{}
                }
                if(placeBlock == 0){break;}
              }
              
              for(int q = oppPosition; q<oppPosition+userInShipSize; q++){
                oppField[q] = "S";
              }
            }
            
            // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
            // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
            System.out.println();
            System.out.println("The game now begins!\n");
            
            while(playerHit < totalHit && opponentHit < totalHit){
              //GAME: View tiles - ORGANIZED
              atkCount++;
              System.out.println("O = Empty Field     S = Ship     ? = Unknown\nH = Already Hit Tile    X = Already Hit Ship");
              System.out.println();
              for(int i = 0; i < userInSize; i+=25){
                System.out.print("    Your field  :");
                for(int x = 0; x<25&&((i+x)<userInSize);x++){
                  System.out.print("   "+ownField[i+x]);
                }
                System.out.println();
                System.out.print("                 ");
                for(int x = 0; x<25&&((i+x)<userInSize);x++){
                  System.out.printf(" %3d",(i+x+1));
                }
                System.out.println();
                System.out.print("Opponent field  :");
                for(int x = 0; x<25&&((i+x)<userInSize);x++){
                  System.out.print("   "+atkField[i+x]);
                }
                System.out.println("\n");
              }
              // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
              //GAME: player attack
              if(atkCount == 1){
                System.out.println("You get the first attack!");
              }else{}
              while(true){
                System.out.println("Your turn");
                System.out.println("Enemy ship tile remaining:"+(totalHit-opponentHit));
                while(true){
                  //input player attack position
                  System.out.println("Where would you like to attack?");
                  atkPosition = in.nextInt();
                  if(atkPosition == 31415926){
                    break;
                  }else if((atkPosition <= 0) || (atkPosition > userInSize)){
                    System.out.println("Invalid input! Please retry.");
                  }else if(atkField[atkPosition-1].equals("X")||atkField[atkPosition-1].equals("H")){
                    System.out.println("You've already attacked the tile "+atkPosition+". Please retry.");
                  }else{
                    break;
                  }
                }
                // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
                if(atkPosition == 31415926){
                  break;
                }else{
                  //player attack action
                  if(oppField[atkPosition-1].equals("O")){
                    atkField[atkPosition-1] = "H";
                    oppField[atkPosition-1] = "H";
                    System.out.println("The tile was empty!");
                    break;
                  }else if(oppField[atkPosition-1].equals("S")){
                    atkField[atkPosition-1] = "X";
                    oppField[atkPosition-1] = "X";
                    System.out.println("Great! You shot an enemy ship!");
                    opponentHit++;
                    if(opponentHit == totalHit){
                      break;
                    }else{
                      // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
                      //Player bonus turn
                      System.out.println("O = Empty Field     S = Ship     ? = Unknown\nH = Already Hit Tile    X = Already Hit Ship");
                      System.out.println();
                      for(int i = 0; i < userInSize; i+=25){
                        System.out.print("    Your field  :");
                        for(int x = 0; x<25&&((i+x)<userInSize);x++){
                          System.out.print("   "+ownField[i+x]);
                        }
                        System.out.println();
                        System.out.print("                 ");
                        for(int x = 0; x<25&&((i+x)<userInSize);x++){
                          System.out.printf(" %3d",(i+x+1));
                        }
                        System.out.println();
                        System.out.print("Opponent field  :");
                        for(int x = 0; x<25&&((i+x)<userInSize);x++){
                          System.out.print("   "+atkField[i+x]);
                        }
                        System.out.println("\n");
                      }
                    }
                  }
                }
              }
              // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
              if(atkPosition == 31415926){
                System.out.println("Since you are too awesome to play, let's end the game here.");
                break;
              }else if(opponentHit == totalHit){
                break;
              }
              // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
              //GAME: opponent attack 
              while(true){
                System.out.println("Opponent's turn");
                while(true){
                  //random opponent attack position
                  if((atkPosition2+1<ownField.length)&&(ownField[atkPosition2].equals("X"))&&!(ownField[atkPosition2+1].equals("X")||ownField[atkPosition2+1].equals("H"))){
                    atkPosition2=atkPosition2+1;
                  }else if((atkPosition2-1>=0)&&(ownField[atkPosition2].equals(3))&&!(ownField[atkPosition2-1].equals("X")||ownField[atkPosition2-1].equals("H"))){
                    atkPosition2=atkPosition2-1;
                  }else{
                    atkPosition2 = (int)(Math.random()*(userInSize-1));
                  }
                  if(!(ownField[atkPosition2].equals("X")||ownField[atkPosition2].equals("H"))){
                    break;
                  }
                }
                // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
                //opponent attack action
                if(ownField[atkPosition2].equals("O")){
                  ownField[atkPosition2] = "H";
                  System.out.println("Opponent hit tile "+(atkPosition2+1)+"! The tile was empty!");
                  break;
                }else if(ownField[atkPosition2].equals("S")){
                  ownField[atkPosition2] = "X";
                  System.out.println("Oh no! The opponent shot a ship at tile "+(atkPosition2+1)+"!");
                  playerHit++;
                  if(playerHit == totalHit){
                    break;
                  }
                }
              }
              if(playerHit == totalHit){
                break;
              }
            }
            // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
            System.out.println();
            //result print
            if(playerHit>opponentHit){
              System.out.println("GAME OVER. You've lost all ships!");
              System.out.println("Opponent ships were placed at following positions:\n   O = Empty Field,    S = Ship");
              for(int j = 0; j < userInSize; j+=25){
                for(int x = 0; x<25&&((j+x)<userInSize);x++){
                    System.out.print("   "+oppField[j+x]);
                }
                System.out.println();
                for(int x = 0; x<25&&((j+x)<userInSize);x++){
                  System.out.printf(" %3d",(j+x+1));
                }
                System.out.println();
              }
            }else if(playerHit<opponentHit){
              System.out.println("Congrations! You've destroyed all enemy ships!");
            }else if(playerHit==opponentHit){
              System.out.println("Looks like the game is a draw!");
            }
            System.out.println("It took "+atkCount+" turn(s)");
            break;
          // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
          // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
          //             D O U B L E      P L A Y E R      C U S T O M
          // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
          // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
          }else if(gameMode == 12){//double player
            System.out.println("You have selected to play player 1 vs player 2");
            
            while(true){
              //creating the field based on input
              System.out.println("Please enter a positive integer greater than 1:");
              System.out.println("How many tiles would you like in your field?");
              userInSize = in.nextInt();
              
              if(userInSize > 1){
                break;
              }else{
                System.out.println("Invalid input! Please retry.");
              }
            }
            String [] ownField = new String[userInSize];
            String [] oppField = new String[userInSize];
            String [] atkFieldP1 = new String[userInSize];
            String [] atkFieldP2 = new String[userInSize];
            
            // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
            for(int i = 0; i < userInSize; i++){
              //filling the Fields with O and atk field with ?
              ownField[i] = oppField[i] = "O";
              atkFieldP1[i] = atkFieldP2[i] = "?";
            }
            // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
            System.out.println();
            System.out.println("Please enter a non zero positive integer which is less than the field size:");
            
            while(true){
              //input ship number
              System.out.println("How many ships would you like to use?");
              userInShipNum = in.nextInt();
              
              if((userInShipNum < userInSize) && (userInShipNum > 0)){
                break;
              }else{
                System.out.println("Invalid input! Please retry.");
              }
            }
            
            // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
            
            ////START OF NEW CODE: SHIP LENGTH
            
            for(int i = 1; i <= userInShipNum; i++){
              System.out.println("Ship "+i+":");
              System.out.println("What would you like to be the ship size?\nMinimum size: 1 tile and maximum size: 10 tiles\n**Ship size is same for both players.");
              while(true){
                //input ship size
                userInShipSize = in.nextInt();
                if(userInShipSize<1){
                  System.out.println("Invalid input! Please retry.");
                }else if(userInShipSize>10){
                  System.out.println("Ship is too big! Please retry.");
                }else{
                  break;
                }
              }
              // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
              totalHit += userInShipSize;
              while(true){
                //input ships in ownField
                System.out.println("Player 1: Where would you like to place this ship?");
                System.out.println("Please enter numbers which signify the tile number of the ships.\nThe number should be between 1 to "+(userInSize-userInShipSize+1)+" inclusive.");
                while(true){
                  //input ship position
                  userInPosition = in.nextInt();
                  if(userInPosition <= 0){
                    System.out.println("Invalid input! Please retry.");
                  }else if(userInPosition + userInShipSize -1 > userInSize){
                    System.out.println("Out of bounds! Please retry.");
                  }else{
                    break;
                  }
                }
                placeBlock = 0;
                //block check
                for(int q = userInPosition; q<userInPosition+userInShipSize; q++){
                  if(ownField[q-1].equals("S")){
                    placeBlock++;
                  }else{}
                }
                if(placeBlock > 0){
                  System.out.println("That position is already occupied. Please retry.");
                }else{
                  break;
                }
              }
              //Placing ships
              for(int q = userInPosition; q<userInPosition+userInShipSize; q++){
                ownField[q-1] = "S";
              }
              // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
              while(true){
                //input ships in oppField
                System.out.println("Player 2: Where would you like to place this ship?");
                System.out.println("Please enter numbers which signify the tile number of the ships.\nThe number should be between 1 to "+(userInSize-userInShipSize+1)+" inclusive.");
                while(true){
                  //input ship position
                  oppPosition = in.nextInt();
                  if(oppPosition <= 0){
                    System.out.println("Invalid input! Please retry.");
                  }else if(oppPosition + userInShipSize -1 > userInSize){
                    System.out.println("Out of bounds! Please retry.");
                  }else{
                    break;
                  }
                }
                placeBlock = 0;
                //block check
                for(int q = oppPosition; q<oppPosition+userInShipSize; q++){
                  if(oppField[q-1].equals("S")){
                    placeBlock++;
                  }else{}
                }
                if(placeBlock > 0){
                  System.out.println("That position is already occupied. Please retry.");
                }else{
                  break;
                }
              }
              //Placing ships
              for(int q = oppPosition; q<oppPosition+userInShipSize; q++){
                oppField[q-1] = "S";
              }
            }
            // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
            System.out.println("The game now begins!\n");
            
            while(playerHit < totalHit && opponentHit < totalHit){
              //GAME: View tiles
              atkCount++;
              
              System.out.println("O = Empty Field       S = Ship       ? = Unknown\nH = Already Hit Tile        X = Already Hit Ship");
              System.out.println();
              for(int i = 0; i < userInSize; i+=25){
                System.out.print("Player 1 field  :");
                for(int x = 0; x<25&&((i+x)<userInSize);x++){
                  System.out.print("   "+atkFieldP1[i+x]);
                }
                System.out.println();
                System.out.print("                 ");
                for(int x = 0; x<25&&((i+x)<userInSize);x++){
                  System.out.printf(" %3d",(i+x+1));
                }
                System.out.println();
                System.out.print("Player 2 field  :");
                for(int x = 0; x<25&&((i+x)<userInSize);x++){
                  System.out.print("   "+atkFieldP2[i+x]);
                }
                System.out.println("\n");
              }
              System.out.println();
              // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
              //GAME: player 1 attack
              if(atkCount == 1){
                System.out.println("Player 1 gets the first attack!");
              }else{}
              while(true){
                System.out.println("Player 1's turn");
                System.out.println("Player2 ship tile remaining:"+(totalHit-opponentHit));
                while(true){
                  //input player 1 attack position
                  System.out.println("Where would you like to attack?");
                  atkPosition = in.nextInt();
                  if(atkPosition == 31415926){
                    break;
                  }else if((atkPosition <= 0) || (atkPosition > userInSize)){
                    System.out.println("Invalid input! Please retry.");
                  }else if(atkFieldP2[atkPosition-1].equals("X")||atkFieldP2[atkPosition-1].equals("H")){
                    System.out.println("You've already attacked the tile "+atkPosition+". Please retry.");
                  }else{
                    break;
                  }
                }
                // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
                if(atkPosition == 31415926){
                  break;
                }else{
                  //player 1 attack action
                  if(oppField[atkPosition-1].equals("O")){
                    atkFieldP2[atkPosition-1] = "H";
                    oppField[atkPosition-1] = "H";
                    System.out.println("The tile was empty!");
                    break;
                  }else if(oppField[atkPosition-1].equals("S")){
                    atkFieldP2[atkPosition-1] = "X";
                    oppField[atkPosition-1] = "X";
                    System.out.println("Great! You shot an enemy ship!");
                    opponentHit++;
                    if(opponentHit == totalHit){
                      break;
                    }else{
                      // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
                      //Player1 bonus turn
                      System.out.println("O = Empty Field     S = Ship     ? = Unknown\nH = Already Hit Tile    X = Already Hit Ship");
                      System.out.println();
                      for(int i = 0; i < userInSize; i+=25){
                        System.out.print("Player 1 field  :");
                        for(int x = 0; x<25&&((i+x)<userInSize);x++){
                          System.out.print("   "+atkFieldP1[i+x]);
                        }
                        System.out.println();
                        System.out.print("                 ");
                        for(int x = 0; x<25&&((i+x)<userInSize);x++){
                          System.out.printf(" %3d",(i+x+1));
                        }
                        System.out.println();
                        System.out.print("Player 2 field  :");
                        for(int x = 0; x<25&&((i+x)<userInSize);x++){
                          System.out.print("   "+atkFieldP2[i+x]);
                        }
                        System.out.println("\n");
                      }
                      System.out.println();
                    }
                  }
                }
              }
              // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
              if(atkPosition == 31415926){
                System.out.println("Since you are too awesome to play, let's end the game here.");
                break;
              }else if(opponentHit == totalHit){
                break;
              }
              //GAME: player 2 attack 
              while(true){
                System.out.println("Player 2's turn");
                System.out.println("Player1 ship tile remaining:"+(totalHit-playerHit));
                while(true){
                  //input player 2 attack position
                  System.out.println("Where would you like to attack?");
                  atkPosition = in.nextInt();
                  if(atkPosition == 31415926){
                    break;
                  }else if((atkPosition <= 0) || (atkPosition > userInSize)){
                    System.out.println("Invalid input! Please retry.");
                  }else if(atkFieldP1[atkPosition-1].equals("X")||atkFieldP1[atkPosition-1].equals("H")){
                    System.out.println("You've already attacked the tile "+atkPosition+". Please retry.");
                  }else{
                    break;
                  }
                }
                // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
                if(atkPosition == 31415926){
                  break;
                }else{
                  //player 2 attack action
                  if(ownField[atkPosition-1].equals("O")){
                    atkFieldP1[atkPosition-1] = "H";
                    ownField[atkPosition-1] = "H";
                    System.out.println("The tile was empty!");
                    break;
                  }else if(ownField[atkPosition-1].equals("S")){
                    atkFieldP1[atkPosition-1] = "X";
                    ownField[atkPosition-1] = "X";
                    System.out.println("Great! You shot an enemy ship!");
                    playerHit++;
                    if(playerHit == totalHit){
                      break;
                    }else{
                      // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
                      //Player2 bonus turn
                      System.out.println("O = Empty Field     S = Ship     ? = Unknown\nH = Already Hit Tile    X = Already Hit Ship");
                      System.out.println();
                      for(int i = 0; i < userInSize; i+=25){
                        System.out.print("Player 1 field  :");
                        for(int x = 0; x<25&&((i+x)<userInSize);x++){
                          System.out.print("   "+atkFieldP1[i+x]);
                        }
                        System.out.println();
                        System.out.print("                 ");
                        for(int x = 0; x<25&&((i+x)<userInSize);x++){
                          System.out.printf(" %3d",(i+x+1));
                        }
                        System.out.println();
                        System.out.print("Player 2 field  :");
                        for(int x = 0; x<25&&((i+x)<userInSize);x++){
                          System.out.print("   "+atkFieldP2[i+x]);
                        }
                        System.out.println("\n");
                      }
                      System.out.println();
                    }
                  }
                }
              }
              // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
              if(atkPosition == 31415926){
                System.out.println("Since you are too awesome to play, let's end the game here.");
                break;
              }
              else if(playerHit == totalHit){
                break;
              }
            }
            // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
            System.out.println();
            //result print
            if(playerHit>opponentHit){
              System.out.println("GAME OVER. Player 1 has lost all ships! Player 2 wins!");
              System.out.println("Player 2's ships were placed at following positions:");
              for(int j = 0; j < userInSize; j+=25){
                for(int x = 0; x<25&&((j+x)<userInSize);x++){
                    System.out.print("   "+oppField[j+x]);
                }
                System.out.println();
                for(int x = 0; x<25&&((j+x)<userInSize);x++){
                  System.out.printf(" %3d",(j+x+1));
                }
                System.out.println();
              }
              // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
            }else if(playerHit<opponentHit){
              System.out.println("GAME OVER. Player 2 has lost all ships! Player 1 wins!");
              System.out.println("Player 1's ships were placed at following positions:");
              for(int j = 0; j < userInSize; j+=25){
                for(int x = 0; x<25&&((j+x)<userInSize);x++){
                    System.out.print("   "+ownField[j+x]);
                }
                System.out.println();
                for(int x = 0; x<25&&((j+x)<userInSize);x++){
                  System.out.printf(" %3d",(j+x+1));
                }
                System.out.println();
              }
            }else if(playerHit==opponentHit){
              System.out.println("Looks like the game is a draw!");
            }
            System.out.println("It took "+atkCount+" turn(s)");
            break;
          // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
          // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
          //             S I N G L E      P L A Y E R      D E F A U L T
          // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
          // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
          }else if(gameMode == 01){//single player default
            System.out.println("You have selected to play single player vs computer on default settings\n");
            
            userInSize = 100;
            
            String [] ownField = new String[userInSize];
            String [] oppField = new String[userInSize];
            String [] atkField = new String[userInSize];
            
            // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
            for(int i = 0; i < userInSize; i++){
              //filling the Fields with O and atk field with ?
              ownField[i] = oppField[i] = "O";
              atkField[i] = "?";
            }
            
            userInShipNum = 7;
            //ship size array
            int[] shipSizeAr = {1,2,3,4,5,6,7};

            for(int i = 0; i < userInShipNum; i++){
              userInShipSize = shipSizeAr[i]; 
              totalHit += userInShipSize;
              // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
              while(true){
                while(true){
                  //randomized ship position in ownField
                  userInPosition = (int)(Math.random()*(userInSize-1));
                  if(userInPosition+userInShipSize<userInSize){
                    break;
                  }
                }
                
                placeBlock = 0;
                //block check
                for(int q = userInPosition; q<userInPosition+userInShipSize; q++){
                  if(ownField[q].equals("S")){
                    placeBlock++;
                  }else{}
                }
                if(placeBlock == 0){break;}
              }
              for(int q = userInPosition; q<userInPosition+userInShipSize; q++){
                ownField[q] = "S";
              }
              // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
              while(true){
                while(true){
                  //randomized ship position in opponentField
                  oppPosition = (int)(Math.random()*(userInSize-1));
                  if(oppPosition+userInShipSize<userInSize){
                    break;
                  }
                }
                
                placeBlock = 0;
                //block check
                for(int q = oppPosition; q<oppPosition+userInShipSize; q++){
                  if(oppField[q].equals("S")){
                    placeBlock++;
                  }else{}
                }
                if(placeBlock == 0){break;}
              }
              
              for(int q = oppPosition; q<oppPosition+userInShipSize; q++){
                oppField[q] = "S";
              }
            }
            
            // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
            System.out.println();
            System.out.println("The game now begins!\n");
            
            while(playerHit < totalHit && opponentHit < totalHit){
              //GAME: View tiles - ORGANIZED
              atkCount++;
              System.out.println("O = Empty Field     S = Ship     ? = Unknown\nH = Already Hit Tile    X = Already Hit Ship");
              System.out.println();
              for(int i = 0; i < userInSize; i+=25){
                System.out.print("    Your field  :");
                for(int x = 0; x<25&&((i+x)<userInSize);x++){
                  System.out.print("   "+ownField[i+x]);
                }
                System.out.println();
                System.out.print("                 ");
                for(int x = 0; x<25&&((i+x)<userInSize);x++){
                  System.out.printf(" %3d",(i+x+1));
                }
                System.out.println();
                System.out.print("Opponent field  :");
                for(int x = 0; x<25&&((i+x)<userInSize);x++){
                  System.out.print("   "+atkField[i+x]);
                }
                System.out.println("\n");
              }
              // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
              //GAME: player attack
              if(atkCount == 1){
                System.out.println("You get the first attack!");
              }else{}
              while(true){
                System.out.println("Your turn");
                System.out.println("Enemy ship tile remaining:"+(totalHit-opponentHit));
                while(true){
                  //input player attack position
                  System.out.println("Where would you like to attack?");
                  atkPosition = in.nextInt();
                  if(atkPosition == 31415926){
                    break;
                  }else if((atkPosition <= 0) || (atkPosition > userInSize)){
                    System.out.println("Invalid input! Please retry.");
                  }else if(atkField[atkPosition-1].equals("X")||atkField[atkPosition-1].equals("H")){
                    System.out.println("You've already attacked the tile "+atkPosition+". Please retry.");
                  }else{
                    break;
                  }
                }
                // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
                if(atkPosition == 31415926){
                  break;
                }else{
                  //player attack action
                  if(oppField[atkPosition-1].equals("O")){
                    atkField[atkPosition-1] = "H";
                    oppField[atkPosition-1] = "H";
                    System.out.println("The tile was empty!");
                    break;
                  }else if(oppField[atkPosition-1].equals("S")){
                    atkField[atkPosition-1] = "X";
                    oppField[atkPosition-1] = "X";
                    System.out.println("Great! You shot an enemy ship!");
                    opponentHit++;
                    if(opponentHit == totalHit){
                      break;
                    }else{
                      // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
                      //Player bonus turn
                      System.out.println("O = Empty Field     S = Ship     ? = Unknown\nH = Already Hit Tile    X = Already Hit Ship");
                      System.out.println();
                      for(int i = 0; i < userInSize; i+=25){
                        System.out.print("    Your field  :");
                        for(int x = 0; x<25&&((i+x)<userInSize);x++){
                          System.out.print("   "+ownField[i+x]);
                        }
                        System.out.println();
                        System.out.print("                 ");
                        for(int x = 0; x<25&&((i+x)<userInSize);x++){
                          System.out.printf(" %3d",(i+x+1));
                        }
                        System.out.println();
                        System.out.print("Opponent field  :");
                        for(int x = 0; x<25&&((i+x)<userInSize);x++){
                          System.out.print("   "+atkField[i+x]);
                        }
                        System.out.println("\n");
                      }
                    }
                  }
                }
              }
              // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
              if(atkPosition == 31415926){
                System.out.println("Since you are too awesome to play, let's end the game here.");
                break;
              }else if(opponentHit == totalHit){
                break;
              }
              // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
              //GAME: opponent attack 
              while(true){
                System.out.println("Opponent's turn");
                while(true){
                  //random opponent attack position
                  if((atkPosition2+1<ownField.length)&&(ownField[atkPosition2].equals("X"))&&!(ownField[atkPosition2+1].equals("X")||ownField[atkPosition2+1].equals("H"))){
                    atkPosition2=atkPosition2+1;
                  }else if((atkPosition2-1>=0)&&(ownField[atkPosition2].equals(3))&&!(ownField[atkPosition2-1].equals("X")||ownField[atkPosition2-1].equals("H"))){
                    atkPosition2=atkPosition2-1;
                  }else{
                    atkPosition2 = (int)(Math.random()*(userInSize-1));
                  }
                  if(!(ownField[atkPosition2].equals("X")||ownField[atkPosition2].equals("H"))){
                    break;
                  }
                }
                // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
                //opponent attack action
                if(ownField[atkPosition2].equals("O")){
                  ownField[atkPosition2] = "H";
                  System.out.println("Opponent hit tile "+(atkPosition2+1)+"! The tile was empty!");
                  break;
                }else if(ownField[atkPosition2].equals("S")){
                  ownField[atkPosition2] = "X";
                  System.out.println("Oh no! The opponent shot a ship at tile "+(atkPosition2+1)+"!");
                  playerHit++;
                  if(playerHit == totalHit){
                    break;
                  }
                }
              }
              if(playerHit == totalHit){
                break;
              }
            }
            // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
            System.out.println();
            //result print
            if(playerHit>opponentHit){
              System.out.println("GAME OVER. You've lost all ships!");
              System.out.println("Opponent ships were placed at following positions:");
              for(int j = 0; j < userInSize; j+=25){
                for(int x = 0; x<25&&((j+x)<userInSize);x++){
                    System.out.print("   "+oppField[j+x]);
                }
                System.out.println();
                for(int x = 0; x<25&&((j+x)<userInSize);x++){
                  System.out.printf(" %3d",(j+x+1));
                }
                System.out.println();
              }
              // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
            }else if(playerHit<opponentHit){
              System.out.println("Congrations! You've destroyed all enemy ships!");
            }else if(playerHit==opponentHit){
              System.out.println("Looks like the game is a draw!");
            }
            System.out.println("It took "+atkCount+" turn(s)");
            break;
          // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
          // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
          //             D O U B L E      P L A Y E R      D E F A U L T
          // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
          // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
          }else if(gameMode == 02){//double player
            System.out.println("You have selected to play player 1 vs player 2 on default settings\n");
            userInSize = 100;
            String [] ownField = new String[userInSize];
            String [] oppField = new String[userInSize];
            String [] atkFieldP1 = new String[userInSize];
            String [] atkFieldP2 = new String[userInSize];
            
            // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
            
            for(int i = 0; i < userInSize; i++){
              //filling the Fields with O and atk field with ?
              ownField[i] = oppField[i] = "O";
              atkFieldP1[i] = atkFieldP2[i]= "?";
            }
            
            userInShipNum = 7;
            //ship size array
            int[] shipSizeAr = {1,2,3,4,5,6,7};

            for(int i = 0; i < userInShipNum; i++){
              userInShipSize = shipSizeAr[i]; 
              totalHit += userInShipSize;
              // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
              while(true){
                while(true){
                  //randomized ship position in ownField
                  userInPosition = (int)(Math.random()*(userInSize-1));
                  if(userInPosition+userInShipSize<userInSize){
                    break;
                  }
                }
                
                placeBlock = 0;
                //block check
                for(int q = userInPosition; q<userInPosition+userInShipSize; q++){
                  if(ownField[q].equals("S")){
                    placeBlock++;
                  }else{}
                }
                if(placeBlock == 0){break;}
              }
              for(int q = userInPosition; q<userInPosition+userInShipSize; q++){
                ownField[q] = "S";
              }
              // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
              while(true){
                while(true){
                  //randomized ship position in opponentField
                  oppPosition = (int)(Math.random()*(userInSize-1));
                  if(oppPosition+userInShipSize<userInSize){
                    break;
                  }
                }
                
                placeBlock = 0;
                //block check
                for(int q = oppPosition; q<oppPosition+userInShipSize; q++){
                  if(oppField[q].equals("S")){
                    placeBlock++;
                  }else{}
                }
                if(placeBlock == 0){break;}
              }
              
              for(int q = oppPosition; q<oppPosition+userInShipSize; q++){
                oppField[q] = "S";
              }
              
            }
            // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
            System.out.println("The game now begins!\n");
            
            while(playerHit < totalHit && opponentHit < totalHit){
              //GAME: View tiles
              atkCount++;
              System.out.println("O = Empty Field     S = Ship     ? = Unknown\nH = Already Hit Tile    X = Already Hit Ship");
              System.out.println();
              for(int i = 0; i < userInSize; i+=25){
                System.out.print("Player 1 field  :");
                for(int x = 0; x<25&&((i+x)<userInSize);x++){
                  System.out.print("   "+atkFieldP1[i+x]);
                }
                System.out.println();
                System.out.print("                 ");
                for(int x = 0; x<25&&((i+x)<userInSize);x++){
                  System.out.printf(" %3d",(i+x+1));
                }
                System.out.println();
                System.out.print("Player 2 field  :");
                for(int x = 0; x<25&&((i+x)<userInSize);x++){
                  System.out.print("   "+atkFieldP2[i+x]);
                }
                System.out.println("\n");
              }
              System.out.println();
              // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
              //GAME: player 1 attack
              if(atkCount == 1){
                System.out.println("Player 1 gets the first attack!");
              }else{}
              while(true){
                System.out.println("Player 1's turn");
                System.out.println("Player2 ship tile remaining:"+(totalHit-opponentHit));
                while(true){
                  //input player 1 attack position
                  System.out.println("Where would you like to attack?");
                  atkPosition = in.nextInt();
                  if(atkPosition == 31415926){
                    break;
                  }else if((atkPosition <= 0) || (atkPosition > userInSize)){
                    System.out.println("Invalid input! Please retry.");
                  }else if(atkFieldP2[atkPosition-1].equals("X")||atkFieldP2[atkPosition-1].equals("H")){
                    System.out.println("You've already attacked the tile "+atkPosition+". Please retry.");
                  }else{
                    break;
                  }
                }
                // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
                if(atkPosition == 31415926){
                  break;
                }else{
                  //player 1 attack action
                  if(oppField[atkPosition-1].equals("O")){
                    atkFieldP2[atkPosition-1] = "H";
                    oppField[atkPosition-1] = "H";
                    System.out.println("The tile was empty!");
                    break;
                  }else if(oppField[atkPosition-1].equals("S")){
                    atkFieldP2[atkPosition-1] = "X";
                    oppField[atkPosition-1] = "X";
                    System.out.println("Great! You shot an enemy ship!");
                    opponentHit++;
                    if(opponentHit == totalHit){
                      break;
                    }else{
                      // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
                      //Player1 bonus turn
                      System.out.println("O = Empty Field     S = Ship     ? = Unknown\nH = Already Hit Tile    X = Already Hit Ship");
                      System.out.println();
                      for(int i = 0; i < userInSize; i+=25){
                        System.out.print("Player 1 field  :");
                        for(int x = 0; x<25&&((i+x)<userInSize);x++){
                          System.out.print("   "+atkFieldP1[i+x]);
                        }
                        System.out.println();
                        System.out.print("                 ");
                        for(int x = 0; x<25&&((i+x)<userInSize);x++){
                          System.out.printf(" %3d",(i+x+1));
                        }
                        System.out.println();
                        System.out.print("Player 2 field  :");
                        for(int x = 0; x<25&&((i+x)<userInSize);x++){
                          System.out.print("   "+atkFieldP2[i+x]);
                        }
                        System.out.println("\n");
                      }
                      System.out.println();
                    }
                  }
                }
              }
              // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
              if(atkPosition == 31415926){
                System.out.println("Since you are too awesome to play, let's end the game here.");
                break;
              }else if(opponentHit == totalHit){
                break;
              }
              //GAME: player 2 attack 
              while(true){
                System.out.println("Player 2's turn");
                System.out.println("Player1 ship tile remaining:"+(totalHit-playerHit));
                while(true){
                  //input player 2 attack position
                  System.out.println("Where would you like to attack?");
                  atkPosition = in.nextInt();
                  if(atkPosition == 31415926){
                    break;
                  }else if((atkPosition <= 0) || (atkPosition > userInSize)){
                    System.out.println("Invalid input! Please retry.");
                  }else if(atkFieldP1[atkPosition-1].equals("X")||atkFieldP1[atkPosition-1].equals("H")){
                    System.out.println("You've already attacked the tile "+atkPosition+". Please retry.");
                  }else{
                    break;
                  }
                }
                // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
                if(atkPosition == 31415926){
                  break;
                }else{
                  //player 2 attack action
                  if(ownField[atkPosition-1].equals("O")){
                    atkFieldP1[atkPosition-1] = "H";
                    ownField[atkPosition-1] = "H";
                    System.out.println("The tile was empty!");
                    break;
                  }else if(ownField[atkPosition-1].equals("S")){
                    atkFieldP1[atkPosition-1] = "X";
                    ownField[atkPosition-1] = "X";
                    System.out.println("Great! You shot an enemy ship!");
                    playerHit++;
                    if(playerHit == totalHit){
                      break;
                    }else{
                      // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
                      //Player2 bonus turn
                      System.out.println("O = Empty Field     S = Ship     ? = Unknown\nH = Already Hit Tile    X = Already Hit Ship");
                      System.out.println();
                      for(int i = 0; i < userInSize; i+=25){
                        System.out.print("Player 1 field  :");
                        for(int x = 0; x<25&&((i+x)<userInSize);x++){
                          System.out.print("   "+atkFieldP1[i+x]);
                        }
                        System.out.println();
                        System.out.print("                 ");
                        for(int x = 0; x<25&&((i+x)<userInSize);x++){
                          System.out.printf(" %3d",(i+x+1));
                        }
                        System.out.println();
                        System.out.print("Player 2 field  :");
                        for(int x = 0; x<25&&((i+x)<userInSize);x++){
                          System.out.print("   "+atkFieldP2[i+x]);
                        }
                        System.out.println("\n");
                      }
                      System.out.println();
                    }
                  }
                }
              }
              // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
              if(atkPosition == 31415926){
                System.out.println("Since you are too awesome to play, let's end the game here.");
                break;
              }
              else if(playerHit == totalHit){
                break;
              }
              
            }
            // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
            System.out.println();
            //result print
            if(playerHit>opponentHit){
              System.out.println("GAME OVER. Player 1 has lost all ships! Player 2 wins!");
              System.out.println("Player 2's ships were placed at following positions:");
              for(int j = 0; j < userInSize; j+=25){
                for(int x = 0; x<25&&((j+x)<userInSize);x++){
                    System.out.print("   "+oppField[j+x]);
                }
                System.out.println();
                for(int x = 0; x<25&&((j+x)<userInSize);x++){
                  System.out.printf(" %3d",(j+x+1));
                }
                System.out.println();
              }
              // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
            }else if(playerHit<opponentHit){
              System.out.println("GAME OVER. Player 2 has lost all ships! Player 1 wins!");
              System.out.println("Player 1's ships were placed at following positions:");
              for(int j = 0; j < userInSize; j+=25){
                for(int x = 0; x<25&&((j+x)<userInSize);x++){
                    System.out.print("   "+ownField[j+x]);
                }
                System.out.println();
                for(int x = 0; x<25&&((j+x)<userInSize);x++){
                  System.out.printf(" %3d",(j+x+1));
                }
                System.out.println();
              }
            }else if(playerHit==opponentHit){
              System.out.println("Looks like the game is a draw!");
            }
            System.out.println("It took "+atkCount+" turn(s)");
            break;
          }else{
            System.out.println("Invalid input! Please retry.");
          }
        }
        // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
      }else if(userInStartVar == 2){//credits
        System.out.println("CREDITS");
        System.out.println("The following students of section 14 of CSE110 course made this simplified battlefield game as a group project under Mr. Abdullah:");
        System.out.println("1. KM ABDULLAH AL MARUF     (ID:19101487)");
        System.out.println("2. RIFAH TASMIAH ISLAM      (ID:19101459)");
        System.out.println("3. SIKANDER SOFIA SAFRINA   (ID:19101234)");
        System.out.println("4. AVINANDAN BANERJEE       (ID:19101541)");
        
      }else if(userInStartVar == 3){//instructions
        System.out.println("Instructions:");
        System.out.println("This is a one dimentional version of the battlefield board game.\nJust follow the game user interface to complete.");
        
            //// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        System.out.println("The game can be played with both default settings and custom settings.\nIn either case, there will be two fields of same length or same number of tiles.");
        System.out.println("The size and number of the ships are the same for both players.\nThe differences between default and custom settings are:\n");
        System.out.println("  Object            -        In Default Game        -        In Custom Game        ");
        System.out.println("");
        System.out.println("  Field Size        -               100             -         User Defined         ");
        System.out.println("  Number of ships   -                7              -         User Defined         ");
        System.out.println("  Ship Length       -  {1, 2, 3, 4, 5, 6, 7} tiles  -   User Defined (maximum 10)  ");
        System.out.println("  Ship Placing      -          Randomly placed       -        User Defined         ");
        System.out.println("\n");
        System.out.println("If you're playing with custom settings, you're going to have to set your parameters first and then start attacking the opponent.");
        System.out.println("If you're playing with default settings, you start off the game right away.");
        System.out.println("\n");
        System.out.println("How to play:");
        System.out.println("Just enter the position of the block or the tile number where you'd want to attack in the opponent's field.");
        System.out.println("If there is a ship in that position, you get to attack again!\nAttack and destroy all the opponent's ship blocks to win the game.");
            //// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -        
      }else{//invalid
        System.out.println("Invalid input! Please retry.");
      }
      
      System.out.println();
      System.out.print("Please enter -\n1 - To play");
      if(playCount>0){
        System.out.println(" again.");
      }else{
        System.out.println(".");
      }
      System.out.println("2 - To view credits.\n3 - To read instructions.\n0 - To exit the program.");
      // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    }
    
    in.close();
    
  }
  
}