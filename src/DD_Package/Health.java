package DD_Package;

public class Health {
    protected int Health_pool;
    protected int Health_amount;

    public Health(int health_pool, int health_amount){
        this.Health_pool = health_pool;
        this.Health_amount = health_amount;
    }


    public int getHealth_pool() {
        return this.Health_pool;
    }

    public int getHealth_amount() {
        return this.Health_amount;
    }

    public void setHealth_pool(int health_pool) {
        this.Health_pool = health_pool;
    }

    public void setHealth_amount(int health_amount) {
        this.Health_amount = health_amount;
    }
}
