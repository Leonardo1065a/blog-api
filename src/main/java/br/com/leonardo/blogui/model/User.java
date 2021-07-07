package br.com.leonardo.blogui.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("serial")
@Table(name = "user")
@Entity
@Getter @Setter @NoArgsConstructor
public class User implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "NM_USER", nullable = false)
	private String name;
	
	@Column(name = "EMAIL", nullable = false)
	private String email;
	
	@Column(name = "PASSWORD", nullable = false)
	private String password;	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_profiles", 
	  joinColumns = {@JoinColumn(name = "USER_ID")}, 
	  inverseJoinColumns = {@JoinColumn(name = "profiles_id")})
	private List<Profile> profiles = new ArrayList<>();
	
	public User(Long id) {
		this.id = id;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return profiles;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
}
