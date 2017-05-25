package com.zero.spring.controller;

import com.zero.spring.model.Course;
import com.zero.spring.service.CourseService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by zqh on 2017/5/25.
 */
@Controller
@RequestMapping(value = "/course")
public class CourseController {
    private CourseService courseService;
//    private static Logger logger =  LogManager.getLogger("HelloWorld");
    private static  final Logger LOGGER = Logger.getLogger(CourseController.class);
    @Autowired
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    @RequestMapping(value="/search",method = RequestMethod.GET)
    public String viewCourse(@RequestParam("id") Integer course_id, Model model) {
        LOGGER.debug("course_id"+course_id);
        Course course = courseService.getCoursebyId(course_id);
        model.addAttribute(course);
        return "course_overview";
    }
}
