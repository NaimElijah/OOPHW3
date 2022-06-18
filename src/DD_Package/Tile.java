package DD_Package;

public abstract class Tile {
    protected String character;
    protected Coordinate coordinate;

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


}
