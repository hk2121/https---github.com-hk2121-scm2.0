package com.scm.scm20.helpers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Mesage {

    private String content;
    @Builder.Default
    private MessageType type = MessageType.blue;

}
