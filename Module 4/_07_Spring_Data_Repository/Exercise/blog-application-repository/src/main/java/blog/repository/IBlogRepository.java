package blog.repository;

import blog.model.Blog;
import blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends PagingAndSortingRepository<Blog, Long> {
    Page<Blog> findAllByCategory(Category category, Pageable pageable);
    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findAllByNameContaining(String name , Pageable pageable);
    Page<Blog> findAllByOrderByDateDesc(Pageable pageable);
}
