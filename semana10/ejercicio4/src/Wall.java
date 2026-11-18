//pared que tiene un atributo durability, implementa la interfaz Damageable. Al recibir daño, se reduce su durabilidad. Si llega a 0, se considera destruida.
public class Wall implements Damageable {
    private int durability;

    public Wall(int durability) {
        this.durability = durability;
    }
// interfaz
    @Override
    public void applyDamage(int points) {
        durability -= points;
        if (durability <= 0) {
            durability = 0;
            System.out.println("Se ha roto la pared!");
        }
    }
    // getter
    public int getDurability() {
        return durability;      
}
}