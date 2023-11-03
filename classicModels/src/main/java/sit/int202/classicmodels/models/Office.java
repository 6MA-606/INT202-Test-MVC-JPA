package sit.int202.classicmodels.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "offices")
@Getter
@Setter
@ToString
@NamedQueries({
        @NamedQuery(name = "Office.findAll", query = "select o from Office o"),
//        @NamedQuery(name = "Office.deleteByCode", query = "delete from Office o where o.officeCode = :officeCode")
})
@NoArgsConstructor
public class Office {
    @Id
    private String officeCode;
    @NonNull
    private String city;
    @NonNull
    private String phone;
    @NonNull
    private String addressLine1;
    private String addressLine2;
    private String state;
    @NonNull
    private String country;
    @NonNull
    private String postalCode;
    @NonNull
    private String territory;
}
