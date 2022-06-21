package DD_Package;

public class Wall extends Tile {
    public Wall(int x, int y){
        super("#", new Coordinate(x, y));
    }

    @Override
    public void move(Tile tile) {
        ///////   can't move into wall
    }

    @Override
    public void interact(Tile other) {
        other.interact(this);
    }
}
