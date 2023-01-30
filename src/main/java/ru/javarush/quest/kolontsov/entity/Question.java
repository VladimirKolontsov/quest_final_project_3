package ru.javarush.quest.kolontsov.entity;


import lombok.*;

import java.util.ArrayList;
import java.util.Collection;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Question extends Entity {
    String title;
    String fabula;
    String text;
    String viewAddress;
    String loosMessage;
    Collection<Answer> answers = new ArrayList<>();
    String[] answerPath;
    int submitAnswerIndex;
}
