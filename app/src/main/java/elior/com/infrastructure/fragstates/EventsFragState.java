package elior.com.infrastructure.fragstates;

public class EventsFragState {

    private String state;
    private boolean showWait = false;
    private boolean isOk;
    private String errorMsg;
    private int stateErrorCode;
    private boolean hasBeenViewed = false;

    public boolean isHasBeenViewed() {
        return hasBeenViewed;
    }

    public void setHasBeenViewed(boolean hasBeenViewed) {
        this.hasBeenViewed = hasBeenViewed;
    }

    public boolean needShowWait() {
        return showWait;
    }

    public void setShowWait(boolean showWait) {
        this.showWait = showWait;
    }

    public boolean isOk() {
        return isOk;
    }

    public void setOk(boolean ok) {
        isOk = ok;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public int getStateErrorCode() {
        return stateErrorCode;
    }

    public void setStateErrorCode(int stateErrorCode) {
        this.stateErrorCode = stateErrorCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
