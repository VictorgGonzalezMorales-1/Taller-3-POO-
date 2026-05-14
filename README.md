# Taller 3 - Sistema de Magos y Hechizos en Consola

## Descripción del proyecto

Este proyecto corresponde al Taller 3 de Programación Orientada a Objetos, desarrollado durante el I Semestre de 2026 para la carrera de Ingeniería Civil Industrial (ICI).

El proyecto consiste en la creación de un sistema interactivo por consola implementado en lenguaje Java, orientado a la administración y análisis de magos y hechizos dentro de un mundo ficticio donde la magia domina las capacidades de cada personaje.

En este sistema, cada mago posee un repertorio de hechizos. Cada hechizo pertenece a un tipo elemental y posee propiedades particulares que permiten calcular su puntuación. Los elementos considerados son Fuego, Tierra/Roca, Planta y Agua.

Toda la información del programa se carga desde archivos de texto y se conserva mediante persistencia de datos, permitiendo que los cambios realizados durante la ejecución se mantengan después de cerrar el programa. Para ello se utilizan principalmente los archivos `Magos.txt` y `Hechizos.txt`.

El sistema aplica principios de Programación Orientada a Objetos, utilizando separación entre la lógica principal, las clases del dominio, una interfaz de sistema, herencia mediante una clase abstracta para los hechizos, subclases específicas para cada tipo elemental y colecciones dinámicas para almacenar magos y hechizos.

---

## Funcionalidades principales

El programa permite:

- Cargar información inicial desde archivos `.txt`.
- Leer el catálogo general de hechizos desde `Hechizos.txt`.
- Leer los magos registrados desde `Magos.txt`.
- Crear objetos de tipo hechizo según su elemento.
- Asociar hechizos existentes a cada mago.
- Calcular la puntuación individual de cada hechizo.
- Calcular la puntuación total de cada mago.
- Ordenar hechizos de mayor a menor puntuación.
- Ordenar magos de mayor a menor puntuación.
- Mostrar el Top 10 de mejores hechizos.
- Mostrar el Top 3 de mejores magos.
- Mostrar todos los hechizos registrados.
- Mostrar todos los magos registrados.
- Mostrar todos los hechizos junto a su puntuación.
- Mostrar todos los magos junto a su puntuación.
- Agregar nuevos magos.
- Modificar magos existentes.
- Eliminar magos.
- Agregar nuevos hechizos.
- Modificar hechizos existentes.
- Eliminar hechizos.
- Reflejar los cambios del panel Administrador en los archivos `.txt`.
- Mantener el formato original de los archivos de datos.
- Evitar errores por líneas vacías, registros incompletos o entradas numéricas inválidas.

---

## Integrantes

| Nombre | Carrera | RUT | Usuario GitHub |
|---|---|---|---|
| Victor Manuel Gonzalez Morales | Ingeniería Civil Industrial | 22.061.552-9 | VictorgGonzalezMorales-1 |
| Joaquin Esteban Torres Flores | Ingeniería Civil Industrial | 21.547.370-8 | JoaquinTFdev1 |

---

## Estructura general del proyecto

El proyecto se encuentra organizado principalmente en dos paquetes:

```txt
dominio
logica
```

La estructura general del proyecto es la siguiente:

```txt
Taller3/
│
├── src/
│   │
│   ├── dominio/
│   │   ├── Hechizo.java
│   │   ├── Agua.java
│   │   ├── Fuego.java
│   │   ├── Planta.java
│   │   ├── Roca.java
│   │   └── Mago.java
│   │
│   └── logica/
│       ├── Main.java
│       ├── Sistema.java
│       └── SistemaImplementado.java
│
├── Magos.txt
├── Hechizos.txt
│
├── DiagramaDeClases.pdf
├── ModeloDeDominio.pdf
└── README.md
```

---

## Archivos de datos

El programa utiliza archivos de texto para cargar y guardar información durante la ejecución.

```txt
Magos.txt
Hechizos.txt
```

Ambos archivos deben encontrarse en la raíz del proyecto, no dentro de la carpeta `src`.

---

# Clases principales

## Main

Clase principal del programa. Contiene el método `main()` y controla el flujo general de ejecución por consola.

### Responsabilidades principales

