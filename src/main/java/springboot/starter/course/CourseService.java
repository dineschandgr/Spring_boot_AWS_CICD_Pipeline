package springboot.starter.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;

	public Course getCourse(String id) {
		return courseRepository.findById(id).orElse(null);
	}

	public List<Course> getAllCourses(String topicId) {
		//return (List<course>) courseRepository.findAll();
		List<Course> courseList = new ArrayList<>();
		courseRepository.findByTopicTopicId(topicId)
		.forEach(courseList :: add);
		return courseList;	
	}
	
	public List<Course> getAllCoursesbyName(String topicName) {
		//return (List<course>) courseRepository.findAll();
		List<Course> courseList = new ArrayList<>();
		courseRepository.findByTopicTopicName(topicName)
		.forEach(courseList :: add);
		return courseList;	
	}
	
	
	public void addCourse(Course course) {
		courseRepository.save(course);
	}
	
	public void updateCourse(String id, Course course) {
		courseRepository.save(course);
	}
	
	public void deleteCourse(String id) {
		courseRepository.deleteById(id);
	}

	public Course getCoursesbyId(String courseId) {
		return courseRepository.findById(courseId).orElse(new Course("Test","Test","Test","1"));
		
	}
	
}
