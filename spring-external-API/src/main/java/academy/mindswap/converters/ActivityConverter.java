package academy.mindswap.converters;

import academy.mindswap.commands.ActivityDto;
import academy.mindswap.persistance.models.Activity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActivityConverter {

    @Autowired
    private ModelMapper modelMapper;

    /*public ActivityDto toDto(Activity activity){
        return modelMapper.map(activity, ActivityDto.class);
    }

    public Activity toEntity(ActivityDto dto){
        return modelMapper.map(dto, Activity.class);
    }*/

    public ActivityDto toDto(Activity activity){
        ActivityDto dto = new ActivityDto();
        dto.setActivity(activity.getDescription());
        dto.setAccessibility(activity.getAccessibility());
        dto.setID(activity.getId());
        dto.setParticipants((activity.getParticipants()));
        dto.setPrice(activity.getPrice());
        dto.setType(activity.getType());
        return dto;
    }

    public Activity toEntity(ActivityDto dto){
        Activity activity = new Activity();
        activity.setDescription(dto.getActivity());
        activity.setAccessibility(dto.getAccessibility());
        activity.setParticipants((dto.getParticipants()));
        activity.setPrice(dto.getPrice());
        activity.setType(dto.getType());
        return activity;
    }
}
