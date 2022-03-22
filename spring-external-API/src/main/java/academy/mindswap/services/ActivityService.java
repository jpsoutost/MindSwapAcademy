package academy.mindswap.services;

import academy.mindswap.commands.ActivityDto;
import academy.mindswap.converters.ActivityConverter;
import academy.mindswap.persistance.models.Activity;
import academy.mindswap.persistance.repositories.ActivityCashe;
import academy.mindswap.persistance.repositories.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private ActivityConverter activityConverter;

    @Autowired
    private BoredAPILookupService boredAPILookupService;

    @Autowired
    private ActivityCashe activityCashe;


    public ActivityDto save() throws ExecutionException, InterruptedException {
        CompletableFuture<ActivityDto> activityDto = boredAPILookupService.findActivity();
        ActivityDto createdActivityDto = activityDto.get();

        if (!activityRepository.findByDescription(createdActivityDto.getActivity()).isEmpty()){
            return null;
        }
        return activityConverter
                .toDto(
                        activityRepository
                                .save(activityConverter
                                        .toEntity(createdActivityDto)));
    }

    public List<ActivityDto> getActivityByType(String type) {
        List<Activity> activities = activityCashe.findByType(type);

        if (!activities.isEmpty()){
            System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
            return activities.stream().map(activityConverter::toDto).collect(Collectors.toList());
        }

        activities = activityRepository.findByType(type);
        activityCashe.add(activities);

        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        return activities.stream()
                .map(activityConverter::toDto)
                .collect(Collectors.toList());
    }

    public List<ActivityDto> getActivityByWordInDescription(String word) {

        List<Activity> activities = activityRepository.findByDescriptionLike("%"+word+"%");

        return activities.stream()
                .map(activityConverter::toDto)
                .collect(Collectors.toList());
    }

}
