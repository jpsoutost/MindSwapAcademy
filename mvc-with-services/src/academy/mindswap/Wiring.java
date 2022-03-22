package academy.mindswap;

import academy.mindswap.controllers.EditController;
import academy.mindswap.controllers.LoginController;
import academy.mindswap.controllers.MainController;
import academy.mindswap.services.UserServiceImpl;
import academy.mindswap.views.EditView;
import academy.mindswap.views.ListView;
import academy.mindswap.views.LoginView;
import academy.mindswap.views.MainView;


public class Wiring {

    public static LoginController wireObjects() {

        // CONTROLLERS
        LoginController loginController = new LoginController();
        MainController mainController = new MainController();

        // VIEWS
        LoginView loginView = new LoginView();
        MainView mainView = new MainView();
        EditView editView = new EditView();
        ListView listView = new ListView();

        // SERVICES
        UserServiceImpl service = new UserServiceImpl();

        // CREATE USERS
        service.createUsers();

        // WIRING
        loginController.setService(service);
        loginController.setView(loginView);
        loginView.setController(loginController);
        loginController.setNextController(mainController);

        mainController.setView(mainView);
        mainView.setController(mainController);

        mainController.buildControllerMap();

        mainController.getControllers()
                .values()
                .forEach(controller -> {
                    controller.setService(service);
                    controller.setNextController(mainController);
                    if (controller instanceof EditController) {
                        controller.setView(editView);
                        editView.setController(controller);
                    } else {
                        controller.setView(listView);
                        listView.setController(controller);
                    }

                });

        return loginController;
    }
}
