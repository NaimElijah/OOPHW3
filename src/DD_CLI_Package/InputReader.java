package DD_CLI_Package;
import DD_Bussiness_Package.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InputReader {
    protected String file_path;
    protected int player;
    protected ArrayList<Monster> Monsters;
    protected ArrayList<Trap> Traps;
    protected Player the_player;

    public InputReader(String file_path, int player){
        this.file_path = file_path;
        this.player = player;
        this.Monsters = new ArrayList<Monster>();
        this.Traps = new ArrayList<Trap>();
    }

    public void setFile_path(String file_path) { this.file_path = file_path; }   ///////  we can use this to change to the next level and then perform Read() again so the next level loads up

    public Player getThe_player() {
        return this.the_player;
    }
    public ArrayList<Monster> getMonsters() {
        return this.Monsters;
    }
    public ArrayList<Trap> getTraps() {
        return this.Traps;
    }

    /////////////////////////////////  listen to my recordings and read the rest of the assignment before continuation  ///////////////////
    public void Read(Game_Board game_board){  ////  maybe just use the Read() again when we move up a level, before returned ArrayList<ArrayList<Tile>>
        ArrayList<ArrayList<Tile>> res = new ArrayList<ArrayList<Tile>>();
        List<String> lines = Collections.emptyList();

        try{
            lines = Files.readAllLines(Paths.get(this.file_path));
        }catch (IOException e){
// we're using a for on the exact amount so no need for this:    System.out.println("Game over"); //////  can't read "level<i>.txt" because it doesnt exist, not needed because we get the amount of levels
            System.out.println(e.getMessage() + "\n" + e.getStackTrace());
        }

        int amount_of_lines = lines.size();
        int line_length = lines.get(0).length();  /// amount of columns
        Monster curr_monster;
        Trap curr_trap;

        for(int i = 0; i < amount_of_lines; i++) {     //////////   if needed we can give each of the units the game_board, for connection reasons
            ArrayList<Tile> curr_line = new ArrayList<Tile>();
            for(int j=0; j < line_length; j++) {
                if ('#' == (lines.get(i).charAt(j))) {   //// Wall
                    curr_line.add(new Wall(j, i));
                }else if ('.' == (lines.get(i).charAt(j))) {   //// Empty
                    curr_line.add(new Empty(j, i));
                }else if ('s' == (lines.get(i).charAt(j))) {   ////////////////////////////////  Monsters now:
                    curr_monster = new Monster(3, "s", j, i, "Lannister Solider", 80, 25, 3, 25);
                    curr_monster.initialize_messages(System.out::println);
                    this.Monsters.add(curr_monster);
                    curr_line.add(curr_monster);
                } else if ('k' == (lines.get(i).charAt(j))) {
                    curr_monster = new Monster(4, "k", j, i, "Lannister Knight", 200, 14, 8, 50);
                    curr_monster.initialize_messages(System.out::println);
                    this.Monsters.add(curr_monster);
                    curr_line.add(curr_monster);
                }else if ('q' == (lines.get(i).charAt(j))) {
                    curr_monster = new Monster(5, "q", j, i, "Queen’s Guard", 400, 20, 15, 100);
                    curr_monster.initialize_messages(System.out::println);
                    this.Monsters.add(curr_monster);
                    curr_line.add(curr_monster);
                }else if ('z' == (lines.get(i).charAt(j))) {
                    curr_monster = new Monster(3, "z", j, i, "Wright", 600, 30, 15, 100);
                    curr_monster.initialize_messages(System.out::println);
                    this.Monsters.add(curr_monster);
                    curr_line.add(curr_monster);
                } else if ('b' == (lines.get(i).charAt(j))) {
                    curr_monster = new Monster(4, "b", j, i, "Bear-Wright", 1000, 75, 30, 250);
                    curr_monster.initialize_messages(System.out::println);
                    this.Monsters.add(curr_monster);
                    curr_line.add(curr_monster);
                }else if ('g' == (lines.get(i).charAt(j))) {
                    curr_monster = new Monster(5, "g", j, i, "Giant-Wright", 1500, 100, 40, 500);
                    curr_monster.initialize_messages(System.out::println);
                    this.Monsters.add(curr_monster);
                    curr_line.add(curr_monster);
                }else if ('w' == (lines.get(i).charAt(j))) {
                    curr_monster = new Monster(6, "w", j, i, "White Walker", 2000, 150, 50, 1000);
                    curr_monster.initialize_messages(System.out::println);
                    this.Monsters.add(curr_monster);
                    curr_line.add(curr_monster);
                } else if ('M' == (lines.get(i).charAt(j))) {
                    curr_monster = new Boss(6, "M", j, i, "The Mountain", 1000, 60, 25, 500, 5);
                    curr_monster.initialize_messages(System.out::println);
                    this.Monsters.add(curr_monster);
                    curr_line.add(curr_monster);
                }else if ('C' == (lines.get(i).charAt(j))) {
                    curr_monster = new Boss(1, "C", j, i, "Queen Cersei", 100, 10, 10, 1000, 8);
                    curr_monster.initialize_messages(System.out::println);
                    this.Monsters.add(curr_monster);
                    curr_line.add(curr_monster);
                }else if ('K' == (lines.get(i).charAt(j))) {
                    curr_monster = new Boss(8, "K", j, i, "Night’s King", 5000, 300, 150, 5000, 3);
                    curr_monster.initialize_messages(System.out::println);
                    this.Monsters.add(curr_monster);
                    curr_line.add(curr_monster);
                }else if ('B' == (lines.get(i).charAt(j))) {   ///////////////////////////////// Traps now:
                    curr_trap = new Trap(1, 5, "B", j, i, "Bonus Trap", 1, 1, 1, 250);
                    curr_trap.initialize_messages(System.out::println);
                    this.Traps.add(curr_trap);
                    curr_line.add(curr_trap);
                }else if ('Q' == (lines.get(i).charAt(j))) {
                    curr_trap = new Trap(3, 7, "Q", j, i, "Queen’s Trap", 250, 50, 10, 100);
                    curr_trap.initialize_messages(System.out::println);
                    this.Traps.add(curr_trap);
                    curr_line.add(curr_trap);
                }else if ('D' == (lines.get(i).charAt(j))) {
                    curr_trap = new Trap(1, 10, "D", j, i, "Death Trap", 500, 100, 20, 250);
                    curr_trap.initialize_messages(System.out::println);
                    this.Traps.add(curr_trap);
                    curr_line.add(curr_trap);
                }else if ('@' == (lines.get(i).charAt(j))) {   ///////////////////////////////   Player now:
                    if (this.player == 1){
                        this.the_player = new Warrior(j, i, "Jon Snow", 300, 30, 4, 3);
                        this.the_player.initialize_messages(System.out::println);
                        curr_line.add(this.the_player);
                    }else if (this.player == 2){
                        this.the_player = new Warrior(j, i, "The Hound", 400, 20, 6, 5);
                        this.the_player.initialize_messages(System.out::println);
                        curr_line.add(this.the_player);
                    } else if (this.player == 3){
                        this.the_player = new Mage(j, i, "Melisandre", 100, 5, 1, 300, 30, 15, 5, 6);
                        this.the_player.initialize_messages(System.out::println);
                        curr_line.add(this.the_player);
                    }else if (this.player == 4){
                        this.the_player = new Mage(j, i, "Thoros of Myr", 250, 25, 4, 150, 20, 20, 3, 4);
                        this.the_player.initialize_messages(System.out::println);
                        curr_line.add(this.the_player);
                    }else if (this.player == 5){
                        this.the_player = new Rogue(20, j, i, "Arya Stark", 150, 40, 2);
                        this.the_player.initialize_messages(System.out::println);
                        curr_line.add(this.the_player);
                    }else if (this.player == 6){
                        this.the_player = new Rogue(50, j, i, "Bronn", 250, 35, 3);
                        this.the_player.initialize_messages(System.out::println);
                        curr_line.add(this.the_player);
                    }
                    else if (this.player == 7){
                        this.the_player = new Hunter(j, i, "Ygritte", 220, 30, 2, 6);
                        this.the_player.initialize_messages(System.out::println);
                        curr_line.add(this.the_player);
                    }
                }
            }
            res.add(curr_line);
        }
        game_board.setArrays_Board(res);
    }
}