- Crear el objeto comunicador con el sistema.
- Cargar los datos iniciales desde `Hechizos.txt`.
- Cargar los datos iniciales desde `Magos.txt`.
- Mostrar el menú principal del programa.
- Permitir ingresar al panel Administrador.
- Permitir ingresar al panel Analista.
- Recibir opciones por teclado.
- Validar entradas numéricas mediante `leerEntero`.
- Coordinar las acciones solicitadas por el usuario.
- Enviar información a `SistemaImplementado`.

### Flujo general

```txt
Main inicia el programa
Main lee Hechizos.txt
Main lee Magos.txt
Main muestra el menú principal
Usuario selecciona Administrador o Analista
Main solicita acciones al Sistema
Sistema procesa la información
Main muestra resultados en consola
```

---

## Sistema

Interfaz que define las operaciones principales que debe cumplir el sistema.

### Responsabilidades principales

- Declarar los métodos de gestión de magos.
- Declarar los métodos de gestión de hechizos.
- Declarar los métodos de ordenamiento.
- Declarar los métodos del panel Administrador.
- Declarar los métodos del panel Analista.
- Declarar los métodos de persistencia.

### Métodos principales

```java
void trabajarHechizo(String[] partes);
void trabajarMago(String[] partes, boolean agregarHechizos);

void ordenarHechizos();
void ordenarMagos();

boolean eliminarMago(int i);
boolean eliminarHechizo(int n);

boolean modificarMago(int posicion, String[] partes);
boolean modificarHechizo(int posicion, String[] partes);

void guardarMagos();
void guardarHechizos();

String entregarTopHechizos();
String entregarTopMago();
String solicitarhechizos();
String solicitarMagos();
String entregarHechizosPuntuacion();
String entregarMagosPuntuacion();
```

---

## SistemaImplementado

Clase encargada de implementar la lógica central del programa.

Funciona como intermediaria entre `Main` y las clases del paquete `dominio`.

### Responsabilidades principales

- Almacenar la lista general de hechizos.
- Almacenar la lista general de magos.
- Crear hechizos a partir de líneas de texto.
- Crear magos a partir de líneas de texto.
- Buscar hechizos por nombre.
- Asociar hechizos a magos.
- Evitar duplicación de hechizos en el catálogo general.
- Ordenar hechizos según su puntuación.
- Ordenar magos según su puntuación.
- Entregar reportes al panel Analista.
- Eliminar magos.
- Eliminar hechizos.
- Modificar magos.
- Modificar hechizos.
- Actualizar los magos cuando un hechizo es eliminado o modificado.
- Guardar los cambios en `Magos.txt`.
- Guardar los cambios en `Hechizos.txt`.
- Controlar errores de formato en la creación de hechizos.

### Colecciones utilizadas

```java
private static LinkedList<Hechizo> H;
private static LinkedList<Mago> M;
```

Donde:

- `H` almacena todos los hechizos disponibles.
- `M` almacena todos los magos registrados.

---

## Mago

Clase que representa a cada mago dentro del sistema.

### Atributos principales

```java
private String nombreMago;
private LinkedList<Hechizo> hechizos;
```

### Responsabilidades principales

- Guardar el nombre del mago.
- Almacenar los hechizos que domina.
- Permitir agregar hechizos al repertorio.
- Permitir olvidar o eliminar hechizos.
- Calcular la puntuación total del mago.
- Entregar el nombre del mago.
- Entregar la lista de hechizos.
- Generar el formato de guardado para `Magos.txt`.

### Cálculo de puntuación del mago

La puntuación de un mago corresponde a la suma de las puntuaciones de todos los hechizos que domina.

```txt
PuntajeMago = PuntajeHechizo1 + PuntajeHechizo2 + PuntajeHechizoN
```

Ejemplo:

```txt
Pruno;Sofoco|Disparo Lodo|Pirotecnia|Vórtice Ígneo
```

El sistema busca cada hechizo, obtiene su puntuación individual y luego suma todos los valores.

---

## Hechizo

Clase abstracta que representa la base común de todos los hechizos.

### Atributos principales

```java
protected String nombreHechizo;
protected String tipoHechizo;
protected int daño;
```

### Responsabilidades principales

- Guardar el nombre del hechizo.
- Guardar el tipo elemental del hechizo.
- Guardar el daño base del hechizo.
- Entregar el nombre del hechizo.
- Definir el método abstracto para calcular puntuación.
- Definir el método abstracto para retornar el formato de archivo.

