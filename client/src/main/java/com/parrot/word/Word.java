package com.parrot.word;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of="id")
public class Word {
    private Long id;
    private Long idVertex;
}
