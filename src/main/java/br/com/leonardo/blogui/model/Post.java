package br.com.leonardo.blogui.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Table(name = "post")
@Entity
@Getter @Setter @NoArgsConstructor
@Accessors(chain=true)
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "TITLE", nullable = false)
	private String title;
	
	@Column(name = "DESCRIPTION", nullable = false)
	private String description;
	
	@Column(name = "URL_IMG", nullable = false)
	private String urlImagem;

	@Column(name = "DT_CRIACAO", nullable = false)
	private Date dtCriacao;
	
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;	
	
}
