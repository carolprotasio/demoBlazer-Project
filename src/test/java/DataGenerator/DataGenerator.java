package DataGenerator;

import com.github.javafaker.Faker;
import java.util.Random;

public class DataGenerator {
    private Faker faker;
    private Random random;

    public DataGenerator() {
        this.faker = new Faker();
        this.random = new Random();
    }
    public String getRandomMonth() {
        String[] months = {
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        };
        return months[random.nextInt(months.length)];
    }
    public String getRandomYear() {
        int currentYear = java.time.Year.now().getValue();
        int startYear = 2000;
        int endYear = currentYear + 10;
        int year = startYear + random.nextInt(endYear - startYear + 1);
        return Integer.toString(year);
    }

}
