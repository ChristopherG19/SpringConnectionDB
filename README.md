## Práctica#2
- Descripción
  - Pt.1: Debe crearse una conexión a una base de datos en OracleXE donde se encuentren 5 tablas. Se puede realizar: insert/update, delete y select de todas las tablas que poseen diferentes relaciones OneToMany y ManyToOne
  - Pt.2: Crear 5 consultas DSL, 1 consulta personalizada que contenga un join y Creación y consumo de un procedimiento almacenado

- Resultados:
  - Nombre tablas: authors, books, clientes, facturas, personas, photos, users
  - Select a la tabla utilizar: http://localhost:8686/{nombreTabla}/consultar
  - Insert/Update a la tabla utilizar: http://localhost:8686/{nombreTabla}/guardar
  - Delete a la tabla utilizar: http://localhost:8686/{nombreTabla}/eliminar/{id}
  
  - Consultas DSL:
    - Consultar personas menores a X edad: http://localhost:8686/personas/consultar/edadmenor/{X} (1, 2, 3, ...)
    - Consultar extensiones de las url de fotos: http://localhost:8686/photos/consultar/urls/{extension} (yahoo, com, html, jpg, ...)
    - Consultar autores vivos: http://localhost:8686/authors/consultar/isAlive/{Estado} (Y: vivo, N: no vivo)
    - Consultar libros por coincidencia de género: http://localhost:8686/books/consultar/genero/{género} (Contiene esta palabra en el género)
    - Consultar montos de facturas entre dos cifras: http://localhost:8686/facturas/consultar/montos/{cifraA}/{cifraB}
  - Consulta con Join: http://localhost:8686/books/consultar/libroautor/{nombreLibro} (Consulta información del libro y su autor)
  - Procedimiento almacenado: http://localhost:8686/books/publicar (Se debe agregar información en el body para "publicar" un libro)

