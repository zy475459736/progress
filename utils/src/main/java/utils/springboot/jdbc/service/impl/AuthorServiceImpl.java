package utils.springboot.jdbc.service.impl;

import com.zhongyi.springboot.jdbc.service.AuthorService;
import me.personal.utils.springboot.jdbc.dao.AuthorDao;
import me.personal.utils.springboot.jdbc.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("jdbc.authorService")
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorDao authorDao;
 
    @Override
    public int add(Author author) {
        return this.authorDao.add(author);
    }
 
    @Override
    public int update(Author author) {
        return this.authorDao.update(author);      
    }
 
    @Override
    public int delete(Long id) {
        return this.authorDao.delete(id);
    }
 
    @Override
    public Author findAuthor(Long id) {
        return this.authorDao.findAuthor(id);
    }
 
    @Override
    public List<Author> findAuthorList() {
        return this.authorDao.findAuthorList();
    }
}