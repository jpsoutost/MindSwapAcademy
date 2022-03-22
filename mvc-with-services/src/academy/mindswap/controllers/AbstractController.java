package academy.mindswap.controllers;

import academy.mindswap.services.UserService;
import academy.mindswap.views.View;

public abstract class AbstractController implements Controller {

    protected UserService service;
    protected View view;
    protected Integer authenticatedUserId;
    protected Controller nextController;

    @Override
    public void init() {
        view.show();
        nextController.setAuthenticatedUserId(authenticatedUserId);
        nextController.init();
    }

    @Override
    public void setAuthenticatedUserId(Integer authenticatedUserId) {
        this.authenticatedUserId = authenticatedUserId;
    }

    @Override
    public void setService(UserService service) {
        this.service = service;
    }

    @Override
    public void setNextController(Controller nextController) {
        this.nextController = nextController;
    }

    public void setView(View view) {
        this.view = view;
    }
}
