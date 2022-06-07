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

    public InputReader(String file_path){
        this.file_path = file_path;
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
            for(int j=0; j < line_length; j++){
                if ('#' == (lines.get(i).charAt(j))){
                    curr_line.add(new Wall());
                }
                if ('.' == (lines.get(i).charAt(j))){
                    curr_line.add(new Empty());
                }
                if ('s' == (lines.get(i).charAt(j))){
                    curr_line.add(new Monster("Lannister Solider", 's', 3, 25, 8, 3, 80, j, i));
                }
                if ('k' == (lines.get(i).charAt(j)))
//                if('@' == new )  /////   complete the player
            }
            res.add(curr_line);
        }

        return res;
    }
}
