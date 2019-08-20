package com.egor.blog.service;

import com.egor.blog.domain.Post;
import com.egor.blog.domain.User;
import com.egor.blog.repo.PostRepository;
import com.github.slugify.Slugify;
import com.ibm.icu.text.Transliterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Service
public class PostService {
    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    PostRepository postRepository;

    public static final String CYRILLIC_TO_LATIN = "Russian-Latin/BGN";

    public String makeSlug(String title) {
        Transliterator toLatinTrans = Transliterator.getInstance(CYRILLIC_TO_LATIN);
        String latinTitle = toLatinTrans.transliterate(title);
        Slugify slug = new Slugify();
        String result = slug.slugify(latinTitle);
        return result;
    }

    public String savePost(Post post, MultipartFile file) throws IOException {

        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();
            file.transferTo(new File(uploadPath + "/" + resultFilename));
            post.setFilename(resultFilename);
        }
        Post postFromDB = postRepository.findBySlug(post.getSlug());
        if (postFromDB != null) {
            postFromDB.setTitle(post.getTitle());
            postFromDB.setText(post.getText());
            postFromDB.setTag(post.getTag());
            post = postFromDB;
        } else {
            postRepository.save(post);
        }
        String slug = makeSlug(post.getTitle()) + "-" + post.getId();
        post.setSlug(slug);
        postRepository.save(post);
        return slug;
    }
}
