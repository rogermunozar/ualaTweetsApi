# ualaTweetsApi

<p>El proyecto esta desarrollado en Java version 17, </p>
<p>Usa el framework Spring Boot 3 para el manejo de controladores e inyeccion de dependencias
En la raiz de proyecto se encuentran  4 entidades, cada una en una carpeta:
  "user", "tweet", "follow" y "timeline",
   Cada una posee 3 subcarpetas: 
     -"application":  Para las clases que requiere la app como intercambio de datos
     -"domain": Aqui se ubica la clase del dominio, 
                el servicio que lo maneja y su interface, 
                asi como la interface del repository que lo maneja. 
              Esto con la intencion de mantener el manejo del servicio y entrada/salida de la futura implementacion del repositorio
     -"infrastructura": donde se manejan los frameworks externos y objetos para su uso
</p>  
  
# base de datos
se utilizo ElasticSearch con el proposito de incrementar o extender la capacidad de almacenamiento debido a que esta herramienta cuanta con la posibilidad de particionar la data en varios servidores y asi mejorar los tiempos de las consulta
Ejamplo,  1 Millon de usuarios podrian estar en decenas de servidores para mejorar su rendimiento
