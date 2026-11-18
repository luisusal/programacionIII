// heredad de caracter, implementa una version personalizada de applyDamage, donde el daño recibido se reduce un 10%.
public class Knight extends Character {

    public Knight(int health) {
        super(health);
    }
// interfaz
    @Override
    public void applyDamage(int points) {
        int tmpPoints = (int) (points * 0.9); // reducir el daño en un 10%
        /*super.setHealth(super.getHealth() - tmpPoints);
        if (super.getHealth() <= 0) {
            super.setHealth(0);
            System.out.println("El caballero ha muerto!");
        }
    }*/ //  YA LO HACE LA CLASE PADRE, SOLO HAY QUE LLAMAR A SUPER
        super.applyDamage(tmpPoints);
    }

}
