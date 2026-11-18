import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<DatabaseService> conexiones = new ArrayList<>();
        conexiones.add(new DatabaseService());// El generico
        conexiones.add(new MySQLDatabaseService());
        conexiones.add(new SQLiteDatabaseService());
        conexiones.add(new FakeDatabaseService());

        for (DatabaseService conexion : conexiones) {
            
            conexion.connect();
        }
    }
}
