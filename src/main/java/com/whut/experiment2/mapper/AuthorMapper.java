package com.whut.experiment2.mapper;

import com.whut.experiment2.model.Author;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface AuthorMapper {
    List<Author> findAllAuthors();
}
