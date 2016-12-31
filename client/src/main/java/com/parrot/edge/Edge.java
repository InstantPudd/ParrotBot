package com.parrot.edge;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of="id")
public class Edge {
    private Long id;
    private Long idVertexFrom;
    private Long idVertexTo;
    private Long numOccurrences;
}
