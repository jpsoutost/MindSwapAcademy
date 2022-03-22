package academy.mindswap.controllers;

import academy.mindswap.services.UserService;
import academy.mindswap.views.View;

public interface Controller {
    void init();

    void setAuthenticatedUserId(Integer authenticatedUserId);

    void setService(UserService service);

    void setView(View view);

    void setNextController(Controller controller);
}
