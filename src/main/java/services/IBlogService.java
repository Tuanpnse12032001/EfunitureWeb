package services;


import com.example.securityl.Responses.BlogResponse;
import com.example.securityl.dtos.BlogDto;
import com.example.securityl.models.Blog;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IBlogService {
     Page<BlogResponse> getAllBlogs(String keyword, Pageable pageable,
                                    Long userBlogId);
     Blog createBlog(BlogDto blogDto) throws EntityNotFoundException;
     Blog updateBlog(Long blogId, BlogDto updatedBlogDto) throws EntityNotFoundException;
     void deleteBlog(Long blogId) throws EntityNotFoundException ;
     String uploadThumbnailToCloudinary(Long blogId, MultipartFile image) throws IOException;

     Blog getBlogById(Long blogId) throws Exception;
     public List<BlogResponse> getLatestThreeBlogs();

}
