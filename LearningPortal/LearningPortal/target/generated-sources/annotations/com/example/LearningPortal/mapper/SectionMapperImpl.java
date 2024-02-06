package com.example.LearningPortal.mapper;

import com.example.LearningPortal.model.Section;
import com.example.LearningPortal.modeldto.SectionDto;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-06T21:02:35+0530",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.36.0.v20231114-0937, environment: Java 17.0.2 (Oracle Corporation)"
)
public class SectionMapperImpl implements SectionMapper {

    @Override
    public SectionDto modelToDto(Section section) {
        if ( section == null ) {
            return null;
        }

        SectionDto sectionDto = new SectionDto();

        sectionDto.setCourse( section.getCourse() );
        sectionDto.setSectionId( section.getSectionId() );
        sectionDto.setSectionName( section.getSectionName() );

        return sectionDto;
    }

    @Override
    public Section dtoToModel(SectionDto sectionDto) {
        if ( sectionDto == null ) {
            return null;
        }

        Section section = new Section();

        section.setCourse( sectionDto.getCourse() );
        section.setSectionId( sectionDto.getSectionId() );
        section.setSectionName( sectionDto.getSectionName() );

        return section;
    }
}
