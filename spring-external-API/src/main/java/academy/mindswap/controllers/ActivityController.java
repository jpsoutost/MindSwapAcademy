package academy.mindswap.controllers;

import academy.mindswap.commands.ActivityDto;
import academy.mindswap.services.ActivityService;
import academy.mindswap.services.BoredAPILookupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @PostMapping("/activity")
    public ResponseEntity<ActivityDto> createActivity() throws ExecutionException, InterruptedException {

        ActivityDto  createdActivityDto = activityService.save();
        if (createdActivityDto == null) {
            return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
        }

        return new ResponseEntity<>(createdActivityDto, HttpStatus.CREATED);
    }

    @GetMapping("/activity")
    public List<ActivityDto> getActivityByType(@RequestParam(value = "type", defaultValue = "") String type) {
        return  activityService.getActivityByType(type);
    }

    @GetMapping("/activity/{word}")
    public List<ActivityDto> getActivityByWordInDescription(@PathVariable String word) {
        return  activityService.getActivityByWordInDescription(word);
    }

}
