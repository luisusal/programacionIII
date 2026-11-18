public class SQLiteDatabaseService extends DatabaseService {
    public SQLiteDatabaseService() {
        super();
        System.out.println("Constructor SQLiteDatabaseService");
    }

    @Override
    public void connect() {
        super.connect();
        System.out.println("Connectado a la base de datos SQLite");
    }

}
