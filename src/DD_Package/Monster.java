package DD_Package;

public class Monster extends Enemy{
    protected int vision_range;

    protected Monster(int vision_range, String character, int x, int y, String name, int h_p, int attack_points, int defense_points, int experience_value) {
        super(character, new Coordinate(x, y), name, new Health(h_p, h_p), attack_points, defense_points, experience_value);
        this.vision_range = vision_range;
    }

    public int getVision_range() {
        return this.vision_range;
    }
    public void setVision_range(int vision_range) {
        this.vision_range = vision_range;
    }


    @Override
    public void On_Tick_Do(Player player, Game_Board game_board) {
        if(this.getRange(player) < this.vision_range){
            if(this.getRange(player) == Math.sqrt(1)){
                this.attack(player);
            }else {
                int dx = this.getCoordinate().getX_coor() - player.getCoordinate().getX_coor();
                int dy = this.getCoordinate().getY_coor() - player.getCoordinate().getY_coor();
                if (Math.abs(dx) > Math.abs(dy)){
                    if(dx > 0){
                        this.move(game_board.arrays_Board.get(this.getCoordinate().getY_coor()).get(this.getCoordinate().getX_coor()-1));// left
                    }else {
                        this.move(game_board.arrays_Board.get(this.getCoordinate().getY_coor()).get(this.getCoordinate().getX_coor()+1));// right
                    }
                }else {
                    if (dy > 0){
                        this.move(game_board.arrays_Board.get(this.getCoordinate().getY_coor()-1).get(this.getCoordinate().getX_coor()));// up
                    }else {
                        this.move(game_board.arrays_Board.get(this.getCoordinate().getY_coor()+1).get(this.getCoordinate().getX_coor()));// down
                    }
                }
            }
        }else {
            double i = Math.floor(Math.random()*5);
            if(i == 0){   /////////  right
                this.move(game_board.arrays_Board.get(this.getCoordinate().getY_coor()).get(this.getCoordinate().getX_coor()+1));
            }else if (i== 1){   /////////  left
                this.move(game_board.arrays_Board.get(this.getCoordinate().getY_coor()).get(this.getCoordinate().getX_coor()-1));
            }else if (i== 2){   /////////  down
                this.move(game_board.arrays_Board.get(this.getCoordinate().getY_coor()+1).get(this.getCoordinate().getX_coor()));
            }
            else if (i== 3){   /////////  up
                this.move(game_board.arrays_Board.get(this.getCoordinate().getY_coor()-1).get(this.getCoordinate().getX_coor()));
            }
        }
    }



    @Override
    public void move(Tile tile){
        tile.move(this);
    }


    @Override
    public void interact(Tile other) {
        other.interact(this);
    }

    @Override
    public void attack(Unit unit) {

    }

    @Override
    public void defense(Unit unit) {

    }
}
