// crear una lista de objetos ArrayList<Damageable> y añadir: una instancia de Wall con 500 puntos de durabilidad, una instancia de Character con 300 puntos de salud y una instancia de Knight con 400 puntos de salud. Luego, recorrer la lista y aplicar 100 puntos de daño a cada objeto, mostrando el estado resultatne.
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<Damageable> objs = new ArrayList<>();
        objs.add(new Wall(500));
        objs.add(new Character(300));
        objs.add(new Knight(400));

        for (Damageable d : objs) {
            d.applyDamage(100);
        }

        // imprimir con cuantos puntos se ha quedado cada objeto
        for (Damageable d : objs) {
            if (d instanceof Wall) {
                Wall wall = (Wall) d;
                System.out.println("La pared tiene " + wall.getDurability() + " puntos de durabilidad.");
            } else if (d instanceof Character) {
                Character character = (Character) d;
                System.out.println("El personaje tiene " + character.getHealth() + " puntos de salud.");
            }
        }

    }
}
