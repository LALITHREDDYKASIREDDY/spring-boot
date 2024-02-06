package com.example.LearningPortal.mapper;

import com.example.LearningPortal.model.Course;
import com.example.LearningPortal.modeldto.CourseDto;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-06T21:02:35+0530",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.36.0.v20231114-0937, environment: Java 17.0.2 (Oracle Corporation)"
)
public class CourseMapperImpl implements CourseMapper {

    @Override
    public CourseDto modelToDto(Course course) {
        if ( course == null ) {
            return null;
        }

        CourseDto courseDto = new CourseDto();

        courseDto.setAuthor( course.getAuthor() );
        courseDto.setCategory( course.getCategory() );
        courseDto.setCourseId( course.getCourseId() );
        courseDto.setDescription( course.getDescription() );
        courseDto.setTitle( course.getTitle() );

        return courseDto;
    }

    @Override
    public Course dtoToModel(CourseDto courseDto) {
        if ( courseDto == null ) {
            return null;
        }

        Course course = new Course();

        course.setAuthor( courseDto.getAuthor() );
        course.setCategory( courseDto.getCategory() );
        course.setCourseId( courseDto.getCourseId() );
        course.setDescription( courseDto.getDescription() );
        course.setTitle( courseDto.getTitle() );

        return course;
    }
}
