package academy.mindswap;

import academy.mindswap.controllers.LoginController;
import academy.mindswap.controllers.MainController;
import academy.mindswap.services.UserServiceImpl;
import academy.mindswap.views.LoginView;
import academy.mindswap.views.MainView;

public class Main {

    public static void main(String[] args) {
        LoginController loginController = Wiring.wireObjects();
        loginController.init();
    }
}
