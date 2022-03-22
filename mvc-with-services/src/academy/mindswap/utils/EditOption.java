package academy.mindswap.utils;

import java.util.Arrays;
import java.util.Optional;

public enum EditOption {
    USERNAME(2),
    EMAIL(3),
    PASSWORD(4);

    private int option;

    EditOption(int option) {
        this.option = option;
    }

    public static EditOption getFromNumber(int number){
        Optional<EditOption> first = Arrays.stream(EditOption.values())
                .filter(entry -> entry.option == number)
                .findFirst();

        return first.orElse(null);
    }
}
