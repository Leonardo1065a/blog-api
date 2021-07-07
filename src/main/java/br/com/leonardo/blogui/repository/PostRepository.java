package br.com.leonardo.blogui.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.leonardo.blogui.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