### Métodos principales

```java
public String getNombreHechizo();
public String getTipoHechizo();
public int getDaño();

public abstract int entregarPuntaje();
public abstract String formatoArchivo();
```

Esta clase permite aplicar herencia, ya que todos los hechizos comparten atributos generales, pero cada tipo calcula su puntuación de manera diferente.

---

## Fuego

Clase hija de `Hechizo`. Representa los hechizos de tipo Fuego.

### Atributo específico

```java
private int duracionQuemadura;
```

### Fórmula de puntuación

```txt
Puntaje = Daño * DuracionQuemadura
```

### Formato en archivo

```txt
NombreHechizo;Fuego;Daño;DuracionQuemadura
```

### Ejemplo

```txt
Calcinación;Fuego;21;4
```

---

## Roca

Clase hija de `Hechizo`. Representa los hechizos de tipo Tierra/Roca.

Aunque la clase se denomina `Roca`, el archivo de datos utiliza el tipo `Tierra`. Por esta razón, el sistema interpreta los registros de tipo `Tierra` mediante la clase concreta `Roca`.

### Atributo específico

```java
private int mejoraDefensa;
```

### Fórmula de puntuación

```txt
Puntaje = (Daño * MejoraDefensa) / 2
```

### Formato en archivo

```txt
NombreHechizo;Tierra;Daño;MejoraDefensa
```

### Ejemplo

```txt
Tumba Rocas;Tierra;18;40
```

---

## Planta

Clase hija de `Hechizo`. Representa los hechizos de tipo Planta.

### Atributos específicos

```java
private int duracionStun;
private int cantPlantas;
```

### Fórmula de puntuación

```txt
Puntaje = Daño + (DuracionStun * CantPlantas)
```

### Formato en archivo

```txt
NombreHechizo;Planta;Daño;DuracionStun,CantPlantas
```

### Ejemplo

```txt
Polen Somnífero;Planta;81;3,10
```

---

## Agua

Clase hija de `Hechizo`. Representa los hechizos de tipo Agua.

### Atributos específicos

```java
private int cantidadHeal;
private int presionDelAgua;
```

### Fórmula de puntuación

```txt
Puntaje = (Daño + CantidadHeal + PresionDelAgua) * 2
```

### Formato en archivo

```txt
NombreHechizo;Agua;Daño;CantidadHeal,PresionDelAgua
```

### Ejemplo

```txt
Escaldar;Agua;110;45,360
```

---

# Archivos utilizados por el programa

## Hechizos.txt

Contiene todos los hechizos disponibles en el sistema.

### Formato general

```txt
NombreHechizo;Tipo;Daño;DatosExtra
```

### Formato por tipo

```txt
Fuego:
NombreHechizo;Fuego;Daño;DuracionQuemadura

Tierra/Roca:
NombreHechizo;Tierra;Daño;MejoraDefensa

Planta:
NombreHechizo;Planta;Daño;DuracionStun,CantPlantas

Agua:
NombreHechizo;Agua;Daño;CantidadHeal,PresionDelAgua
```

### Ejemplos

```txt
Escaldar;Agua;110;45,360
Tumba Rocas;Tierra;18;40
Polen Somnífero;Planta;81;3,10
Ascuas;Fuego;77;5
```

---

## Magos.txt

Contiene los magos registrados y los hechizos que domina cada uno.

### Formato general

```txt
NombreMago;Hechizo1|Hechizo2|HechizoN
```

### Ejemplo

```txt
Pruno;Sofoco|Disparo Lodo|Pirotecnia|Vórtice Ígneo
Ferran;Salmuera|Envite Igneo|Disparo Lodo|Poder Pasado|Rueda Fuego|Hidroariete|Burbuja
Sasa;Infierno|Martillazo|Hidroariete|Envite Igneo
```

### Mago sin hechizos

El sistema también permite mantener un mago sin hechizos registrados, conservando el siguiente formato:

```txt
NombreMago;
```

Ejemplo:

```txt
Pukki;
```

Este formato se conserva mediante `split(";", -1)`, lo que permite reconocer el nombre del mago y mantener el campo de hechizos vacío sin provocar errores de lectura.

---

# Flujo general de ejecución

