package ch.wetwer.moviescore.api.controller;

import ch.wetwer.moviescore.api.data.access.BlogDao;
import ch.wetwer.moviescore.api.data.entity.Blog;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class BlogController {

    private BlogDao blogDao;

    public BlogController(BlogDao blogDao) {
        this.blogDao = blogDao;
    }

    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @GetMapping(value = "blog", produces = "application/json")
    public Iterable<Blog> getBlogPages(@RequestParam(name = "pageNr", required = false, defaultValue = "1") String pageNr,
                                       @RequestParam(name = "sort", required = false, defaultValue = "id") String sort) {
        return blogDao.getAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping(value = "blog", produces = "application/json")
    public void updateBlog(@RequestBody Blog blog) {
        blogDao.save(blog);
    }

}
