package academy.mindswap.views;

import academy.mindswap.controllers.Controller;
import academy.mindswap.controllers.ListController;


public class ListView implements View {

    private Controller controller;

    @Override
    public void show() {
        if (controller instanceof ListController) {
            ((ListController) controller).getUsersInfo()
                    .forEach(System.out::println);
        }
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }
}
