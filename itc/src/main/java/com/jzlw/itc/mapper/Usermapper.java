package com.jzlw.itc.mapper;

import com.jzlw.itc.domain.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Usermapper {
    List<User> slectall();
    //查询用户的所有相关属性，其他为制作映射所需要的方法
    User selectuserattribute(Integer id);
    List<Posts> selectuserposts0(Integer userid);
    List<FileEntity>selectuserposts1(Integer userid);
    List<Comment> selectuserposts2(Integer userid);
    List<Goodp> selectuserposts3(Integer userid);
    List<Goodv> selectuserposts4(Integer userid);
    List<Collectionp> selectuserposts5(Integer userid);
    List<Collectionv> selectuserposts6(Integer userid);
    List<Trashcan> selectuserposts7(Integer userid);
    Headpicture selectuserposts8(Integer userid);
    //登录
    User selectoflogin(@Param("username") String username,@Param("password") String password);
    //注册
    void insertauser(User user);
    //修改信息
    void updateuser(User user);

    User selectauser(Integer id);
}
