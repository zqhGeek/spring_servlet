package com.zero.spring.service;

import com.zero.spring.model.Course;
import org.springframework.stereotype.Service;

/**
 * Created by zqh on 2017/5/25.
 */
@Service
public interface CourseService {
    Course getCoursebyId(Integer courseId);
}
