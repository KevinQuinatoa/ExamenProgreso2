# Taller CineLikes

## Enunciado

Un cineclub universitario necesita una aplicación para administrar su catálogo de películas.
Los participantes podrán registrar películas, localizar las que les interesan, borrar peliculas y editar sus datos y expresar sus preferencias mediante un botón «Me gusta».
El cineclub desea consultar un ranking de popularidad.

Creen un nuevo proyecto. Utilicen **ArrayList, búsqueda lineal, búsqueda binaria, ordenamiento y Java Swing**.
La lógica debe quedar separada de los eventos de la interfaz.

El equipo trabajará en **un único repositorio de GitHub**, con commits de código desde **al menos tres cuentas distintas**. 
Cada integrante debe realizar al menos un commit significativo.

## Datos de la película

| Atributo | Tipo | Regla |
|---|---|---|
| `numeroID` | `int` | Positivo, único después del registro. |
| `titulo` | `String` | Obligatorio; puede repetirse en películas con códigos diferentes. |
| `director` | `String` | Obligatorio; puede repetirse. |
| `genero` | `String` | Obligatorio; seleccionado de un JComboBox. |
| `anio` | `int` | Desde 1930 hasta el año actual. |
| `meGusta` | `int` | No negativo; inicialmente 0 para películas nuevas. Solo aumenta mediante el botón Me gusta. |

Los géneros del ejercicio son Drama, Aventura, Comedia, Animación, y Documental.

## Organización de los datos

La colección principal será `ArrayList<Pelicula>` cree un método para que se encuentre ordenada por numero descendente para utilizar la búsqueda binaria.

Para el ranking, muestre los datos ordenados por me gusta de manera descendente.
La lista principal debe conservar su orden para que siga funcionando nuevos ingresos.


## Requerimientos funcionales

### R1 Cargar veinte películas al iniciar

-En un primer Tab de un componentes JTabbedPane listar todos los elementos en un JList
- Precargar exactamente veinte películas.
- Revisar que no se ingresen numeros duplicados y que se permita valores repetidos en género, año y me gusta.
- Cargar una sola vez durante la ejecución. Cambiar de pestaña, buscar o actualizar el ranking no debe reiniciar los contadores ni duplicar registros.
- Mostrar la cantidad actual de películas. Trabajar en memoria; no se exige persistencia en archivos ni base de datos.


### R2 Registrar nuevas películas

-En el primer Tab del JTabbedPane crear los controles para registrar nuevas peliculas
- Incorporar un formulariode ingreso con código, título, director, género y año, más el botón Registrar.
- Validar los campos obligatorios, el código positivo, el año permitido y que no exista otro registro con el mismo código.
- Las nuevas películas comienzan con cero me gusta; ese valor no se escribe en el formulario.
- Si hay errores, mostrar un mensaje sin registrar parcialmente la película ni cambiar los datos anteriores.

Debe poder registrarse un código menor que los existentes, por ejemplo 1999. No se puede asumir que los nuevos códigos siempre pertenecen al final de la lista ordenada.

### R3 Buscar coincidencias de texto
-En un segundo Tab de un componentes JTabbedPane, Implementar búsqueda sobre título y director unicamente por exactitud:

- Mayúsculas y minúsculas seran diferentes.
- Incluir una película si el texto exacto aparece en el título **o** en el nombre del director, hacerlo desde un solo textfield y un solo boton.
- Rechazar consultas nulas, vacías o formadas solo por espacios.
- Mostrar los resultados en un `TextArea`.


### R4 Buscar por numero 
-En el segundo Tab, Implementar una búsqueda binaria propia sobre la colección principal:

- Devolver el índice correspondiente o `-1` cuando no exista.
- Rechazar numero no positivos.
- Al encontrar una película, cargar sus datos en componentes para la edición o mostrar un mensaje de que no existe el elemento buscado.
- Permitir modificar título, director, género y año. No editar numero ni escribir manualmente el contador de me gusta.
- Validar todos los nuevos valores antes de guardar. Si uno falla, no modificar parcialmente los otros atributos.
- Si el código no se encuentra, mostrar un aviso y limpiar cualquier selección anterior para evitar cambios sobre otra película.
- Actualizar los datos, mostrar un aviso mediante ShowMessajeDialog, estos cambios deben reflejarse en el tab1 en el listado de peliculas.
- Agregar un boton Borrar, una vez Buscado por código y una vez encontrada la película, hay un boton para **ELIMINAR PELICULA**, que elimina del arraylist por completo.

### R5 Dar me gusta a una película seleccionada
-En el segundo Tab,
- Buscar por código y una vez encontrada la película, hay un boton para pulsar **Me gusta +1**.
- Cada clic válido incrementa únicamente en uno el contador del registro seleccionado.
- Mostrar el contador actualizado y refrescar las vistas correspondientes.
- Sin una selección válida, mostrar un aviso sin modificar ninguna película.
- Para esta simulación se permiten varios clics sobre la misma película. No se requieren cuentas de espectadores ni la operación de quitar me gusta.

El incremento ocurre únicamente al pulsar el botón.

### R6 Ordenar el ranking 

Implementar el siguiente método:
-En el Tercer Tab,
- Mostrar en un nuevo JList todos los elementos ordenados por me gusta descendente.
- Conservar todas las películas, incluso cuando tengan la misma cantidad de me gusta.
- Mostrar en una JList el numero, título y contador de cada película.
- Después de consultar el ranking, la búsqueda binaria por numero debe seguir funcionando correctamente.

## Interfaz requerida con JTabbedPane

La interfaz debe ser elaborada manualmente por los estudiantes. 
Después de registrar, editar o dar me gusta, actualizar las vistas afectadas sin volver a cargar los datos iniciales. Si una edición hace que la película deje de coincidir con el texto buscado, recalcular los resultados y limpiar la selección cuando corresponda.

## Trabajo en GitHub y entrega

1. Crear un repositorio único por equipo, accesible al docente.
2. Incluir commits de código desde al menos tres cuentas diferentes y al menos un aporte significativo por integrante.
3. No se exige utilizar ramas ni pull requests. Pueden trabajar con el procedimiento de carga que aprendieron en clase, conservando la autoría de cada aporte.
4. Entregar enlace al repositorio, código integrado, capturas de las tres pestañas y evidencia de los casos de comprobación.
5. Completar la tabla de aportes. Cualquier integrante debe poder ejecutar el programa y explicar la colaboración del equipo.

| Integrante | Usuario GitHub | Mensaje de commit 
|---|---|---|---|

Verificar que GitHub muestre correctamente la autoría. Si utilizan Git local, configurar un correo asociado a la cuenta correspondiente. No compartir cuentas.

## Rúbrica sobre 10 puntos


| Criterio | Puntaje máximo | Evidencia |
|---|---|---|
| Funcionamiento | 4 | Los seis requerimientos y los casos de comprobación funcionan. Cualquier integrante ejecuta la demostración. |
| Interfaz realizada manualmente por los estudiantes | 3 | JTabbedPane, formularios, JList, botones y mensajes conectados correctamente. Cualquier integrante ejecuta y muestra la interfaz. |
| GitHub | 3 | Un repositorio, commits desde al menos tres cuentas y aportes identificables. 


