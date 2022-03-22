package academy.mindswap.views;

import academy.mindswap.controllers.Controller;

public interface View {
    void show();

    void setController(Controller controller);
}
