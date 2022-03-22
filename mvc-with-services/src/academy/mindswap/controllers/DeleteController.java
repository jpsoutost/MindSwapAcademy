package academy.mindswap.controllers;


public class DeleteController extends AbstractController {

    @Override
    public void init() {
        service.deleteUser(authenticatedUserId);
        System.exit(0);
    }
}
