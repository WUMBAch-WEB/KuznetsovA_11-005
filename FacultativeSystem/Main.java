package FacultativeSystem;

public class Main {
    public static void main(String[] args) {
        DataBase dataBase =  new DataBase();
        Platform platform = new Platform();
        platform.setDataBase(dataBase);
        platform.welcome();
    }
}
