package DD_Package;

public class Empty extends Tile {
    public Empty(int x, int y){
        super(".", new Coordinate(x, y));
    }


    @Override
    public void move(Tile tile) {
        this.replace_positions(tile);
    }

    @Override
    public void interact(Tile other) {
        other.interact(this);
    }
}
