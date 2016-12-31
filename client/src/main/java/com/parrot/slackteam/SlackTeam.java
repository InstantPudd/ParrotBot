package com.parrot.slackteam;

import lombok.*;
import org.joda.time.DateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of="id")
public class SlackTeam {
    private Long id;
    private Long slackTeamId;
    private String name;
    private DateTime createdAt;
}
