package com.parrot.slackteam;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CreateSlackTeamRequest {
    private Long slackTeamId;
    private String name;
}
