# ualaTweetsApi
<pre>El proyecto esta desarrollado en Java version 17, 
Usa el framework Spring Boot 3 para el manejo de controladores e inyeccion de dependencias
En la raiz de proyecto se encuentran  4 entidades, cada una en una carpeta:
  "user", "tweet", "follow" y "timeline",
   Cada una posee 3 subcarpetas: 
     -"application":  Para las clases que requiere la app como intercambio de datos
     -"domain": Aqui se ubica la clase del dominio, 
                el servicio que lo maneja y su interface, 
                asi como la interface del repository que lo maneja. 
              Esto con la intencion de mantener el manejo del servicio y entrada/salida de la futura implementacion del repositorio
     -"infrastructura": donde se manejan los frameworks externos y objetos para su uso
</pre>  
  
# ualaTweetsApi
