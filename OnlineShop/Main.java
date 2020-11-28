package OnlineShop;

public class Main extends Souts{
    static AbstractEngineOfShop engine = new AbstractEngineOfShop();
    public static void main(String[] args) {
        engine.addAdmin();
        welcomeMessage();
        engine.choiceSignUpOrSignIn();
    }
}

