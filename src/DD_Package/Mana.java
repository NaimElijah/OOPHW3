package DD_Package;

public class Mana {
    private int mana_pool;
    private int current_mana;

    public Mana(int mana_pool, int current_mana){
        this.mana_pool = mana_pool;
        this.current_mana = current_mana;
    }

    public int getMana_pool() {
        return this.mana_pool;
    }

    public int getCurrent_mana() {
        return this.current_mana;
    }

    public void setMana_pool(int mana_pool) {
        this.mana_pool = mana_pool;
    }

    public void setCurrent_mana(int current_mana) {
        this.current_mana = current_mana;
    }
}
