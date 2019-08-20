package com.egor.blog.repo;

import com.egor.blog.domain.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface PostRepository extends CrudRepository<Post, Long> {
    Post findByTag(String tag);
    @Transactional
    Post findBySlug(String slug);
    @Transactional
    Iterable<Post> findAllByOrderByIdDesc();
}
