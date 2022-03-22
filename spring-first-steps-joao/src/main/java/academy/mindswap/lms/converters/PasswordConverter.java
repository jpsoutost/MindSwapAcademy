package academy.mindswap.lms.converters;

import academy.mindswap.lms.commands.PasswordDto;
import org.springframework.stereotype.Component;

@Component
public class PasswordConverter {
    public PasswordDto toDto (String password){
        PasswordDto dto = new PasswordDto();
        dto.setNewPassword(password);
        return dto;
    }

    public String toEntity(PasswordDto dto){
        return dto.getNewPassword();
    }
}
