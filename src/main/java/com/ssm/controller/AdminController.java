package com.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.entity.College;
import com.ssm.entity.Course;
import com.ssm.entity.Student;
import com.ssm.entity.Teacher;
import com.ssm.entity.Userlogin;
import com.ssm.exception.CustomException;
import com.ssm.service.CollegeService;
import com.ssm.service.CourseService;
import com.ssm.service.StudentService;
import com.ssm.service.TeacherService;
import com.ssm.service.UserloginService;
import com.ssm.utils.DataRequest;
import com.ssm.utils.DataResponse;
import com.ssm.vo.StudentVo;
import com.ssm.vo.TeacherVo;


@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private UserloginService userloginService;
	
	@Autowired
	private StudentService	 studentService;
	
	@Autowired
	private CollegeService collegeService;
	
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private CourseService courseService;
	
    //  学生信息显示
    @RequestMapping("/showStudent")
    public String showStudent(Model model,@RequestParam(required=true,defaultValue="1") Integer page) throws Exception {

    	PageHelper.startPage(page, 5);
    	
        List<StudentVo> list = studentService.findStudents();

        PageInfo<StudentVo> p= new PageInfo<StudentVo>(list);
        model.addAttribute("studentList", list);
        model.addAttribute("page",p);

        return "admin/showStudent";

    }
    @RequestMapping("/showStudentGrid")
    @ResponseBody
    public DataResponse showStudentGrid(Model model,@RequestParam(required=true,defaultValue="1") Integer page,DataRequest request) throws Exception {

    	DataResponse response = new DataResponse();
    	PageHelper.startPage(page, 5);
    	
        List<StudentVo> list = studentService.findStudents();

        PageInfo<StudentVo> p= new PageInfo<StudentVo>(list);
        model.addAttribute("studentList", list);
        model.addAttribute("page",p);

        response.setRows(list);
        response.setRecords((int) p.getTotal());
        response.setTotal(p.getPages());
        response.setPage(5);
        return response;

    }
    //  添加学生信息页面显示
    @RequestMapping(value = "/addStudent", method = {RequestMethod.GET})
    public String addStudentUI(Model model) throws Exception {

        List<College> list = collegeService.findColleges();

        model.addAttribute("collegeList", list);

        return "admin/addStudent";
    }

    // 添加学生信息操作
   @RequestMapping(value = "/addStudent", method = {RequestMethod.POST})
   public String addStudent(Student student, Model model) throws Exception {

	   
       Boolean result = studentService.saveSudent(student);

       if (!result) {
           model.addAttribute("message", "学号重复");
           return "error";
       }
       //添加成功后，也添加到登录表
       Userlogin userlogin = new Userlogin();
       userlogin.setUserId(student.getUserId());
       userlogin.setUserName(student.getUserName().toString());
       userlogin.setPassword("123");
       userlogin.setRole(2);
       userloginService.save(userlogin);

       //重定向
       return "redirect:/admin/showStudent";
   }
    

   // 搜索学生
   @RequestMapping(value = "selectStudent", method = {RequestMethod.POST})
   private String selectStudent(String findByName, Model model,@RequestParam(required=true,defaultValue="1") Integer page) throws Exception {

       
	   	PageHelper.startPage(page, 5);
		
	    List<StudentVo> list = studentService.findByName(findByName);
	    PageInfo<StudentVo> p= new PageInfo<StudentVo>(list);
	    model.addAttribute("studentList", list);
	    model.addAttribute("page",p);
       
       return "admin/showStudent";
   }
   
   // 修改学生信息页面显示
   @RequestMapping(value = "/editStudent", method = {RequestMethod.GET})
   public String editStudentUI(Integer id, Model model) throws Exception {
       if (id == null) {
           //加入没有带学生id就进来的话就返回学生显示页面
           return "redirect:/admin/showStudent";
       }
       StudentVo  studentVo = studentService.findStudentById(id);
       if (studentVo == null) {
           throw new CustomException("未找到该名学生");
       }
       List<College> list = collegeService.findColleges();

       model.addAttribute("collegeList", list);
       model.addAttribute("student", studentVo);


       return "admin/editStudent";
   }

   // 修改学生信息处理
   @RequestMapping(value = "/editStudent", method = {RequestMethod.POST})
   public String editStudent(Student student) throws Exception {

       studentService.updateStudent(student);

       //重定向
       return "redirect:/admin/showStudent";
   }

   // 删除学生
   @RequestMapping(value = "/removeStudent", method = {RequestMethod.GET} )
   private String removeStudent(Integer id) throws Exception {
       if (id == null) {
           //加入没有带学生id就进来的话就返回学生显示页面
           return "admin/showStudent";
       }
       studentService.deleteStudent(id);
       userloginService.removeByName(id.toString());

       return "redirect:/admin/showStudent";
   }
   
   
   // 教师页面显示
   @RequestMapping("/showTeacher")
   public String showTeacher(Model model, @RequestParam(required=true,defaultValue="1") Integer page) throws Exception {
       PageHelper.startPage(page,5);
       
       List<TeacherVo> list=teacherService.findTeachers();
       

       PageInfo<TeacherVo> p=new PageInfo<TeacherVo>(list);
       model.addAttribute("teacherList", list);
       model.addAttribute("page", p);

       return "admin/showTeacher";

   }
   // 添加教师信息
   @RequestMapping(value = "/addTeacher", method = {RequestMethod.GET})
   public String addTeacherUI(Model model) throws Exception {

       List<College> list = collegeService.findColleges();

       model.addAttribute("collegeList", list);

       return "admin/addTeacher";
   }
   

   // 添加教师信息处理
   @RequestMapping(value = "/addTeacher", method = {RequestMethod.POST})
   public String addTeacher(Teacher teacher, Model model) throws Exception {

       Boolean result = teacherService.save(teacher);

       if (!result) {
           model.addAttribute("message", "工号重复");
           return "error";
       }
       //添加成功后，也添加到登录表
       Userlogin userlogin = new Userlogin();
       userlogin.setUserId(teacher.getUserId());
       userlogin.setUserName(teacher.getUserName());
       userlogin.setPassword("123");
       userlogin.setRole(1);
       userloginService.save(userlogin);

       //重定向
       return "redirect:/admin/showTeacher";
   }

   //搜索教师
   @RequestMapping(value = "selectTeacher", method = {RequestMethod.POST})
   private String selectTeacher(String findByName, Model model,@RequestParam(required=true,defaultValue="1") Integer page) throws Exception {

	   PageHelper.startPage(page, 5);
       List<TeacherVo> list = teacherService.findByName(findByName);
       PageInfo<TeacherVo> p=new PageInfo<TeacherVo>(list);
       model.addAttribute("teacherList", list);
       model.addAttribute("page", p);
       return "admin/showTeacher";
   }
   
   // 修改教师信息页面显示
   @RequestMapping(value = "/editTeacher", method = {RequestMethod.GET})
   public String editTeacherUI(Integer id, Model model) throws Exception {
       if (id == null) {
           return "redirect:/admin/showTeacher";
       }
       Teacher teacher = teacherService.findById(id);
       if (teacher == null) {
           throw new CustomException("未找到该名学生");
       }
       List<College> list = collegeService.findColleges();

       model.addAttribute("collegeList", list);
       model.addAttribute("teacher", teacher);


       return "admin/editTeacher";
   }

   // 修改教师信息页面处理
   @RequestMapping(value = "/editTeacher", method = {RequestMethod.POST})
   public String editTeacher(Teacher teacher) throws Exception {

       teacherService.update(teacher);

       //重定向
       return "redirect:/admin/showTeacher";
   }

   //删除教师
   @RequestMapping("/removeTeacher")
   public String removeTeacher(Integer id) throws Exception {
       if (id == null) {
           //加入没有带教师id就进来的话就返回教师显示页面
           return "admin/showTeacher";
       }
       teacherService.removeById(id);
       userloginService.removeById(id);

       return "redirect:/admin/showTeacher";
   }
   
   // 课程信息显示
   @RequestMapping("/showCourse")
   public String showCourse(Model model,@RequestParam(required=true,defaultValue="1") Integer page) throws Exception {

       
       
       PageHelper.startPage(page, 5);
       List<Course> list = courseService.findCourses();
       PageInfo<Course> p=new PageInfo<Course>(list);
       
       model.addAttribute("courseList", list);
       model.addAttribute("page", p);

       return "admin/showCourse";

   }

   //添加课程
   @RequestMapping(value = "/addCourse", method = {RequestMethod.GET})
   public String addCourseUI(Model model) throws Exception {

       List<TeacherVo> list = teacherService.findTeachers();
       List<College> collegeList = collegeService.findColleges();

       model.addAttribute("collegeList", collegeList);
       model.addAttribute("teacherList", list);

       return "admin/addCourse";
   }

   // 添加课程信息处理
   @RequestMapping(value = "/addCourse", method = {RequestMethod.POST})
   public String addCourse(Course course, Model model) throws Exception {

       int result = courseService.save(course);

       if (result==0) {
           model.addAttribute("message", "课程号重复");
           return "error";
       }


       //重定向
       return "redirect:/admin/showCourse";
   }
   
   // 修改课程信息页面显示
   @RequestMapping(value = "/editCourse", method = {RequestMethod.GET})
   public String editCourseUI(Integer id, Model model) throws Exception {
       if (id == null) {
           return "redirect:/admin/showCourse";
       }
       Course course = courseService.findById(id);
       if (course == null) {
           throw new CustomException("未找到该课程");
       }
       List<TeacherVo> list = teacherService.findTeachers();
       List<College> collegeList = collegeService.findColleges();

       model.addAttribute("teacherList", list);
       model.addAttribute("collegeList", collegeList);
       model.addAttribute("course", course);


       return "admin/editCourse";
   }

   // 修改课程信息页面处理
   @RequestMapping(value = "/editCourse", method = {RequestMethod.POST})
   public String editCourse(Course course) throws Exception {

       courseService.update(course);

       //重定向
       return "redirect:/admin/showCourse";
   }
   // 删除课程信息
   @RequestMapping("/removeCourse")
   public String removeCourse(Integer id) throws Exception {
       if (id == null) {
           //加入没有带教师id就进来的话就返回教师显示页面
           return "admin/showCourse";
       }
       courseService.removeById(id);

       return "redirect:/admin/showCourse";
   }
   //搜索课程
   @RequestMapping(value = "selectCourse", method = {RequestMethod.POST})
   private String selectCourse(String findByName, Model model,@RequestParam(required=true,defaultValue="1") Integer page) throws Exception {

	   PageHelper.startPage(page, 5);
	   
       List<Course> list = courseService.findByName(findByName);

       PageInfo<Course> p=new PageInfo<Course>(list);
       model.addAttribute("courseList", list);
       model.addAttribute("page", p);
       return "admin/showCourse";
   }
}
