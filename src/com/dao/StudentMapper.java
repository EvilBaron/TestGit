package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bean.Student;

public interface StudentMapper {
    int insert(Student record);
    int delete(Integer id);
	int update(Student record);
    Student selectByPrimaryKey(Integer id);
    List<Student> findAll(@Param("from")Integer from
    		,@Param("pageSize") Integer pageSize
    		,@Param("name") String name);
    int selectCount(String name);
    Student selectLastOne();
    Student selectByName(String name);
}