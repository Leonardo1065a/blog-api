package br.com.leonardo.blogui.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Table(name = "profile")
@Entity
@Getter @Setter
public class Profile implements GrantedAuthority {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "NM_ROLE", nullable = false)
	private String role;
	
	@Override
	public String getAuthority() {
		return role;
	}

}
