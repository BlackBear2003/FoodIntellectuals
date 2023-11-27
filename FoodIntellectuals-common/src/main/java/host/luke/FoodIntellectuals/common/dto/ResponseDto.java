package host.luke.FoodIntellectuals.common.dto;

public class ResponseDto<T> {

  private int code;
  private String errorMessage;
  private T data;

  public ResponseDto(int code, String errorMessage, T data) {
    this.code = code;
    this.errorMessage = errorMessage;
    this.data = data;
  }

  public static <T> ResponseDto<T> success(T data) {
    ResponseDto<T> dto = new ResponseDto<>();
    dto.setCode(200);
    dto.setData(data);
    dto.setErrorMessage("");
    return dto;
  }

  public static <T>  ResponseDto<T> success(T data, String message) {
    ResponseDto<T> dto = new ResponseDto<>();
    dto.setCode(200);
    dto.setData(data);
    dto.setErrorMessage(message);
    return dto;
  }

  public ResponseDto() {
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
