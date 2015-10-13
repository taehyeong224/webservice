package koreatech.cse.repository;


import koreatech.cse.domain.Searchable;
import koreatech.cse.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    @Insert("INSERT INTO USERS (NAME, EMAIL, PASSWORD, AGE) VALUES (#{name}, #{email}, #{password}, #{age})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before=false, resultType = int.class)
    void insert(User user);

    @Update("UPDATE USERS SET NAME = #{name}, EMAIL = #{email}, PASSWORD = #{password}, AGE = #{age} WHERE ID = #{id}")
    void update(User user);

    @Select("SELECT * FROM USERS WHERE ID = #{id}")
    User findOne(@Param("id") int id);

    @Delete("DELETE FROM USERS WHERE ID = #{id}")
    void delete(@Param("id") int id);

    @Select("<script>"
            + "SELECT * FROM USERS"
            + "<if test='name != null'> WHERE NAME = #{name}</if>"
            + "<if test='name != null and email != null'> OR EMAIL = #{email}</if>"
            + "<if test='orderParam != null'>ORDER BY ${orderParam} DESC</if>"
            + "</script>")
    List<User> findByScript(Searchable searchable);

//    @Select("<script>"
//            + "SELECT * FROM USERS"
//            + "<if test='name != null'> WHERE NAME = #{name}</if>"
//            + "<if test='name != null and email != null'> OR EMAIL = #{email}</if>"
//            + "<if test='orderParam != null'>ORDER BY ${orderParam} DESC</if>"
//            + "</script>")
//    List<User> findByScript(@Param("name") String name, @Param("email") String email, @Param("orderParam") String orderParam);
}