1. Se ejecuta `Main.java`.
2. Se instancia el sistema mediante la interfaz `Sistema`.
3. Se carga `Hechizos.txt`.
4. Cada línea válida del archivo se separa por `;`.
5. El sistema identifica el tipo de hechizo.
6. Se crea el objeto correspondiente: `Fuego`, `Roca`, `Planta` o `Agua`.
7. Se almacena el hechizo en la lista general.
8. Se carga `Magos.txt`.
9. Cada línea válida del archivo se separa por `;`.
10. Se crea un objeto `Mago`.
11. Si el mago posee hechizos, estos se separan por `|`.
12. El sistema busca cada hechizo en el catálogo general.
13. Los hechizos encontrados se agregan al mago.
14. Se muestra el menú principal.
15. El usuario selecciona el panel Administrador, el panel Analista o la opción de finalizar.
16. El sistema ejecuta la acción solicitada.
17. Si se agregan, modifican o eliminan registros, se actualizan los archivos `.txt`.
18. Al finalizar, los datos permanecen guardados para futuras ejecuciones.

---

# Menú principal

Al ejecutar el programa se muestra:

```txt
Taller 3

1) Ingresar al panel de Administrador
2) Ingresar al panel de Analista
3) Finalizar programa
```

---

# Panel Administrador

El panel Administrador permite gestionar los registros principales del sistema.

```txt
1) Agregar Mago
2) Modificar Mago
3) Eliminar Mago
4) Agregar Hechizo
5) Modificar Hechizo
6) Eliminar Hechizo
7) Salir del Administrador
```

---

## 1) Agregar Mago

Permite registrar un nuevo mago en el sistema.

### Formato esperado

```txt
NombreMago;Hechizo1|Hechizo2|HechizoN
```

### Ejemplo

```txt
Pukki;Sofoco|Disparo Lodo|Pirotecnia
```

También se puede registrar un mago sin hechizos:

```txt
Pukki;
```

El sistema conserva este formato y lo guarda en `Magos.txt`.

---

## 2) Modificar Mago

Permite reemplazar la información de un mago existente.

El usuario selecciona la posición del mago en la lista y luego ingresa los nuevos datos con el formato:

```txt
NombreMago;Hechizo1|Hechizo2|HechizoN
```

O bien:

```txt
NombreMago;
```

si el mago quedará sin hechizos.

---

## 3) Eliminar Mago

Permite eliminar un mago desde la lista general.

El usuario selecciona la posición del mago que desea eliminar. Si la posición es válida, el sistema elimina el objeto de la lista y actualiza `Magos.txt`.

---

## 4) Agregar Hechizo

Permite registrar un nuevo hechizo.

El usuario ingresa:

- Nombre del hechizo.
- Tipo elemental.
- Daño.
- Propiedades específicas según el tipo.

### Tipos disponibles

```txt
1) Fuego
2) Tierra
3) Planta
4) Agua
```

Según el tipo seleccionado, el programa solicita los datos adicionales necesarios.

---

## 5) Modificar Hechizo

Permite modificar un hechizo existente.

El usuario selecciona la posición del hechizo y luego ingresa los nuevos datos con el formato:

```txt
NombreHechizo;Tipo;Daño;DatosExtra
```

Cuando un hechizo es modificado, el sistema actualiza también los magos que tenían asociado ese hechizo.

---

## 6) Eliminar Hechizo

Permite eliminar un hechizo del catálogo general.

Cuando se elimina un hechizo, el sistema también lo elimina del repertorio de todos los magos que lo poseían. Luego se actualizan `Hechizos.txt` y `Magos.txt`.

---

# Panel Analista

El panel Analista permite consultar información calculada y ordenada del sistema.

```txt
1) Top 10 Mejores Hechizos
2) Top 3 Mejores Magos
3) Mostrar todos los Hechizos
4) Mostrar todos los magos
5) Mostrar todos los Hechizos junto a su puntuacion
6) Mostrar todos los magos junto a su puntuacion
7) Salir del Analista
```

---

## 1) Top 10 Mejores Hechizos

Muestra los diez hechizos con mayor puntuación.

Antes de mostrar el resultado, el sistema ordena la lista de hechizos de mayor a menor según `entregarPuntaje()`.

---

## 2) Top 3 Mejores Magos

Muestra los tres magos con mayor puntuación total.

