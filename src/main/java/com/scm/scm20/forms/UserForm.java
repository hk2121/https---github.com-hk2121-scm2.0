package com.scm.scm20.forms;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserForm {

    private String name;
    private String email;
    private String password;
    private String about;
    private String phoneNumber;

}
