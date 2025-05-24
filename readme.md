# tarea2_doo
Khristian Daniel Alexander Villalobos Alfaro  
Alonso Ignacio Toledo Aceituno

Cambios significativos al UML original:
1) A todas las clases se les agregaron sus constructores.
2) Clase *"Informe"*: Esta clase se creó para simplificar la clase reunión.
 De manera que los métodos utilizados para crear el informe estén encapsulados dentro de esta clase.  
Posee una dependencia con Reunion porque el método elaborarInforme(...) tiene de parámetro una Reunion.
3) Enum *"Modalidad"*: Este enum se utiliza para diferenciar si una reunión es presencial o virtual
4) numero_nota y contenido en clase "Nota": 
El número de nota se utiliza para diferenciar las notas y el orden en que fueron creadas
y el contenido almacena texto que incluye la nota al momento de ser creada.
5) Clase *"Persona"*: Para poder aceptar a personas ajenas a la organización se crea esta clase genérica la cual
representa cualquier persona que pueda ser añadida a la reunion de manera que todas las clases están diseñadas 
para funcionar con objetos de tipo Persona y no exclusivamente empleados.  
Métodos invitar y resolver_invitación en clase Persona: el método invitar recibe 
la invitación, sin embargo, no la acepta o rechaza para ello el método resolver_invitación 
decide si el usuario acepta la invitación o no, en caso de aceptar es añadido a la 
reunión especificada por la invitación.
6) Clase *"Asistencia"*: Se le agregó el atributo persona, además se
cambió su asociación con Empleado a una composición con Persona, ya que asistencia posee a un objeto Persona
en su atributo final.
7) Clase *"Retraso"*: Se le agregó una dependencia a Informe, ya que su toString invoca al método estático
Informe.formatear_hora(...).
8) Clase *"Empleado"*: Se eliminaron sus atributos, ya que se extienden de Persona y en vez de asociarse 
con Asistencia y Reunion se generaliza de Persona.
9) Clase *"Departamento"*: se le agregó el atributo empleado y los métodos invitar(...) y agregarEmpleado(...), 
además ahora tiene una dependencia con Invitacion, ya que en su método invitar envía una Invitacion a todos sus empleados.
10) Clase *"Invitacion"*: se le agregó el atributo reunion y se cambió su composición con Reunion por una asociación,
ya que Invitacion posee un atributo público Reunion.
11) Clase *"Reunion"*: se le agregaron los atributos tipoDeReunion, lista_invitados, asistencias, ausencias, retrasos, 
notas y los métodos obtenerInvitados(), obtenerNotas(), agregarNota(...), quitarNota(...), crear_invitacion(...)
e invitaciones_Aceptadas().  
Se eliminó su asociación con Empleado, se cambió su asociación con tipoReunion por una dependencia con esta misma,
ya que Reunion posee un atributo final TipoReunion, ahora tiene una composición con Persona, porque Reunion posee dos atributos
tipo ArrayList< Persona>, ahora tiene una composición con Retraso, porque Reunion posee un atributo tipo 
ArrayList< Retraso>, ahora posee una dependencia con Invitacion, porque en crear_invitacion(...) crea y usa una 
nueva instancia de Invitacion.
12) Clases *"ReunionPresencial y ReunionVirtual"*: ambas ahora poseen una dependencia con Modalidad porque sus métodos
getModalidad() devuelven Modalidad.Presencial o Modalidad.Virtual respectivamente.
13) Clase *"Nota"*: se le agrego el atributo numero_nota.
14) Interfaz *"Invitable"*: ahora en vez de una asociación desde Invitacion posee una dependencia hacia ella,
ya que el método invitar(...) posee una Invitacion en su argumento.