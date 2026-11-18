public class MySQLDatabaseService extends DatabaseService {
    public MySQLDatabaseService() {
        super();
        System.out.println("Constructor MySQLDatabaseService");
    }

    @Override
    public void connect() {
        super.connect();
        System.out.println("Connectado a la base de datos MySQL");
    }

}
