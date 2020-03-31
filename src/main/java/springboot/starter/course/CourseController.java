package springboot.starter.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import springboot.starter.topic.Topic;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;

	@RequestMapping("/topics/{topicId}/courses")
	public List<Course> getCourses(@PathVariable String topicId){
		
		return courseService.getAllCourses(topicId);			
		
	}
	
	@RequestMapping("/topics/{topicId}/courses/{courseId}")
	public Course getCoursesbyId(@PathVariable String courseId){
		
		return courseService.getCoursesbyId(courseId);			
		
	}
/*	
	@RequestMapping("/topics/{topicName}/courses")
	public List<Course> getCoursesbyName(@PathVariable String topicName){
		
		return courseService.getAllCoursesbyName(topicName);			
		
	}
	*/
@RequestMapping("/courses/{id}")
public Course getCourse(@PathVariable String id){
		
	return courseService.getCourse(id);
}

@RequestMapping(method=RequestMethod.POST,value="/topics/{topicId}/courses")
public void addCourse(@RequestBody Course course,@PathVariable String topicId){
   course.setTopic(new Topic(topicId,"",""));		
   courseService.addCourse(course);
		
}

@RequestMapping(method=RequestMethod.PUT,value="/topics/{topicId}/courses/{courseId}")
public void updatecourse(@RequestBody Course course,@PathVariable String topicId,@PathVariable String courseId){
	course.setTopic(new Topic(topicId,"",""));	
	courseService.updateCourse(courseId,course);
		
 }

@RequestMapping(method=RequestMethod.DELETE,value="/topics/{topicId}/courses/{courseId}")
public void deletecourse(@PathVariable String courseId){
		
	courseService.deleteCourse(courseId);
		
 }
}
