package academy.mindswap.controllers;

import academy.mindswap.utils.EditOption;

public class EditController extends AbstractController {

    private EditOption action;

    public void doAction(String value){
        switch (action) {
            case EMAIL -> service.editEmail(authenticatedUserId, value);
            case PASSWORD -> service.editPassword(authenticatedUserId, value);
            case USERNAME -> service.editUsername(authenticatedUserId, value);
        }
    }

    public void setAction(EditOption action) {
        this.action = action;
    }
}