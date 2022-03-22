package academy.mindswap.views;

import academy.mindswap.controllers.Controller;
import academy.mindswap.controllers.EditController;
import academy.mindswap.utils.Messages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EditView implements View {

    private Controller controller;

    @Override
    public void show() {
        System.out.print(Messages.NEW_VALUE);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            if (controller instanceof EditController) {
                ((EditController) controller).doAction(reader.readLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }
}
