# Taller CineLikes

Aplicación de escritorio en **Java Swing** para administrar el catálogo de un cineclub universitario. Permite registrar películas, buscarlas, editarlas, eliminarlas, dar «Me gusta» y consultar un ranking de popularidad.

Los datos se trabajan en memoria con `ArrayList`. No se usa persistencia en archivos ni base de datos.

---

## Integrantes y aportes

Asignación de aportes (sorteada al azar):

| Integrante | Usuario GitHub | Aporte principal | Mensaje de commit de referencia |
|---|---|---|---|
| Valeria Cáceres | `[usuario GitHub]` | R3 · Búsqueda exacta por título o director | `Agrega busqueda exacta por titulo o director (R3)` |
| Valeria Cáceres | `[usuario GitHub]` | R6 · Ranking ordenado por me gusta | `Agrega ranking por me gusta sobre copia de la coleccion (R6)` |
| Rafaela Ludeña | `[usuario GitHub]` | R5 · Botón Me gusta +1 | `Agrega incremento de me gusta por seleccion valida (R5)` |
| Jostin Saca | `JostinSaca` | R4 · Búsqueda binaria, edición y eliminación | `Agrega busqueda binaria por numeroID, edicion y eliminacion (R4)` |
| Kevin Quinatoa | `[usuario GitHub]` | R1 · Precarga de 20 películas y listado | `Precarga 20 peliculas y listado inicial (R1)` |
| Steven Vaca | `[usuario GitHub]` | R2 · Registro con validaciones e inserción ordenada | `Agrega registro de peliculas con validaciones (R2)` |

---

## Requisitos

- JDK 1.8 (Java 8)
- IntelliJ IDEA
- Sin dependencias externas

## Cómo ejecutar

1. Clonar el repositorio.
2. Abrirlo en IntelliJ IDEA y configurar el SDK en 1.8.
3. Ejecutar el método `main` de `Ventana.java`.

---

## Datos de una película

| Atributo | Tipo | Regla |
|---|---|---|
| `numeroID` | `int` | Positivo y único. |
| `titulo` | `String` | Obligatorio. Puede repetirse. |
| `director` | `String` | Obligatorio. Puede repetirse. |
| `genero` | `String` | Obligatorio. Se elige de un `JComboBox`: Drama, Aventura, Comedia, Animación o Documental. |
| `anio` | `int` | Desde 1930 hasta el año actual. |
| `meGusta` | `int` | No negativo. Inicia en 0 y solo aumenta con el botón «Me gusta +1». |

---

## Funcionalidades

| Requisito | Pestaña | Descripción |
|---|---|---|
| R1 | 1 · Registro | Precarga exactamente 20 películas al iniciar y las muestra en un `JList`. Muestra la cantidad actual. |
| R2 | 1 · Registro | Formulario con código, título, director, género y año, más el botón **Registrar**. Valida los datos antes de guardar. |
| R3 | 2 · Búsquedas | Búsqueda exacta (sensible a mayúsculas) por título **o** director, con un solo campo de texto y un botón. Resultados en un `JTextArea`. |
| R4 | 2 · Búsquedas | Búsqueda binaria por `numeroID`. Permite editar título, director, género y año, y eliminar la película. |
| R5 | 2 · Búsquedas | Botón **Me gusta +1** sobre la película seleccionada. |
| R6 | 3 · Ranking | Lista de todas las películas ordenadas por `meGusta` descendente, con número, título y contador. |

### Reglas importantes

- El código puede ser menor que los existentes (por ejemplo, 1999). La colección debe mantenerse ordenada por `numeroID` descendente al insertar.
- Si una validación falla, no se guarda nada: ni el registro ni la edición se aplican de forma parcial.
- Después de registrar, editar, eliminar o dar «Me gusta», las vistas se actualizan sin volver a cargar las películas iniciales.
- El ranking no debe alterar el orden de la colección principal.

---

## Estructura del proyecto

```text
src/
├── main/java/
│   ├── Pelicula.java            Modelo de una película
│   ├── GestionCineLikes.java    Lógica: ArrayList, búsquedas, ordenamiento y validaciones
│   ├── Ventana.java             Interfaz Swing (sin lógica de negocio)
│   └── Ventana.form            Diseño de la interfaz en IntelliJ
└── test/java/                   Pruebas de comprobación
capturas/                        Capturas de las tres pestañas
```

## Algoritmos

- **Búsqueda lineal:** texto exacto en título o director, y verificación de código único.
- **Búsqueda binaria:** por `numeroID` sobre la colección ordenada de forma descendente.
- **Ordenamiento:** inserción directa para mantener la colección por `numeroID` descendente, y ordenamiento del ranking por `meGusta` sobre una copia.

---

## Casos de comprobación

| Caso | Resultado esperado |
|---|---|
| Registrar código 1999 (menor que los existentes) | Se registra y la colección sigue ordenada. |
| Registrar un código ya existente | Mensaje de error; no se registra nada. |
| Registrar año 1929 o un año futuro | Mensaje de error. |
| Buscar texto formado solo por espacios | Consulta rechazada. |
| Buscar un director con el nombre exacto | Aparecen las películas de ese director. |
| Buscar con distinta mayúscula | No aparecen resultados si el texto no coincide exactamente. |
| Buscar un código inexistente | Aviso y selección limpiada. |
| Editar con un valor inválido | No se modifica ningún atributo. |
| Pulsar «Me gusta +1» varias veces | El contador aumenta en 1 por cada clic. |
| Ranking con películas empatadas | Todas se conservan en la lista. |
| Consultar el ranking y luego buscar por código | La búsqueda binaria sigue funcionando. |

---

## Capturas

- `capturas/pestana_registro.png`
- `capturas/pestana_busquedas.png`
- `capturas/pestana_ranking.png`

---

## Trabajo en equipo

- Repositorio único del equipo.
- Commits de código desde al menos tres cuentas distintas, con al menos un aporte significativo por integrante.
- Cada cuenta debe tener su correo configurado en Git (`git config user.email`).
- Los mensajes de commit deben describir el cambio realizado.
