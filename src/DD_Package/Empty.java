package DD_Package;

public class Empty extends Tile {
    public Empty(int x, int y){
        this.setCharacter(".");
        this.setCoordinate(new Coordinate(x, y));
    }
    @Override
    public String toString() {
        return this.getCharacter();
    }

}
