Khristian Daniel Alexander Villalobos Alfaro, Alonso Ignacio Toledo Aceituno

Cambios significativos al UML principal:

1) Clase "Informe"": Esta clase se creó para simplicar la clase reunión. De manera que los métodos utilizados para crear el informe estén encapsulados dentro de esta clase
2) Enum "Modalidad": Este enum se utiliza para diferenciar si una reunión es presencial o virtual
3) numero_nota y contenido en clase "Nota": El número de nota se utiliza para diferenciar las notas y el orden en que fueron creadas y el contenido almacena texto que incluye la nota al momento de ser creada
4) Clase "Persona": Para poder aceptar a personas ajenas a la organización se crea esta clase genérica la cual representa cualquier persona que pueda ser añadida a la reunion de manera que todas las clases están diseñadas para funcionar con objetos de tipo Persona y no exclusivamente empleados
5) Métodos invitar y resolver_invitación en clase Persona: el método invitar recibe la invitación sin embargo no la acepta o rechaza para ello el método resolver_invitación decide si el usuario acepta la invitación o no, en caso de aceptar es añadido a la reunión especificada por la invitación