Antes de mostrar el resultado, el sistema ordena la lista de magos de mayor a menor según la suma de sus hechizos.

---

## 3) Mostrar todos los Hechizos

Muestra la lista completa de hechizos registrados en el sistema.

---

## 4) Mostrar todos los magos

Muestra la lista completa de magos registrados en el sistema.

---

## 5) Mostrar todos los Hechizos junto a su puntuación

Muestra cada hechizo junto con su puntuación calculada.

Ejemplo de salida:

```txt
1) Excavar - Puntaje: 2580
2) Fuerza Equina - Puntaje: 2244
3) Ataque Arena - Puntaje: 2040
```

---

## 6) Mostrar todos los magos junto a su puntuación

Muestra cada mago junto con su puntuación total.

Ejemplo de salida:

```txt
1) NicolasDiaz - Puntaje: 7671
2) Ferran - Puntaje: 4820
3) DamianValdivia - Puntaje: 4427
```

---

# Mecánica de puntuación

Cada tipo de hechizo posee una fórmula diferente.

## Fuego

```txt
Puntaje = Daño * DuracionQuemadura
```

## Tierra/Roca

```txt
Puntaje = (Daño * MejoraDefensa) / 2
```

## Planta

```txt
Puntaje = Daño + (DuracionStun * CantPlantas)
```

## Agua

```txt
Puntaje = (Daño + CantidadHeal + PresionDelAgua) * 2
```

---

# Cálculo de mejor mago

La puntuación de cada mago se obtiene sumando las puntuaciones de todos los hechizos que domina.

```txt
PuntajeMago = Σ PuntajeHechizo
```

Ejemplo:

```txt
Pruno;Sofoco|Disparo Lodo|Pirotecnia|Vórtice Ígneo
```

Si sus hechizos tienen las siguientes puntuaciones:

```txt
Sofoco = 144
Disparo Lodo = 696
Pirotecnia = 156
Vórtice Ígneo = 80
```

Entonces:

```txt
Puntaje Pruno = 144 + 696 + 156 + 80
Puntaje Pruno = 1076
```

---

# Reglas y restricciones

- Los archivos `Magos.txt` y `Hechizos.txt` deben estar en la raíz del proyecto.
- Los archivos no deben ubicarse dentro de `src`.
- El formato de los archivos debe respetarse estrictamente.
- Los hechizos de los magos deben coincidir por nombre con los hechizos existentes en `Hechizos.txt`.
- Si un hechizo mencionado por un mago no existe en el catálogo, no se agrega al repertorio del mago.
- Un mago puede quedar registrado sin hechizos usando el formato `NombreMago;`.
- Los hechizos no deben duplicarse dentro del catálogo general.
- Al eliminar un hechizo, este también se elimina de los magos que lo tenían.
- Al modificar un hechizo, el cambio debe reflejarse en los magos que lo poseen.
- El panel Administrador debe reflejar sus cambios en los archivos `.txt`.
- El panel Analista debe mostrar información ordenada y calculada a partir de los datos cargados.
- Las entradas numéricas inválidas deben ser controladas para evitar caídas del programa.
- Las líneas vacías o incompletas en los archivos deben ser ignoradas durante la lectura.

---

# Control de errores

El programa incorpora validaciones para evitar caídas durante la ejecución, especialmente en:

- Entradas numéricas inválidas.
- Opciones fuera de rango.
- Posiciones inexistentes al modificar magos.
- Posiciones inexistentes al eliminar magos.
- Posiciones inexistentes al modificar hechizos.
- Posiciones inexistentes al eliminar hechizos.
- Líneas vacías en `Magos.txt`.
- Líneas vacías en `Hechizos.txt`.
- Líneas incompletas en archivos.
- Registros con formato incorrecto.
- Hechizos inexistentes al asociarlos a un mago.
- Tipos de hechizo no reconocidos.
- Datos numéricos mal formateados.
- Conversión inválida de texto a número.
- Objetos nulos durante la lectura o modificación.
- Escritura incorrecta de archivos.
- Líneas vacías al final de los archivos `.txt`.

Para controlar entradas numéricas, el programa utiliza el método `leerEntero`, que evita que el sistema se cierre si el usuario ingresa letras u otros caracteres no numéricos al seleccionar posiciones.

---

# Persistencia de datos

La persistencia se realiza mediante lectura y escritura de archivos de texto.

