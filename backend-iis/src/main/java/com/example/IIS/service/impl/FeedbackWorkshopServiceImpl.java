package com.example.IIS.service.impl;

import com.example.IIS.domain.FeedbackWorkshop;
import com.example.IIS.domain.FilledInTest;
import com.example.IIS.domain.Workshop;
import com.example.IIS.dto.*;
import com.example.IIS.repository.FeedbackWorkshopRepo;
import com.example.IIS.service.FeedbackWorkshopService;
import com.example.IIS.service.RegisteredUserService;
import com.example.IIS.service.WorkshopService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeedbackWorkshopServiceImpl implements FeedbackWorkshopService {

    @Autowired
    FeedbackWorkshopRepo feedbackWorkshopRepo;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    WorkshopService workshopService;

    @Autowired
    RegisteredUserService registeredUserService;

    private FeedbackWorkshop mapToEntity(FeedbackWorkshopDto feedbackWorkshopDto){
        FeedbackWorkshop feedbackWorkshop = mapper.map(feedbackWorkshopDto, FeedbackWorkshop.class);
        return feedbackWorkshop;
    }

    private FeedbackWorkshopDto mapToDTO(FeedbackWorkshop feedbackWorkshop){
        FeedbackWorkshopDto feedbackWorkshopDto= mapper.map(feedbackWorkshop, FeedbackWorkshopDto.class);
        return feedbackWorkshopDto;
    }

    @Override
    public FeedbackWorkshopDto createFeedback(FeedbackWorkshopDto feedbackWorkshopDto) {
        feedbackWorkshopDto.setFinalGrade((double) (feedbackWorkshopDto.getPriceGrade() + feedbackWorkshopDto.getOrganizationGrade() + feedbackWorkshopDto.getContentGrade() + feedbackWorkshopDto.getPsychologistGrade()) /4);
         feedbackWorkshopRepo.save(mapToEntity(feedbackWorkshopDto));

         return feedbackWorkshopDto;
    }

    @Override
    public WorkshopEvaluationDto getEvaluationByWorkshop(long workshopId) {
        WorkshopEvaluationDto workshopEvaluationDto=new WorkshopEvaluationDto();

        workshopEvaluationDto.setWorkshopName(workshopService.getWorkshopNameByWorkshopId(workshopId));
        workshopEvaluationDto.setTotalNumberOfParticipants((int) registeredUserService.getUsersByWorkshopId(workshopId).stream().count());
        workshopEvaluationDto.setFemaleParticipation((int) registeredUserService.getFemalesByWorkshopId(workshopId).stream().count());
        workshopEvaluationDto.setMaleParticipation((int) registeredUserService.getMalesByWorkshopId(workshopId).stream().count());
        workshopEvaluationDto.setGradeByFemale(getGradeByFemales(workshopId));
        workshopEvaluationDto.setGradeByMale(getGradeByMale(workshopId));
        workshopEvaluationDto.setFinalGrade(getFinalGrade(workshopId));
        workshopEvaluationDto.setTotalNumberOfFeedback(getAllByWorkshopId(workshopId).size());
        workshopEvaluationDto.setTotalOrgGrade(getTotalOrganizationGrade(workshopId));
        workshopEvaluationDto.setTotalContentGrade(getTotalContentGrade(workshopId));
        workshopEvaluationDto.setTotalPriceGrade(getTotalPriceGrade(workshopId));
        workshopEvaluationDto.setTotalPsychologicalGrade(getTotalPsychologistGrade(workshopId));
        workshopEvaluationDto.setNumberRecommended(getNumberOfRecommended(workshopId));
        workshopEvaluationDto.setNumberNotRecommended(getAllByWorkshopId(workshopId).size()-getNumberOfRecommended(workshopId));
        workshopEvaluationDto.setFeedbackWorkshopDtoList(getAllByWorkshopId(workshopId));

        return  workshopEvaluationDto;
    }

    @Override
    public double getGradeByFemales(long workshopId) {
        List<RegisteredUserDto> users=registeredUserService.getFemalesByWorkshopId(workshopId);

        double finalGrade=0;

        for(FeedbackWorkshopDto feedbackWorkshopDto:getAllByWorkshopId(workshopId))
        {
            for(RegisteredUserDto registeredUserDto:users)
            {
                if (feedbackWorkshopDto.getRegisteredUserId()==registeredUserDto.getId())
                {
                    finalGrade+=feedbackWorkshopDto.getFinalGrade();
                }
            }
        }
        if (finalGrade!=0)
        return finalGrade/ (long) users.size() ;
        else
            return 0;

    }

    @Override
    public double getGradeByMale(long workshopId) {
        List<RegisteredUserDto> users=registeredUserService.getMalesByWorkshopId(workshopId);

        double finalGrade=0;

        for(FeedbackWorkshopDto feedbackWorkshopDto:getAllByWorkshopId(workshopId))
        {
            for(RegisteredUserDto registeredUserDto:users)
            {
                if (feedbackWorkshopDto.getRegisteredUserId()==registeredUserDto.getId())
                {
                    finalGrade+=feedbackWorkshopDto.getFinalGrade();
                }
            }
        }
        if (finalGrade!=0)
            return finalGrade/ (long) users.size() ;
        else
            return 0;
    }

    @Override
    public List<FeedbackWorkshopDto> getAllByWorkshopId(Long workshopId) {
        // Fetching all feedback entries for a specific workshop ID
        List<FeedbackWorkshop> workshops = feedbackWorkshopRepo.findAllByWorkshopId(workshopId);
        List<FeedbackWorkshopDto> workShopDtos = new ArrayList<>();

        // Mapping each FeedbackWorkshop to FeedbackWorkshopDto
        for (FeedbackWorkshop workshop : workshops) {
            FeedbackWorkshopDto workShopDto = mapToDTO(workshop);
            workShopDtos.add(workShopDto);
        }
        return workShopDtos;
    }


    @Override
    public double getFinalGrade(long workshopId) {
        List<RegisteredUserDto> users=registeredUserService.getUsersByWorkshopId(workshopId);

        double finalGrade=0;

        for(FeedbackWorkshopDto feedbackWorkshopDto:getAllByWorkshopId(workshopId))
        {
            for(RegisteredUserDto registeredUserDto:users)
            {
                if (feedbackWorkshopDto.getRegisteredUserId()==registeredUserDto.getId())
                {
                    finalGrade+=feedbackWorkshopDto.getFinalGrade();
                }
            }
        }
        return finalGrade/ (long) users.size();
    }

    @Override
    public double getTotalContentGrade(long workshopId) {
        double totalCount=0;
        List<FeedbackWorkshopDto> feedbackWorkshopDtos=getAllByWorkshopId(workshopId);

        for(FeedbackWorkshopDto feedbackWorkshopDto:feedbackWorkshopDtos)
        {
            totalCount+=feedbackWorkshopDto.getContentGrade();
        }
        return totalCount/feedbackWorkshopDtos.size();
    }

    @Override
    public double getTotalOrganizationGrade(long workshopId) {
        double totalCount=0;
        List<FeedbackWorkshopDto> feedbackWorkshopDtos=getAllByWorkshopId(workshopId);

        for(FeedbackWorkshopDto feedbackWorkshopDto:feedbackWorkshopDtos)
        {
            totalCount+=feedbackWorkshopDto.getOrganizationGrade();
        }
        return totalCount/feedbackWorkshopDtos.size();    }

    @Override
    public double getTotalPriceGrade(long workshopId) {
        double totalCount=0;
        List<FeedbackWorkshopDto> feedbackWorkshopDtos=getAllByWorkshopId(workshopId);

        for(FeedbackWorkshopDto feedbackWorkshopDto:feedbackWorkshopDtos)
        {
            totalCount+=feedbackWorkshopDto.getPriceGrade();
        }
        return totalCount/feedbackWorkshopDtos.size();    }

    @Override
    public double getTotalPsychologistGrade(long workshopId) {
        double totalCount=0;
        List<FeedbackWorkshopDto> feedbackWorkshopDtos=getAllByWorkshopId(workshopId);

        for(FeedbackWorkshopDto feedbackWorkshopDto:feedbackWorkshopDtos)
        {
            totalCount+=feedbackWorkshopDto.getPsychologistGrade();
        }
        return totalCount/feedbackWorkshopDtos.size();    }

    @Override
    public int getNumberOfRecommended(long workshopId) {
        int totalCount=0;
        List<FeedbackWorkshopDto> feedbackWorkshopDtos=getAllByWorkshopId(workshopId);

        for(FeedbackWorkshopDto feedbackWorkshopDto:feedbackWorkshopDtos)
        {
            if(feedbackWorkshopDto.isRecommended())
            {
                totalCount+=1;
        }
        }
        return totalCount;
    }
}
