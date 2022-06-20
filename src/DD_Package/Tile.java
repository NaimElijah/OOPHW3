package DD_Package;

public abstract class Tile {
    protected String character;
    protected Coordinate coordinate;

    protected Tile(String character, Coordinate coordinate){
        this.character = character;
        this.coordinate = coordinate;
    }

    public String getCharacter(){
        return this.character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Coordinate getCoordinate(){
        return this.coordinate;
    }

    public double getRange(Tile other){
        return Math.sqrt(Math.pow(this.coordinate.getX_coor() - other.getCoordinate().getX_coor(), 2) + Math.pow(this.coordinate.getY_coor() - other.getCoordinate().getY_coor(), 2));
    }

    public abstract void move(Tile tile);

    public void replace_positions(Tile other){
        Coordinate temp = this.getCoordinate();
        this.setCoordinate(other.getCoordinate());
        other.setCoordinate(temp);
    }

    public abstract void interact(Tile other);


}
