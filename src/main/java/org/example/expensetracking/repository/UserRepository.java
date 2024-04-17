package org.example.expensetracking.repository;

import org.apache.ibatis.annotations.*;
import org.example.expensetracking.model.User;
import org.example.expensetracking.model.dto.request.RegisterRequest;

@Mapper
public interface UserRepository {
    @Results(id = "UserMapping", value = {
            @Result(property = "userId", column = "user_id"), // Map userId column to userId property
            @Result(property = "profileImage", column = "profile_image")
    })
    @Select("""
        INSERT INTO users  
        VALUES (DEFAULT,#{user.email} , #{user.password},#{user.profileImage}) 
        RETURNING user_id, *
    """)
    User saveUser(@Param("user") RegisterRequest registerRequest);

    @ResultMap("UserMapping")
    @Select("""
        SELECT * 
        FROM users 
        WHERE email = #{email}
    """)
    User findUserByEmail(@Param("email") String email);

    @ResultMap("UserMapping")
    @Select("""
        UPDATE users 
        SET password = #{encodedPassword} 
        WHERE email = #{email}
        RETURNING user_id, email,password, profile_image
    """)
    User updatePasswordByEmail(@Param("email") String email, @Param("encodedPassword") String encodedPassword);
}
