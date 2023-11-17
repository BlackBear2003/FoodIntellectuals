package host.luke.FoodIntellectuals.common.dto;

public class ResponseDTO<T> {

  private int code;
  private String errorMessage;
  private T data;

  public ResponseDTO(int code, String errorMessage, T data) {
    this.code = code;
    this.errorMessage = errorMessage;
    this.data = data;
  }

  public ResponseDTO() {
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }
}