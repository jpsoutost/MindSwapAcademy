package academy.mindswap.views;

import academy.mindswap.controllers.Controller;
import academy.mindswap.controllers.LoginController;
import academy.mindswap.utils.Messages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.CharBuffer;

public class LoginView implements View {

    private Controller controller;

    @Override
    public void show() {
        System.out.println("\n" + Messages.WELCOME);
        System.out.println("\n" + Messages.CREDENTIALS);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            scanCredentials(reader);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void scanCredentials(BufferedReader reader) throws IOException {

        System.out.print(Messages.USERNAME);
        String username = reader.readLine();
        System.out.print(Messages.PASSWORD);
        String password = reader.readLine();

        if (controller instanceof LoginController) {
            if (!((LoginController) controller).doAuthentication(username, password)) {
                System.out.println("\n" + Messages.LOGIN_ERROR + "\n");
                scanCredentials(reader);
            }

            System.out.println(Messages.LOGIN_SUCCESS);
        }
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
}
