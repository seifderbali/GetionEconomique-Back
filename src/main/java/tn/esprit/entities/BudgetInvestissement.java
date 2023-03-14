package tn.esprit.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Set;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "budgetInvestissement")
public class BudgetInvestissement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    Long id;
    @Column(name="anneebudgetaire")
    String anneebudgetaire;
    @Column(name="coutLogiciel")
    String coutLogiciel;
    @Column(name="coutMateriel")
    String coutMateriel;
    @Column(name="coutEtudeServ")
    String coutEtudeServ;
    @Column(name="BudgetN")
    String BudgetN;
    @Column(name="BudgetN1")
    String BudgetN1;
    @Column(name="BudgetN2")
    String BudgetN2;
    @Column(name="BudgetN3")
    String BudgetN3;


/*

    @OneToMany(cascade = CascadeType.ALL,mappedBy="budgetInvestissement")
    Set<ContatDeMarche> contatDeMarches;

    @OneToOne(mappedBy = "budgetInvestissement")
  //  @JsonIgnore
    ProjetInvestissment projetInvestissment ;

 */
}
