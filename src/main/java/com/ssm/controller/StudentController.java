package com.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.entity.Course;
import com.ssm.service.CourseService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private CourseService courseService;
	
	/**
	 * 显示所有课程
	 * @param model
	 * @param page 页码
	 * @return
	 * @throws Exception
	 */
    @RequestMapping(value = "/showCourse")
    public String stuCourseShow(Model model,@RequestParam(required=true,defaultValue="1") Integer page) throws Exception {

    	//分页插件
        PageHelper.startPage(page, 5);
        List<Course> list=courseService.findCourses();
        PageInfo<Course> p = new PageInfo<Course>(list);
        model.addAttribute("courseList", list);
        model.addAttribute("page", p);

        return "student/showCourse";
    }
}
