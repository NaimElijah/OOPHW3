package DD_Bussiness_Package;

public class Empty extends Tile {
    public Empty(int x, int y){
        super(".", new Coordinate(x, y));
    }


    @Override
    public void move(Tile tile) {
        this.replace_positions(tile);
    }

    @Override
    public void move(Enemy enemy) { }  ///////  won't do anything, because already dealt with in the move(Tile tile) here

    @Override
    public void move(Player player) { }  ///////  won't do anything, because already dealt with in the move(Tile tile) here

//    @Override
//    public void interact(Tile other) {
//        other.interact(this);
//    }
}
