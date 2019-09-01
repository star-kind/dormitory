package college.dorm.json;

import java.io.Serializable;

/**
 * 响应结果类型Json
 *
 * @param <T>
 *            服务器向客户端响应的数据的类型
 */
public class ResponseEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer state;
	private String message;
	private T data;

	public ResponseEntity() {
	}

	public ResponseEntity(Integer state) {
		this.state = state;
	}

	public ResponseEntity(Integer state, T data) {
		this.state = state;
		this.data = data;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ResponseEntity [state=");
		builder.append(state);
		builder.append(", message=");
		builder.append(message);
		builder.append(", data=");
		builder.append(data);
		builder.append("]");
		return builder.toString();
	}

}
