package br.com.leonardo.blogui.model.dto;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LoginDTO {
	
	private String email;
	private String password;

	public UsernamePasswordAuthenticationToken toLoginToken() {
		return new UsernamePasswordAuthenticationToken(email, password);
	}
}
