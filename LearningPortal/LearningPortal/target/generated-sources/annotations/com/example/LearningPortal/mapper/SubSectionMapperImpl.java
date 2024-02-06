package com.example.LearningPortal.mapper;

import com.example.LearningPortal.model.SubSection;
import com.example.LearningPortal.modeldto.SubSectionDto;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-06T21:02:34+0530",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.36.0.v20231114-0937, environment: Java 17.0.2 (Oracle Corporation)"
)
public class SubSectionMapperImpl implements SubSectionMapper {

    @Override
    public SubSectionDto modelToDto(SubSection subSection) {
        if ( subSection == null ) {
            return null;
        }

        SubSectionDto subSectionDto = new SubSectionDto();

        subSectionDto.setSection( subSection.getSection() );
        subSectionDto.setSubSectionId( subSection.getSubSectionId() );
        subSectionDto.setSubSectionName( subSection.getSubSectionName() );
        subSectionDto.setVideoUrl( subSection.getVideoUrl() );

        return subSectionDto;
    }

    @Override
    public SubSection dtoToModel(SubSectionDto subSectionDto) {
        if ( subSectionDto == null ) {
            return null;
        }

        SubSection subSection = new SubSection();

        subSection.setSection( subSectionDto.getSection() );
        subSection.setSubSectionId( subSectionDto.getSubSectionId() );
        subSection.setSubSectionName( subSectionDto.getSubSectionName() );
        subSection.setVideoUrl( subSectionDto.getVideoUrl() );

        return subSection;
    }
}
