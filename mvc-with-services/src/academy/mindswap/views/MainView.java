package academy.mindswap.views;

import academy.mindswap.controllers.Controller;
import academy.mindswap.controllers.MainController;
import academy.mindswap.utils.Messages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainView implements View {

    private Controller controller;

    @Override
    public void show() {

        System.out.println();
        System.out.println(Messages.LIST);
        System.out.println(Messages.CHANGE_USERNAME);
        System.out.println(Messages.CHANGE_EMAIL);
        System.out.println(Messages.CHANGE_PASSWORD);
        System.out.println(Messages.DELETE);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            if (controller instanceof MainController) {
                ((MainController) controller).doAction(reader.readLine());
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
}
