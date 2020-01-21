package utils.alert;

import model.Interface.Error;

public class PopupError implements Error {
    private Error error;

    public PopupError(Error error) {
        this.error = error;
        showError();
    }

    @Override
    public void showError() {
        error.showError();
    }
}
