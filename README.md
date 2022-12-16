# Challenge
Proyecto creado en spring tool suite

1. Crear la base de datos MySql con las siguientes lineas
  CREATE SCHEMA `accenturedb`;
  USE `accenturedb`;
  
2. Correr el proyecto

# Permisos
  0 no tiene permisos
  1 lectura
  2 escritura (teniendo en cuenta de que si escribe tambien puede leer)

# Para pruebas en Postman
  Metodos GET

  Retorna todos los usuarios
  localhost:8080/business/users

  Retorna todos los albums
  localhost:8080/business/albums

  Retorna todos los fotos de un album
  localhost:8080/business/photos/{idalbum}

  Retorna todas las fotos de un usuario
  localhost:8080/business/photos/user={iduser}

  Retorna todos los albums de un usuario enviando su id
  localhost:8080/business/userandalbums/{id}

  Retorna lista de comentarios en base a postId
  localhost:8080/business/comment/{id}

  Permisos

  Metodo POST
  Crea un permiso, solo puede hacerlo el titular del album
  El id enviado por Path {id} es el que hace el pedido
  localhost:8080/business/newpermission/{id}
  {
      "user" : "1",
      "album" : "25",
      "permissionType" : "1"
  }

  Metodo PUT
  Actualiza el tipo de permiso, solo puede hacerlo el titular del album
  El id enviado por Path {id} es el que hace el pedido
  localhost:8080/business/updatepermission/{id}
  Formato del JSON que necesita
  {
      "user" : "1",
      "album" : "25",
      "permissionType" : "1"
  }

  Metodos GET
  Retorna lista de usuarios de un album especifico y un tipo de permiso
  localhost:8080/business/usersandpermissions/album={idalbum}/permission={idpermission}

  Retorna un album si es que el usuario tiene permisos, para mostrar la vista de un album utilizando los permisos
  El {idalbum} es del album solicitado y {iduser} es del usuario que lo pide
  localhost:8080/business/album={idalbum}/user={iduser}






