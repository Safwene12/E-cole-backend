package communication;

import org.poly.entities.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class UserResponse {
	
	private User user ; 
	private String accessToken;
	private String role;

}
