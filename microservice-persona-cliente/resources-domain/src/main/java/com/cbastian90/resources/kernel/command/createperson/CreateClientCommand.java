package com.cbastian90.resources.kernel.command.createperson;

import com.cbastian90.resources.kernel.command.Command;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateClientCommand implements Command, Serializable {
        private String authorization;
        private String messageUid;
        private String name;
        private String gender;
        private Integer age;
        private String identification;
        private String address;
        private String phone;
        private String password;
        private String estado;
}
