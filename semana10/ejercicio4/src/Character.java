//personaje con un atributo health, implementa la interfaz Damageable. Al recibir daño, se reduce su salud. Si llega a 0 o menos, se considera que está fuera de combate.
public class Character implements Damageable {
    private int health;

    public Character(int health) {
        this.health = health;
    }

   //interfaz
    @Override
    public void applyDamage(int points) {
        health -= points;
        if (health <= 0) {
            health = 0;
            System.out.println("El personaje ha muerto!");
        }
    }
    //getter
    public int getHealth() {
        return health;
    }
    //setter
    public void setHealth(int health) {
        this.health = health;
    }
}