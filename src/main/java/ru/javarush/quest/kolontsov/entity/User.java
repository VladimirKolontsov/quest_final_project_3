package ru.javarush.quest.kolontsov.entity;

import lombok.*;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder

public final class User extends Entity {
    Long id;
    String login;
    String password;
    int questStatus;
}
