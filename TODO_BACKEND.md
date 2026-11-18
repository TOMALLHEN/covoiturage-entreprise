# Backend — reprise après les derniers ajouts

Travail disponible sur `allan`.
Fusionner `allan` dans la branche de reprise avant de continuer.

## Nouveaux ajouts

- Salariés, véhicules, trajets et participations — entités, repositories et DTO complétés.
- Contrôleurs et méthodes de service préparés.
- Route admin pour modifier le poste et l’horaire d’un salarié.
- Classement — DTO, controller et service préparés.
- Droits des nouvelles routes configurés.
- Comptes en mémoire remplacés par la recherche des salariés en BDD.
- Conflits des postes gérés avec HTTP 409(amélioration suggérer par Julien).
- Participation unique par couple salarié/trajet.

## Fichiers utiles

- `*Request.java` — données reçues et validation.
- `*Response.java` — données renvoyées.
- `*Repository.java` — recherches en BDD.
- `*Controller.java` — routes et appels aux services.
- `*Service.java` — logique métier à compléter.
- `SalarieUserDetailsService.java` — chargement du compte depuis la BDD.
- `SecurityConfig.java` — authentification et droits, profil dev.

## À implémenter par Tom

Les nouveaux services renvoient actuellement HTTP 501.

- `AuthService` — inscription, e-mail unique, BCrypt, rôle SALARIE et affectations.
- `SalarieService` — consultation, profil et affectation poste/horaire.
- `VehiculeService` — CRUD et contrôle du propriétaire.
- `TrajetService` — consultation, publication, modification et annulation.
- `ParticipationService` — réservation, consultation, annulation et validation.
- `ClassementService` — calcul à partir des covoiturages validés.

## Règles à intégrer

- Vérifier les droits sur les données de chaque salarié.
- Vérifier les dates et la capacité du véhicule.
- Empêcher le conducteur de réserver son propre trajet.
- Éviter le dépassement des places, même avec des réservations simultanées.
- Réutiliser une participation annulée lors d’une nouvelle réservation.
- Gérer les participations lors de l’annulation d’un trajet.
- Vérifier la cohérence service/poste/horaire.
- Gérer les suppressions d’éléments encore utilisés.
- Définir qui valide et comment calculer le classement.

## Intégrations restantes

- Ajouter les filtres de recherche de trajets.
- Intégrer géolocalisation conducteur et estimation de durée.
- Finaliser le mécanisme de connexion avec Expo.
- Prévoir la création initiale d’un compte ADMIN.
- Tester les parcours complets et les droits après implémentation.

## Authentification actuelle

- HTTP Basic avec les comptes de la table `salaries`.
- Mot de passe BCrypt, rôle SALARIE ou ADMIN.
- Anciens comptes de test en mémoire retirés.
- Inscription publique, mais encore en 501.
- `ConnexionRequest.java` actuellement inutilisé.

## Vérifié

- Compilation et démarrage.
- Swagger accessible.
- Routes protégées refusées sans connexion.
- Validation des champs obligatoires de l’inscription.

## Encore à vérifier

- Connexion avec des comptes BDD.
- Droits salarié/admin.
- Contraintes SQL et réponses d’erreur.
- Fonctionnement complet après implémentation des services.