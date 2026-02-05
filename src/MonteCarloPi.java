import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class MonteCarloPi {

    public static void main(String[] args) {
        int trials = 1_000_000; // 試行回数
        Random random = new Random();
        int insideCircle = 0;

        for (int i = 0; i < trials; i++) {
            double x = random.nextDouble();
            double y = random.nextDouble();

            if (x * x + y * y <= 1.0) {
                insideCircle++;
            }
        }

        double piEstimate = 4.0 * insideCircle / trials;

        System.out.println("試行回数: " + trials);
        System.out.println("推定されたπの値: " + piEstimate);

        // CSV出力
        try (FileWriter writer = new FileWriter("result.csv")) {
            writer.write("trials,pi_estimate\n");
            writer.write(trials + "," + piEstimate + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
