package com.parrot.wordrepresentation;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CreateWordRepresentationRequest {
    private Long id;
    private Long idWord;
    private String representation;
    private Long numOccurrences;
}
