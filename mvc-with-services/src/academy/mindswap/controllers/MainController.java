package academy.mindswap.controllers;

import academy.mindswap.utils.EditOption;
import academy.mindswap.utils.Messages;

import java.util.HashMap;
import java.util.Map;

public class MainController extends AbstractController {

    private Map<Integer, Controller> controllers;

    @Override
    public void init() {
       view.show();
    }

    public void buildControllerMap() {
        controllers = new HashMap<>();

        controllers.put(1, new ListController());

        Controller editController = new EditController();
        controllers.put(2, editController);
        controllers.put(3, editController);
        controllers.put(4, editController);

        controllers.put(5, new DeleteController());
    }

    public void doAction(String option) {
        try {

            int optionNumber = Integer.parseInt(option);
            Controller controller = controllers.get(optionNumber);

            if (controller == null){
                System.err.println(Messages.OPTION_ERROR);
                view.show();
            }

            if (controller instanceof EditController) {
                ((EditController) controller).setAction(EditOption.getFromNumber(optionNumber));
            }

            controller.setAuthenticatedUserId(authenticatedUserId);
            controller.init();

        } catch (NumberFormatException e) {
            System.err.println(Messages.OPTION_ERROR);
            view.show();
        }
    }

    public Map<Integer, Controller> getControllers() {
        return controllers;
    }
}
