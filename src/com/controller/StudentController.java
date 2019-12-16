package com.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.bean.Page;
import com.bean.StuManager;
import com.bean.Student;
import com.dao.GradeMapper;
import com.dao.StudentMapper;

@Controller
@RequestMapping("/stu")
public class StudentController {
	@Resource
	StudentMapper studentMapper;
	@Resource
	GradeMapper gradeMapper;
	
	@RequestMapping("/list/{pageIndex}")
	public String list(@PathVariable Integer pageIndex, 
			String name,
			HttpServletRequest request){
		if (name == null) {
			name = "";
		}
		System.out.println("left");
		System.out.println("right");
		int pageSize = 3;
		int from  = (pageIndex-1)*pageSize;
		
		List<Student> list = studentMapper.findAll(from, pageSize,name);
		//说明是新增之后的操作
		if (request.getSession().getAttribute("add") != null) {
			Student stu = studentMapper.selectLastOne();
			
			list.add(0, stu);
			list.remove(list.size()-1);
			request.getSession().setAttribute("add", null);
		}
		
		Page<Student> page = new Page<Student>(
				pageIndex, 	//第几页
				pageSize, 	//每页几条
				studentMapper.selectCount(name), 	//总行数
				list	//查询的结果
				);
		
		request.setAttribute("name", name);
		request.setAttribute("pageStudent", page);
		request.getSession().setAttribute("gradelist", gradeMapper.findAll());
		return "index";
	}
	
	@RequestMapping("/add")
	public void add(Student s,HttpSession session, HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=utf-8");
		if(studentMapper.insert(s) > 0){
			session.setAttribute("add", "true");
			response.getWriter().print("<script>alert('新增成功！');location.href='../index.jsp';</script>");
		}else{
			response.getWriter().print("<script>alert('新增失败！');location.href='../add.jsp';</script>");
		}
	}
	
	@RequestMapping("/up/{id}")
	public String up(@PathVariable Integer id, HttpServletRequest request){
		request.setAttribute("s", studentMapper.selectByPrimaryKey(id));
		return "update";
	}
	
	@RequestMapping("/update")
	public String update(Student s, HttpServletRequest request){
		if (studentMapper.update(s) > 0) {
			request.getSession().setAttribute("info", "修改成功！");
			return "index";
		}else{
			return "update";
		}
	}
	
	@RequestMapping("/del/{id}")
	public String del(@PathVariable Integer id){
		studentMapper.delete(id);
		return "index";
	}
	
	@RequestMapping("/json")
	@ResponseBody
	public String testJson(HttpServletResponse response, String name) throws IOException{
		return String.valueOf(studentMapper.selectByName(name)==null);
	}
	
	@RequestMapping("/jsonlist")
	@ResponseBody
	public String stulist(){
		return JSON.toJSONStringWithDateFormat(studentMapper.findAll(0,5,""),"yyyy-MM-dd");
	}
	
	@RequestMapping("/jsonxml")
	@ResponseBody
	public StuManager jsonxml(){
		StuManager m = new StuManager();
		m.setList(studentMapper.findAll(0, 3, ""));
		return m;
	}
}













