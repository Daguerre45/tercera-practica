
# BÚSQUEDA DE UN CAMINO DE UN GRAFO #
En este proyecto programaremos y veremos cómo se busca o como se consigue un camino de un vértice a otro dentro de un gráfo y que pasos sigue.

___
## ¿Qué es un grafo? ##
Representación simbólica de los elementos constituidos de un 
sistema o conjunto, mediante esquemas gráficos.

![imagenGraph.png](../tercera-practica/imagenGraph.png)

___
## ¿Como funciona? ##
Para la realización de este código hemos utilizado la metodología de programación de TDD
### ¿Qué es la metodología de programación TDD ###
TDD o Test-Driven Development (desarrollo dirigido por tests) es una práctica de programación que consiste en escribir primero las pruebas (generalmente unitarias), después escribir el código fuente que pase la prueba satisfactoriamente y, por último, refactorizar el código escrito.
### El código se divide en dos partes ###
- #### La clase GraphTest.java #### 
        En esta clase hemos creado todos nuestros test para ir comprobando el buen funcionamiento del cógido. Son tests básicos que nos ayudarán para poder realizar el último test (el importante), que es el que va a recorrer el grafo para encontrar la ruta de acceso entre 2 puntos.
- #### La clase Graph.java ####
        En esta clase hemos programado el código en base a constantes para que los tests realizado funcionen con cualquier variable.

___
## Comandos ##
* **IMPORTANTE** Para que funcionen estos comandos tendremos que haber descargado previamente maven en nuestro ordenador y deberemos estar dentro de la carpeta Práctica3(para llegar a ella usaremos el comado "cd Preactica3").
1. **mvn clean:** sirve para limpiar todo lo que se ha creado al usar varias veces maven (no es necesario su uso).
2. **mvn compile:** sirve para compilar el código.
3. **mvn test:** sirve para que se realicen todos los tests que se hayam creado.

___
## Autor
* *[Alberto Daguerre Torres]
(https://github.com/Daguerre45/tercera-practica.git)*
___
## Copyright
Yo, Alberto Daguerre Torres creador
de este repositorio, concedo el uso
de este para cualquier persona que 
se quiera basar en este código o 
cualquiera que quiera retocarlo o 
simplemente trastear con el.

Copyright 2021 Alberto Daguerre Torres
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, 
software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or 
implied.
See the License for the specific language governing permissions 
and
limitations under the License.


![Copyright.png](../tercera-practica/Copyright.png)
