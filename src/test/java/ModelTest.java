import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.javarush.quest.kolontsov.entity.Answer;
import ru.javarush.quest.kolontsov.entity.Question;
import ru.javarush.quest.kolontsov.entity.Statistic;
import ru.javarush.quest.kolontsov.model.Model;
import ru.javarush.quest.kolontsov.util.Go;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModelTest {
    public Model model;
    Statistic statistic;
    Question question;
    String time;
    List<Answer> answerArrayList = new ArrayList<>();


    @BeforeEach
    public void init(){
        int id = 0;
        time = Statistic.currentTime( new Date(System.currentTimeMillis()));

        answerArrayList.add(Answer.builder()
                .id(String.valueOf(id++))
                .text("Принять вызов")
                .build());
        answerArrayList.add(Answer.builder()
                .id(String.valueOf(id))
                .text("Отклонить вызов")
                .build());

        question = Question.builder()
                .title("Вопрос1")
                .fabula("Ты потерял память...")
                .text("Принять вызов НЛО?")
                .loosMessage("Ты отклонил вызов.")
                .answers(answerArrayList)
                .answerPath(new String[]{Go.QUESTION2, Go.LOOS})
                .build();

        statistic = Statistic.builder()
                .dateTime(time)
                .lastQuestion(question)
                .login("Elena")
                .result("Выигрыш")
                .build();

        model = Model.getInstance();

        for (int statNum = 1; statNum <= 30; statNum++) {
            model.add(statistic);
        }
    }

    @Test
    public void getInstanceRetModelList(){
        assertEquals(model.list(), Model.getInstance().list());
    }

    @Test
    public void retStringStat(){
        String statStr = "2022-10-09 at 16:59:49 MSK             Выигрыш";
        Statistic statistic1 = Statistic.builder()
                .dateTime("2022-10-09 at 16:59:49 MSK")
                .lastQuestion(question)
                .login("Elena")
                .result("Выигрыш")
                .build();

        assertEquals(statStr, statistic1.toString());
    }
}
