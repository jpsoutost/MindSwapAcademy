package academy.mindswap.commands;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ActivityDto {
    private Integer ID;
    @NotBlank(message="Name cannot be empty")
    private String activity;
    @NotBlank(message="Type cannot be empty")
    private String type;
    private Integer participants;
    private Float price;
    private Float accessibility;
}
