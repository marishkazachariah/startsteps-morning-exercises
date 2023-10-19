package week_7.day_3;

import java.util.*;
import java.util.stream.Stream;

public class Bingo {
    private static List<String> generateLabels(char letter, int start, int end) {
        return Stream.iterate(start, i -> i + 1)
                .limit(end - start + 1)
                .map(i -> letter + Integer.toString(i))
                .toList();
    }

    private static String[] generateLabelsArray(char letter, int start, int end) {
        String[] labels = new String[end - start + 1];
        for (int i = start; i <= end; i++) {
            labels[i - start] = letter + Integer.toString(i);
        }
        return labels;
    }

    private static Stream<String> generateLabelsStream(char letter, int start, int end) {
        return Stream.iterate(start, i -> i + 1)
                .limit(end - start + 1)
                .map(i -> letter + Integer.toString(i));
    }

    public static void main(String[] args) {
        List<String> labelsB = generateLabels('B', 1, 15);
        String[] labelsI = generateLabelsArray('I', 16, 30);
        Stream<String> labelsN = generateLabelsStream('N', 31, 45);
        Stream<String> labelsG = Stream.of(generateLabels('G', 46, 60).toString());
        Stream<String> labelsO = Arrays.stream(generateLabelsArray('O', 61, 75));

        Stream<String> allLabels = Stream.concat(
                Stream.concat(
                        Stream.concat(
                                labelsB.stream(),
                                Arrays.stream(labelsI)
                        ),
                        labelsN
                ),
                Stream.concat(
                        labelsG,
                        labelsO
                )
        );


        allLabels.forEach(label -> System.out.print(label + ", "));

        List<String> bingoPool = new ArrayList<>(75);

        int start = 1;
        for (char c: "BINGO".toCharArray()) {
            for (int i = 0; i < (start + 15); i++) {
                bingoPool.add(c + "" + i);
                System.out.println(c + "" + i);
            }
            start += 15;
        }

        Collections.shuffle(bingoPool);

        for (int i = 0; i < 15; i++) {
            System.out.println(bingoPool.get(i));
        }

        System.out.println("------------");

        List<String> firstFifteen = new ArrayList<>(bingoPool.subList(0, 15));
        firstFifteen.sort(Comparator.naturalOrder());

        for (int i = 0; i < 15; i++) {
            System.out.println(firstFifteen.get(i));
        }

        firstFifteen.replaceAll(s -> {
            if(s.indexOf('G') == 0 ||s.indexOf('O') == 0) {
                String updated = s.charAt(0)+ "-" + s.substring(1);
                System.out.println(updated + " ");
                return updated;
            }
            return s;
        });
        System.out.println("-----");
        bingoPool.stream()
                .limit(15)
                .filter(s -> s.indexOf('G') == 0 ||s.indexOf('O') == 0)
                .map(s -> s.charAt(0)+"-" + s.substring(1))
                .sorted()
                .forEach(s -> System.out.println(s +" "));

    }
}
