package com.parrot.wordrepresentation;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of="id")
public class WordRepresentation {
    private Long id;
    private Long idWord;
    private String representation;
    private Long numOccurrences;
}
