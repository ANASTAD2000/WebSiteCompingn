package repositories;

import models.Utilisateur;
import org.springframework.data.repository.CrudRepository;

public interface UtilisateurRepository extends CrudRepository<Utilisateur, Long> {
    Utilisateur findByUsername(String username);
}
