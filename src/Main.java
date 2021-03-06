import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(final String[] args) {
        final ArrayList<Boy> boys = new ArrayList<>() {{
            add(new Boy("Николай", 68));
            add(new Boy("Пётр", 53));
            add(new Boy("Василий", 25));
            add(new Boy("Михаил", 19));
            add(new Boy("Алексей", 6));
            add(new Boy("Николай", 86));
            add(new Boy("Пётр", 35));
            add(new Boy("Михаил", 111));
            add(new Boy("Алексей", 22));
            add(new Boy("Михаил", 1));
            add(new Boy("Яков", 30));
        }};
        final int ageControl = 18;
        final int limitBoys = 4;
        Map<String, Long> sortedBoys = boys.stream()
                .filter(boy -> boy.getAge() >= ageControl)
                .map(Boy::getName)
                .sorted()
                .distinct()
                .limit(limitBoys)
                .collect(Collectors.toMap(name -> name,
                        name -> boys.stream()
                                .filter(Boy -> Boy.getName().equals(name)).count() - 1));
        System.out.println(sortedBoys);
    }
}
