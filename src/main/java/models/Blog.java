package models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "blogs")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Blog extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", length = 255)
    private String title;

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    @Column(name = "thumbnail",  columnDefinition = "TEXT", nullable = true)
    private String thumbnail;

    @Column(name = "image_urls", columnDefinition = "TEXT", nullable = true)
    private String imageUrls;


    @Column(name = "is_active")
    // dm phu le
    private boolean active;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "blog_category",
            joinColumns = @JoinColumn(name = "blog_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", nullable = true))
    private List<CategoryBlog> categories;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable( name= "blog_tag",
            joinColumns = @JoinColumn(name = "blog_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_blog_id",nullable = true))
    private List<TagsBlog> tagsBlog;

    @ManyToOne
    @JoinColumn(name = "user_blog_id",nullable = false)
    private User user;


}
