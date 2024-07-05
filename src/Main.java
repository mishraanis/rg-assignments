public class Main {
    public static void main(String[] args) {
        DatabaseConnector dbConnector = DatabaseConnector.getInstance();
        dbConnector.connect();
    }
}
