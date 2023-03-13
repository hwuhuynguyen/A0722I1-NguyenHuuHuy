package blog.service.blog;

import blog.model.Blog;
import blog.model.Category;
import blog.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService extends IGeneralService<Blog> {
    Page<Blog> findAllByCategory(Category category, Pageable pageable);
    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findAllByNameContaining(String name , Pageable pageable);
    Page<Blog> findAllByOrderByDateDesc(Pageable pageable);
}
