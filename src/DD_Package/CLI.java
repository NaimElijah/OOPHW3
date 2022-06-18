package DD_Package;
import java.util.Scanner;

public class CLI {

    public static void main(String[] args) {  /////  all the sout's and visuals are here
        Scanner reader = new Scanner(System.in);  // this will read the user's input

        System.out.println("Select player:"); /// the player selection screen
        System.out.println("1. Jon Snow ");  /// stats
        System.out.println("");
        System.out.println("2. The Hound ");  /// stats
        System.out.println("");
        System.out.println("3. Melisandre ");  /// stats
        System.out.println("");
        System.out.println("4. Thoros of Myr ");  /// stats
        System.out.println("");
        System.out.println("5. Arya Stark ");  /// stats
        System.out.println("");
        System.out.println("6. Bronn ");  /// stats
        System.out.println("");

        //  first the representation of all the players, ordered by their types, is shown and the player picks a player, receive that in player
        int player = reader.nextInt(); // Scans the next token of the input as an int.

        System.out.println("You have selected:");
        if (player == 1){ System.out.println("Jon Snow");}
        else if(player == 2){System.out.println("The Hound");}
        else if(player == 3){System.out.println("Melisandre");}
        else if(player == 4){System.out.println("Thoros of Myr");}
        else if(player == 5){System.out.println("Arya Stark");}
        else if(player == 6){System.out.println("Bronn");}

        //////////  get the arguments file_path, playerint from args like in the practical lesson with Tal(in pictures) and send it to the Game_Board
        Game_Board game = new Game_Board(args[1], player);   ////////  gets the file_path and the player and builds
        //////////  if we want we can get the_player, the Monsters and the Traps from the Game_Board game
        String move;

        for() {  ////  amount of levels
            while (game.getThe_player().getHealth().getHealth_amount() > 0 &&) {  ///  at the end of each iteration soutln the current board standings
                move = reader.nextLine();
                if(move.equals("w")){    //////  up !!

                } else if (move.equals("s")) {    ////// down !!



                }else if (move.equals("a")) {    ////// left !!



                }else if (move.equals("d")) {    ////// right !!



                }else if (move.equals("e")) {    ////// special ability !!



                }else if (move.equals("q")) {    ////// do nothing !!



                }
            }
        }
        }
    }
}
