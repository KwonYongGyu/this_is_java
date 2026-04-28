package cookies.models.common;

import com.mjc813.cookies.models.common.ResponseCode;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponse<T> {
	private com.mjc813.cookies.models.common.ResponseCode responseCode;
	private String message;
	private T responseData;

	public static <T> ApiResponse<T> make(ResponseCode code, String msg, T responseData) {
		return new ApiResponse<T>(code, msg, responseData);
	}
}
