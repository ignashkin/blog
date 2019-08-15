package com.egor.blog.repo;

import com.egor.blog.domain.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
    Post findByTag(String tag);
    Post findBySlug(String slug);
}
