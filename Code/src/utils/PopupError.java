package utils;

import model.Interface.Error;

public class PopupError {
    public PopupError(Error error) {
        error.showError();
    }
}
