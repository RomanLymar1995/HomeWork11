import java.util.List;

public class Task1 {
    public static String formatNames(List<String> names) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < names.size(); i++) {
            if (i % 2 == 0) {
                int index = i / 2 + 1;
                result.append(index).append(". ").append(names.get(i)).append(", ");
            }
        }
        if (result.length() > 0) {
            result.delete(result.length() - 2, result.length());
        }
        return result.toString();
    }
}