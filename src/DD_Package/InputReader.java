package DD_Package;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InputReader {
    private String file_path;
    private int player;

    public InputReader(String file_path, int player){
        this.file_path = file_path;
        this.player = player;
    }

    public ArrayList<ArrayList<Tile>> Read(){
        ArrayList<ArrayList<Tile>> res = new ArrayList<ArrayList<Tile>>();
        List<String> lines = Collections.emptyList();

        try{
            lines = Files.readAllLines(Paths.get(this.file_path));
        }catch (IOException e){
            System.out.println(e.getMessage() + "\n" + e.getStackTrace());
        }

        int amount_of_lines = lines.size();
        int line_length = lines.get(0).length();

        for(int i = 0; i < amount_of_lines; i++) {
            ArrayList<Tile> curr_line = new ArrayList<Tile>();
            for(int j=0; j < line_length; j++) {
                if ('#' == (lines.get(i).charAt(j))) {   //// Wall
                    curr_line.add(new Wall());
                }
                if ('.' == (lines.get(i).charAt(j))) {   //// Empty
                    curr_line.add(new Empty());
                }
                if ('s' == (lines.get(i).charAt(j))) {   ////////// Monster
                    curr_line.add(new Monster("Lannister Solider", 's', 3, 25, 8, 3, 80, j, i));
                }
                if ('k' == (lines.get(i).charAt(j))) {
                    curr_line.add(new Monster("Lannister Knight", 'k', 4, 50, 14, 8, 200, j, i));
                }
                if ('q' == (lines.get(i).charAt(j))) {
                    curr_line.add(new Monster())
                }
                if ('z' == (lines.get(i).charAt(j))) {
                    curr_line.add(new Monster())
                }
                if ('b' == (lines.get(i).charAt(j))) {
                    curr_line.add(new Monster())
                }
                if ('g' == (lines.get(i).charAt(j))) {
                    curr_line.add(new Monster())
                }
                if ('w' == (lines.get(i).charAt(j))) {
                    curr_line.add(new Monster())
                }
                if ('M' == (lines.get(i).charAt(j))) {
                    curr_line.add(new Monster())
                }
                if ('C' == (lines.get(i).charAt(j))) {
                    curr_line.add(new Monster())
                }
                if ('K' == (lines.get(i).charAt(j))) {
                    curr_line.add(new Monster())
                }
                if ('B' == (lines.get(i).charAt(j))) {   ////////// Trap
                    curr_line.add(new Trap())
                }
                if ('Q' == (lines.get(i).charAt(j))) {
                    curr_line.add(new Trap())
                }
                if ('D' == (lines.get(i).charAt(j))) {
                    curr_line.add(new Trap())
                }
                if ('@' == (lines.get(i).charAt(j))) {   //////////   Player            read the rest of the assignment !!!!!!!!!
                    if (this.player == 1){
                        curr_line.add(new )
                    }
                    if (this.player == 2){
                        curr_line.add(new )
                    }
                    if (this.player == 3){
                        curr_line.add(new )
                    }
                    if (this.player == 4){
                        curr_line.add(new )
                    }
                    if (this.player == 5){
                        curr_line.add(new )
                    }
                    if (this.player == 6){
                        curr_line.add(new )
                    }
                }
            }
            res.add(curr_line);
        }
        return res;
    }
}
