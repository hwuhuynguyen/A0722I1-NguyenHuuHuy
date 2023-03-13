package blog.controller;

import blog.model.Blog;
import blog.model.Category;
import blog.service.blog.IBlogService;
import blog.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private ICategoryService iCategoryService;

    @ModelAttribute("categories")
    public Iterable<Category> categories(){
        return iCategoryService.findAll();
    }

    @GetMapping("/blog")
    public ModelAndView home(@RequestParam("search") Optional<String> search,
                             @RequestParam("filter") Optional<String> filter,
                             @PageableDefault(value = 5) Pageable pageable)
    {
        Page<Blog> blogs;
        if (search.isPresent()) {
            blogs = iBlogService.findAllByNameContaining(search.get(), pageable);
        } else {
            blogs = iBlogService.findAll(pageable);
        }

        if (filter.isPresent()) {
            for (Category category : categories()) {
                if (category.getNameCategory().equals(filter.get()))
                    blogs = iBlogService.findAllByCategory(category, pageable);
            }
        }
        ModelAndView modelAndView = new ModelAndView("/blog/home");
        modelAndView.addObject("blogs", blogs);
        modelAndView.addObject("categories", categories());
        return modelAndView;
    }

    @GetMapping("/create-blog")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("/create-blog")
    public ModelAndView saveBlog(@ModelAttribute("blog") Blog blog) {
        iBlogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("message", "New blog created successfully");
        return modelAndView;
    }

    @GetMapping("/edit-blog/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Blog> blog = iBlogService.findById(id);
        if (blog.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/blog/edit");
            modelAndView.addObject("blogDetail", blog.get());
            return modelAndView;

        } else {
            return new ModelAndView("/error");
        }
    }

    @PostMapping("/edit-blog")
    public ModelAndView updateBlog(@ModelAttribute("blog") Blog blog) {
        iBlogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/blog/edit");
        modelAndView.addObject("blogDetail", blog);
        modelAndView.addObject("message", "Blog updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-blog/{id}")
    public String deleteBlog(@PathVariable Long id) {
        iBlogService.remove(id);
        return "redirect:/blog";
    }

    @GetMapping("/view-blog/{id}")
    public ModelAndView viewBlog(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("/blog/view");
        Optional<Blog> blog = iBlogService.findById(id);
        if (blog.isPresent()) {
            modelAndView.addObject("blogDetail", blog.get());
            return modelAndView;
        } else {
            return new ModelAndView("error");
        }
    }

//    @GetMapping("/view-blog-by-category/{category}")
//    public ModelAndView viewBlogsByCategory(@PathVariable String category) {
//        ModelAndView modelAndView = new ModelAndView("/blog/home");
//    }
}
