package com.parrot.vertex;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of="id")
public class Vertex {
    private Long id;
    private Long idSlackTeam;
}