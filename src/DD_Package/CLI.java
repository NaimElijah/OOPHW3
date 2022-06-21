package DD_Package;
import java.util.Scanner;

public class CLI {
    public static void main(String[] args) {  /////  all the sout's and visuals are here
        boolean is_game_again = true;
        while (is_game_again){
            Scanner reader = new Scanner(System.in);  // this will read the user's input

            System.out.println("Select player:"); /// the player selection screen
            System.out.println("Warriors:");
            System.out.println("1. Jon Snow          Health: 300/300          Attack: 30          Defense: 4          Level: 1");  /// stats
            System.out.println("          Experience: 0/50          Cooldown: 0/3");
            System.out.println();
            System.out.println("2. The Hound          Health: 400/400          Attack: 20          Defense: 6          Level: 1");  /// stats
            System.out.println("          Experience: 0/50          Cooldown: 0/5");
            System.out.println();
            System.out.println("Mages:");
            System.out.println("3. Melisandre          Health: 100/100          Attack: 5          Defense: 1          Level: 1");  /// stats
            System.out.println("          Experience: 0/50          Mana: 75/300          Spell Power: 15");
            System.out.println();
            System.out.println("4. Thoros of Myr          Health: 250/250          Attack: 25          Defense: 4          Level: 1");  /// stats
            System.out.println("          Experience: 0/50          Mana: 37/150          Spell Power: 20");
            System.out.println();
            System.out.println("Rogues:");
            System.out.println("5. Arya Stark          Health: 150/150          Attack: 40          Defense: 2          Level: 1");  /// stats
            System.out.println("          Experience: 0/50          Energy: 100/100");
            System.out.println();
            System.out.println("6. Bronn          Health: 250/250          Attack: 35          Defense: 3          Level: 1");  /// stats
            System.out.println("          Experience: 0/50          Energy: 100/100");

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

//        System.out.println(game.getArrays_Board());  and print the game with it's toString()
            //////////  if we want we can get the_player, the Monsters and the Traps from the Game_Board game
            String move;
            int level = 0;

            while () {  ////  amount of levels
                level++;
                Game_Board game = new Game_Board("D:\\levels_dir\\levels_dir\\level" + level +".txt", player);   ////////  gets the file_path and the player and builds
//                Game_Board game = new Game_Board(args[0] + "\\level" + level +".txt", player);   ////////  gets the file_path and the player and builds

                System.out.println(game);
                while (game.getThe_player().getHealth().getHealth_amount() > 0 &&) {  ///  at the end of each iteration soutln the current board standings
                    move = reader.nextLine();
                    if(move.equals("w")){    //////  up !!

                    } else if (move.equals("s")) {    ////// down !!



                    }else if (move.equals("a")) {    ////// left !!



                    }else if (move.equals("d")) {    ////// right !!



                    }else if (move.equals("e")) {    ////// special ability !!



                    }else if (move.equals("q")) {    ////// do nothing !!



                    }

                    //////  now do the tick_do of the player, then run over the monsters and do each of their ticks, same with the traps.
                }
            }
            System.out.println("Do you want to play again ? (enter: yes or no)");
            String yes_or_no = reader.nextLine();
            is_game_again = yes_or_no == "yes";
        }

    }
}
