package DD_Package;

public class Wall extends Tile {
    public Wall(int x, int y){
        this.setCharacter("#");
        this.setCoordinate(new Coordinate(x, y));
    }
    @Override
    public String toString() {
        return this.getCharacter();
    }

}
