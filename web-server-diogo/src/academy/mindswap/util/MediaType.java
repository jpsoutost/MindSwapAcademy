package academy.mindswap.util;

import java.util.Arrays;
import java.util.List;

public enum MediaType {
    IMG(Arrays.asList("ico", "png")),
    AUDIO(Arrays.asList("mp3")),
    TEXT(Arrays.asList("html"));

    private List<String> types;

    MediaType(List<String> types) {
        this.types = types;
    }

    public List<String> getTypes() {
        return types;
    }
}
