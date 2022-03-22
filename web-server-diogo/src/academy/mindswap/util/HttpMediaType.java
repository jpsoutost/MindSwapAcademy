package academy.mindswap.util;

public class HttpMediaType {

    public static boolean isType(String fileName, MediaType type) {
        String extension = getExtension(fileName);
        return type.getTypes().contains(extension);
    }

    public static String getExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }
}