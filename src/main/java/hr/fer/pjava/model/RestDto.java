package hr.fer.pjava.model;

/**
 * Created by Igor Farszky on 8.2.2018..
 */
public class RestDto<T> {

    public static <T> RestDto<T> success(String message) {
        return RestDto.success(null, message);
    }

    public static <T> RestDto<T> success(T data, String message) {
        RestDto<T> model = new RestDto<>();
        model.setSuccess(true);
        model.setMessage(message);
        model.setData(data);
        return model;
    }

    public static <T> RestDto<T> fail(String message) {
        RestDto<T> model = new RestDto<>();
        model.setSuccess(false);
        model.setMessage(message);
        return model;
    }


    private T data;
    private boolean success;
    private String message;

    public T getData() {
        return data;
    }

    private void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
