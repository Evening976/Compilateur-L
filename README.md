# Compilateur Language L

Ce projet est un compilateur pour le langage Language L, un langage de programmation procédural similaire au C. Il a été implémenté en Java en utilisant SableCC pour l'analyse syntaxique et Nasm pour la génération de code assembleur. 
Fonctionnalités :
  - Analyse syntaxique : Le compilateur utilise SableCC pour générer un analyseur syntaxique fiable qui permet de traiter efficacement les programmes écrits en Language L.
  - Analyse sémantique : L'implémentation inclut une analyse sémantique pour détecter les erreurs de typage et assurer la cohérence du programme.
  - Génération de code intermédiaire : Le compilateur génère un code intermédiaire à partir du code source en Language L.

Comment utiliser : 

  1. **Cloner le dépôt** : Utilisez la commande git clone pour obtenir une copie locale du dépôt.
  2. **Compiler le projet**: Utilisez le makefile pour générer le compilateur.
  3. **Exécuter le compilateur** : Lancez le compilateur en spécifiant le fichier source en Language L en argument. Par exemple :
```bash
    java Compiler mon_programme.l -v [niveau de verbosité]
```
  4. **Exécuter le programme généré** : Après avoir compilé avec succès un programme en Language L, exécutez le fichier exécutable généré.

Ce qu'il manque : 
  - Graphe d'analyse/interférence pour l'utilisations des registres