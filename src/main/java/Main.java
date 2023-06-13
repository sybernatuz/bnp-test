import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        List<String> lines = getLinesFromInputFile(args);
        if (lines.isEmpty())
            throw new RuntimeException("Empty file");

        Rover rover = new Rover();
        for (int i = 1; i < lines.size(); i++) {
            if (isNewRover(i)) {
                initNewRover(lines.get(i), rover);
            } else {
                computeMoves(lines.get(i), rover);
                System.out.println(rover);
            }
        }
    }

    private static List<String> getLinesFromInputFile(String[] args) throws IOException {
        String inputFile = Arrays.stream(args)
                .filter(s -> s.contains(".txt"))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No input file specified"));
        return Files.readAllLines(Paths.get(inputFile));
    }

    private static boolean isNewRover(int i) {
        return (i + 1) % 2 == 0;
    }

    private static void initNewRover(String line, Rover rover) {
        String[] values = line.split(" ");
        Coordinate coordinate = new Coordinate();
        coordinate.setX(Integer.valueOf(values[0]));
        coordinate.setY(Integer.valueOf(values[1]));
        rover.setCoordinate(coordinate);
        rover.setDirection(Direction.valueOf(values[2]));
    }

    private static void computeMoves(String moves, Rover rover) {
        for (int j = 0; j < moves.length(); j++) {
            Move move = Move.valueOf(String.valueOf(moves.charAt(j)));
            rover.move(move);
        }
    }

}
