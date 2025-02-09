package tn.esprit.careerlink.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Reclamation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idreclamation;
    LocalDate datereclamation;
    String description;
    private double importance;
    private int descriptionLength;
    public double getImpactClient() {
        // Implémentez ici la logique pour calculer l'impact sur le client en fonction de l'importance
        // Par exemple, vous pouvez attribuer un impact plus élevé à une réclamation
        // ayant une importance plus élevée
        // Voici une implémentation simplifiée pour illustrer le concept

        int impact = 0;

        if (importance <= 3) {
            impact = 1; // Faible
        } else if (importance <= 6) {
            impact = 2; // Moyen
        } else {
            impact = 3; // Élevé
        }

        return impact;
    }

    // Méthode pour calculer et obtenir la récurrence de la réclamation
    public int getRecurrence() {
        // Implémentez ici la logique pour calculer la récurrence en fonction de l'importance
        // Par exemple, vous pouvez attribuer une récurrence plus élevée à une réclamation
        // ayant une importance plus élevée
        // Voici une implémentation simplifiée pour illustrer le concept

        int recurrence = 0;

        if (importance <= 3) {
            recurrence = 1; // Occasionnelle
        } else if (importance <= 6) {
            recurrence = 2; // Régulière
        } else {
            recurrence = 3; // Fréquente
        }

        return recurrence;
    }
    public int getGravite() {
        // Implémentez ici la logique pour calculer la gravité en fonction de l'importance
        // Par exemple, vous pouvez attribuer une gravité plus élevée à une réclamation
        // ayant une importance plus élevée
        // Voici une implémentation simplifiée pour illustrer le concept

        int gravite = 0;

        if (importance <= 3) {
            gravite = 1; // Faible
        } else if (importance <= 6) {
            gravite = 2; // Moyenne
        } else {
            gravite = 3; // Élevée
        }

        return gravite;
    }

    @Enumerated(EnumType.STRING)
    private TypeReclamation typeReclamation;
    @JsonIgnore
    @OneToOne
    Reponse reponse;
    @OneToOne
    Expense expense;


}
