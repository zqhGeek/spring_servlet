package com.zero.spring.controller;

import com.zero.spring.model.Chapter;
import com.zero.spring.model.Course;
import com.zero.spring.service.CourseService;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by zqh on 2017/5/25.
 */
@Controller
@RequestMapping(value = "/course")
public class CourseController {
    private CourseService courseService;
    //    private static Logger logger =  LogManager.getLogger("HelloWorld");
    private static final Logger LOGGER = Logger.getLogger(CourseController.class);

    //如果把@ModelAttribute放在方法的注解上时，代表的是：该Controller的所有方法在调用前，先执行此@ModelAttribute方法。
    @ModelAttribute
    public void initController() {
        LOGGER.debug("initController");
    }

    @ModelAttribute("course")
    public Course createCourse() {
        LOGGER.debug("createCourse");
        Course course = new Course();
        course.setCourseId(123321);
        course.setTitle("深入浅出Java多线程");
        course.setImgPath("resources/imgs/course-img.jpg");
        course.setLearningNum(12345);
        course.setLevel(2);
        course.setLevelDesc("中级");
        course.setDuration(7200l);
        course.setDescr("多线程是日常开发中的常用知识，也是难用知识。bala bala...");
        LOGGER.debug(ToStringBuilder.reflectionToString(course));
        return course;
    }

    @Autowired
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    //处理根路径/course/search?id=123
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String viewCourse(@RequestParam("id") Integer course_id, Model model) {
        LOGGER.debug("course_id" + course_id);
        Course course = courseService.getCoursebyId(course_id);
        model.addAttribute(course);
        return "course_overview";
    }

    @RequestMapping(value = "/searchId/{id}", method = RequestMethod.GET)
    public String viewCourse(@PathVariable("id") Integer course_id, Map<String, Object> model) {
        LOGGER.debug("course_id" + course_id);
        Course course = courseService.getCoursebyId(course_id);
        model.put("course", course);
        return "course_overview";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET, params = "add")
    public String createCouese() {
        return "course_admin/edit";
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String doSave(@ModelAttribute Course course) {

        //数据持久化操作
        LOGGER.debug("Info of Course");
        LOGGER.debug(ToStringBuilder.reflectionToString(course));
        course.setCourseId(123);
        return "redirect:searchId/" + course.getCourseId();
    }
}
