package org.example.expensetracking.repository;

import org.apache.ibatis.annotations.*;
import org.example.expensetracking.model.Category;
import org.example.expensetracking.model.dto.request.CategoryRequest;


import java.util.List;

@Mapper
public interface CategoryRepository {

    //Get All Categories
    @Select("""
              SELECT * FROM categories
       LIMIT #{size}
       OFFSET #{size} * (#{page} - 1)
       """)
    @Results(id = "categoryMapping", value = {
            @Result(property = "categoryID",column = "category_id"),
            @Result(property = "name", column = "name"),
            @Result(property = "description", column = "description"),
            @Result(property = "userId",column = "user_id",
            one = @One(select = "org.example.expensetracking.repository.UserRepository.findUserByEmail"))
    })
    List<Category> getAllCategories(Integer page, Integer size);

    //Insert Category
    @Select("""
    INSERT INTO categories (category_id, name,user_id)
    VALUES (#{categoryID}, #{name},#{userId})
    RETURNING *
""")
    List<Category> insertCategory(CategoryRequest categoryRequest);
}
