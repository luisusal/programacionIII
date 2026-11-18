public class FakeDatabaseService extends DatabaseService {
    public FakeDatabaseService() {
        super();
        System.out.println("Constructor FakeDatabaseService");
    }

    @Override
    public void connect() {
        super.connect();
        System.out.println("Connectado a la base de datos Fake");
    }

}
