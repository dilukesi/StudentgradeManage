package com.example.controller;

import com.example.common.Result;
import com.example.entity.Course;
import com.example.entity.Grade;
import com.example.service.GradeService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
@RestController

@RequestMapping("/grade")

public class GradeController {

@Resource
    GradeService gradeService;


    @PostMapping("/add")
    public Result add(@RequestBody Grade grade){
        gradeService.add(grade);
        return Result.success();
    }
    @PutMapping("/update")
    public Result update(@RequestBody Grade grade){
        gradeService.update(grade);
        return Result.success();
    }

    @GetMapping("/selectPage")
    public Result selectPage(@RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10")Integer pageSize,
                             Grade grade){
        PageInfo<Grade> PageInfo = gradeService.selectPage(pageNum, pageSize,grade);
        return Result.success(PageInfo);
    }
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id){
        gradeService.deleteById(id);
        return Result.success();
    }
}