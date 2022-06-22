package DD_Bussiness_Package;

public interface EnemyDeathCallback{   /////  Enemy will probably implement this  ///////   may not be needed !!
    public Enemy call(Enemy e);    /////  gives us the Enemy we want to remove and remove it with the remove(Enemy enemy) in Game_Board
}
