package com.parrot.edge;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CreateEdgeRequest {
    private Long idVertexFrom;
    private Long idVertexTo;
    private Long numOccurrences;
}
