package fr.rizomm.contacts.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Builder;

/**
 * Created by Maximilien on 22/02/2015.
 */
@Data
@AllArgsConstructor(suppressConstructorProperties = true)
@Builder
public class Contact {
    private String lastName;
    private String firstName;
    private String phone;
    private String mail;
}
