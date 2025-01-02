package com.example.mapper;

import com.example.entity.Grade;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface GradeMapper {

    @Insert("insert into grade (course_id,student_id,score,teacher_name)" +
            "values(#{courseId},#{studentId},#{score},#{teacher})")
    void insert(Grade grade);

    List<Grade> selectAll(Grade grade);

    @Update("update grade set score=#{score},feedback=#{feedback} where id=#{id}")
    void update(Grade grade);

    @Select("select * from grade where student_id=#{studentId} and course_id=#{courseId}")
    Grade selectByCondition(Grade grade);

    @Delete("delete from  grade where id =#{id}")
    void deleteById(Integer id);
}