## Lectura

Al iniciar el programa, se cargan:

```txt
Hechizos.txt
Magos.txt
```

Primero se cargan los hechizos, porque los magos dependen de ellos para asociar correctamente sus repertorios.

## Escritura

Cuando el usuario realiza cambios desde el panel Administrador, el sistema actualiza los archivos correspondientes:

```txt
Agregar Mago      -> actualiza Magos.txt
Modificar Mago    -> actualiza Magos.txt
Eliminar Mago     -> actualiza Magos.txt

Agregar Hechizo   -> actualiza Hechizos.txt
Modificar Hechizo -> actualiza Hechizos.txt y Magos.txt
Eliminar Hechizo  -> actualiza Hechizos.txt y Magos.txt
```

Para la escritura se utiliza `BufferedWriter`, cuidando no generar líneas vacías adicionales y conservando el formato original de los archivos.

---

# Instrucciones de ejecución

## Requisitos

- Java JDK 8 o superior.
- IDE compatible con Java:
  - Eclipse.
  - IntelliJ IDEA.
  - Visual Studio Code.
  - NetBeans.

---

## Pasos para ejecutar

1. Clonar el repositorio desde GitHub:

```bash
git clone [URL_DEL_REPOSITORIO]
```

2. Abrir el proyecto en el IDE de preferencia.

3. Verificar que las clases se encuentren dentro de los paquetes correspondientes:

```txt
dominio
logica
```

4. Verificar que los archivos `.txt` estén ubicados en la raíz del proyecto:

```txt
Magos.txt
Hechizos.txt
```

5. Verificar que los archivos PDF solicitados se encuentren en la raíz del repositorio:

```txt
DiagramaDeClases.pdf
ModeloDeDominio.pdf
```

6. Ejecutar la clase principal:

```txt
Main.java
```

7. Navegar mediante números ingresados por teclado.

8. Seguir las instrucciones mostradas en consola.

---

# Consideraciones para ejecución en Eclipse

1. Importar el proyecto como proyecto Java existente.
2. Verificar que existan los paquetes:

```txt
dominio
logica
```

3. Verificar que `Main.java` tenga el método:

```java
public static void main(String[] args)
```

4. Verificar que los archivos `.txt` estén en la raíz del proyecto, no dentro de `src`.

5. Ejecutar con clic derecho sobre `Main.java`:

```txt
Run As → Java Application
```

---

# Diagramas y entregables

El repositorio debe incluir en la raíz los siguientes archivos:

```txt
DiagramaDeClases.pdf
ModeloDeDominio.pdf
README.md
Magos.txt
Hechizos.txt
```

## Diagrama de clases

Debe representar la estructura técnica del sistema, incluyendo:

- Clases.
- Atributos.
- Métodos.
- Herencia.
- Interfaz.
- Implementación de interfaz.
- Relaciones entre `Mago` y `Hechizo`.
- Relación entre `Sistema` y `SistemaImplementado`.

## Modelo de dominio

Debe representar la abstracción conceptual del problema, incluyendo:

- Mago.
- Hechizo.
- Tipo de hechizo.
- Relación entre mago y hechizo.
- Especialización de hechizos por tipo elemental.

---

# Tecnologías y conceptos aplicados

Este proyecto utiliza:

- Java.
- Programación Orientada a Objetos.
- Clases y objetos.
- Encapsulamiento.
- Abstracción.
- Herencia.
- Polimorfismo.
- Interfaces.
- Clases abstractas.
- Sobrescritura de métodos.
- Colecciones dinámicas con `LinkedList`.
- Lectura de archivos con `Scanner`.
- Escritura de archivos con `BufferedWriter`.
- Persistencia de datos mediante archivos `.txt`.
- Menús interactivos por consola.
- Ordenamiento de colecciones.
- Validación de entradas.
- Manejo de errores con `try/catch`.
- Separación de responsabilidades.
- Arquitectura por paquetes.

---

# Estado del proyecto

Proyecto desarrollado como entrega académica para el Taller 3 de Programación Orientada a Objetos, I Semestre 2026, carrera de Ingeniería Civil Industrial.

El sistema permite administrar magos y hechizos por consola, calcular puntuaciones según reglas específicas, generar rankings desde el panel Analista y mantener la persistencia de datos mediante archivos de texto.
