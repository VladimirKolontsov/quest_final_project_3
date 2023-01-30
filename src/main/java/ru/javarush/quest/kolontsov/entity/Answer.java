package ru.javarush.quest.kolontsov.entity;

import lombok.*;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Answer extends Entity {
    String id;
    String text;
}
