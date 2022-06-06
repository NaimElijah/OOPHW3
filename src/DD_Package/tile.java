package DD_Package;

public abstract class tile {
    private char character;
    private Coordinate coordinate;

    public char getCharacter(){
        return this.character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Coordinate getCoordinate(){
        return this.coordinate;
    }

    public double getRange(tile other){
        return Math.sqrt(Math.pow(this.coordinate.getX_coor() - other.getCoordinate().getX_coor(), 2) + Math.pow(this.coordinate.getY_coor() - other.getCoordinate().getY_coor(), 2));
    }


}
