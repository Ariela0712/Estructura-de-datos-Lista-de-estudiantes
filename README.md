# Estructura-de-datos-Lista-de-estudiantes

# Sistema de control de estudiantes

Aplicación de consola desarrollada en Java para registrar estudiantes y consultar información usando una lista simplemente enlazada implementada en el proyecto.

## Enunciado

En el departamento de Informática se desea facilitar el control de los datos de los estudiantes. De cada estudiante se conoce el CI, nombre, apellido, sexo, año académico, si es militante de la UJC y si es becado.

El ejercicio consiste en implementar una lista simplemente enlazada y los siguientes métodos:

- Obtener los nombres de los estudiantes que cumplen años en un mes determinado.
- Obtener la información de los militantes de la UJC, ordenados por año académico de menor a mayor.
- Contar cuántos estudiantes son becados.

## ¿Para qué sirve?

El programa permite llevar un registro básico de estudiantes y consultar sus datos mediante un menú interactivo. Los métodos de consulta procesan los elementos almacenados en una lista enlazada propia, sin utilizar las colecciones de listas de Java.

## Objetivos

- Implementar una lista simplemente enlazada genérica con nodos.
- Registrar y recorrer estudiantes almacenados en la lista.
- Buscar estudiantes según el mes de cumpleaños.
- Filtrar y ordenar militantes de la UJC por año académico.
- Contar la cantidad de estudiantes becados.
- Comprobar el comportamiento con distintos casos de prueba.

## Funcionalidades

En el menú de la aplicación se puede:

1. Agregar un estudiante.
2. Mostrar los estudiantes registrados.
3. Consultar los estudiantes que cumplen años en un mes.
4. Mostrar los militantes de la UJC ordenados por año.
5. Consultar la cantidad de estudiantes becados.
6. Ejecutar los casos de prueba incluidos.
0. Salir.

### Métodos del ejercicio

| Método | Descripción |
| --- | --- |
| `cumpleanios(String mes)` | Devuelve una lista con los nombres y apellidos de los estudiantes cuyo mes de cumpleaños coincide con el indicado. Recibe el mes con dos dígitos, por ejemplo, `"05"`. |
| `cantMilitantes()` | Devuelve una lista nueva con los estudiantes militantes de la UJC ordenados por año académico ascendente. |
| `cantBecados()` | Devuelve la cantidad de estudiantes cuyo atributo `becado` es verdadero. |

El mes de cumpleaños se obtiene de los dígitos 3 y 4 del CI. Al registrar un estudiante, el programa valida que el CI tenga 11 dígitos, que el mes esté entre `01` y `12`, que el día esté entre `01` y `31` y que no exista otro estudiante con el mismo CI.

## Requisitos

- JDK instalado, con `javac` y `java` disponibles en la terminal.
- No se necesitan dependencias externas.

## Estructura del repositorio

```text
.
├── README.md
└── lista-estudiantes/
    ├── Estudiante.java
    ├── LinkedList.java
    ├── List.java
    ├── ListaEstudiantes.java
    ├── Main.java
    ├── Nodo.java
    ├── Sistema.java
    └── Validacion.java
```

## Compilar y ejecutar

Desde la raíz del repositorio, ejecuta:

```powershell
cd lista-estudiantes
javac *.java
java Main
```

También puedes abrir la terminal directamente dentro de `lista-estudiantes` y ejecutar `javac *.java` seguido de `java Main`.

Al iniciar aparecerá el menú. Para probar los métodos, selecciona la opción **6. Ejecutar casos de prueba**. Los resultados se muestran en la consola.

## Casos de prueba incluidos

La opción 6 ejecuta ejemplos para comprobar:

- Cumpleaños en mayo y noviembre, un mes sin coincidencias y una lista vacía.
- Militantes ordenados por año, comprobando también que la lista original conserva su orden.
- Una lista sin militantes y una lista vacía.
- El conteo de becados con estudiantes, sin estudiantes becados y con una lista vacía.

Los casos presentan los resultados para su comprobación visual en la consola.

## Implementación de la lista

`LinkedList<E>` implementa las operaciones básicas de una lista enlazada: agregar al final o en una posición, obtener y eliminar elementos por índice, consultar el tamaño, comprobar si está vacía y limpiar la lista. Cada `Nodo<E>` almacena un elemento y una referencia al nodo siguiente.

`ListaEstudiantes` extiende `LinkedList<Estudiante>` y añade las consultas específicas del ejercicio.
