# ualaTweetsApi
El proyecto esta desarrollado en Java en su version 17, 
Usa el framework es Spring Boot 3 para el manejo de controladores e inyeccion de dependencias
En la raiz de proyecto se encuentran  4 entidades, cada una en una carpeta:
  user, tweet, follow y timeline,
   Cada una posee 3 subcarpetas: 
     -application:  Para las clases que requiere la app como intercambio de datos
     -domain: alli se ubica la clase del dominio, el servicio que lo maneja, su interface, asi como la interface del repository que lo maneja. Esto con la intencion de mantener en el nivel domain el manejo del servicio y entrada/salida de la futura implementacion del repositorio
     -infrastructura: donde se manejan 
  
  
# ualaTweetsApi
