# Backend — passage de relais

Travail sur la branche `allan`.
Créer la branche `tom` depuis `allan` pour reprendre.

## Stack

- Java 21, Spring Boot, Spring Security.
- PostgreSQL dans Docker.
- Maven Wrapper.
- Swagger pour tester l’API.

## Organisation des fichiers

Même fonctionnement dans les packages `serviceentreprise`, `poste` et `horaire`.

- `Nom.java` — entité JPA, champs et relations avec les autres entités.
- `NomRepository.java` — accès à la BDD, recherche, enregistrement et suppression.
- `NomRequest.java` — données reçues en POST/PUT et contraintes de validation.
- `NomResponse.java` — données renvoyées au client.
- `NomService.java` — logique métier, CRUD et vérification des éléments existants.
- `NomController.java` — routes GET, POST, PUT et DELETE.

Autres fichiers.

- `auth/SecurityConfig.java` — droits d’accès et comptes temporaires de développement.
- `auth/OpenApiConfig.java` — documentation Swagger et bouton Authorize.
- `application.properties` — configuration de l’application et connexion BDD.
- `compose.yaml` — lancement de PostgreSQL dans Docker.
- `pom.xml` — dépendances et configuration Maven.
- `docs/` — MCD, MLD et logigramme.

## Déjà développé

- [x] MCD et MLD corrigés et synchronisés.
- [x] Logigramme de navigation.
- [x] CRUD services d’entreprise.
- [x] CRUD postes, chaque poste appartient à un service.
- [x] CRUD horaires, chaque horaire appartient à un service.
- [x] Swagger avec authentification Basic.
- [x] Sécurité dev — GET salarié/admin, écritures admin.
- [x] Tests services et postes.

## Vérifications avant reprise

- [ ] Terminer les tests horaires.
- [ ] Vérifier le PUT avec les vrais identifiants horaire/service.
- [ ] Vérifier les derniers commits et le push sur `allan`.

## Backend restant

### Salariés

- [ ] Entité, repository, DTO, service et controller.
- [ ] Gestion des informations du salarié.
- [ ] Affectation à un poste et à un horaire.
- [ ] Modification du profil et contrôle des droits.

### Authentification

- [ ] Remplacer les comptes en mémoire par les salariés en BDD.
- [ ] Inscription avec e-mail unique et mot de passe haché.
- [ ] Connexion et authentification adaptée à Expo.
- [ ] Gestion des rôles SALARIE et ADMIN.
- [ ] Empêcher l’attribution du rôle ADMIN depuis l’inscription.

### Véhicules

- [ ] CRUD et rattachement au propriétaire.
- [ ] Marque, modèle et nombre de places passagers.
- [ ] Autoriser le propriétaire à gérer ses véhicules.

### Trajets

- [ ] CRUD et rattachement au conducteur et au véhicule.
- [ ] Adresses et coordonnées de départ/arrivée.
- [ ] Dates, heures, places proposées et statuts.
- [ ] Géolocalisation obligatoire dans le parcours conducteur.
- [ ] Estimation de la durée via un service d’itinéraire.
- [ ] Recherche par départ, arrivée, date et horaires.
- [ ] Modification et annulation des trajets.

### Participations

- [ ] Réservation d’une place par un salarié.
- [ ] Liste des réservations du salarié.
- [ ] Liste des passagers d’un trajet.
- [ ] Annulation et validation après le trajet.
- [ ] Empêcher les doubles réservations.
- [ ] Empêcher le conducteur de réserver son propre trajet.
- [ ] Gérer les réservations simultanées sans dépasser les places.
- [ ] Gérer les participations lorsqu’un trajet est annulé.

### Classement

- [ ] Définir le calcul et les salariés récompensés.
- [ ] Calculer à partir des covoiturages validés.
- [ ] Exposer une route pour consulter le classement.

### Finalisation

- [ ] Compléter les règles dans SecurityConfig.
- [ ] Vérifier les droits sur chaque ressource.
- [ ] Gérer les doublons de postes avec une réponse 409.
- [ ] Gérer les suppressions d’éléments encore utilisés.
- [ ] Tester les cas métier et les erreurs.
- [ ] Connecter l’application Expo à l’API.

## Règles à préciser

- Qui valide une participation après le trajet.
- Calcul du classement.
- Qui affecte et modifie les postes/horaires des salariés.
- Effet d’une modification ou suppression sur les données liées.

## Lancement

Depuis la racine.

    docker compose up -d db

Depuis `backend`.

    .\mvnw.cmd spring-boot:run "-Dspring-boot.run.profiles=dev"

Swagger.

    http://localhost:8080/swagger-ui/index.html

## Comptes de test — profil dev

- Admin — admin@covoiturage.test / AdminDev123!
- Salarié — salarie@covoiturage.test / SalarieDev123!

## Points à connaître

- Comptes de test stockés en mémoire.
- Tables créées/mises à jour par Hibernate, sans migrations.
- Horaires de nuit acceptés, heures de début et fin identiques refusées.
- Packages encore à implémenter à partir des fichiers vierges.
- Utiliser les vrais identifiants de la BDD dans Swagger.