package com.egor.blog.domain;

import org.hibernate.annotations.Type;
import org.springframework.web.util.HtmlUtils;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    @Lob
    @NotBlank (message = "Введите ваш текст")
    private String text;
    private String tag;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    private String filename;

    public Post() {
    }

    public Post(String title, String text, String tag, User user) {
        this.author = user;
        this.title = HtmlUtils.htmlEscape(title);
        this.text = HtmlUtils.htmlEscape(text);
        this.tag = HtmlUtils.htmlEscape(tag);
    }

    public String getAuthorName() {
        return author != null ? author.getUsername() : "<none>";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = HtmlUtils.htmlEscape(title);;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text =  HtmlUtils.htmlEscape(text);
    }

    public String getTag() {
        return tag != null ? this.tag : "<none>";
    }

    public void setTag(String tag) {
        this.tag =HtmlUtils.htmlEscape(tag);
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}

