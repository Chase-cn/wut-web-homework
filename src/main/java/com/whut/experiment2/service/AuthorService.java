package com.whut.experiment2.service;

import com.whut.experiment2.model.Author;
import com.whut.experiment2.mapper.AuthorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AuthorService {
    private final AuthorMapper authorMapper;

    @Autowired
    public AuthorService(AuthorMapper authorMapper) {
        this.authorMapper = authorMapper;
    }

    public List<Author> getAllAuthors() {
        return authorMapper.findAllAuthors();
    }
}
