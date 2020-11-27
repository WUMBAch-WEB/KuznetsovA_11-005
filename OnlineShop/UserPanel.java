package OnlineShop;

public class UserPanel extends Souts {
    AbstractEngineOfShop engine = new AbstractEngineOfShop();
    public void exitFromUserAccount(){
        welcomeMessage();
        engine.choiceSignUpOrSignIn();
    }
}
